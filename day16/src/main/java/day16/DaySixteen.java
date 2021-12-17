package day16;

import java.io.File;
import java.util.*;

public class DaySixteen {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("input_day16.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        String hexString = inputs.get(0);
        //System.out.println(hexString);
        int offSet = 0;
        String sCode = "";
        while (hexString.length() > offSet){
            int code = 0;
            if(hexString.length() > offSet+1)
                code = HexFormat.fromHexDigits(hexString.substring(offSet,offSet+1));
            else
                code = HexFormat.fromHexDigits(hexString.substring(offSet));
            for (int i = 0; i < 4 - Integer.toBinaryString(code).length() ; i++) {
                sCode = sCode.concat("0");
            }
            sCode = sCode.concat(Integer.toBinaryString(code));
            offSet = offSet + 1;
        }


        //System.out.println(sCode);

        String[] result = parsePacket(sCode);
        System.out.println("\n\n");
        System.out.println("Answer part 1: " +result[0]);
        System.out.println(result[2]);
        System.out.println("Answer part 2: "+ Long.parseLong(result[2], 2));


    }

    private static String[] parsePacket(String bPacket){

        //System.out.println(bPacket);

        int version = Integer.parseInt(bPacket.substring(0,3),2);
        //System.out.println("Ver: "+version);

        int type = Integer.parseInt(bPacket.substring(3,6), 2);
        //System.out.println("Type: "+type);


        if(type == 4) {
            String sLiteral = "";
            int offset = 6;
            String bit = bPacket.substring(offset, offset + 5);

            while (bit.charAt(0) == '1') {
                sLiteral = sLiteral.concat(bit.substring(1, 5));
                offset = offset + 5;
                bit = bPacket.substring(offset, offset + 5);
            }
            sLiteral = sLiteral.concat(bit.substring(1, 5));
            //int literal = Integer.parseInt(sLiteral, 2);

            String[] returnArray = new String[3];
            returnArray[0] = ""+version;//+" "+type+" "+literal;
            returnArray[1] = "" +(offset + 5);
            returnArray[2] = sLiteral;
            System.out.println("Literal return: "+returnArray[2] +"  " + Long.parseLong(returnArray[2],2));
            return returnArray;
        }
        else{
            int versionSum = version;
            String lengthTypeId = bPacket.substring(6,7);
            int offset = 0;
            List<String> subPackets = new ArrayList<>();
            if(lengthTypeId.equals("0")){
                offset = 22;
                //System.out.println(bPacket.substring(7,22));
                int length = Integer.parseInt(bPacket.substring(7,22),2);
                //System.out.println("Length: " + length);

                int subOffset = 0;
                while(subOffset < length) {
                    //System.out.println("S: "+subOffset+ " l: "+length);
                    //System.out.println(parsePacket(bPacket.substring(offset+subOffset))[0]);
                    String[] returnValue = parsePacket(bPacket.substring(offset+subOffset));
                    versionSum = versionSum + Integer.parseInt(returnValue[0]);

                    subPackets.add(returnValue[2]);
                    //System.out.println("v "+versionSum);
                    //System.out.println(parsePacket(bPacket.substring(offset+subOffset))[1]);
                    subOffset = subOffset + Integer.parseInt(returnValue[1]);
                   // System.out.println("ss:"+subOffset);
                }
                offset=offset+subOffset;
            }
            else{
                offset = 18;
                //System.out.println(bPacket.substring(7,18));
                int numberOfPackets = Integer.parseInt(bPacket.substring(7,18),2);
                //System.out.println("Number of packets: " + numberOfPackets);

                int subOffset = 0;
                int packets = 0;

                while(packets < numberOfPackets) {
                    //System.out.println(parsePacket(bPacket.substring(offset+subOffset))[0]);
                    //versionSum = versionSum + Integer.parseInt(parsePacket(bPacket.substring(offset+subOffset))[0]);
                    String[] returnValue = parsePacket(bPacket.substring(offset+subOffset));
                    versionSum = versionSum + Integer.parseInt(returnValue[0]);

                    subPackets.add(returnValue[2]);
                    //System.out.println("v "+versionSum);
                    //System.out.println(parsePacket(bPacket.substring(offset+subOffset))[1]);
                    subOffset = subOffset + Integer.parseInt(returnValue[1]);
                    packets++;
                }
                offset=offset+subOffset;
            }

            String[] returnArray = new String[3];
            returnArray[0] = ""+versionSum;
            returnArray[1] = "" + offset;
            returnArray[2] = "" + calculateOperation(type, subPackets);
            System.out.println("Type: "+type+"  Packets: "+subPackets+"  Calc Answer: " + returnArray[2] + "  " + Long.parseLong(returnArray[2], 2));
            return returnArray;
        }

    }
    private static String calculateOperation(int type, List<String> subPackets){
        if(type == 0){
            long sum = 0;
            for (String subPacket:subPackets
                 ) {
                sum = sum + Long.parseLong(subPacket, 2);
            }
            return Long.toBinaryString(sum);
        }
        if(type == 1){
            long product = 1;
            for (String subPacket:subPackets
            ) {
               // product = product * Integer.parseInt(subPacket, 2);
                product = product * Long.parseLong(subPacket, 2);
            }
            return Long.toBinaryString(product);
        }

        if(type == 2){
            List<Long> valueList = new ArrayList<>();
            for (String subPacket:subPackets
                 ) {
                valueList.add(Long.parseLong(subPacket,2));
            }
            Collections.sort(valueList);
            return Long.toBinaryString(valueList.get(0));
        }

        if(type == 3){
            List<Long> valueList = new ArrayList<>();
            for (String subPacket:subPackets
            ) {
                valueList.add(Long.parseLong(subPacket,2));
            }
            Collections.sort(valueList);
            return Long.toBinaryString(valueList.get(valueList.size() -1));
        }

        if(type == 5){
            if(Long.parseLong(subPackets.get(0), 2)  > Long.parseLong(subPackets.get(1), 2))
                return Integer.toBinaryString(1);
            else
                return Integer.toBinaryString(0);
        }
        if(type == 6){
            if(Long.parseLong(subPackets.get(0),2)  < Long.parseLong(subPackets.get(1),2))
                return Integer.toBinaryString(1);
            else
                return Integer.toBinaryString(0);
        }
        if(type == 7){
            if(Long.parseLong(subPackets.get(0),2)  == Long.parseLong(subPackets.get(1),2))
                return Integer.toBinaryString(1);
            else
                return Integer.toBinaryString(0);
        }

        //Default, should never get here
        return Integer.toBinaryString(0);
    }

}
