import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int height;
    private int width;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;


    public Arena(int height, int width) {
        this.height = height;
        this.width = width;
        this.hero = new Hero(new Position(10, 10));
        this.walls = createWalls();
        this.coins=createCoins();
    }


    public void moveHero(Position position) {
        if (canHerMove(position)) {
            hero.setPosition(position);
            retrieveCoins();
        }
    }
    public void retrieveCoins(){
        int x=0;
        for(int i=0;i<coins.size();i++){
            if(coins.get(x).getPosition().equals(hero.getPosition())){
                coins.remove(x);
            }
            else{
                x++;
            }
        }
        Integer b=0;
        if(b.equals(coins.size())){
            coins=createCoins();
        }

    }


    private boolean canHerMove(Position position) {
        if (position.getX() < 0) {
            return false;
        } else if (position.getX() >= width) {
            return false;
        } else if (position.getY() >= height) {
            return false;
        } else if (position.getY() < 0) {
            return false;
        }
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
            return true;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#AAAAAA"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for (Coin coin : coins){
            coin.draw(graphics);
        }
    }

    public boolean processKey(KeyStroke key) throws IOException {
        System.out.println(key);

        switch (key.getKeyType()) {
            case ArrowUp:


                moveHero(hero.moveUp());
                break;
            case ArrowDown:

                moveHero(hero.moveDown());
                break;
            case ArrowRight:

                moveHero(hero.moveRight());
                break;
            case ArrowLeft:

                moveHero(hero.moveLeft());
                break;
            case Character:
                if (key.getCharacter() == 'q' || key.getCharacter() == 'Q') {
                    return false;

                }
                break;
            case EOF:
                return false;


        }
        return true;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(new Position(c, 0)));
            walls.add(new Wall(new Position(c, height - 1)));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(new Position(0, r)));
            walls.add(new Wall(new Position(width - 1, r)));
        }
        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            coins.add(new Coin(new Position (random.nextInt(width - 2) +1, random.nextInt(height - 2) + 1)));
        }
        return coins;
    }
}




