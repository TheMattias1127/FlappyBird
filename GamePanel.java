import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class GamePanel extends JPanel implements Runnable {

    private Bird bird;
    private Game game;
    public Background bg;

    public GamePanel () {
        game = new Game();
        bird = game.bird;
        bg = new Background();
        new Thread(this).start();
    }

    public void update () {
        game.update();
        repaint();
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.drawImage(bg.getImage(), 0, 0, null);
        
    for (Tube tube : game.getTubes()) {
        g.drawImage(tube.getImage(), tube.x, tube.y, null);
    }

    g.drawImage(bird.getImage(), bird.x, bird.y, null);
    g.drawOval(bird.x, bird.y, 45, 35);
}
    
    @Override 
    public void run () {
        try {
            while (true) {
                update();
                Thread.sleep(23);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
