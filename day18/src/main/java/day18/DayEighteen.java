package day18;



import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DayEighteen {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("/GIT/advent2021/day18/src/main/resources/test_day18.txt");
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
//            Pair hlPair = new Pair();
//            char[] chars = input.toCharArray();
//            for (char character:chars
//                 ) {
//                if(character=='['){
//
//                }
//            }
            PairStack stack = new PairStack(input);
//            System.out.println(stack.toString());

        }


    }
}
class PairStack{
    List<String> inStack;
    public  PairStack(String pairString){
        inStack = new ArrayList<>();
        int brackets = 0;
        String latestLeft = "";
        for (int i = 0; i < pairString.length() ; i++) {
            if(pairString.charAt(i) == '[') {
                if(brackets==4){
                    int leftRemove = Integer.parseInt(latestLeft.substring(1,2));
                    System.out.println(latestLeft.substring(2));
                    int explodedLeft = Integer.parseInt(pairString.substring(i+1,i+2));
                    System.out.println("["+(explodedLeft+leftRemove));
                }
                else {
                    if (pairString.substring(i + 1, i + 2).matches("-?\\d+")) {
                        System.out.print(latestLeft);
                        latestLeft = pairString.substring(i,i+2);
                    } else if (latestLeft.isBlank()) {
                        System.out.print("[");
                    } else {
                        latestLeft = latestLeft + "[";
                    }
                    brackets++;
                }
            }
            if(pairString.charAt(i) == ']') {
                if(pairString.substring(i+-1,i).matches("-?\\d+")){
//                    String stackValue = inStack.get(brackets-1);
//                    inStack.remove(brackets-1);
//                    inStack.add(brackets-1,stackValue+pairString.substring(i-1,i));
                }
                brackets--;
            }
            if(pairString.charAt(i) == ',') {
                if(latestLeft.isBlank())
                    System.out.print(",");
                else
                    latestLeft = latestLeft + ",";
            }


        }
        System.out.println();
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (String pair:this.inStack
             ) {
            sb.append(pair+" # ");
        }
        return sb.toString();
    }
}

// class Pair{
//    Object leftmost;
//    Object rightmost;
//    public Pair addPair(String pairString){
//        System.out.println("PS: "+pairString);
//        if(pairString.charAt(0) == '['){
//            int brackets = 1;
//            int charPos = 1;
//            while(brackets > 0){
//                if(pairString.charAt(charPos) == '['){
//                    brackets++;
//                }
//                else if(pairString.charAt(charPos) == ']'){
//                    brackets--;
//                    if(brackets==0)
//                        charPos++;
//
//                }
//                else if(pairString.charAt(charPos) == ',' && brackets == 1){
//                    break;
//                }
//                charPos++;
//            }
//            this.leftmost = this.addPair(pairString.substring(1,charPos));
//            this.rightmost = this.addPair(pairString.substring((charPos+1),pairString.length() - 1));
//        }
//        else{
//            if(pairString.contains(",")) {
//                this.leftmost = pairString.substring(0, pairString.indexOf(','));
//                if (pairString.charAt(pairString.indexOf(',')) == '[') {
//                    this.addPair(pairString.substring((pairString.indexOf(',') + 1), pairString.length() - 1));
//                } else {
//                    this.rightmost = pairString.substring(pairString.indexOf(','));
//                }
//            }
//            else {
//                this.leftmost = pairString;
//            }
//
//        }
//        return this;
//
//    }
// }


