package javagame;

import org.newdawn.slick.*;

/**
 * A forest dirt block.
 * @author ZnigelN
 *
 */
public class DesertGroundBlock extends Block {

	public DesertGroundBlock(int xPos) throws SlickException {
		super(true, 25, 120, xPos, 380, new Image("res/Blocks/DesertGround.png"));
		
	}
	
}
