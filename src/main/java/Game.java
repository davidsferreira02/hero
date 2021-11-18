import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private int x=10;
    private int y=10;

    private static  Screen screen ;

    public Game (){
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
            screen.clear();
            screen.setCharacter(x,y,TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   public void run() throws IOException {
        draw();
     KeyStroke key=screen.readInput();
     processKey(key);

}
    private void processKey(com.googlecode.lanterna.input.KeyStroke key){
        System.out.println(key);
    }
       private void draw(){
           screen.clear();
           screen.setCharacter(10, 10,
                   TextCharacter.fromCharacter('X')[0]);
           try {
               screen.refresh();
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
   }