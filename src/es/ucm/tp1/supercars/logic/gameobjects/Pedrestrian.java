package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Container;
import es.ucm.tp1.supercars.logic.Game;

public class Pedrestrian extends GameObject {
	
	private static int columna_print;
	private static int contadorObstacles = 0;
	private boolean alive;
	private boolean arriba_abajo; //arriba true, abajo false
	
	public Pedrestrian(Game game, int x, int y) {
		super(game, x, y);
		columna_print = y;
		this.symbol = ":)";
		this.alive = true;
		this.arriba_abajo = false;
	}

	@Override
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
        
        return true;
    }
	
	public boolean recieveShot(Player player, int x) {
		
        player.resetearCoin();
        return true;
	}

	@Override
	public void onEnter() {
		contadorObstacles++;
	}

	public void Update() {
		columna_print--;
		if (arriba_abajo) {
			y--;
			if(y == 0) {
				arriba_abajo = false;
			}
		} else {
			y++;
			if(y == 2) {
				arriba_abajo = true;
			}
		}
	}
	
	public void update() {
		
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
		if(arriba_abajo) {return "up";}
		return "down";
	}

	@Override
	public boolean recieveExplosion(int x, int y) {
		Container.delete(this, getY(), getX());
        return true;
	}
}