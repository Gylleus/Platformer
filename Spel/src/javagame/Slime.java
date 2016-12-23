package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Slime extends Entity {
	
	Animation chomper;
	
	public Slime(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 40, 45, 1, 25);
		
		Image[] imageLeft = {new Image("res/Enemies/Slime/SlimeLeft.png"), new Image("res/Enemies/Slime/SlimeLeft.png")};
		Image[] imageRight = {new Image("res/Enemies/Slime/SlimeRight.png"), new Image("res/Enemies/Slime/SlimeRight.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Chomper/ChomperDead.png"), new Image("res/Enemies/Chomper/ChomperDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Chomper/ChomperDeathSound.ogg"));
	}

}
