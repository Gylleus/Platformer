package javagame;

import org.newdawn.slick.*;

/**
 * A standard dirt block.
 * @author ZnigelN
 *
 */
public class GroundBlock extends Block {

	public GroundBlock(int xPos) throws SlickException {
		super(true, 25, 120, xPos, 380, new Image("res/Blocks/Ground.png"));
		
	}
	
}
