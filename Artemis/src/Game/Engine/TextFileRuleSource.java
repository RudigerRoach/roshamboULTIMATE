package Game.Engine;

import Game.Moves.Move;

public class TextFileRuleSource implements IRuleSource
{
    private File physicalRuleSource;
    
    public TextFileRuleSource(string fileName)
    {
        physicalRuleSource = new File(fileName);
    }
    
    public IGameResult applyRule(Move move1, Move move2)
    {
        // TODO
    }
}
