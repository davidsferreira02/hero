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
    // private int x = 10;
    //private int y = 10;
    private Hero hero;


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
            Hero hero = new Hero(10, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() throws IOException {

        boolean play = true;
        while (play == true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

    private void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowLeft) {
            hero.moveLeft();

        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            hero.moveRight();
        }
        if (key.getKeyType() == KeyType.ArrowUp) {
            hero.moveUp();

        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            hero.moveDown();

        }
        if (key.getKeyType() == KeyType.EOF) {


        }
        if (key.getKeyType() == KeyType.Character) {
            if (key.getCharacter() == 'q') {
                try {
                    screen.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println(key);
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();


    }
}