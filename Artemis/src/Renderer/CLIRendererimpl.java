package Renderer;

import Game.Engine.GameResult;
import Game.Moves.Move;
import Game.Player.Player;

import java.io.IOException;
import java.util.*;

public class CLIRendererimpl implements Renderer.Renderer {


    @Override
    public void displayWelcomeScreen() {
        System.out.println("****************************************");
        System.out.println("    You are now playing Roshambo.");
        System.out.println("****************************************");
    }

    @Override
    public Boolean confirmComputerPlayer() throws IOException {
        System.out.println("Play against :");
        System.out.println("1. The Computer");
        System.out.println("2. Another player");
        Scanner s = new Scanner(System.in);

        String playComputer = s.nextLine();

        if(((playComputer).compareTo("1")) == 0){
            return true;
        }
        return false;
    }

    @Override
    public String requestPlayerName(){
        System.out.println("please provide a player name: ");
        Scanner s = new Scanner(System.in);
        String playerName = s.nextLine();
        return playerName;
    }

    @Override
    public Move requestMove(Set<String> possibleMovesStrings) {
        System.out.println("Please choose your move number: ");
        Iterator it =  possibleMovesStrings.iterator();
        Object[] moves;
        moves = possibleMovesStrings.toArray();
        int i = 0;
        while (it.hasNext()){
            String k = (String) it.next();
            System.out.println(i+". "+k);
            i++;
        }

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int ichoice = Integer.parseInt(choice);
        return new Move ((String) moves[ichoice]);
    }

    @Override
    public void displayFinalResult(Player player1, Player player2, GameResult result) {
        System.out.println(player1.getName() + " chose: " + player1.getMoveName()+" vs "+player2.getName() + " chose: " + player2.getMoveName());
        System.out.println(result.getResult());
    }
}
