package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Container;
import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {
	
	private static int columna_print;
	private static int contadorObstacles = 0;
	private int vida;
	private boolean alive;
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		columna_print = y;
		this.symbol = "||";
		this.vida = 1;
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
		vida--;
		if(vida == 0) { alive = false;}
        Container.delete(this, getY(), getX());
        return true;
	}

	@Override
	public void onEnter() {
		contadorObstacles++;
	}

	@Override
	public void update() {
		columna_print--;
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
	
	public String getInfo() {
		StringBuilder s = new StringBuilder();
		s.append(vida);
		return s.toString();
	}

	@Override
	public boolean recieveExplosion(int x, int y) {
		vida--;
		if(vida == 0) { alive = false;}
        Container.delete(this, getY(), getX());
        return true;
	}
}
