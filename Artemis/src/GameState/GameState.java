package GameState;

import Game.Engine.IGameResult;
import Game.Moves.Move;
import Game.Player.IPlayer;

import java.util.List;

public class GameState {
    private IPlayer player1;
    private IPlayer player2;
    private Move player1Move;
    private Move player2Move;
    private IGameResult gameResult;
    private IPlayer winner;
    private List<Move> possibleMoves;

    public void setGameResult(IGameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void setPlayer1(IPlayer player1) {
        this.player1 = player1;
    }

    public void setPlayer1Move(Move player1Move) {
        this.player1Move = player1Move;
    }

    public void setPlayer2(IPlayer player2) {
        this.player2 = player2;
    }

    public void setPlayer2Move(Move player2Move) {
        this.player2Move = player2Move;
    }

    public void setWinner(IPlayer winner) {
        this.winner = winner;
    }

    public IPlayer getPlayer1() {
        return player1;
    }

    public IGameResult getGameResult() {
        return gameResult;
    }

    public IPlayer getPlayer2() {
        return player2;
    }

    public IPlayer getWinner() {
        return winner;
    }

    public Move getPlayer1Move() {
        return player1Move;
    }

    public Move getPlayer2Move() {
        return player2Move;
    }

    public void setPossibleMoves(List<Move> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public List<Move> getPossibleMoves() {
        return possibleMoves;
    }
}
