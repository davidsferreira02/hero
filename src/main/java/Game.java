import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private int x = 10;
    private int y = 10;

    private static Screen screen;

    public Game() {

        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() throws IOException {
        draw();
        KeyStroke key = screen.readInput();
        processKey(key);
        boolean play = true;
        while (play == true) {
            if (key.getKeyType() == KeyType.ArrowLeft) {
                y = y - 1;
                break;
            }
            if (key.getKeyType() == KeyType.ArrowRight) {
                y = y + 1;
                break;
            }
            if (key.getKeyType() == KeyType.ArrowUp) {
                x = x - 1;
                break;
            }
            if (key.getKeyType() == KeyType.ArrowDown) {
                x = x + 1;
                break;
            }
            if (key.getKeyType() == KeyType.EOF) {
                play = false;
                break;
            }
            if (key.getKeyType() == KeyType.Character) {
                if (key.getCharacter() == 'q') {
                    screen.close();
                    break;
                }
            }
        }
    }
    private void processKey(KeyStroke key) {
            System.out.println(key);
    }

    private void draw() {
        screen.clear();
        screen.setCharacter(x,y, TextCharacter.fromCharacter('X')[0]);
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}