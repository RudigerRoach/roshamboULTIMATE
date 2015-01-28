package Renderer;

import Game.Engine.IGameResult;
import Game.Moves.Move;
import Game.Player.IPlayer;
import GameState.GameState;

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
        if (winner.getMove().getMoveName().compareTo("") != 0){

        }
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
}
