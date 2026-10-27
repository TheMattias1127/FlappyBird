import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Keyboard extends KeyAdapter implements JumpInput {

	private static Keyboard instance;
	private boolean[] keys = new boolean[256];
	
	private Keyboard() {
	}

	public static Keyboard getInstance() {

		if (instance == null) {
			instance = new Keyboard();
		}
		
		return instance;
	}

	@Override 
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() >= 0 && e.getKeyCode() < keys.length) {
			keys[e.getKeyCode()] = true;
		}
	}
	
	@Override 
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() >= 0 && e.getKeyCode() < keys.length) {
			keys[e.getKeyCode()] = false;
		}
	}

	public boolean isDown(int n) {

		if (n >= 0 && n < keys.length) {
			return keys[n];
		}
		
		return false;
	}

	@Override
    public boolean isJumpPressed() {
        return keys[KeyEvent.VK_SPACE];
    }
}

