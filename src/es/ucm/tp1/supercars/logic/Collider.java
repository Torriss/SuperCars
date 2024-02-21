package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.Player;

public interface Collider {

	boolean doCollision();

	boolean receiveCollision(Player player);
	
	boolean recieveShot(Player player, int x);
	
	boolean recieveExplosion(int x, int y);

}
