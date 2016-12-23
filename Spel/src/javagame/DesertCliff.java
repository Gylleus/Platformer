package javagame;

import org.newdawn.slick.*;

/**
 * A standard dirt block.
 * @author ZnigelN
 *
 */
public class DesertCliff extends Block {

	public DesertCliff(int xPos, int yPos) throws SlickException {
		super(true, 25, 25, xPos, yPos, new Image("res/Blocks/DesertCliff.png"));
		
	}
	
}
