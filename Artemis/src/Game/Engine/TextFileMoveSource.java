package Game.Engine;

import Exceptions.EmptyFileException;
import Game.Moves.Move;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextFileMoveSource implements IMoveSource {
    IFileReader MoveFile;
    Map<String, Move> moveMap;
    @Override
    public Move getMoveFromName(String name) {
        return moveMap.get(name);
    }

    public TextFileMoveSource(IFileReader _FileReader) throws IOException, EmptyFileException {
        MoveFile = _FileReader;
        moveMap = new HashMap<String, Move>();
        generateMoveObjects();
    }

    public String getFileName()
    {
        return MoveFile.getFileName();
    }

    private void generateMoveObjects() throws IOException, EmptyFileException {
        String line;
        while((line = MoveFile.readLine()) != null) {
            Move current = new Move(line);
            moveMap.put(line, current);
        }
        if(moveMap.size() == 0)
            throw new EmptyFileException();
    }
}
