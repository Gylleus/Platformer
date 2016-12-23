package javagame;

import org.newdawn.slick.*;

/**
 * A standard dirt block.
 * @author ZnigelN
 *
 */
public class FlagBlock extends Block {

	public FlagBlock(int xPos, int yPos) throws SlickException {
		super(false, 40, 80, xPos, yPos, new Image("res/Blocks/WinningFlag1.png"));
		
	}
	
}
