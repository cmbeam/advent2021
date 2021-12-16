package day14;
<<<<<<< HEAD
import org.jgrapht.*;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.DepthFirstIterator;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DayFourteen {
    public static void main(String[] args) {
        Graph<String,DefaultWeightedEdge> grid = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        Graph<String,DefaultWeightedEdge> bigGrid = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);


        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("/Users/cbeam/GIT/advent2021/day14/src/main/resources/input_day15.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }

        int xSize = inputs.get(0).length();
        int ySize = inputs.size();
        int maxBigX = xSize*5;
        int maxBigY = ySize*5;
        int[][] riskGrid = new int[xSize*5][ySize*5];

        for (int i = 0; i < ySize ; i++) {
            for (int j = 0; j < xSize ; j++) {
                riskGrid[j][i] = Integer.parseInt(""+inputs.get(i).charAt(j));

                riskGrid[j][i+ySize*1] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),1));
                riskGrid[j][i+ySize*2] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),2));
                riskGrid[j][i+ySize*3] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),3));
                riskGrid[j][i+ySize*4] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),4));

                riskGrid[j+xSize*1][i] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),1));

                riskGrid[j+xSize*1][i+ySize*1] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),2));
                riskGrid[j+xSize*1][i+ySize*2] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),3));
                riskGrid[j+xSize*1][i+ySize*3] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),4));
                riskGrid[j+xSize*1][i+ySize*4] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),5));

                riskGrid[j+xSize*2][i] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),2));

                riskGrid[j+xSize*2][i+ySize*1] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),3));
                riskGrid[j+xSize*2][i+ySize*2] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),4));
                riskGrid[j+xSize*2][i+ySize*3] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),5));
                riskGrid[j+xSize*2][i+ySize*4] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),6));

                riskGrid[j+xSize*3][i] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),3));

                riskGrid[j+xSize*3][i+ySize*1] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),4));
                riskGrid[j+xSize*3][i+ySize*2] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),5));
                riskGrid[j+xSize*3][i+ySize*3] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),6));
                riskGrid[j+xSize*3][i+ySize*4] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),7));

                riskGrid[j+xSize*4][i] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),4));

                riskGrid[j+xSize*4][i+ySize*1] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),5));
                riskGrid[j+xSize*4][i+ySize*2] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),6));
                riskGrid[j+xSize*4][i+ySize*3] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),7));
                riskGrid[j+xSize*4][i+ySize*4] = Integer.parseInt(""+increaseRisk( Integer.parseInt(""+inputs.get(i).charAt(j)),8));


                grid.addVertex(""+j+","+i);

                bigGrid.addVertex(""+j+","+i);
                bigGrid.addVertex(""+(xSize+j)+","+i);
                bigGrid.addVertex(""+(2*xSize+j)+","+i);
                bigGrid.addVertex(""+(3*xSize+j)+","+i);
                bigGrid.addVertex(""+(4*xSize+j)+","+i);
                bigGrid.addVertex(""+j+","+(ySize+i));
                bigGrid.addVertex(""+(xSize+j)+","+(ySize+i));
                bigGrid.addVertex(""+(2*xSize+j)+","+(ySize+i));
                bigGrid.addVertex(""+(3*xSize+j)+","+(ySize+i));
                bigGrid.addVertex(""+(4*xSize+j)+","+(ySize+i));
                bigGrid.addVertex(""+j+","+(2*ySize+i));
                bigGrid.addVertex(""+(xSize+j)+","+(2*ySize+i));
                bigGrid.addVertex(""+(2*xSize+j)+","+(2*ySize+i));
                bigGrid.addVertex(""+(3*xSize+j)+","+(2*ySize+i));
                bigGrid.addVertex(""+(4*xSize+j)+","+(2*ySize+i));
                bigGrid.addVertex(""+j+","+(3*ySize+i));
                bigGrid.addVertex(""+(xSize+j)+","+(3*ySize+i));
                bigGrid.addVertex(""+(2*xSize+j)+","+(3*ySize+i));
                bigGrid.addVertex(""+(3*xSize+j)+","+(3*ySize+i));
                bigGrid.addVertex(""+(4*xSize+j)+","+(3*ySize+i));
                bigGrid.addVertex(""+j+","+(4*ySize+i));
                bigGrid.addVertex(""+(xSize+j)+","+(4*ySize+i));
                bigGrid.addVertex(""+(2*xSize+j)+","+(4*ySize+i));
                bigGrid.addVertex(""+(3*xSize+j)+","+(4*ySize+i));
                bigGrid.addVertex(""+(4*xSize+j)+","+(4*ySize+i));
            }
        }

        for (int i = 0; i < ySize ; i++) {
            for (int j = 0; j < xSize ; j++) {
              //  System.out.println("Add edge: " + "" + (j) + "," + i + "  " + "" + (j + 1) + "," + i);

                if (j < xSize - 1) {
                    DefaultWeightedEdge e1 = grid.addEdge("" + j + "," + i, "" + (j + 1) + "," + i);
                    grid.setEdgeWeight(e1, riskGrid[j + 1][i]);
                }
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (!(k * xSize + j + 1 == maxBigX)) {
                            DefaultWeightedEdge b1 = bigGrid.addEdge("" + (k * xSize + j) + "," + (l * ySize + i),
                                    "" + (k * xSize + j + 1) + "," + (l * ySize + i));
                            bigGrid.setEdgeWeight(b1, riskGrid[k * xSize + j + 1][l * ySize + i]);
                        }
                    }
                }


                if (i < ySize - 1) {
                    DefaultWeightedEdge e2 = grid.addEdge("" + j + "," + i, "" + (j) + "," + (i + 1));
                    grid.setEdgeWeight(e2, riskGrid[j][i + 1]);
                }
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (!(l * ySize + i + 1 == maxBigY)) {
                            DefaultWeightedEdge b1 = bigGrid.addEdge("" + (k * xSize + j) + "," + (l * ySize + i),
                                    "" + (k * xSize + j) + "," + (l * ySize + i + 1));
                            bigGrid.setEdgeWeight(b1, riskGrid[k * xSize + j][l * ySize + i + 1]);
                        }
                    }
                }

                if (j > 0) {
                    DefaultWeightedEdge e3 = grid.addEdge("" + j + "," + i, "" + (j - 1) + "," + (i));
                    grid.setEdgeWeight(e3, riskGrid[j - 1][i]);
                }
                    for (int k = 0; k < 5; k++) {
                        for (int l = 0; l < 5; l++) {
                            if (!(k * xSize + j - 1 < 0)) {
                                DefaultWeightedEdge b1 = bigGrid.addEdge("" + (k * xSize + j) + "," + (l * ySize + i),
                                        "" + (k * xSize + j - 1) + "," + (l * ySize + i));
                                bigGrid.setEdgeWeight(b1, riskGrid[k * xSize + j - 1][l * ySize + i]);
                            }
                        }
                    }

                if (i > 0) {
                    DefaultWeightedEdge e4 = grid.addEdge("" + j + "," + i, "" + (j) + "," + (i - 1));
                    grid.setEdgeWeight(e4, riskGrid[j][i - 1]);
                }
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (!(l * ySize + i - 1 < 0)) {
                            DefaultWeightedEdge b1 = bigGrid.addEdge("" + (k * xSize + j) + "," + (l * ySize + i),
                                    "" + (k * xSize + j) + "," + (l * ySize + i - 1));
                            bigGrid.setEdgeWeight(b1, riskGrid[k * xSize + j][l * ySize + i - 1]);
                        }
                    }
                }



            }
        }
