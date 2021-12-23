package day18;



import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayEighteen {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("/Users/cbeam/GIT/advent2021/day18/src/main/resources/test_day18.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        List<Pair> pairs = new ArrayList<>();
        for (String input:inputs
             ) {
            System.out.println(input);
//            Pair nPair = new Pair();
//            nPair.leftmost=1;
//            nPair.rightmost=2;
//            System.out.println(nPair.toString());
//            Pair sPair = new Pair();
//            sPair.leftmost=nPair;
//            sPair.rightmost=4;
//            System.out.println(sPair.toString());
            Pair hlPair = new Pair();
            char[] chars = input.toCharArray();
            for (char character:chars
                 ) {
                if(character=='['){

                }
            }

        }


    }
}
 class Pair{
    Object leftmost;
    Object rightmost;
    public String toString() {
        return "["+leftmost+","+rightmost+"]";
    }
    public Pair addPair(String pairString){
        if(pairString.charAt(0) == '['){
            this.leftmost = this.addPair(pairString.substring(1,pairString.indexOf(',')));
            this.rightmo
        }
        else{
            this.leftmost = pairString.substring(0,pairString.indexOf(','));
            if(pairString.)
            this.rightmost = pairString.substring(pairString.indexOf(',') );
        }

    }
 }


