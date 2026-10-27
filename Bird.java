import java.awt.Image;
import java.awt.event.KeyEvent;

public class Bird {

    public int x;
    public int y;
    public int width;
    public int height;
    public boolean collision;
    // y velocity
    public double yvel;
    public double gravity;

    // delay between key presses
    private int jumpDelay;

    private Image image;
    private JumpInput input;

    public Bird() {
        this(Keyboard.getInstance(), new CachedFileImageLoader());
    }

    public Bird(JumpInput input, ImageLoader imageLoader) {
        this.x = 100;
        this.y = 200;
        this.yvel = 0;
        this.width = 40;
        this.height = 40;
        this.gravity = 0.6;
        this.jumpDelay = 0;
        this.collision = false;

        this.input = input;
        this.image = imageLoader.loadImage("lib/bird.png");
    }
    private void checkCollision(){
        //System.out.println(y);
        if(y > 380){
            collision = true;
        }
    }

    public void update () {
        yvel += gravity;

        if (jumpDelay > 0){
            jumpDelay--;
        }

        if (input.isJumpPressed() && jumpDelay <= 0) {
            yvel = -10;
            jumpDelay = 10;
        }

        checkCollision();
        if (!collision) {
            y += (int) yvel;
        }
    }

    public Image getImage () {
        return image;
    }
}
