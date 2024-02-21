package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Container;
import es.ucm.tp1.supercars.logic.Game;

public class Truck extends GameObject {
	
	private static int columna_print;
	private static int contadorObstacles = 0;
	private boolean alive;
	
	public Truck(Game game, int x, int y) {
		super(game, x, y);
		columna_print = y;
		this.symbol = "<-";
		this.alive = true;
	}

	@Override
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
        
        return true;
    }
	
	public boolean recieveShot(Player player, int x) {

        return false;
	}

	@Override
	public void onEnter() {
		contadorObstacles++;
	}

	@Override
	public void update() {
		columna_print--;
		x--;
	}
	
	public void Update() {
		
	}

	@Override
	public void onDelete() {
		contadorObstacles--;
	}

	public boolean isAlive() {
		return alive;
	}
	
	public static int getColumnaPrint() {
		return columna_print;
	}
	
	public static int getContador() {
		return contadorObstacles;
	}
	
	public static void reset() {
		contadorObstacles = 0;
	}

	public static int getObstaclesCount() {
		return contadorObstacles;
	}
	
	public void waveBack() {
		// TODO Auto-generated method stub
		x++;
		columna_print++;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean recieveExplosion(int x, int y) {
		Container.delete(this, getY(), getX());
        return true;
	}
}