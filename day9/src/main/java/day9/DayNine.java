package day9;

import java.io.File;
import java.util.*;

public class DayNine {
    final static int SIZE_X = 100;
    final static int SIZE_Y = 100;

    public static void main(String[] args) {

        int sizeX = SIZE_X;//100;
        int sizeY = SIZE_Y;//100;
        int[][] grid = new int[sizeX][sizeY];
        try {
            File myObj = new File("I:\\GIT\\advent2021\\day9\\src\\main\\resources\\input_day9.txt");
            Scanner myReader = new Scanner(myObj);
            //String[] input;
            int row = 0;
            while (myReader.hasNextLine()) {
                String inputLine = myReader.nextLine();
                System.out.println(inputLine);
                for (int i = 0; i < inputLine.length() ; i++) {
                    grid[i][row] = Integer.parseInt(inputLine.substring(i, i+1));
                }
                row++;
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());

        }
        int sums = 0;
        List<Integer> basinSizes = new ArrayList<>();

        for (int i = 0; i < sizeX ; i++) {
            for (int j = 0; j < sizeY ; j++) {
                boolean low = true;
                System.out.print("["+i+"]["+j+"] "+ grid[i][j] + " : ");
                if (i - 1 >= 0 && grid[i - 1][j] <= grid[i][j]) {
                    low = false;
                }
                if (i + 1 < sizeX && grid[i + 1][j] <= grid[i][j]) {
                    low = false;
                }
                if (j - 1 >= 0 && grid[i][j - 1] <= grid[i][j]) {
                    low = false;
                }
                if (j + 1 < sizeY && grid[i][j + 1] <= grid[i][j]) {
                    low = false;
                }

                if (low) {
                    System.out.print("low point found. ");

                    //add to sums for part 1
                    sums = sums + grid[i][j] + 1;

                    //find basin
                    Set<String> basinSet = getBasinSize(grid, i, j,new HashSet<>());
                    System.out.print(" risk level: " + (grid[i][j] + 1) + "   basin size: " + basinSet.size());
                    basinSizes.add(basinSet.size());

//

                }
                System.out.println();

            }
        }
        System.out.println("Part 1: "+ sums);
        Collections.sort(basinSizes);

        List<Integer> lastThree = basinSizes.subList(basinSizes.size() - 3,basinSizes.size() );
        int product = 1;
        for (Integer basinSize: lastThree
        ) {
            product = product * basinSize;
        }
        System.out.println("Part 2: " + product);
    }

    public static Set<String> getBasinSize(int[][] grid, int x, int y, Set<String> visited){
        Set<String> basinPoints = new HashSet<>();

//        for (String coord:visited
//             ) {
//            System.out.println(coord);
//        }
        if(visited.contains(x+","+y) || x < 0 || y < 0|| x >= SIZE_X || y >= SIZE_Y || grid[x][y] == 9){
            return basinPoints;
        }
        else{
            visited.add(x+","+y);
            basinPoints.add(x+","+y);
            //System.out.println("("+x+ "," + y + ") value: "+grid[x][y]);

            basinPoints.addAll(getBasinSize(grid, x -1, y, visited));
            basinPoints.addAll(getBasinSize(grid, x + 1, y, visited));
            basinPoints.addAll(getBasinSize(grid, x, y - 1, visited));
            basinPoints.addAll(getBasinSize(grid, x, y + 1, visited));



            return basinPoints;


        }
    }
}
