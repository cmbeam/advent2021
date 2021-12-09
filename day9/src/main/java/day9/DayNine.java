package day9;

import java.io.File;
import java.util.Scanner;

public class DayNine {
    public static void main(String[] args) {

        int size = 9;
        int[][] grid = new int[size][size];
        try {
            File myObj = new File("test_day9.txt");
            Scanner myReader = new Scanner(myObj);
            String[] input;
            int row = 0;
            while (myReader.hasNextLine()) {
                String inputLine = myReader.nextLine();
                input = inputLine.split("\\s");
                for (int i = 0; i < input.length ; i++) {
                    grid[i][row] = Integer.parseInt(input[i]);
                }
                row++;
            }
        } catch (Exception e) {

        }
        int sums = 0;
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                boolean low = true;
                System.out.print("["+i+"]["+j+"] ");
                if (i - 1 >= 0 && grid[i - 1][j] <= grid[i][j]) {
                    System.out.print("hit 1  ");
                    low = false;
                }
                if (i + 1 < size && grid[i + 1][j] <= grid[i][j]) {
                    System.out.print("hit 2  ");
                    low = false;
                }
                if (j - 1 >= 0 && grid[i][j - 1] <= grid[i][j]) {
                    System.out.print("hit 3  ");
                    low = false;
                }
                if (j + 1 < size && grid[i][j + 1] <= grid[i][j]) {
                    System.out.print("hit 4  ");
                    low = false;
                }
                System.out.println();
                if (low) {
                    System.out.println("hit all four");
                    sums = sums + grid[i][j] + 1;
                }

            }
        }
        System.out.println(sums);
    }
}
