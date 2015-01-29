package Game.Engine;

import Exceptions.MovePairUndefinedException;
import Game.Moves.Move;

public interface RuleSource {
    public GameResult applyRule(Move move1, Move move2) throws MovePairUndefinedException;
}
