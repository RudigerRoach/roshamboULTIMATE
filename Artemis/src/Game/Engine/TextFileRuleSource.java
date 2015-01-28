package Game.Engine;

import Game.Moves.Move;
import org.junit.Rule;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TextFileRuleSource implements IRuleSource
{
    private Map<MovePairKey, IGameResult> rules;
    
    public TextFileRuleSource(String fileName, IMoveSource moveSource) throws FileNotFoundException, IOException
    {
        File           ruleFile           = new File(fileName);
        FileReader     ruleFileReader     = new FileReader(ruleFile);
        BufferedReader physicalRuleSource = new BufferedReader(ruleFileReader);
        String         ruleLine;
        rules = new HashMap<MovePairKey, IGameResult>();

        while ((ruleLine = physicalRuleSource.readLine()) != null)
        {
            String[]    values = ruleLine.split(",");
            Move        move1  = moveSource.getMoveFromName(values[0]);
            Move        move2  = moveSource.getMoveFromName(values[1]);
            MovePairKey key    = new MovePairKey(move1, move2);
            rules.put(key, GameResultFactory.parseGameResult(values[2], values[3]));
        }
    }
    
    public IGameResult applyRule(Move move1, Move move2) throws MovePairUndefinedException {
        MovePairKey movePairKey = new MovePairKey(move1, move2);
        if (rules.containsKey(movePairKey))
        {
            return rules.get(movePairKey);
        }
        
        MovePairKey movePairKeyReversed = new MovePairKey(move2, move1);
        if (!rules.containsKey(movePairKey))
        {
            throw new MovePairUndefinedException();
        }

        return rules.get(movePairKey);
    }
}
