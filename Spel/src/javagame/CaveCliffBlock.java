package javagame;

import org.newdawn.slick.*;

/**
 * A standard dirt block.
 * @author ZnigelN
 *
 */
public class CaveCliffBlock extends Block {

	public CaveCliffBlock(int xPos, int yPos) throws SlickException {
		super(true, 25, 25, xPos, yPos, new Image("res/Blocks/CaveCliff.png"));
		
	}
	
}
