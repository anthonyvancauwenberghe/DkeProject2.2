package org.entities.bots.police;

import org.entities.bots.Bot;
import org.map.Grid;
import org.map.GridObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pmmde on 27-Jun-17.
 */
public class MCTSBotAlgorithm extends Bot {

    private static int[][] presetMoves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean groupMoveAlgorithm = true;

    public MCTSBotAlgorithm() {
        super("MCTS");
    }

    public static void moveShared(LinkedList<Bot> policesEntities) {
        Grid grid = policesEntities.get(0).getGrid();
        ArrayList<int[]> startLocationsCriminal = getLocationVectors(grid, 2);
        ArrayList<int[]> startLocationsPolices = getLocationVectors(policesEntities);
        int[][] startRawGrid = grid.getRawGrid();
        ArrayList<int[]> moves = getMultiStartPresetMoves(policesEntities.size());
        int[] votes = new int[moves.size()];
        int depth = 1000;
        for (int i = 0; i < moves.size(); i++) {
            boolean movesLegal = true;
            for (int j = 0; j < policesEntities.size(); j++) {
                int newx = startLocationsPolices.get(j)[0] + presetMoves[moves.get(i)[j]][0];
                int newy = startLocationsPolices.get(j)[1] + presetMoves[moves.get(i)[j]][1];
                if (newx >= 0 && newy >= 0 && newx < startRawGrid.length && newy < startRawGrid[0].length) {
                    if (!(startRawGrid[newx][newy] == 0 || startRawGrid[newx][newy] == 2)) {
                        movesLegal = false;
                    }
                } else {
                    movesLegal = false;
                }
            }
            if (movesLegal) {
                for (int k = 0; k < 10000; k++) {
                    int[][] rawGrid = copyRawGrid(startRawGrid);
                    ArrayList<int[]> criminals = copyLocationVectors(startLocationsCriminal);
                    ArrayList<int[]> polices = copyLocationVectors(startLocationsPolices);
                    for (int j = 0; j < policesEntities.size(); j++) {
                        int x = startLocationsPolices.get(j)[0];
                        int y = startLocationsPolices.get(j)[1];
                        int newx = startLocationsPolices.get(j)[0] + presetMoves[moves.get(i)[j]][0];
                        int newy = startLocationsPolices.get(j)[1] + presetMoves[moves.get(i)[j]][1];
                        if (rawGrid[newx][newy] == 0) {
                            rawGrid[newx][newy] = 3;
                            rawGrid[x][y] = 0;
                            moveLocation(polices, x, y, newx, newy);
                        } else if (rawGrid[newx][newy] == 2) {
                            rawGrid[newx][newy] = 3;
                            rawGrid[x][y] = 0;
                            moveLocation(polices, x, y, newx, newy);
                            removeLocation(criminals, newx, newy);
                        }
                    }
                    votes[i] += depth - simulate(rawGrid, criminals, polices, depth);
                }
            }
        }
        int bestMove = getMaxArrayIndex(votes);
        if (votes[bestMove] > 0) {
            for (int i = 0; i < policesEntities.size(); i++) {
                int newx = policesEntities.get(i).getLocation().x + presetMoves[moves.get(bestMove)[i]][0];
                int newy = policesEntities.get(i).getLocation().y + presetMoves[moves.get(bestMove)[i]][1];
                policesEntities.get(i).setLocation(new Point(newx, newy));
            }
        } else {
            System.out.println("No usefull moves found");
        }
    }

    private static int simulate(int[][] rawGrid, ArrayList<int[]> criminals, ArrayList<int[]> polices, int depth) {
        int startCriminals = criminals.size();
        for (int i = 0; i < depth; i++) {
            for (int[] police : polices) {
                moveEntityRandom(rawGrid, criminals, polices, police[0], police[1], 4, true);
            }
            for (int[] criminal : criminals) {
                moveEntityRandom(rawGrid, criminals, polices, criminal[0], criminal[1], 4, false);
            }
            if (criminals.size() < startCriminals) {
                return i;
            }
        }
        return depth;
    }

    private static int moveEntityRandom(int[][] rawGrid, ArrayList<int[]> criminals, ArrayList<int[]> police, int x, int y, int tries, boolean isPolice) {
        for (int i = 0; i < tries; i++) {
            int moveIndex = ThreadLocalRandom.current().nextInt(0, presetMoves.length);
            int newx = x + presetMoves[moveIndex][0];
            int newy = y + presetMoves[moveIndex][1];
            if (newx >= 0 && newy >= 0 && newx < rawGrid.length && newy < rawGrid[0].length) {
                if (rawGrid[newx][newy] == 0) {
                    rawGrid[x][y] = 0;
                    if (isPolice) {
                        moveLocation(police, x, y, newx, newy);
                        rawGrid[newx][newy] = 3;
                    } else {
                        moveLocation(criminals, x, y, newx, newy);
                        rawGrid[newx][newy] = 2;
                    }
                    return 1;
                } else if (isPolice && rawGrid[newx][newy] == 2) {
                    rawGrid[newx][newy] = 3;
                    rawGrid[x][y] = 0;
                    moveLocation(police, x, y, newx, newy);
                    removeLocation(criminals, newx, newy);
                    return 0;
                }
            }
        }

        return 2;
    }

