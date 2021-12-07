package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFive {
    public static void main(String[] args) {
        int[][] gridSpace = new int[1000][1000];
        for (int i = 0; i < 1000 ; i++) {
            for (int j = 0; j < 1000; j++) {
                gridSpace[i][j] = 0;
            }

        }

        try {
            File myObj = new File("/Users/cbeam/GIT/advent2021/day5j/src/main/resources/input_day5.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] coordinates = myReader.nextLine().split(" -> ");
                String[] first = coordinates[0].split(",");
                String[] second = coordinates[1].split(",");
                if (first[0].equals(second[0])) {
                    int one = Integer.parseInt(first[1]);
                    int two = Integer.parseInt(second[1]);
                    if(one > two){
                        int tmp = one;
                        one = two;
                        two = tmp;
                    }
                    System.out.println("x");
                    for (int i = one; i <= two ; i++) {
                        gridSpace[Integer.parseInt(first[0])][i]++;

                    }
                }
                else if(first[1].equals(second[1])) {
                    int one = Integer.parseInt(first[0]);
                    int two = Integer.parseInt(second[0]);
                    if(one > two){
                        int tmp = one;
                        one = two;
                        two = tmp;
                    }
                    System.out.println("y");
                    for (int i = one; i <= two ; i++) {
                        gridSpace[i][Integer.parseInt(first[1])]++;

                    }
                }
                else{
                    System.out.println("diag");
                    int xOne = Integer.parseInt(first[0]);
                    int xTwo = Integer.parseInt(second[0]);
                    int yOne = Integer.parseInt(first[1]);
                    int yTwo = Integer.parseInt(second[1]);
                    if(xOne > xTwo){
                        int tmp = xOne;
                        xOne = xTwo;
                        xTwo = tmp;
                        tmp = yOne;
                        yOne = yTwo;
                        yTwo = tmp;
                    }

                    for (int i = xOne; i <= xTwo ; i++) {
                        if(yOne < yTwo)
                            gridSpace[i][yOne++]++;
                        else
                            gridSpace[i][yOne--]++;

                    }
                }
            }
        }
        catch (FileNotFoundException fne){

        }

        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(gridSpace[j][i]);
            }
            System.out.println();
        }


        int count = 0;
        for (int i = 0; i < 1000 ; i++) {
            for (int j = 0; j < 1000; j++) {
                if(gridSpace[i][j] > 1){
                    count++;
                }
            }

        }
        System.out.println(count);
    }

}

