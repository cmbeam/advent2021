package day4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) {
        try {
            File myObj = new File("input_day4.txt");
            Scanner myReader = new Scanner(myObj);

            List<String> calledNumbers = Arrays.stream(myReader.nextLine().split(",")).toList();
            List<BingoBoard> boards = new ArrayList<>();
            while (myReader.hasNextLine()) {
                myReader.nextLine();
               // List<Set<String>> board = new ArrayList<>();
                BingoBoard board = new BingoBoard();
                Set<String> line1 = new HashSet<>();
                Set<String> line2 = new HashSet<>();
                Set<String> line3 = new HashSet<>();
                Set<String> line4 = new HashSet<>();
                Set<String> line5 = new HashSet<>();

                for (int i = 0; i < 5 ; i++) {
                    String[] line = myReader.nextLine().split((" +"));
                    List<String> lLine = Arrays.stream(line).collect(Collectors.toList());
                    Set<String> data = Arrays.stream(line).collect(Collectors.toSet());
                    data.remove("");
                    lLine.remove("");
                    board.lines.add(data);
                    line1.add(lLine.get(0));
                    line2.add(lLine.get(1));
                    line3.add(lLine.get(2));
                    line4.add(lLine.get(3));
                    line5.add(lLine.get(4));
                    board.numbers.add(lLine.get(0));
                    board.numbers.add(lLine.get(1));
                    board.numbers.add(lLine.get(2));
                    board.numbers.add(lLine.get(3));
                    board.numbers.add(lLine.get(4));
                    //System.out.println(data);
                }
                board.lines.add(line1);
                board.lines.add(line2);
                board.lines.add(line3);
                board.lines.add(line4);
                board.lines.add(line5);
                boards.add(board);
            }
            System.out.println(calledNumbers);
            for (BingoBoard board:boards
                 ) {
                System.out.println();
                System.out.println(board);

            }

            myReader.close();

            boolean done = false;
            Set<String> numbersSoFar = new HashSet<>();
            int boardCount = boards.size();
            for (String number:calledNumbers
                 ) {
                numbersSoFar.add(number);
                for (BingoBoard board:boards
                     ) {
                    if(!board.bingoed) {
                        for (Set<String> line : board.lines
                        ) {
                            if (numbersSoFar.containsAll(line)) {

                                System.out.println("Bingo! " + line + "   " + numbersSoFar + " score: " + board.getScore(numbersSoFar));
                                board.bingoed = true;
                                System.out.println("Last called: " + calledNumbers.get(82));
                                //done = true;
                                break;
                            }
                        }
                    }
                    if(done) break;
                }
                if(done) break;
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }




}
