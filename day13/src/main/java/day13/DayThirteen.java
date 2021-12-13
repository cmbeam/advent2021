package day13;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayThirteen {
    public static void main(String[] args) {
        int xSize = 2000;
        int ySize = 2000;
        List<String[]> instructions = new ArrayList<>();
        int[][] grid = new int[xSize][ySize];
        for (int i = 0; i < ySize ; i++) {
            for (int j = 0; j <xSize ; j++) {
                grid[j][j] = 0;
            }
        }

        try {
            File myObj = new File("/Users/cbeam/GIT/advent2021/day13/src/main/resources/input_day13.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String[] nodeInputs = myReader.nextLine().split(",");
                if(nodeInputs[0] == "")
                    break;
                else{
                    System.out.println("x "+nodeInputs[0]+"  y " + nodeInputs[1]);
                    int x = Integer.parseInt(nodeInputs[0]);
                    int y = Integer.parseInt(nodeInputs[1]);
                    grid[x][y] = 1;
                }
            }
            while (myReader.hasNextLine()) {
                String[] nodeInputs = myReader.nextLine().split("\\s");
                String[] instructionParts = nodeInputs[2].split("=");
                System.out.println("Instruction: " + instructionParts[0] + " " + instructionParts[1] );
                instructions.add(instructionParts);
            }

        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }

//        for (int i = 0; i < ySize ; i++) {
//            for (int j = 0; j <xSize ; j++) {
//                if(grid[j][i] == 0)
//                    System.out.print(".");
//                else
//                    System.out.print("#");
//            }
//            System.out.println();
//        }

        for (String[] instruction:instructions
             ) {

            int foldLine = Integer.parseInt(instruction[1]);
            String direction = instruction[0];

            if (direction.equals("y")) {
                System.out.println("Start Folding along y axis");
                for (int i = 0; i < foldLine; i++) {
                    int top = i;
                    int bottom = foldLine * 2 - i;
                    for (int j = 0; j < xSize; j++) {
                        if (grid[j][top] == 1 || grid[j][bottom] == 1) {
                            grid[j][top] = 1;
                        }
                        grid[j][bottom] = 0;
                    }
                }
            } else {
                System.out.println("Start Folding along x axis");
                for (int i = 0; i < foldLine; i++) {
                    int left = i;
                    int right = foldLine * 2 - i;
                    for (int j = 0; j < ySize; j++) {
                        if (grid[left][j] == 1 || grid[right][j] == 1) {
                            grid[left][j] = 1;
                        }
                        grid[right][j] = 0;
                    }
                }

            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        int count = 0;
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 200 ; j++) {
                if(grid[j][i] == 0)
                    System.out.print(".");
                else {
                    System.out.print("#");
                    count++;
                }
            }
            System.out.println();
        }
        System.out.println("Count: "+count);

    }
}
