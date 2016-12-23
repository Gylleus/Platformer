package javagame;

import org.newdawn.slick.*;

/**
 * A chomper class - a common enemy.
 * @author ZnigelN
 *
 */
public class UndeadPriest extends Entity {
	
	Animation chomper;
	int projectilesShot;
	
	public UndeadPriest(int xPos, int yPos) throws SlickException {
		super(xPos, yPos, 40, 60, 2, 4);
		
		Image[] imageLeft = {new Image("res/Enemies/UndeadPriest/UndeadPriestWalkingLeft.png"), new Image("res/Enemies/UndeadPriest/UndeadPriestWalkingLeft2.png")};
		Image[] imageRight = {new Image("res/Enemies/UndeadPriest/UndeadPriestWalkingRight.png"), new Image("res/Enemies/UndeadPriest/UndeadPriestWalkingRight2.png")};
		
		Image[] imageDead = {new Image("res/Enemies/UndeadPriest/UndeadPriestDead.png"), new Image("res/Enemies/UndeadPriest/UndeadPriestDead.png")};
		
		setWalkAnimation(imageLeft, imageRight);
		setDeathAnimation(imageDead);
		setDeathSound(new Sound("res/Enemies/Lootaz/LootazDeathSound.ogg"));
	}

	@Override
	public Projectile shoot (double xSpeed, double ySpeed, Image image, double xPlayer, double yPlayer, boolean ifPlayer, boolean facingRight, int cooldown, int lifeSpan) {
		if (getProjectileCD() == 0) {
		projectilesShot++;
		Projectile projectile = new Projectile(xSpeed, ySpeed, image, ifPlayer, facingRight, xPlayer, yPlayer, lifeSpan);
		 if (projectilesShot == 3)  {
			 setProjectileCD(cooldown);
			 projectilesShot = 0;
		 }
		return projectile;
		}
		return null;
	}
	
}
