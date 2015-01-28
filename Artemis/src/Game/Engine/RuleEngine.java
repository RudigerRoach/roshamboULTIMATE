package Game.Engine;

import Game.Player.IPlayer;

public class RuleEngine {
        IRuleSource ruleSource;
        public IGameResult getResult(IPlayer player1, IPlayer player2)
        {
            return ruleSource.applyRule(player1.getMove(), player2.getMove());
        }
}
