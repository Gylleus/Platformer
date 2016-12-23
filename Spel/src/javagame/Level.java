package javagame;

import java.util.ArrayList;

import org.newdawn.slick.*;

public class Level {

	private int length; //Specifies the length of the level in pixels, must be dividable by 25.
	private ArrayList<ArrayList<Block>> blockList = new ArrayList<ArrayList<Block>>();
	private ArrayList<Entity> enemyList = new ArrayList<Entity>();
	
	public Level(int length) {
		this.length = length;
		blockList.add(new ArrayList<Block>()); //index 0 = ground blocks
	}
	
	/**
	 * Blocks
	 * @throws SlickException
	 */
	public void generateLand(int index) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		GroundBlock block = new GroundBlock(index * 25);
		groundBlocks.add(block);
	}
	
	public void generateForestGround(int index) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		ForestGroundBlock block = new ForestGroundBlock(index * 25);
		groundBlocks.add(block);
	}
	
	public void generateMountainGround(int index) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		MountainGroundBlock block = new MountainGroundBlock(index * 25);
		groundBlocks.add(block);
	}
	
	public void generateCaveGround(int index) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		CaveGroundBlock block = new CaveGroundBlock(index * 25);
		groundBlocks.add(block);
	}
	
	public void generateDesertGround(int index) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		DesertGroundBlock block = new DesertGroundBlock(index * 25);
		groundBlocks.add(block);
	}
	
	public void generatePlatform(int index, int yPos) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		PlatformBlock block = new PlatformBlock(index * 25, yPos);
		groundBlocks.add(block);
	}
	
	public void generateCliff(int index, int yPos) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		CliffBlock block = new CliffBlock(index * 25, yPos);
		groundBlocks.add(block);
	}
	
	public void generateCaveCliff(int index, int yPos) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		CaveCliffBlock block = new CaveCliffBlock(index * 25, yPos);
		groundBlocks.add(block);
	}
	
	public void generateDesertCliff(int index, int yPos) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		DesertCliff block = new DesertCliff(index * 25, yPos);
		groundBlocks.add(block);
	}
	
	public void generateBouncyMushroom(int index, int yPos) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		BouncyMushroom block = new BouncyMushroom(index * 25 - 10, yPos);
		groundBlocks.add(block);
	}
	
	public void generateFlag(int index, int yPos) throws SlickException {
		ArrayList<Block> groundBlocks = blockList.get(0); 
		
		FlagBlock block = new FlagBlock(index * 25, yPos);
		groundBlocks.add(block);
	}
	
	/**
	 * Enemies
	 * @param index
	 * @param yPos
	 * @return
	 * @throws SlickException
	 */
	public Chomper generateChomper(int index, int yPos) throws SlickException {
		Chomper chomper = new Chomper(index * 25, yPos);
		enemyList.add(chomper);
		return chomper;
	}
	
	public Clawer generateClawer(int index, int yPos) throws SlickException {
		Clawer clawer = new Clawer(index * 25, yPos);
		enemyList.add(clawer);
		return clawer;
	}
	
	public Lootaz generateLootaz(int index, int yPos) throws SlickException {
		Lootaz lootaz = new Lootaz(index * 25, yPos);
		enemyList.add(lootaz);
		return lootaz;
	}
	
	public Menki generateMenki(int index, int yPos) throws SlickException {
		Menki menki = new Menki(index * 25, yPos);
		enemyList.add(menki);
		return menki;
	}
	
	public Schoben generateSchoben(int index, int yPos) throws SlickException {
		Schoben schoben = new Schoben(index * 25, yPos);
		enemyList.add(schoben);
		return schoben;
	}
	
	public ShootingFlower generateShootingFlower(int index, int yPos) throws SlickException {
		ShootingFlower flower = new ShootingFlower(index * 25, yPos);
		enemyList.add(flower);
		return flower;
	}
	
	public RockEater generateRockEater(int index, int yPos) throws SlickException {
		RockEater eater = new RockEater(index * 25, yPos);
		enemyList.add(eater);
		return eater;
	}
	
	public Miner generateMiner(int index, int yPos) throws SlickException {
		Miner miner = new Miner(index * 25, yPos);
		enemyList.add(miner);
		return miner;
	}
	
	public Goat generateGoat(int index, int yPos) throws SlickException {
		Goat goat = new Goat(index * 25, yPos);
		enemyList.add(goat);
		return goat;
	}
	
	public Slime generateSlime(int index, int yPos) throws SlickException {
		Slime slime = new Slime(index * 25, yPos);
		enemyList.add(slime);
		return slime;
	}
	
	public Spider generateSpider(int index, int yPos) throws SlickException {
		Spider spider = new Spider(index * 25, yPos);
		enemyList.add(spider);
		return spider;
	}
	
	public Troglodyte generateTroglodyte(int index, int yPos) throws SlickException {
		Troglodyte trog = new Troglodyte(index * 25, yPos);
		enemyList.add(trog);
		return trog;
	}
	
	public UndeadPriest generateUndeadPriest(int index, int yPos) throws SlickException {
		UndeadPriest priest = new UndeadPriest(index * 25, yPos);
		enemyList.add(priest);
		return priest;
	}
	
	public Anubite generateAnubite(int index, int yPos) throws SlickException {
		Anubite anubite = new Anubite(index * 25, yPos);
		enemyList.add(anubite);
		return anubite;
	}
	
	public Spikes generateSpike(int index, int yPos, String direction) throws SlickException {
		Spikes spikes = new Spikes(index * 25, yPos, direction);
		enemyList.add(spikes);
		return spikes;
	}
	
	
	
	
	
	public ArrayList<ArrayList<Block>> getBlockList() {
		return blockList;
	}
	
	public void renderEnemies(float playerPositionX, int[] windowSize) {
		for (Entity enemy : enemyList) {
			if (enemy instanceof Spikes) {
				enemy.getAnimation().draw(enemy.getXPos() + playerPositionX + windowSize[0]/2 + enemy.getXSize()/2, enemy.getYPos() - enemy.getYSize());
				continue;
			}
			if (enemy instanceof RockEater) {
				if (enemy.isAlive()) {
				enemy.getAnimation().draw(enemy.getXPos() + playerPositionX + windowSize[0]/2 - enemy.getXSize()/4, enemy.getYPos() - enemy.getYSize());
				continue;
				}
				enemy.getDeathAnimation().draw(enemy.getXPos() + playerPositionX + windowSize[0]/2- enemy.getXSize()/4, enemy.getYPos() - enemy.getYSize());
				continue;
			}
			if (enemy.ifInAir()) {
				enemy.getJumpAnimation().draw(enemy.getXPos() + playerPositionX + windowSize[0]/2, enemy.getYPos() - enemy.getYSize());
			}
			if (enemy.isAlive() && !enemy.ifInAir()) {
			enemy.getAnimation().draw(enemy.getXPos() + playerPositionX + windowSize[0]/2 - enemy.getXSize()/4, enemy.getYPos() - enemy.getYSize());
		}
			else if (!enemy.isAlive()){
				enemy.getDeathAnimation().draw(enemy.getXPos() + playerPositionX + windowSize[0]/2, enemy.getYPos() - enemy.getYSize());
			}
		}
	}
	
	public ArrayList<Entity> getEnemyList() {
		return enemyList;
	}
}
