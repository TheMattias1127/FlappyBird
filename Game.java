import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {
    
    public Keyboard keyboard;
    public Bird bird;
    private ArrayList<Tube> tubes;

    public Game () {
        keyboard = Keyboard.getInstance();
        bird = new Bird();
        tubes = new ArrayList<Tube>();
        tubes.add(new Tube());
        
    }

    public void update() {
        bird.update();
        if (!bird.collision) {
            for (int i = 0; i < tubes.size(); i++) {
                Tube t = tubes.get(i);
                t.update();
                if (t.spawnedOneTube == 0 && t.x < 300) {
                    tubes.add(new Tube());
                    t.spawnedOneTube = 1;
                }
                if (t.x < -100) {
                    tubes.remove(i);
                    i--;
                }
            }
        }
    }

    public ArrayList<Tube> getTubes(){
        return tubes;
    }



}