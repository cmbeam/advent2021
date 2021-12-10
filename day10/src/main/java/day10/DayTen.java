package day10;

import java.io.File;
import java.util.*;

public class DayTen {
    public static void main(String[] args) {
        int score = 0;
        List<Double> incompleteScores = new ArrayList<>();

        try {
            File myObj = new File("input_day10.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                char[] line = myReader.nextLine().toCharArray();
                Stack<Character> chunkStack = new Stack<>();
                boolean corrupt = false;

                for (char symbol:line
                     ) {
                    switch(symbol){
                        case  ')':
                            if(!(chunkStack.pop() == '(')) {
                                corrupt = true;
                                score = score + 3;
                            }
                            break;
                        case '}':
                            if(!(chunkStack.pop() == '{')) {
                                corrupt = true;
                                score = score + 1197;
                            }
                            break;
                        case '>':
                            if(!(chunkStack.pop() == '<')) {
                                corrupt = true;
                                score = score + 25137;
                            }
                            break;
                        case ']':
                            if(!(chunkStack.pop() == '[')) {
                                corrupt = true;
                                score = score + 57;
                            }
                                break;

                        default:
                            chunkStack.push(symbol);
                    }
                    if(corrupt)
                        break;
                }
                if(corrupt)
                    System.out.println("Corrupt line: " + new String(line));
                else{
                    System.out.println("Fixing incomplete line: " + new String(line));
                    double incompleteScore = 0;
                    String fixedLine = new String(line);
                    while(!chunkStack.isEmpty()) {
                        char nextCharToClose = chunkStack.pop();
                        switch (nextCharToClose) {
                            case '(':
                                fixedLine = fixedLine.concat(")");
                                incompleteScore = (incompleteScore * 5) + 1;
                                break;
                            case '{':
                                fixedLine = fixedLine.concat("}");
                                incompleteScore = (incompleteScore * 5) + 3;
                                break;
                            case '<':
                                fixedLine = fixedLine.concat(">");
                                incompleteScore = (incompleteScore * 5) + 4;
                                break;
                            case '[':
                                fixedLine = fixedLine.concat("]");
                                incompleteScore = (incompleteScore * 5) + 2;
                                break;

                            default:

                        }
                    }
                    incompleteScores.add(incompleteScore);
                    System.out.println("Fixed line: " + fixedLine + "  score: " + incompleteScore);
                }


            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Part 1 Score: " + score);

        Collections.sort(incompleteScores);
        System.out.println("Part 2 score: " + incompleteScores.get(((incompleteScores.size() - 1) / 2) ));
    }

}
