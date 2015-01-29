package Game.Engine;

import Exceptions.EmptyFileException;
import Game.Moves.Move;

import java.io.*;
import java.util.*;

public class TextFileMoveSource implements MoveSource {
    FileReader MoveFile;
    Map<String, Move> moveMap;
    @Override
    public Move getMoveFromName(String name) {
        return moveMap.get(name);
    }

    public TextFileMoveSource(FileReader _FileReader) throws IOException, EmptyFileException {
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

    public Set<String> getPossibleMovesStrings()
    {
        return moveMap.keySet();
    }

    public Collection<Move> getPossibleMoves()
    {
        return moveMap.values();
    }
}
