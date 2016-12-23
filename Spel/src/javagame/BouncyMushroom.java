package javagame;

import org.newdawn.slick.*;

/**
 * A standard dirt block.
 * @author ZnigelN
 *
 */
public class BouncyMushroom extends Block {

	public BouncyMushroom(int xPos, int yPos) throws SlickException {
		super(true, 38, 40, xPos, yPos, new Image("res/Blocks/BouncyMushroom.png"));
		
	}
	
}
