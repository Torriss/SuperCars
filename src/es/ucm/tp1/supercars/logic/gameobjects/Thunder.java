package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Thunder extends GameObject {
	
	private static  int columna_print;
	private boolean alive;
	
	public Thunder(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = "";
		this.alive = true;
	}

	@Override
	public boolean doCollision() {
		return false;
	}
	
	public boolean recieveShot(Player player, int x) {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		
        return false;
    }
	
	@Override
	public void onEnter() {
		
	}

	@Override
	public void update() {
		columna_print--;
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

	@Override
	public void waveBack() {
		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean recieveExplosion(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
