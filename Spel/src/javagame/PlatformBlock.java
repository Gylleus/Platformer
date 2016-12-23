package javagame;

import org.newdawn.slick.*;

/**
 * A standard dirt block.
 * @author ZnigelN
 *
 */
public class PlatformBlock extends Block {

	public PlatformBlock(int xPos, int yPos) throws SlickException {
		super(true, 25, 25, xPos, yPos, new Image("res/Blocks/MetalPlatform.png"));
		
	}
	
}
