package Game.Engine;

import GameState.GameState;
import Renderer.CLIRenderer;
import Renderer.IRenderer;

public class GameManager {
    private GameState gamestate;
    IRenderer renderer;
    public void initialise()
    {
        gamestate = new GameState();
        renderer = new CLIRenderer();

        renderer.displayWelcomeScreen();
        Boolean computer = renderer.confirmComputerPlayer();
        String PlayerName = renderer.requestPlayerName();

    }
}
