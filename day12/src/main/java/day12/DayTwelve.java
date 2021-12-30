package day12;

import java.io.File;
import java.util.*;

public class DayTwelve {
    public static void main(String[] args) {

        Map<String, CaveNode> nodes = new HashMap<>();
        try {
            File myObj = new File("/GIT/advent2021/day12/src/main/resources/input_day12.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String[] nodeInputs = myReader.nextLine().split("-");
//                System.out.println(nodeInputs[0]);
//                System.out.println(nodeInputs[1]);
//                System.out.println();

                CaveNode node0 = null;
                if(nodes.containsKey(nodeInputs[0])){
                    node0 = nodes.get(nodeInputs[0]);
                }
                else{
                    boolean large = false;
                    if(isStringUpperCase(nodeInputs[0]))
                        large = true;
                    node0 = new CaveNode(nodeInputs[0],large);
                }
                CaveNode node1 = null;
                if(nodes.containsKey(nodeInputs[1])){
                    node1 = nodes.get(nodeInputs[1]);
                }
                else {
                    boolean large = false;
                    if(isStringUpperCase(nodeInputs[1]))
                        large = true;
                    node1 = new CaveNode(nodeInputs[1], large);
                }
                node0.addChild(node1);
                if(!nodeInputs[1].equals("end"))
                    node1.addChild(node0);
                nodes.put(node0.name, node0);
                nodes.put(node1.name, node1);
            }
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        for (Map.Entry<String,CaveNode> cNode:nodes.entrySet()) {
            System.out.print(cNode.getKey() + ":"+cNode.getValue().large + "   ");
            for (CaveNode ccNode:cNode.getValue().children) {
                System.out.print(ccNode.name+":");

            }
            System.out.println();

        }
        System.out.println();

        List<String> allPaths = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        findRoutes("start", nodes, currentPath, allPaths);
        for (String path:allPaths
             ) {
            System.out.println(path);

        }
        System.out.println("Answer part 1: "+allPaths.size());
    }

    public static class CaveNode{
        String name;
        int visits;
        boolean large;
        List<CaveNode> children;

        CaveNode(String name, boolean large){
            this.name = name;
            this.large = large;
            this.visits = 0;
            this.children = new ArrayList<>();
        }
        void addChild(CaveNode child){
            this.children.add(child);
        }

    }

    public static void findRoutes(String head, Map<String, CaveNode> nodes, List<String> currentPath, List<String> paths){
        System.out.println("Node: " + head);
        currentPath.add(head);
        if(head.equals("end")) {
            System.out.println("End path found   "+currentPath.toString());
            paths.add(currentPath.toString());
        }
        else{
            for (CaveNode child:nodes.get(head).children
                 ) {
                System.out.println("Child: "+child.name);
 //               if(!currentPath.contains(child.name) || child.large || child.name.equals("end")) {
                if(canVisit(child.name, currentPath)){
                    List<String> newCurrentPath = new ArrayList<>();
                    for (String nodeInList:currentPath) {
                        newCurrentPath.add(nodeInList);
                    }
                    findRoutes(child.name, nodes, newCurrentPath, paths);
                }
            }
        }
    }
    private static boolean isStringUpperCase(String str){

        //convert String to char array
        char[] charArray = str.toCharArray();

        for(int i=0; i < charArray.length; i++){

            //if any character is not in upper case, return false
            if( !Character.isUpperCase( charArray[i] ))
                return false;
        }

        return true;
    }
    private static boolean canVisit(String name, List<String> currentPath) {
        if(name.equals("start"))
            return false;

        if(isStringUpperCase(name))
            return true;

        if(!currentPath.contains(name))
            return true;

        List<String> visitedCount = new ArrayList<>();
        for (String cName:currentPath
             ) {
            System.out.println(visitedCount.toString());
            if(visitedCount.contains(cName) && !isStringUpperCase(cName))
                return false;
            else
                visitedCount.add(cName);
        }

        return true;
    }

}
