package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class Spikes extends Entity {
	
	Animation chomper;
	Animation left, right, up, down;
	String direction;
	
	public Spikes(int xPos, int yPos, String direction) throws SlickException {
		super(xPos, yPos, 25, 15, 0, 5);
		this.direction = direction.toLowerCase();
		
		Image[] imageLeft = {new Image("res/Enemies/Spikes/SpikesLeft.png"), new Image("res/Enemies/Spikes/SpikesLeft.png")};
		Image[] imageRight = {new Image("res/Enemies/Spikes/SpikesRight.png"), new Image("res/Enemies/Spikes/SpikesRight.png")};
		Image[] imageUp = {new Image("res/Enemies/Spikes/SpikesUp.png"), new Image("res/Enemies/Spikes/SpikesUp.png")};
		Image[] imageDown = {new Image("res/Enemies/Spikes/SpikesDown.png"), new Image("res/Enemies/Spikes/SpikesDown.png")};
		
		Image[] imageDead = {new Image("res/Enemies/ClawerDead.png"), new Image("res/Enemies/ClawerDead.png")};
		
		int[] duration = {200,200};
		left = new Animation (imageLeft, duration, false);
		right = new Animation (imageRight, duration, false);
		up = new Animation (imageUp, duration, false);
		down = new Animation (imageDown, duration, false);
		
		if (direction.equals("left")) {
			setYPos(yPos + 15);
			setXPos(xPos + 12);
		}
		if (direction.equals("right")) {
			setYPos(yPos + 15);
		}
		if (direction.equals("down")) {
			setYPos(yPos + 12);
		}
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Lootaz/LootazDeathSound.ogg"));
	}
	
	@Override
	public Animation getAnimation() {
		if (direction.equals("left")) {
			return left;
		}
		if (direction.equals("right")) {
			return right;
		}
		if (direction.equals("down")) {
			return down;
		}
		if (direction.equals("up")) {
			return up;
		}
		return null;
	}

}
