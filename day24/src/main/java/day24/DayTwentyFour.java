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


//        Map<String,Integer> variables = new HashMap<>();
//        variables.put("w",0);
//        variables.put("x",0);
//        variables.put("y",0);
//        variables.put("z",0);
//
//        for (String instruction:inputs
//             ) {
//            System.out.println(instruction);
//            String[] parts = instruction.split("\\s");
//            int bInt;
//            switch (parts[0]){
//                case "inp":
//                    try {
//                        Scanner sc= new Scanner(System.in);
//                        System.out.print("Input: ");
//                        int userInput = sc.nextInt();
//
//                        variables.put(parts[1],userInput);
//                    }
//                    catch (Exception e){
//                        System.out.println("read exception: "+e.getMessage());
//                    }
//                    break;
//                case "mul":
//                    if(parts[2].matches("-?\\d+")) {
//                        bInt = Integer.parseInt(parts[2]);
//                    }
//                    else{
//                       bInt = variables.get(parts[2]);
//                    }
//                    variables.put(parts[1],variables.get(parts[1]) * bInt);
//                    break;
//                case "add":
//                    if(parts[2].matches("-?\\d+")) {
//                        bInt = Integer.parseInt(parts[2]);
//                    }
//                    else{
//                        bInt = variables.get(parts[2]);
//                    }
//                    variables.put(parts[1],variables.get(parts[1]) + bInt);
//                    break;
//                case "div":
//                    if(parts[2].matches("-?\\d+")) {
//                        bInt = Integer.parseInt(parts[2]);
//                    }
//                    else{
//                        bInt = variables.get(parts[2]);
//                    }
//                    variables.put(parts[1],variables.get(parts[1]) / bInt);
//                    break;
//                case "mod":
//                    if(parts[2].matches("-?\\d+")) {
//                        bInt = Integer.parseInt(parts[2]);
//                    }
//                    else{
//                        bInt = variables.get(parts[2]);
//                    }
//                    variables.put(parts[1], Math.floorMod(variables.get(parts[1]), bInt));
//                    break;
//                case "eql":
//                    if(parts[2].matches("-?\\d+")) {
//                        bInt = Integer.parseInt(parts[2]);
//                    }
//                    else{
//                        bInt = variables.get(parts[2]);
//                    }
//                    if(variables.get(parts[1]) == bInt){
//                        variables.put(parts[1], 1);
//                    }
//                    else {
//                        variables.put(parts[1], 0);
//                    }
//                    break;
//                default:
//                    break;
//            }
//
//        }
//        System.out.println(variables.toString());


        String testSerial = "13579246899999";
        //String testSerial = "99999999999999";
       runMonad(testSerial,inputs);

//        for (int i = 9999999; i >= 1111111 ; i--) {
//            for (int j = 9999999; j >= 1111111; j--) {
//                String serial = ""+i+""+j;
//                //System.out.print(serial+": ");
//                if(!serial.contains("0")){
//                    //System.out.println("run");
//                    if(runMonad(serial,inputs))
//                        break;
//                }
//            }
//        }


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
           System.out.println(instruction);
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
                    System.out.println();
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
            System.out.println(variables.toString());

        }
        if(variables.get("z") == 0) {
            System.out.println(serial);
            return true;
        }
        else
            return false;
    }
}