    private static ArrayList<int[]> getLocationVectors(Grid grid, int retrieveId) {
        ArrayList<int[]> vectors = new ArrayList<>();
        GridObject[][] gridObjects = grid.getGridArray();
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
                if (gridObjects[x][y].getId() == retrieveId) {
                    vectors.add(new int[]{x, y});
                }
            }
        }
        return vectors;
    }

    private static ArrayList<int[]> getLocationVectors(LinkedList<Bot> list) {
        ArrayList<int[]> vectors = new ArrayList<>();
        for (Bot item : list) {
            vectors.add(new int[]{item.getLocation().x, item.getLocation().y});
        }
        return vectors;
    }

    private static void moveLocation(ArrayList<int[]> list, int xfrom, int yfrom, int xto, int yto) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == xfrom && list.get(i)[1] == yfrom) {
                list.get(i)[0] = xto;
                list.get(i)[1] = yto;
                return;
            }
        }
    }

    private static void removeLocation(ArrayList<int[]> list, int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == x && list.get(i)[1] == y) {
                list.remove(i);
                return;
            }
        }
    }

    private static ArrayList<int[]> copyLocationVectors(ArrayList<int[]> old) {
        ArrayList<int[]> newVectors = new ArrayList<>(old.size());
        for (int[] locOld : old) {
            newVectors.add(new int[]{locOld[0], locOld[1]});
        }
        return newVectors;
    }

    private static int[][] copyRawGrid(int[][] old) {
        int[][] newRawGrid = new int[old.length][old[0].length];
        for (int i = 0; i < old.length; i++) {
            for (int j = 0; j < old[0].length; j++) {
                newRawGrid[i][j] = old[i][j];
            }
        }
        return newRawGrid;
    }

    private static int getMaxArrayIndex(int[] arr) {
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static ArrayList<int[]> getMultiStartPresetMoves(int size) {
        ArrayList<int[]> data = new ArrayList<int[]>();

        for (int i = 0; i < (int) Math.pow(presetMoves.length, size); i++) {
            data.add(new int[size]);
        }

        multiPresetMovesHelper(data, 0, (int) Math.pow(presetMoves.length, size), size, 0);

        return data;
    }

    private static void multiPresetMovesHelper(ArrayList<int[]> data, int from, int to, int size, int depth) {
        if (size == depth) {
            return;
        }
        int difference = to - from;
        for (int j = 0; j < presetMoves.length; j++) {
            int startEdit = from + j * difference / presetMoves.length;
            int endEdit = from + (j + 1) * difference / presetMoves.length;
            for (int i = startEdit; i < endEdit; i++) {
                data.get(i)[depth] = j;
            }
            multiPresetMovesHelper(data, startEdit, endEdit, size, depth + 1);
        }
    }

    @Override
    public void move() {
        Grid grid = getGrid();
        if (grid != null) {
            int listLength = this.getAvailableNextLocations(grid).size();

            if (listLength == 0) {
                System.out.println("no moves available you are trapped");
            } else {
                runMCTS(grid, getLocation().x, getLocation().y, 10000);
            }
        }
    }

    private void runMCTS(Grid grid, int x, int y, int depth) {
        ArrayList<int[]> startLocationsCriminal = getLocationVectors(grid, 2);
        ArrayList<int[]> startLocationsPolices = getLocationVectors(grid, 3);
        int[][] startRawGrid = grid.getRawGrid();
        int[] votes = new int[presetMoves.length];

        for (int i = 0; i < presetMoves.length; i++) {
            int newx = x + presetMoves[i][0];
            int newy = y + presetMoves[i][1];
            if (newx >= 0 && newy >= 0 && newx < startRawGrid.length && newy < startRawGrid[0].length) {
                if (startRawGrid[newx][newy] == 0 || startRawGrid[newx][newy] == 2) {
                    for (int j = 0; j < 1000; j++) {
                        int[][] rawGrid = copyRawGrid(startRawGrid);
                        ArrayList<int[]> criminals = copyLocationVectors(startLocationsCriminal);
                        ArrayList<int[]> polices = copyLocationVectors(startLocationsPolices);
                        if (rawGrid[newx][newy] == 0) {
                            rawGrid[newx][newy] = 3;
                            rawGrid[x][y] = 0;
                            moveLocation(polices, x, y, newx, newy);
                        } else if (rawGrid[newx][newy] == 2) {
                            rawGrid[newx][newy] = 3;
                            rawGrid[x][y] = 0;
                            moveLocation(polices, x, y, newx, newy);
                            removeLocation(criminals, newx, newy);
                        }
                        votes[i] += depth - simulate(rawGrid, criminals, polices, depth);
                    }
                }
            }
        }
        int bestMove = getMaxArrayIndex(votes);
        if (votes[bestMove] > 0) {
            setLocation(new Point(x + presetMoves[bestMove][0], y + presetMoves[bestMove][1]));
        } else {
            System.out.println("No usefull moves found");
        }
    }
}