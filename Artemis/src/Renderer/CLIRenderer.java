package Renderer;

import Game.Engine.IGameResult;
import Game.Moves.Move;
import Game.Player.IPlayer;
import GameState.GameState;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Set;

public class CLIRenderer implements IRenderer {
    private GameState gameState;


    private IPlayer player1;
    private IPlayer player2;
    private Move player1Move;
    private Move player2Move;
    private IGameResult gameResult;
    private IPlayer winner;

    public void renderGame(GameState gameState){
        populatePrivates(gameState);
        printBanner();
        printMovesStatus();
        /*if (winner.getMove().getMoveName().compareTo("") != 0){

        }*/
    }

    private void populatePrivates(GameState gameState){
        this.gameState = gameState;
        player1 = gameState.getPlayer1();
        player2 = gameState.getPlayer2();
        player1Move = gameState.getPlayer1Move();
        player2Move = gameState.getPlayer2Move();
        gameResult = gameState.getGameResult();
        winner = gameState.getWinner();
    }

    private void printBanner(){
        System.out.println("****************************************");
        System.out.println("    You are now playing Roshambo.");
        System.out.println("****************************************");
    }

    private void printMovesStatus(){
        if (player1Move.getMoveName().compareTo("") != 0 && player2Move.getMoveName().compareTo("") != 0){
            System.out.println("You played "+player1Move.getMoveName());
            System.out.println("Your opponent played "+player2Move.getMoveName());
        }else if (player2Move.getMoveName().compareTo("") != 0){
            System.out.println("Waiting for your opponents move...");
        }else if (player1Move.getMoveName().compareTo("") != 0){
            System.out.println("Waiting for your move...");
        }
    }

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
        DataInputStream in = new DataInputStream(System.in);
        char c = in.readChar();
        if(((Character.toString(c)).compareTo("1")) == 0){
            return true;
        }
        return false;
    }

    @Override
    public String requestPlayerName(){
        System.out.println("please provide a player name: ");
        String playerName = System.console().readLine();
        return playerName;
    }

    @Override
    public Move requestMove(Set<String> possibleMovesStrings) {
        System.out.println("Please choose your move number: ");
        String[] moves = (String[])possibleMovesStrings.toArray();
        for (int i = 0; i < moves.length; i++){
            System.out.println(i+". "+moves[i]);
        }
        String move = (System.console().readLine()).substring(0,0);
        int pos = (Integer.parseInt(move));
        Move newMove = new Move(moves[pos]);
        return newMove;
    }

    @Override
    public void displayFinalResult(IPlayer player1, IPlayer player2, IGameResult result) {

    }
}
