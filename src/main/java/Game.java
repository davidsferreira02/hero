import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Game {
    private int x=10;
    private int y=10;
    private void readInput() {
        KeyStroke Key = screen.readInput();
    }

    private static  Screen screen ;
    private void processKey(KeyStroke key){
        System.out.println(key);
    }
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
   public void run() {
        draw();
       readInput();
     processKey(screen.readInput());
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