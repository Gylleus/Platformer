package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Spider extends Entity {
	
	Animation chomper;
	
	public Spider(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 45, 26, 2, 5);
		
		Image[] imageLeft = {new Image("res/Enemies/Spider/SpiderWalkingLeft.png"), new Image("res/Enemies/Spider/SpiderWalkingLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Spider/SpiderWalkingRight.png"), new Image("res/Enemies/Spider/SpiderWalkingRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Spider/SpiderDead.png"), new Image("res/Enemies/Spider/SpiderDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Lootaz/LootazDeathSound.ogg"));
	}

}
