import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    public Position position;

    public Element(Position position) {
        this.position = position;
    }
    public Position getPosition(){
        return position;
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }
    public void setPosition(Position position){
        this.position=position;
    }
     abstract void draw(TextGraphics textGraphics);



}

