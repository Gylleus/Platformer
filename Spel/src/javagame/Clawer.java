package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Clawer extends Entity {
	
	Animation chomper;
	
	public Clawer(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 30, 50, 1, 5);
		
		Image[] imageLeft = {new Image("res/Enemies/ClawerLeft.png"), new Image("res/Enemies/ClawerLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/ClawerRight.png"), new Image("res/Enemies/ClawerRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/ClawerDead.png"), new Image("res/Enemies/ClawerDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Lootaz/LootazDeathSound.ogg"));
	}

}
