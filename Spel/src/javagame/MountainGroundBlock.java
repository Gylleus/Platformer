package javagame;

import org.newdawn.slick.*;

/**
 * A standard dirt block.
 * @author ZnigelN
 *
 */
public class MountainGroundBlock extends Block {

	public MountainGroundBlock(int xPos) throws SlickException {
		super(true, 25, 120, xPos, 380, new Image("res/Blocks/MountainGround.png"));
		
	}
	
}
