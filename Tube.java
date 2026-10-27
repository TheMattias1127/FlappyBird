import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Graphics;

public class Tube implements Obstacle {

    public int x;
    public int y;
    public int width = 50;
    public int height = 300;
    public boolean currentEnnemy;
    public int spawnedOneTube;

    private Image image;
    
    public Tube () {
        x=500;
        y = 0;
        spawnedOneTube=0;
    }

    @Override
    public void update() {
        x = x - 2;
    }

    @Override
    public boolean collidesWith(Bird bird) {
        return bird.x < x + width && bird.x + bird.width > x &&
            bird.y < y + height && bird.y + bird.height > y;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }

    public Image getImage () {

        if (image == null) {
            image = Util.loadImage("lib/tube.png");     
        }
        
        return image;
    }
}
