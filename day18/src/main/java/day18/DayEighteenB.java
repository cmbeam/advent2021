package day18;

import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DayEighteenB {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("/Users/cbeam/GIT/advent2021/day18/src/main/resources/input_day18.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        String runningCalculation = "";

        for (String input:inputs
             ) {
            BinaryTree tree = new BinaryTree();
           // System.out.println(input);
            if(runningCalculation == ""){
                runningCalculation = input;
                tree.create(runningCalculation);
                System.out.println(runningCalculation);
            }
            else {
                runningCalculation = "[" + runningCalculation + "," + input + "]";
                tree.create(runningCalculation);
                runningCalculation = "" + tree.traverseInOrder(tree.root);
               // System.out.println(runningCalculation);
            }
                boolean calculating = true;
                while(calculating){
                    calculating = (tree.explode(tree.root, 1) || tree.split(tree.root)) ;
//                    tree.pair(tree.root);

                    runningCalculation = ""+ tree.traverseInOrder(tree.root);
                    //System.out.println("calculation: "+ runningCalculation);
                }


            System.out.println(runningCalculation);
            tree.create(runningCalculation);
            System.out.println("Magnitude: "+tree.magnitude(tree.root));
        }
        long maxMagnitude = 0;
        for (int i = 0; i < inputs.size() ; i++) {
            for (int j = 0; j < inputs.size(); j++) {
                if(i != j){
                    BinaryTree tree = new BinaryTree();
                    String adder = "[" + inputs.get(i) + "," + inputs.get(j) + "]";
                    tree.create(adder);

                    boolean calculating = true;
                    while(calculating){
                        calculating = (tree.explode(tree.root, 1) || tree.split(tree.root)) ;
//                    tree.pair(tree.root);
                    }
                    long currentMagnitude = tree.magnitude(tree.root);
                    if(currentMagnitude > maxMagnitude)
                        maxMagnitude = currentMagnitude;
                }
            }
        }
        System.out.println();
        System.out.println("Max magnitude: "+maxMagnitude);
    }
}

