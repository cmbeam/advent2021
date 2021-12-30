package day7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaySeven {
    public static void main(String[] args) {

        List<Integer> locations = new ArrayList<>();
        int limit = 0;
        try {
            File myObj = new File("/GIT/advent2021/day7j/src/main/resources/input_day7.txt");
            Scanner myReader = new Scanner(myObj);
            String[] input;
            while (myReader.hasNextLine()) {
                String inputLine = myReader.nextLine();
                input = inputLine.split(",");
                for (int i = 0; i < input.length; i++) {
                    int location = Integer.parseInt(input[i]);
                    locations.add(location);
                    if (location > limit)
                        limit = location;

                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        for (Integer location:locations
             ) {
            System.out.println(location);
        }
        System.out.println("Limit: " + limit);
        int minMovesSimple = 0;
        int minMoves = 0;
        for (int i = 0; i <= limit ; i++) {
            int movesSimple = 0;
            int moves = 0;
            for (Integer location:locations
                 ) {
                movesSimple = movesSimple + Math.abs((location - i));

                int newMoves =  (Math.abs(location - i) * (Math.abs(location - i) + 1) / 2);
                moves = moves + newMoves;
                //System.out.println("Common position: " + i + " location: " + location + " moves: " + newMoves);
            }
            if(minMovesSimple == 0 || movesSimple < minMovesSimple)
                minMovesSimple = movesSimple;
            if(minMoves == 0 || moves < minMoves)
                minMoves = moves;

        }
        System.out.println("Moves part 1: " + minMovesSimple);
        System.out.println("moves part 2: " + minMoves);
    }

}
