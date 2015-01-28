package Game.Engine;

import Exceptions.InvalidRuleFormatException;
import Exceptions.MovePairUndefinedException;
import Game.Moves.Move;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TextFileRuleSource implements IRuleSource
{
    private Map<MovePairKey, IGameResult> rules;
    
    public TextFileRuleSource(IFileReader ruleFileReader, IMoveSource moveSource) throws FileNotFoundException, IOException, InvalidRuleFormatException
    {
        String  ruleLine;
        rules = new HashMap<MovePairKey, IGameResult>();

        while ((ruleLine = ruleFileReader.readLine()) != null)
        {
            StringTokenizer tokenizer = new StringTokenizer(ruleLine, ",");
            if (tokenizer.countTokens() != 4)
            {
                throw new InvalidRuleFormatException();
            }
            Move        move1 = moveSource.getMoveFromName(tokenizer.nextToken());
            Move        move2 = moveSource.getMoveFromName(tokenizer.nextToken());
            MovePairKey key   = new MovePairKey(move1, move2);
            rules.put(key, GameResultFactory.parseGameResult(tokenizer.nextToken(), tokenizer.nextToken()));
        }
    }
    
    public IGameResult applyRule(Move move1, Move move2) throws MovePairUndefinedException
    {
        MovePairKey movePairKey = new MovePairKey(move1, move2);
        if (rules.containsKey(movePairKey))
        {
            return rules.get(movePairKey);
        }
        
        MovePairKey movePairKeyReversed = new MovePairKey(move2, move1);
        if (!rules.containsKey(movePairKeyReversed))
        {
            throw new MovePairUndefinedException();
        }

        return rules.get(movePairKey);
    }
}
