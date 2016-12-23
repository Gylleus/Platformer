package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Anubite extends Entity {
	
	Animation chomper;
	int jumpCounter;
	
	
	public Anubite(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 27, 55, 3, 4);
		
		Image[] imageLeft = {new Image("res/Enemies/Anubite/AnubiteWalkingLeft.png"), new Image("res/Enemies/Anubite/AnubiteWalkingLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/Anubite/AnubiteWalkingRight.png"), new Image("res/Enemies/Anubite/AnubiteWalkingRight2.png")};
		
		Image[] jumpingLeft = {new Image("res/Enemies/Anubite/AnubiteWalkingLeft.png"), new Image("res/Enemies/Anubite/AnubiteWalkingLeft.png")};
		Image[] jumpingRight = {new Image("res/Enemies/Anubite/AnubiteWalkingRight.png"), new Image("res/Enemies/Anubite/AnubiteWalkingRight.png")};
		
		Image[] imageDead = {new Image("res/Enemies/Anubite/AnubiteDead.png"), new Image("res/Enemies/Anubite/AnubiteDead.png")};
		
		setJumpAnimation(jumpingLeft, jumpingRight);
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Chomper/ChomperDeathSound.ogg"));
		
	}

	@Override
	public void jump() {
		jumpCounter++;
		if(jumpCounter == 60) {
		setMovementSpeed(1);
		setYMomentum(34);
		setInAir();
		jumpCounter = 0;
		}
	}
	
	@Override
	public void hitGround() {
		onGround();
		setYMomentum(0);
		setMovementSpeed(3);
	}
}
