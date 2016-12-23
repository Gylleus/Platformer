package javagame;

import org.newdawn.slick.*;

/**
 * A forest dirt block.
 * @author ZnigelN
 *
 */
public class ForestGroundBlock extends Block {

	public ForestGroundBlock(int xPos) throws SlickException {
		super(true, 25, 120, xPos, 380, new Image("res/Blocks/ForestGround.png"));
		
	}
	
}
