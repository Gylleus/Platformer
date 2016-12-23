package javagame;

import org.newdawn.slick.*;

/**
 * Superclass for all blocks.
 * @author ZnigelN
 *
 */
public class Block {

	private boolean walkable;
	private int xSize;
	private int ySize;
	private int xPos;
	private int yPos;
	private Image blockVisual;
	
	public Block(boolean isWalkable, int width, int height, int xLoc, int yLoc, Image block) {
		walkable = isWalkable;
		xSize = width;
		ySize = height;
		xPos = xLoc;
		yPos = yLoc;
		blockVisual = block;
	}
	
	public boolean isWalkable() {
		return walkable;
	}
	
	public Image getBlockImage() {
		return blockVisual;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getXSize() {
		return xSize + 1;
	}
	
	public int getYSize() {
		return ySize;
	}
}
