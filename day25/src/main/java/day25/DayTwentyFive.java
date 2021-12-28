package day25;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwentyFive {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("/Users/cbeam/GIT/advent2021/day25/src/main/resources/input_day25.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        boolean[][] east = new boolean[inputs.size()][inputs.get(0).length()];
        boolean[][] south = new boolean[inputs.get(0).length()][inputs.size()];


        int line = 0;
        for (String input:inputs
             ) {
            for (int i = 0; i < input.length() ; i++) {
                if(input.charAt(i) == '>') {
                    east[line][i] = true;
                    south[i][line] = false;
                }
                if(input.charAt(i) == 'v') {
                    east[line][i] = false;
                    south[i][line] = true;
                }
                if(input.charAt(i) == '.') {
                    east[line][i] = false;
                    south[i][line] = false;
                }
            }
            line++;
        }
        printMap(east,south);
        System.out.println();
        int steps = 0;
        boolean moving = true;
        while(moving){
            moving = false;

            //east first
            for (int i = 0; i < east.length ; i++) {
                boolean[] tempEast = new boolean[south.length];
                for (int j = 0; j < south.length; j++) {
                    if( east[i][j]) {
                        if(j == south.length - 1 && !east[i][0] && !south[0][i]){
                            moving = true;
                            tempEast[j] = false;
                            tempEast[0] = true;
                        }
                        else if (j < south.length - 1 && !east[i][j + 1] && !south[j+1][i]) {
                            moving = true;
                            tempEast[j] = false;
                            tempEast[j + 1] = true;
                        }
                        else {
                            tempEast[j] = east[i][j];
                        }
                    }
                }
                east[i] = tempEast;
            }
            //south second
            for (int i = 0; i < south.length ; i++) {
                boolean[] tempSouth = new boolean[east.length];
                for (int j = 0; j < east.length; j++) {
                    if( south[i][j]) {
                        if(j == east.length - 1 && !south[i][0] && !east[0][i]){
                            moving = true;
                            tempSouth[j] = false;
                            tempSouth[0] = true;
                        }
                        else if (j < east.length - 1 && !south[i][j + 1] && !east[j+1][i]) {
                            moving = true;
                            tempSouth[j] = false;
                            tempSouth[j + 1] = true;
                        }
                        else {
                            tempSouth[j] = south[i][j];
                        }
                    }
                }
                south[i] = tempSouth;
            }


            steps++;

            //temp step limiter
//            if (steps == 7)
//                moving=false;

            printMap(east,south);
            System.out.println();
        }

        System.out.println("Steps: "+steps);


    }

    private static void printMap(boolean[][] east, boolean[][] south){
        for (int i = 0; i < east.length; i++) {
            for (int j = 0; j < south.length; j++) {
                if(east[i][j])
                    System.out.print(">");
                else if(south[j][i])
                    System.out.print("v");
                else
                    System.out.print(".");
            }
            System.out.println();

        }
    }
}
