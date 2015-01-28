package Game.Engine;

import Exceptions.MovePairUndefinedException;
import Game.Player.IPlayer;

public class RuleEngine {
        IRuleSource ruleSource;
        public IGameResult getResult(IPlayer player1, IPlayer player2) throws MovePairUndefinedException {
            return ruleSource.applyRule(player1.getMove(), player2.getMove());
        }
}
