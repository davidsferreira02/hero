import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Arena {
    private int height;
    private int width;
    private Hero hero;


    public Arena(int height, int width, Hero hero) {
        this.height = height;
        this.width = width;
        this.hero = hero;
    }


    public void moveHero(Position position) {
        if (canHerMove(position)) {
            hero.setPosition(position);
        }
    }

    private Boolean canHerMove(Position position) {
        if (position.getX() < 0 || position.getX() >= width) {
            return false;
        }
        if (position.getY() < 0 || position.getY() >= height) {
            return false;
        }
        return true;
    }


    public void draw(Screen screen) throws IOException {
        screen.setCharacter(hero.getHeroX(),hero.getHeroY(), TextCharacter.fromCharacter('X')[0]);
    }
    {

    }
}