//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 50 ; j++) {
//                System.out.print(riskGrid[j][i]);
//            }
//            System.out.println();
//
//        }


        //traverseHrefGraph(grid,"0,0");

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg =
                new DijkstraShortestPath<>(grid);
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> iPaths = dijkstraAlg.getPaths("0,0");
        System.out.println(iPaths.getPath(""+(xSize-1)+","+(ySize-1)) + "\n");
        System.out.println(iPaths.getPath(""+(xSize-1)+","+(ySize-1)).getWeight());


        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlgB =
                new DijkstraShortestPath<>(bigGrid);
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> iPathsB = dijkstraAlgB.getPaths("0,0");
        System.out.println(iPathsB.getPath(""+(5*xSize-1)+","+(5*ySize-1)) + "\n");
        System.out.println(iPathsB.getPath(""+(5*xSize-1)+","+(5*ySize-1)).getWeight());

        //System.out.println(bigGrid.edgeSet());
        //traverseHrefGraph(bigGrid,"0,0");
    }



    private static void traverseHrefGraph(Graph<String,DefaultWeightedEdge> hrefGraph, String start)
    {
        Iterator<String> iterator = new DepthFirstIterator<>(hrefGraph, start);
        while (iterator.hasNext()) {
            String cave = iterator.next();
            System.out.println(cave);
        }
    }

    private static int increaseRisk(int risk, int factor) {
        int returnValue = risk;
        for (int i = 0; i < factor ; i++) {

            if (returnValue == 9)
                returnValue = 1;
            else
                returnValue++;
        }
        return returnValue;
    }



