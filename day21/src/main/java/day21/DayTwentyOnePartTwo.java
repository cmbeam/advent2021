package day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayTwentyOnePartTwo{
    public static void main(String[] args) {
        List<Integer> dies = new ArrayList<>();
        Integer[] dieArray = {3,4,5, 4,5,6, 5,6,7, 4,5,6, 5,6,7, 6,7,8, 5,6,7, 6,7,8, 7,8,9};
        for (Integer die:dieArray
             ) {
            dies.add(die);
        }
        Map<Integer,Integer> dieCounts = new HashMap<>();
        dieCounts.put(3,1);
        dieCounts.put(4,3);
        dieCounts.put(5,6);
        dieCounts.put(6,7);
        dieCounts.put(7,6);
        dieCounts.put(8,3);
        dieCounts.put(9,1);

        Map<StateKey,Long> universeCounts = new HashMap<>();

        long playerOneWins = 0;
        long playerTwoWins = 0;
        universeCounts.put(new StateKey(0,0, 2, 10), 1L);
        
        while(true){
            //Player 1
            List<StateKey> removalList = new ArrayList<>();
            Map<StateKey,Long> addUniverseCounts = new HashMap<>();
            for (Map.Entry<StateKey, Long> universe : universeCounts.entrySet()){
                for(Map.Entry<Integer,Integer> dieCount : dieCounts.entrySet()){
                    int position1 = universe.getKey().pos1;
                    int score1 = universe.getKey().score1;
                    int newPosition = Math.floorMod(dieCount.getKey() + position1,10);
                    if(newPosition == 0)
                        newPosition = 10;
                    int newScore = score1 + newPosition;
                    if(newScore >= 21){
                        playerOneWins = playerOneWins + universe.getValue() * dieCount.getValue();
                    }
                    else{
                        addUniverseCounts.put(new StateKey(newScore, universe.getKey().score2, newPosition, universe.getKey().pos2), universe.getValue() * dieCount.getValue());
                    }
                }
                removalList.add(universe.getKey());

            }
            for (StateKey removeKey:removalList
                 ) {
                universeCounts.remove(removeKey);
            }
            for (Map.Entry<StateKey, Long> addUniverse : addUniverseCounts.entrySet()
            ) {
                universeCounts.put(addUniverse.getKey(),addUniverse.getValue());
            }
            if(universeCounts.isEmpty())
                break;
            
            //Player 2
            removalList.clear();
            addUniverseCounts.clear();
            for (Map.Entry<StateKey, Long> universe : universeCounts.entrySet()){
                for(Map.Entry<Integer,Integer> dieCount : dieCounts.entrySet()){
                    int position2 = universe.getKey().pos2;
                    int score2 = universe.getKey().score2;
                    int newPosition = Math.floorMod(dieCount.getKey() + position2,10);
                    if(newPosition == 0)
                        newPosition = 10;
                    int newScore = score2 + newPosition;
                    if(newScore >= 21){
                        playerTwoWins = playerTwoWins + universe.getValue() * dieCount.getValue();
                    }
                    else{
                        addUniverseCounts.put(new StateKey(universe.getKey().score1, newScore, universe.getKey().pos1, newPosition), dieCount.getValue() * universe.getValue());
                    }
                }
                removalList.add(universe.getKey());
            }
            for (StateKey removeKey:removalList
            ) {
                universeCounts.remove(removeKey);
            }
            for (Map.Entry<StateKey, Long> addUniverse : addUniverseCounts.entrySet()
            ) {
                universeCounts.put(addUniverse.getKey(),addUniverse.getValue());
            }
            if(universeCounts.isEmpty())
                break;

            System.out.println(universeCounts.size());
            System.out.println("Player 1 wins: "+playerOneWins);
            System.out.println("Player 2 wins: "+playerTwoWins);
        }
        System.out.println("Player 1 wins: "+playerOneWins);
        System.out.println("Player 2 wins: "+playerTwoWins);
    }
}

class StateKey{
    int score1;
    int score2;
    int pos1;
    int pos2;
    public StateKey(int s1, int s2, int p1, int p2){
        score1 = s1;
        score2 = s2;
        pos1 = p1;
        pos2 = p2;
    }
}
