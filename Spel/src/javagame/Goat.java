package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Goat extends Entity {
	
	Animation chomper;
	
	
	public Goat(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 36, 36, 2, 4);
		
		Image[] imageLeft = {new Image("res/Enemies/Goat/GoatStandingLeft.png"), new Image("res/Enemies/Goat/GoatStandingLeft.png")};
		Image[] imageRight = {new Image("res/Enemies/Goat/GoatStandingRight.png"), new Image("res/Enemies/Goat/GoatStandingRight.png")};
		
		Image[] jumpingLeft = {new Image("res/Enemies/Goat/GoatJumpingLeft.png"), new Image("res/Enemies/Goat/GoatJumpingLeft.png")};
		Image[] jumpingRight = {new Image("res/Enemies/Goat/GoatJumpingRight.png"), new Image("res/Enemies/Goat/GoatJumpingRight.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Chomper/ChomperDead.png"), new Image("res/Enemies/Chomper/ChomperDead.png")};
		
		setJumpAnimation(jumpingLeft, jumpingRight);
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Chomper/ChomperDeathSound.ogg"));
		
	}

	@Override
	public void jump() {
		setYMomentum(35);
		setInAir();
	}
}
