package day4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BingoBoard {
    Set<String> numbers = new HashSet<>();
    List<Set<String>> lines = new ArrayList<>();
    boolean bingoed = false;
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (Set<String> line:lines
             ) {
            sb.append(line.toString());

        }
        sb.append(numbers.toString());
        return sb.toString();
    }

    public int getScore(Set<String> calledNumbers){

        System.out.println("Number index: " + calledNumbers.size());
        //Get non union board numbers
        numbers.removeAll(calledNumbers);
        System.out.println("Intersection: " + numbers);
        int sum2 = 0;
        for (String number:numbers
        ) {
            sum2 = sum2 + Integer.parseInt(number);
        }

        //Return calculated score

        return sum2;
    }
}

