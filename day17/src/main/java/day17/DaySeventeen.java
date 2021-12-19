package day17;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaySeventeen {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("input_day17.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        int xTargetL = Integer.parseInt(inputs.get(0).split(": ")[1].split(", ")[0].split("=")[1].split("\\.\\.")[0]);
        int xTargetH = Integer.parseInt(inputs.get(0).split(": ")[1].split(", ")[0].split("=")[1].split("\\.\\.")[1]);

        int yTargetL = Integer.parseInt(inputs.get(0).split(": ")[1].split(", ")[1].split("=")[1].split("\\.\\.")[0]);
        int yTargetH = Integer.parseInt(inputs.get(0).split(": ")[1].split(", ")[1].split("=")[1].split("\\.\\.")[1]);

        System.out.println(xTargetL+" "+xTargetH+ " "+yTargetL+" "+yTargetH);

        int[] start = new int[2];
        start[0] = 0;
        start[1] = 0;
        int[] vector = new int[2];
        vector[0] = 6;
        vector[1] = 0;



       System.out.println(hitsTarget(start,vector,xTargetL,xTargetH,yTargetL,yTargetH));
        int maxY = 0;
        int count = 0;
        for (int i = 0; i < xTargetH + 1; i++) {
            for (int j = -100; j < 100 ; j++) {
                int[] newVector = new int[2];
                vector[0] = i;
                vector[1] = j;
                int y = hitsTarget(start,vector,xTargetL,xTargetH,yTargetL,yTargetH);
                if(y > maxY)
                    maxY = y;
                if(y >=0){
                    count++;
                }
            }

        }
        System.out.println("Max y: " + maxY);
        System.out.println(("Count: " + count));


    }
    private static int hitsTarget(int[] start, int[] vector, int xTargetLow, int xTargetHigh, int yTargetLow, int yTargetHigh){

        int x = start[0];
        int y = start[1];
        int xVector = vector[0];
        int yVector = vector[1];
        boolean hit = false;
        int yHigh = 0;
        while(!hit && x <= xTargetHigh && y >= yTargetLow){
            if(y > yHigh)
                yHigh = y;
            x = x + xVector;
            y = y + yVector;
            if(xVector > 0)
                xVector--;
            if(xVector < 0)
                xVector++;
            yVector--;
            System.out.println("("+x+","+y+")");
            if(x >= xTargetLow && x <= xTargetHigh && y >= yTargetLow && y <= yTargetHigh) {
                System.out.println("Vector: " + vector[0] + " " + vector[1]);
                hit = true;
            }
        }

        if(hit) {
            //System.out.println("x: " + x + " y: " + y + "   " + yHigh);

            return yHigh;
        }
        else
            return -1;
    }
}
