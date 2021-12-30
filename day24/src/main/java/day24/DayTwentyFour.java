package day24;

import java.io.File;
import java.util.*;

public class DayTwentyFour {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("/Users/cbeam/GIT/advent2021/day24/src/main/resources/input_day24.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }



        long highest = 0;
        long lowest = 99999999999999L;
        for (int i = 9; i < 10 ; i++) {
            for (int j = 1; j < 7; j++) {
                for (int k = 3; k < 10 ; k++) {
                    for (int l = 1; l < 9 ; l++) {
                        for (int m = 1; m < 6 ; m++) {
                            for (int n = 1; n < 5 ; n++) {
                                for (int o = 1; o < 3; o++) {
                                    String w1 = ""+(o+7);
                                    String w2 = ""+(j+3);
                                    String w3 = ""+(i-8);
                                    String w4 = "" + i;
                                    String w5 = "" + j;
                                    String w6 = ""+(m+4);
                                    String w7 = ""+(l+1);
                                    String w8 = ""+(k-2);
                                    String w9 = "" + k;
                                    String w10 = "" + l;
                                    String w11 = "" + m;
                                    String w12 = ""+(n+5);
                                    String w13 = "" + n;
                                    String w14 = "" + o;
                                    long calc = Long.parseLong(w1+w2+w3+w4+w5+w6+w7+w8+w9+w10+w11+w12+w13+w14);
                                    if(calc > highest)
                                        highest = calc;
                                    if(calc < lowest)
                                        lowest = calc;

                                }

                            }

                        }

                    }

                }

            }

        }
        System.out.println("Highest: " +highest);
        runMonad(""+highest,inputs);
        System.out.println("Lowest: " +lowest);
        runMonad(""+lowest,inputs);
    }

    private static boolean runMonad(String serial, List<String> code){

        int cDigit = 0;

        Map<String,Long> variables = new HashMap<>();
        variables.put("w",0L);
        variables.put("x",0L);
        variables.put("y",0L);
        variables.put("z",0L);

        for (String instruction:code
        ) {
           //System.out.println(instruction);
            String[] parts = instruction.split("\\s");
            long bInt;
            switch (parts[0]){
                case "inp":
                    try {
                        long userInput = Integer.parseInt(serial.substring(cDigit,cDigit+1));
                        cDigit++;
                        variables.put(parts[1],userInput);
                    }
                    catch (Exception e){
                        System.out.println("read exception: "+e.getMessage());
                    }
                    System.out.println("Inp");
                    System.out.println(variables.toString());

                    break;
                case "mul":
                    if(parts[2].matches("-?\\d+")) {
                        bInt = Integer.parseInt(parts[2]);
                    }
                    else{
                        bInt = variables.get(parts[2]);
                    }
                    variables.put(parts[1],variables.get(parts[1]) * bInt);
                    break;
                case "add":
                    if(parts[2].matches("-?\\d+")) {
                        bInt = Integer.parseInt(parts[2]);
                    }
                    else{
                        bInt = variables.get(parts[2]);
                    }
                    variables.put(parts[1],variables.get(parts[1]) + bInt);
                    break;
                case "div":
                    if(parts[2].matches("-?\\d+")) {
                        bInt = Integer.parseInt(parts[2]);
                    }
                    else{
                        bInt = variables.get(parts[2]);
                    }
                    variables.put(parts[1],variables.get(parts[1]) / bInt);
                    break;
                case "mod":
                    if(parts[2].matches("-?\\d+")) {
                        bInt = Integer.parseInt(parts[2]);
                    }
                    else{
                        bInt = variables.get(parts[2]);
                    }
                    variables.put(parts[1], Math.floorMod(variables.get(parts[1]), bInt));
                    break;
                case "eql":
                    if(parts[2].matches("-?\\d+")) {
                        bInt = Integer.parseInt(parts[2]);
                    }
                    else{
                        bInt = variables.get(parts[2]);
                    }
                    if(variables.get(parts[1]) == bInt){
                        variables.put(parts[1], 1L);
                    }
                    else {
                        variables.put(parts[1], 0L);
                    }
                    break;
                default:
                    break;
            }
            //System.out.println(variables.toString());

        }
        if(variables.get("z") == 0) {
            System.out.println(serial);
            return true;
        }
        else
            return false;
    }
}
