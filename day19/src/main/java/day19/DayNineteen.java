package day19;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayNineteen {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("/GIT/advent2021/day20/src/main/resources/input_day19.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }


    }
}
class ScannerInfo{
    List<Point> points;
    Point scannerLocation;

}

class Point{
    int x;
    int y;
    int z;
}

