package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Container;
import es.ucm.tp1.supercars.logic.Game;

public class Grenade extends GameObject {
	
	private static int columna_print;
	private int ciclos;
	private boolean alive;
	
	public Grenade(Game game, int x, int y) {
		super(game, x, y);
		columna_print = y;
		this.symbol = "G[3]";//añadir ciclos
		this.ciclos = 3;
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
        
        return true;
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void update() {
		ciclos --;
		if(ciclos != 0) {
		symbol = "G" + "[" + ciclos + "]";
		columna_print--;
		}
		else{
			game.explota(getX(), getY());
		}
	}
	
	public void Update() {
		
	}

	@Override
	public void onDelete() {
		
	}

	public boolean isAlive() {
		return alive;
	}
	
	public static int getColumnaPrint() {
		return columna_print;
	}
	
	
	public static void reset() {
	
	}
	
	public void waveBack() {
		// TODO Auto-generated method stub
		x++;
		columna_print++;
	}
	
	public String getInfo() {
		StringBuilder s = new StringBuilder();
		s.append(ciclos);
		return s.toString();
	}

	@Override
	public boolean recieveExplosion(int x, int y) {
		Container.delete(this, getY(), getX());
        return true;
	}

}