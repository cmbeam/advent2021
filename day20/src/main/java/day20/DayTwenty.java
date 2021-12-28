package day20;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class DayTwenty {
    static final int layers = 2;
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        char[] ieAlgorithm = new char[0];
        Map<Point, Character> imageArray = new HashMap<>();

        try {
            File myObj = new File("/Users/cbeam/GIT/advent2021/day20/src/main/resources/input_day20.txt");
            Scanner myReader = new Scanner(myObj);
            ieAlgorithm = myReader.nextLine().toCharArray();
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        for (int y = 0; y < inputs.size() ; y++) {
            for (int x = 0; x < inputs.get(y).length() ; x++) {
                imageArray.put(new Point(x,y), inputs.get(y).charAt(x));
            }

        }
        //System.out.println(imageArray);
        printImage(imageArray);
        
        int eLimit = 50;
        
        Map<Point,Character> eImage = new HashMap<>();
        
        for (int enhancements = 0; enhancements < eLimit; enhancements++) {
            double size = Math.sqrt(imageArray.size());
            for (int y = -1; y < size +1; y++) {
                for (int x = -1; x < size +  1; x++) {
                    String binaryString = "";
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2 ; j++) {
                            if(imageArray.containsKey(new Point(x+j,y+i))) {
                                char pixelChar = imageArray.get(new Point(x + j, y + i));
                                if (pixelChar == '#') {
                                    binaryString = binaryString + '1';
                                } else {
                                    binaryString = binaryString + '0';
                                }
                            }
                            else{
                                if(Math.floorMod(enhancements, 2) == 1 && ieAlgorithm[0] == '#') {
                                    binaryString = binaryString + '1';
                                }
                                else{
                                    binaryString = binaryString + '0';
                                }
                            }

                        }

                    }
//                    if(Integer.parseInt(binaryString,2) >510)
//                        System.out.println("Big binary: " + Integer.parseInt(binaryString,2) + " " + ieAlgorithm[Integer.parseInt(binaryString, 2)] );
//                    //System.out.println(Integer.parseInt(binaryString, 2));
                   eImage.put(new Point(x+1,y+1), ieAlgorithm[Integer.parseInt(binaryString, 2)]);
                }
            }
            imageArray.clear();
            imageArray.putAll(eImage);
            eImage.clear();
            printImage(imageArray);
            System.out.println();

        }
        System.out.println();
        System.out.println();

        printImage(imageArray);


    }

    private static void printImage(Map<Point,Character> imageArray) {
        long pixelCount = 0;
        double size = Math.sqrt(imageArray.size());
        for (int y = -(layers+1); y < size + layers+1; y++) {
            for (int x = -(layers+1); x < size + layers+1; x++) {
                if(imageArray.containsKey(new Point(x,y))){
                    System.out.print(imageArray.get(new Point(x,y)));
                    if(imageArray.get(new Point(x,y)) == '#'){
                        pixelCount++;
                    }
                }
                else
                    System.out.print(".");
            }
            System.out.println();
        }
        System.out.println("Pixel count: "+pixelCount);

    }
}
class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
