package Game.Engine;

import Game.Moves.Move;

import java.io.File;

public class TextFileRuleSource implements IRuleSource
{
    private File physicalRuleSource;
    
    public TextFileRuleSource(String fileName)
    {
        physicalRuleSource = new File(fileName);
    }
    
    public IGameResult applyRule(Move move1, Move move2)
    {
        // TODO
        return null;
    }
}
