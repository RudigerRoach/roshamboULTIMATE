package Game.Engine;

import Game.Moves.Move;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TextFileRuleSource implements IRuleSource
{
    private Map<MovePairKey, IGameResult> rules;
    
    public TextFileRuleSource(string fileName, IMoveSource moveSource)
    {
        File               ruleFile           = new File(fileName);
        FileReader         ruleFileReader     = new FileReader(ruleFile);
        BufferedFileReader physicalRuleSource = new BufferedFileReader(ruleFileReader);
        String             ruleLine;
        rules = new HashMap<MovePairKey, IGameResult>();

        while ((ruleLine = physicalRuleSource.readLine()) != null)
        {
            String[]    values = ruleLine.split(",");
            Move        move1  = moveSource.getMoveFromName(values[0]);
            Move        move2  = moveSource.getMoveFromName(values[1]);
            MovePairKey key    = new MovePairKey(move1, move2);
            rules.put(key, new Rule(values[2]));
        }
    }
    
    public IGameResult applyRule(Move move1, Move move2)
    {
        MovePairKey movePairKey = new MovePairKey(move1, move2);
        if (containsKey(movePairKey))
        {
            return rules.get(movePairKey);
        }
        
        MovePairKey movePairKeyReversed = new MovePairKey(move2, move1);
        if (!containsKey(movePairKey))
        {
            throw new MovePairNotDefinedException();
        }

        return rules.get(movePairKey);
    }
}
