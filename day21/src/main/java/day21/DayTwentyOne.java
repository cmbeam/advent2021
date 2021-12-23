package day21;


import java.util.ArrayList;
import java.util.List;

public class DayTwentyOne {
    final static int oneStart = 2;
    final static int twoStart = 10;

    public static void main(String[] args) {
        long scoreOne = 0;
        long scoreTwo = 0;
        int onePosition = oneStart;
        int twoPosition = twoStart;
        int dieValue = 1;

        DeterministicDie die = new DeterministicDie(100);
        while(true){
            //Player 1
            int oneRoll = die.getNextRoll() + die.getNextRoll() +die.getNextRoll();
            onePosition = Math.floorMod(onePosition + oneRoll, 10);
            if(onePosition == 0)
                onePosition = 10;
            scoreOne = scoreOne + onePosition;
           // System.out.println("1:  " + scoreOne);
            if(scoreOne >= 1000)
                break;

            //Player 2
            int twoRoll = die.getNextRoll() + die.getNextRoll() +die.getNextRoll();
            twoPosition = Math.floorMod(twoPosition + twoRoll, 10);
            if(twoPosition == 0)
                twoPosition = 10;
            scoreTwo = scoreTwo + twoPosition;
            //System.out.println("2:  "+scoreTwo);
            if(scoreTwo >= 1000)
                break;
        }

        if(scoreOne >= scoreTwo){
            System.out.println("Answer part 1: " + (scoreTwo * die.getRolls()));
        }
        else{
            System.out.println("Answer part 1: " + (scoreOne * die.getRolls()));
        }

        List<Game> games = new ArrayList<>();
        List<Game> completeGames = new ArrayList<>();
        Game startGame = new Game();
        startGame.gameContinues = true;
        startGame.scoreOne = 0;
        startGame.scoreTwo = 0;
        startGame.onePosition = oneStart;
        startGame.twoPosition = twoStart;
        games.add(startGame);
        boolean gameOverAll = true;

        int level = 0;
        while(gameOverAll){
            List<Game> intermediateGames = new ArrayList<>();
            for (int i = 1; i <= 3 ; i++) {
                for (int j = 1; j <= 3; j++) {
                    for (int k = 1; k <= 3; k++) {
                        for (int l = 1; l <= 3 ; l++) {
                            for (int m = 1; m <= 3 ; m++) {
                                for (int n = 1; n <= 3 ; n++) {
                                    System.out.println("New: "+ games.size() + "   " + i + " " + j + " " + k + " " + l + " "+ m + " " +n);
                                    gameOverAll = false;
                                    for (Game game:games
                                         ) {
                                        if(game.gameContinues) {
                                            gameOverAll = true;
                                            boolean singleGameOver = true;
                                            int oneRollQ = i + j + k;
                                            int onePos = Math.floorMod(game.onePosition + oneRollQ, 10);
                                            if (onePos == 0)
                                                onePos = 10;
                                            int score1 = game.scoreOne + onePos;
                                            //System.out.println("1:  " + score1);
                                            if(score1 > 21){
                                                singleGameOver = false;
                                            }

                                            int twoRollQ = l + m + n;
                                            int twoPos = Math.floorMod(game.twoPosition + twoRollQ, 10);
                                            if (twoPos == 0)
                                                twoPos = 10;
                                            int score2 = game.scoreTwo + twoPos;
                                            //System.out.println("2:  " + score2);
                                            if(score2 > 21){
                                                //System.out.println("Done 2");
                                                singleGameOver = false;
                                            }
                                            Game newGame = new Game();
                                            newGame.gameContinues = singleGameOver;
                                            newGame.onePosition=onePos;
                                            newGame.twoPosition=twoPos;
                                            newGame.scoreOne=score1;
                                            newGame.scoreTwo=score2;
                                            intermediateGames.add(newGame);
                                            //System.out.println("Continue?: " +newGame.gameContinues);

                                        }
                                        else{
                                            if(!intermediateGames.contains(game))
                                                intermediateGames.add(game);
                                        }

                                    }

                                }

                            }

                        }
                    }
                }
            }
            System.out.println("Level: " + level);
            games.clear();
            games.addAll(intermediateGames);
        }
        System.out.println(games.toString());


    }

}
class DeterministicDie{
    int currentRoll;
    int sides;
    long rolls;
    public DeterministicDie(int sides) {
        this.currentRoll = 0;
        this.sides = sides;
    }
    public int getNextRoll() {
        if(currentRoll < sides)
            currentRoll++;
        else
            currentRoll = 1;
        rolls++;
        return currentRoll;
    }

    public long getRolls() {
        return rolls;
    }
}



class Game{
    int scoreOne;
    int scoreTwo;
    int onePosition;
    int twoPosition;
    boolean gameContinues;


}
