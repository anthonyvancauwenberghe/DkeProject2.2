package org.entities.bots.police;

import org.entities.bots.Bot;
import org.map.Grid;
import org.map.GridObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pmmde on 27-Jun-17.
 */
public class MCTSBotAlgorithm extends Bot {

    public MCTSBotAlgorithm() {
        super("MCTS");
    }

    private static int[][] presetMoves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    @Override
    public void move() {
        Grid grid = getGrid();
        if (grid != null) {
            int listLength = this.getAvailableNextLocations(grid).size();

            if (listLength == 0) {
                System.out.println("no moves available you are trapped");
            } else {
                System.out.println("Start MCTS");
                runMCTS(grid,getLocation().x,getLocation().y,100);
                System.out.println("End MCTS");
            }
        }
    }

    private void runMCTS(Grid grid, int x, int y, int depth){
        ArrayList<int[]> startLocationsCriminal = getLocationVectors(grid, 2);
        ArrayList<int[]> startLocationsPolices = getLocationVectors(grid, 3);
        int[][] startRawGrid = grid.getRawGrid();
        int[] votes = new int[presetMoves.length];

        for(int i=0;i<presetMoves.length;i++){
            int newx = x+presetMoves[i][0];
            int newy = y+presetMoves[i][1];
            if(newx>=0 && newy>=0 && newx<startRawGrid.length && newy<startRawGrid[0].length) {
                if(startRawGrid[newx][newy]==0 || startRawGrid[newx][newy]==2) {
                    for (int j = 0; j < 100; j++) {
                        int[][] rawGrid = copyRawGrid(startRawGrid);
                        ArrayList<int[]> criminals = copyLocationVectors(startLocationsCriminal);
                        ArrayList<int[]> polices = copyLocationVectors(startLocationsPolices);
                        if(rawGrid[newx][newy]==0){
                            rawGrid[newx][newy]=3;
                            rawGrid[x][y]=0;
                            moveLocation(polices,x,y,newx,newy);
                        }else if(rawGrid[newx][newy]==2){
                            rawGrid[newx][newy]=3;
                            rawGrid[x][y]=0;
                            moveLocation(polices,x,y,newx,newy);
                            removeLocation(criminals,newx,newy);
                        }
                        votes[i] += depth-simulate(rawGrid,criminals,polices,depth);
                    }
                }
            }
        }
        System.out.println("votes: "+votes[0]+" "+votes[1]+" "+votes[2]+" "+votes[3]);
        int bestMove = getMaxArrayIndex(votes);
        if(votes[bestMove]>0) {
            setLocation(new Point(x + presetMoves[bestMove][0], y + presetMoves[bestMove][1]));
        }
        else
        {
            System.out.println("No usefull moves found");
        }
    }

    private int simulate(int[][]rawGrid,  ArrayList<int[]> criminals,  ArrayList<int[]> polices, int depth){
        int startCriminals = criminals.size();
        for(int i=0;i<depth;i++){
            for(int[] criminal : criminals){
                moveEntityRandom(rawGrid, criminals,polices,criminal[0],criminal[1],4,false);
            }
            for(int[] police : polices){
                moveEntityRandom(rawGrid, criminals,polices,police[0],police[1],4,true);
            }
            if(criminals.size()<startCriminals){
                return i;
            }
        }
        return depth;
    }

    private int moveEntityRandom(int[][] rawGrid,  ArrayList<int[]> criminals,  ArrayList<int[]> police, int x, int y, int tries, boolean isPolice){
        for(int i=0;i<tries;i++){
            int moveIndex = ThreadLocalRandom.current().nextInt(0, presetMoves.length);
            int newx = x+presetMoves[moveIndex][0];
            int newy = y+presetMoves[moveIndex][1];
            if(newx>=0 && newy>=0 && newx<rawGrid.length && newy<rawGrid[0].length){
                if(rawGrid[newx][newy]==0){
                    rawGrid[x][y]=0;
                    if(isPolice) {
                        moveLocation(police, x, y, newx, newy);
                        rawGrid[newx][newy]=3;
                    }
                    else
                    {
                        moveLocation(criminals, x, y, newx, newy);
                        rawGrid[newx][newy]=2;
                    }
                    return 1;
                }else if(isPolice && rawGrid[newx][newy]==2){
                    rawGrid[newx][newy]=3;
                    rawGrid[x][y]=0;
                    moveLocation(police,x,y,newx,newy);
                    removeLocation(criminals,newx,newy);
                    return 0;
                }
            }
        }

        return 2;
    }

    private ArrayList<int[]> getLocationVectors(Grid grid, int retrieveId){
        ArrayList<int[]> vectors = new ArrayList<>();
        GridObject[][] gridObjects = grid.getGridArray();
        for (int x = 0; x < grid.getWidth(); x++) {
            for (int y = 0; y < grid.getHeight(); y++) {
                if(gridObjects[x][y].getId()==retrieveId){
                    vectors.add(new int[]{x, y});
                }
            }
        }
        return vectors;
    }

    private void moveLocation(ArrayList<int[]> list, int xfrom, int yfrom, int xto, int yto){
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0]==xfrom && list.get(i)[1]== yfrom){
                list.get(i)[0] = xto;
                list.get(i)[1] = yto;
                return;
            }
        }
    }
    private void removeLocation(ArrayList<int[]> list, int x, int y){
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0]==x && list.get(i)[1]== y){
                list.remove(i);
                return;
            }
        }
    }

    private ArrayList<int[]> copyLocationVectors(ArrayList<int[]> old){
        ArrayList<int[]> newVectors = new ArrayList<>(old.size());
        for(int[] locOld:old){
            newVectors.add(new int[]{locOld[0],locOld[1]});
        }
        return newVectors;
    }

    private int[][] copyRawGrid(int[][] old){
        int[][] newRawGrid = new int[old.length][old[0].length];
        for(int i=0;i<old.length;i++){
            for(int j=0;j<old[0].length;j++){
                newRawGrid[i][j]=old[i][j];
            }
        }
        return newRawGrid;
    }

    private int getMaxArrayIndex(int[] arr){
        int max = arr[0];
        int maxIndex = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}