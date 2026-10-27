import java.awt.Graphics;

public class FloorObstacle implements Obstacle {
    private static final int FLOOR_Y = 380;

    @Override
    public void update() {}

    @Override
    public boolean collidesWith(Bird bird) {
        return bird.y > FLOOR_Y;
    }

    @Override
    public void render(Graphics g) {}
}

