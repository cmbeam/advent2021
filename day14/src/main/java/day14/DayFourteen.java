package day14;

import java.io.File;
import java.util.*;

public class DayFourteen {

    final static int STEPS = 10;
    final static int STEPS_PART2 = 40;

    public static void main(String[] args) {
        List<Character> template = new ArrayList<>();
        Map<String,Character> rules = new HashMap();

        try {
            File myObj = new File("input_day14.txt");
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
}
