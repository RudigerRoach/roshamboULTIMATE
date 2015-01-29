package Game.Engine;

import Exceptions.InvalidResultException;
import Exceptions.InvalidRuleFormatException;
import Exceptions.MovePairUndefinedException;
import Game.Moves.Move;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TextFileRuleSource implements RuleSource
{
    private Map<MovePairKey, GameResult> rules;
    
    public TextFileRuleSource(FileReader ruleFileReader, MoveSource moveSource) throws FileNotFoundException, IOException, InvalidRuleFormatException, InvalidResultException {
        String  ruleLine;
        rules = new HashMap<MovePairKey, GameResult>();

        while ((ruleLine = ruleFileReader.readLine()) != null)
        {
            StringTokenizer tokenizer = new StringTokenizer(ruleLine, ", ");
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
    
    public GameResult applyRule(Move move1, Move move2) throws MovePairUndefinedException
    {
        MovePairKey movePairKey = new MovePairKey(move1, move2);
        if (rules.containsKey(movePairKey))
        {
            return rules.get(movePairKey);
        }
        
        throw new MovePairUndefinedException();
    }
}
