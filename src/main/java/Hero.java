import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
//private Position position
      private int x;
      private int y;
    private static Screen screen;
    public  Hero(int x,int y) {
        this.x = x;
        this.y = y;
    }
        public  void moveUp() {
            this.y = this.y + 1;
        }
        public  void moveRight() {
            this.x = this.x + 1;
        }
        public  void moveDown () {
            this.y=this.y-1;
        }
        public  void moveLeft () {
            this.x = this.x - 1;
        }
    public  void draw(Screen screen) throws IOException {
        Hero.screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        }
}