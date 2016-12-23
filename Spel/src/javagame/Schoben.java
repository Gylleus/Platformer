package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Schoben extends Entity {
	
	Animation chomper;
	
	public Schoben(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 40, 70, 2, 15);
		
		Image[] imageLeft = {new Image("res/Enemies/Schoben/SchobenWalkingLeft.png"), new Image("res/Enemies/Schoben/SchobenWalkingLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Schoben/SchobenWalkingRight.png"), new Image("res/Enemies/Schoben/SchobenWalkingRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Schoben/SchobenDead.png"), new Image("res/Enemies/Schoben/SchobenDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Chomper/ChomperDeathSound.ogg"));
	}

}
