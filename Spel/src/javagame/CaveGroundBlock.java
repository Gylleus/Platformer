package javagame;

import org.newdawn.slick.*;

/**
 * A forest dirt block.
 * @author ZnigelN
 *
 */
public class CaveGroundBlock extends Block {

	public CaveGroundBlock(int xPos) throws SlickException {
		super(true, 25, 120, xPos, 380, new Image("res/Blocks/CaveGround.png"));
		
	}
	
}
