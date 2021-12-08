package day6;


import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;

public class Day6 {
    //static String inputText = "3,4,3,1,2";
    static String inputText = "1,1,3,5,1,3,2,1,5,3,1,4,4,4,1,1,1,3,1,4,3,1,2,2,2,4,1,1,5,5,4,3,1,1,1,1,1,1,3,4,1,2,2,5,1,3,5,1,3,2,5,2,2,4,1,1,1,4,3,3,3,1,1,1,1,3,1,3,3,4,4,1,1,5,4,2,2,5,4,5,2,5,1,4,2,1,5,5,5,4,3,1,1,4,1,1,3,1,3,4,1,1,2,4,2,1,1,2,3,1,1,1,4,1,3,5,5,5,5,1,2,2,1,3,1,2,5,1,4,4,5,5,4,1,1,3,3,1,5,1,1,4,1,3,3,2,4,2,4,1,5,5,1,2,5,1,5,4,3,1,1,1,5,4,1,1,4,1,2,3,1,3,5,1,1,1,2,4,5,5,5,4,1,4,1,4,1,1,1,1,1,5,2,1,1,1,1,2,3,1,4,5,5,2,4,1,5,1,3,1,4,1,1,1,4,2,3,2,3,1,5,2,1,1,4,2,1,1,5,1,4,1,1,5,5,4,3,5,1,4,3,4,4,5,1,1,1,2,1,1,2,1,1,3,2,4,5,3,5,1,2,2,2,5,1,2,5,3,5,1,1,4,5,2,1,4,1,5,2,1,1,2,5,4,1,3,5,3,1,1,3,1,4,4,2,2,4,3,1,1";

    static int iterations = 256;

    public static void main(String[] args) {

        List<Integer> fishSchool = new ArrayList<Integer>();
        String[] inputs = inputText.split(",");
        for (String input: inputs
             ) {
            fishSchool.add(Integer.parseInt(input));
        }

//        System.out.println(fishSchool.size());
//        for (int i = 0; i < iterations; i++) {
//            //Do we need temp new fish school object?
//            for (int j = 0; j < fishSchool.size() ; j++) {
//
//                if(fishSchool.get(j) == 0){
//                    fishSchool.set(j,6);
//                    fishSchool.add(9);
//                }
//                else {
//                    fishSchool.set(j,fishSchool.get(j) - 1);
//                }
//
//            }
//
//            System.out.print("Iteration: "+i + ": ");
//            for (Integer fish:fishSchool
//            ) {
//                System.out.print(fish+ " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Number of fish: " + fishSchool.size());

        long[] producers = new long[7];
        long[] hatchery = new long[2];
        for (int i = 0; i < producers.length; i++) {
            producers[i] = 0;
        }
        for (int i = 0; i < hatchery.length; i++) {
            producers[i] = 0;
        }

        for (String input: inputs
        ) {
            producers[Integer.parseInt(input)]++;
        }
        for (int i = 0; i < producers.length; i++) {
            System.out.print(producers[i]);
        }
        System.out.println();

        int phase = 0;
        for (int i = 0; i < iterations ; i++) {
            System.out.println("Phase: " + phase);
            long newFish = producers[phase];
            producers[phase] = producers[phase] + hatchery[0];
            hatchery[0] = hatchery[1];
            hatchery[1] = newFish;
            if(phase == 6){
                phase = 0;
            }
            else{
                phase++;
            }
            for (int j = 0; j < producers.length; j++) {
                System.out.print(producers[j] + " ");
            }
            System.out.print("  ");
            for (int j = 0; j < hatchery.length; j++) {
                System.out.print(hatchery[j] + " ");
            }
            System.out.println();
        }
        long totalFish = 0;
        for (long producer:producers
             ) {
            totalFish = totalFish + producer;
        }
        for (long newFish:hatchery
             ) {
            totalFish = totalFish + newFish;
        }
        System.out.println("Count: " + totalFish);


    }



}
