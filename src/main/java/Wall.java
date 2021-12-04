import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wall extends Element {
    private Position position;

    public Wall(Position position){
       super(position);
    }

    public int getWallX(){
        return getX();
    }

    public int getWallY(){
        return getY();
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(new TerminalPosition(this.getWallX(), this.getWallY()), " ");
    }

}