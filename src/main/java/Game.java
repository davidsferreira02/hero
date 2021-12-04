
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    //Attributes
     static Screen screen;
    private Arena arena;

    //Methods
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null); //don't need a cursor
            this.screen.startScreen(); //start screen
            this.screen.doResizeIfNecessary(); //resize if needed


            this.arena = new Arena(40, 40);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        boolean playing = true;
        while (playing) {
            draw();
            KeyStroke key = screen.readInput();
            playing=processKey(key);
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();


    }



    private boolean processKey(KeyStroke key) throws IOException {
        return arena.processKey(key);
    }
}



