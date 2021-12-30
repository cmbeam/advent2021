package day22;

import java.io.File;
import java.util.*;

public class DayTwentyTwo {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("/GIT/advent2021/day22/src/main/resources/test2_day22.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

//        boolean[][][] grid = new boolean[100][100][100];
//        for (int x = 0; x < 100  ; x++) {
//            for (int y = 0; y < 100 ; y++) {
//                for (int z = 0; z < 100 ; z++) {
//                    grid[x][y][z] = true;
//                }
//            }
//        }
        HashMap<String,Boolean> grid = new HashMap<>();

        for (String input : inputs
        ) {


            int xRangeL = Integer.parseInt(input.split("\\s")[1].split(",")[0].split("=")[1].split("\\.\\.")[0]);
            int xRangeH = Integer.parseInt(input.split("\\s")[1].split(",")[0].split("=")[1].split("\\.\\.")[1]);

            int yRangeL = Integer.parseInt(input.split("\\s")[1].split(",")[1].split("=")[1].split("\\.\\.")[0]);
            int yRangeH = Integer.parseInt(input.split("\\s")[1].split(",")[1].split("=")[1].split("\\.\\.")[1]);

            int zRangeL = Integer.parseInt(input.split("\\s")[1].split(",")[2].split("=")[1].split("\\.\\.")[0]);
            int zRangeH = Integer.parseInt(input.split("\\s")[1].split(",")[2].split("=")[1].split("\\.\\.")[1]);

            System.out.println(xRangeL + " " + xRangeH + " " + yRangeL + " " + yRangeH + " " + zRangeL + " " + zRangeH);

//            if(xRangeL < -50)
//                xRangeL = -50;
//            if(yRangeL < -50)
//                yRangeL = -50;
//            if(zRangeL < -50)
//                zRangeL = -50;
//            if(xRangeH > 50)
//                xRangeH = 50;
//            if(yRangeH > 50)
//                yRangeH = 50;
//            if(zRangeH > 50)
//                zRangeH = 50;

            boolean on = input.split("\\s")[0].equals("on");
            for (int x = xRangeL; x <= xRangeH  ; x++) {

                for (int y = yRangeL; y <= yRangeH ; y++) {
                    //System.out.println(y+"range: "+yRangeL+ " "+yRangeH);
                    for (int z = zRangeL; z <= zRangeH ; z++) {

                        if(on) {

                            //grid.put("" + x + "," + y + "," + z, true);
                        }
                        else {
                            //grid.put("" + x + "," + y + "," + z, false);
                        }
                    }
                }
            }
        }
        int count = 0;
        for(Map.Entry<String, Boolean> entry : grid.entrySet()){
            if(entry.getValue() == true) {
                count++;
            }
        }
        System.out.println(count);
    }


}
class Cube{
    long xl, xh, yl,yh,zl,zh;
}
class Intersect {
    double volume;
    List<Cube> cubes;
    public Intersect(){
        this.volume = 0;
        this.cubes = new ArrayList<>();
    }

    public void add(long xl, long xh, long yl, long yh, long zl, long zh){
        Cube nCube = new Cube();
        nCube.xl = xl;
        nCube.xh = xh;
        nCube.yl = yl;
        nCube.yh = yh;
        nCube.zl = zl;
        nCube.zh = zh;
        long nVolume = (xh - xl) * (yh - yl) * (xh - zl);
        this.volume = this.volume + nVolume;
        for (Cube cube:cubes
             ) {
            if(intersects(nCube,cube)){

            }
        }
    }
    private boolean intersects(Cube c1, Cube c2){
        return false;
    }

}
