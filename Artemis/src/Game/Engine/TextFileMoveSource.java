package Game.Engine;

import Exceptions.EmptyFileException;
import Game.Moves.Move;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextFileMoveSource implements IMoveSource {
    File MoveFile;
    Map<String, Move> moveMap;

    @Override
    public Move getMoveFromName(String name) {
        return moveMap.get(name);
    }

    public TextFileMoveSource(String filename) throws IOException, EmptyFileException
    {
        MoveFile = new File(filename);
        moveMap = new HashMap<String, Move>();
        generateMoveObjects();
    }

    private void generateMoveObjects() throws IOException, EmptyFileException {
        BufferedReader bfr = new BufferedReader(new FileReader(MoveFile));
        String line;
        while((line = bfr.readLine()) != null) {
            Move current = new Move(line);
            moveMap.put(line, current);
        }
        if(moveMap.size() == 0)
            throw new EmptyFileException();
        bfr.close();
    }
}
