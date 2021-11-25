
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    //Attributes
    private Hero hero;
    private Screen screen;
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


            Position position = new Position(10, 10);
            this.hero = new Hero(position);
            this.arena=new Arena(40,40,hero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        boolean playing = true;
        while (playing) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen);
        screen.refresh();
    }

    private void moveHero(Position position) {
        hero.setPosition(position);
    }

    private void processKey(KeyStroke key) throws IOException {
        Boolean playing=true;
        while(playing==true){
            switch (key.getKeyType()) {
                case ArrowUp:

                    arena.moveHero(hero.moveUp());
                    break;
                case ArrowDown:

                    arena.moveHero(hero.moveDown());
                    break;
                case ArrowRight:

                    arena.moveHero(hero.moveRight());
                    break;
                case ArrowLeft:

                    arena.moveHero(hero.moveLeft());
                    break;
                case Character:
                    if (key.getCharacter() == 'q') {
                        this.screen.close();
                        playing = false;
                        break;
                    }
                    break;
                case EOF:
                    playing = false;
                    break;

            }
            }
            System.out.println(key);
        }


}