=======

import java.io.File;
import java.util.*;

public class DayFourteen {

    final static int STEPS = 10;
    final static int STEPS_PART2 = 40;

    public static void main(String[] args) {
        List<Character> template = new ArrayList<>();
        Map<String,Character> rules = new HashMap();

        try {
            File myObj = new File("input_day15.txt");
            Scanner myReader = new Scanner(myObj);

            String inputLine1 = myReader.nextLine();
            for (int i = 0; i < inputLine1.length() ; i++) {
                template.add(inputLine1.charAt(i));
            }

            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String[] nodeInputs = myReader.nextLine().split("\\s->\\s");
                rules.put(nodeInputs[0],nodeInputs[1].charAt(0));
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
//        System.out.println(template.toString());
//        for (String key : rules.keySet()) {
//            System.out.println(key + " " + rules.get(key));
//        }

        List<Character> initialTemplate = new ArrayList<>();
        for (Character copyChar:template
             ) {
            initialTemplate.add(copyChar);
        }

        List<Character> workingCopy = new ArrayList<>();
        System.out.println("Start: " + template);
        for (int i = 0; i < STEPS ; i++) {
            workingCopy.add(template.get(0));
            for (int j = 0; j < template.size() - 1 ; j++) {
                char firstCharacter = template.get(j);
                char secondChar = template.get(j+1);
               // System.out.println(firstCharacter+" "+secondChar);
                //Insert rule character here
                Character insertCharacter = rules.get(""+firstCharacter+secondChar);
                if(insertCharacter != null)
                    workingCopy.add(insertCharacter);
                workingCopy.add(secondChar);

            }
            template = workingCopy;
            workingCopy = new ArrayList<>();
            System.out.println(template);
        }
        System.out.println("End: "+ template);
        Map<Character,Integer> counts = new HashMap<>();
        for (Character templateCharacter:template
             ) {
            if(counts.containsKey(templateCharacter)){
                counts.put(templateCharacter,counts.get(templateCharacter)+1);
            }
            else{
                counts.put(templateCharacter,1);
            }
        }
        System.out.println(counts);
        int lowest = 999999999;
        int highest = 0;
        Character lowChar = ' ';
        Character highChar = ' ';
        for (Character countChar : counts.keySet()) {
            if(counts.get(countChar) < lowest){
                lowest = counts.get(countChar);
                lowChar = countChar;
            }
            if(counts.get(countChar) > highest){
                highest = counts.get(countChar);
                highChar = countChar;
            }
        }
        System.out.println("Lowest: "+lowChar+ " "+lowest + "   Highest: "+highChar+" "+highest);
        System.out.println("Answer Part 1: " + (highest - lowest));



        Map<Character, Double> charCounts = new HashMap<>();
        Map<String,Double> twoCharCounts = new HashMap<>();

        for (int i = 0; i < initialTemplate.size() - 1 ; i++) {
            if(twoCharCounts.containsKey(""+initialTemplate.get(i)+initialTemplate.get(i+1))){
                twoCharCounts.put(""+initialTemplate.get(i)+initialTemplate.get(i+1), twoCharCounts.get(""+initialTemplate.get(i)+initialTemplate.get(i+1)) + 1);
            }
            else {
                twoCharCounts.put("" + initialTemplate.get(i) + initialTemplate.get(i + 1), 1.0);
            }
            if(charCounts.containsKey(initialTemplate.get(i))) {
                charCounts.put(initialTemplate.get(i), charCounts.get(initialTemplate.get(i)) + 1);
            }
            else {
                charCounts.put(initialTemplate.get(i), 1.0);
            }
        }
        if(charCounts.containsKey(initialTemplate.get(initialTemplate.size() -1 )))
            charCounts.put(initialTemplate.get(initialTemplate.size() -1), charCounts.get(initialTemplate.get(initialTemplate.size() -1))+1 );
        else
            charCounts.put(initialTemplate.get(initialTemplate.size() -1), 1.0);
        for (int i = 0; i < STEPS_PART2 ; i++) {
//            System.out.println("Step: "+i);
//            System.out.println("2 Char counts: " + twoCharCounts.toString());
//            System.out.println("Char counts: " + charCounts.toString());

            Map<String,Double> workingTwoCharCounts = new HashMap<>();

            for (String twoCharKey : twoCharCounts.keySet()) {
                double originalCount = twoCharCounts.get(twoCharKey);
                if(originalCount > 0){
                    //System.out.println("Do some work for: " + twoCharKey);

                    Character ruleChar = rules.get(twoCharKey);
                    //System.out.println(""+twoCharKey.charAt(0)+ruleChar + "  " +ruleChar+twoCharKey.charAt(1));

                    //twoCharCounts.put(twoCharKey, 0);
                    //first combo
                    if(workingTwoCharCounts.containsKey(""+twoCharKey.charAt(0)+ruleChar)){
                        workingTwoCharCounts.put(""+twoCharKey.charAt(0)+ruleChar, workingTwoCharCounts.get(""+twoCharKey.charAt(0)+ruleChar) + originalCount);
                    }
                    else {
                        workingTwoCharCounts.put(""+twoCharKey.charAt(0)+ruleChar, originalCount);
                    }

                    //second combo
                    if(workingTwoCharCounts.containsKey(""+ruleChar+twoCharKey.charAt(1))){
                        workingTwoCharCounts.put(""+ruleChar+twoCharKey.charAt(1), workingTwoCharCounts.get(""+ruleChar+twoCharKey.charAt(1)) + originalCount);
                    }
                    else {
                        workingTwoCharCounts.put(""+ruleChar+twoCharKey.charAt(1), originalCount);
                    }

                    //Update char count for new char from rule
                    if(charCounts.containsKey(ruleChar ))
                        charCounts.put(ruleChar, charCounts.get(ruleChar) + originalCount );
                    else
                        charCounts.put(ruleChar, originalCount );

                }
            }
            twoCharCounts = workingTwoCharCounts;
        }

        //System.out.println("2 Char counts: " + twoCharCounts.toString());
        System.out.println();
        System.out.println("Part 2");
        System.out.println(charCounts);

        double dLowest = 999999999E12;
        double dHighest = 0;
        lowChar = ' ';
        highChar = ' ';
        for (Character countChar : charCounts.keySet()) {
            if(charCounts.get(countChar) < dLowest){
                dLowest = charCounts.get(countChar);
                lowChar = countChar;
            }
            if(charCounts.get(countChar) > dHighest){
                dHighest = charCounts.get(countChar);
                highChar = countChar;
            }
        }
        System.out.println("Lowest: "+lowChar+ " "+dLowest + "   Highest: "+highChar+" "+dHighest);
        System.out.println("Answer Part 2: " + String.format("%.0f", dHighest - dLowest));

    }
>>>>>>> origin/main
}
