package day11;

import java.io.File;
import java.util.Scanner;

public class DayEleven {
    final static int SIZE_X = 12;
    final static int SIZE_Y = 12;

    public static void main(String[] args) {
        int sizeX = SIZE_X ;//100;
        int sizeY = SIZE_Y;//100;
        int[][] grid = new int[sizeX][sizeY];

        try {
            File myObj = new File("/GIT/advent2021/day11/src/main/resources/test_day11.txt");
            Scanner myReader = new Scanner(myObj);

            int row = 1;
            while (myReader.hasNextLine()) {
                String inputLine = myReader.nextLine();
                for (int i = 0; i < inputLine.length() ; i++) {
                    grid[i+1][row] = Integer.parseInt(inputLine.substring(i, i+1));

                }

                row++;
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }



        int flashes = 0;
        for (int steps = 0; steps < 10000 ; steps++) {
            for (int j = 1; j < SIZE_X - 1; j++) {
                for (int i = 1; i < SIZE_Y - 1; i++) {
                    grid[i][j]++;
                }
            }
            boolean flashed = true;
            while(flashed) {
                flashed = false;
                for (int j = 1; j < SIZE_X - 1; j++) {
                    for (int i = 1; i < SIZE_Y - 1; i++) {
                        if (grid[i][j] > 9 && grid[i][j] < 16 ) {
                            flashed = true;
                            grid[i - 1][j - 1]++;
                            grid[i][j - 1]++;
                            grid[i + 1][j - 1]++;
                            grid[i - 1][j]++;
                            grid[i + 1][j]++;
                            grid[i - 1][j + 1]++;
                            grid[i][j + 1]++;
                            grid[i + 1][j + 1]++;
                            grid[i][j] = grid[i][j] + 6;
                        }
                    }
                }

            }
            int stepFlashes = 0;
            for (int j = 1; j < SIZE_X - 1 ; j++) {
                for (int i = 1; i < SIZE_Y - 1; i++) {
                    if(grid[i][j] > 9) {
                        grid[i][j] = 0;
                        stepFlashes++;
                    }
                    //System.out.print(grid[i][j]);
                }
                //System.out.println();
            }
            if(stepFlashes == 100){
                System.out.println("All flashed at step: " + steps);
                break;
            }
            else{
                //System.out.println(stepFlashes+ " flashed");
            }
            flashes = flashes + stepFlashes;
            System.out.println();
        }
        System.out.println();
        System.out.println("Flashes: " + flashes);

    }
}
