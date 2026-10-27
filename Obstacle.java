import java.awt.Graphics;

public interface Obstacle {
    void update();
    boolean collidesWith(Bird bird);
    void render(Graphics g);
}

