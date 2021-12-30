package day13;

import java.io.File;
import java.util.Scanner;

public class DayThirteen {
    public static void main(String[] args) {
        try {
            File myObj = new File("/GIT/advent2021/day13/src/main/resources/input_day13.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String[] nodeInputs = myReader.nextLine().split("-");
            }
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
