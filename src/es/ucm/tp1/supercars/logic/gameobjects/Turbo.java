package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo extends GameObject {
	
	private static  int columna_print;
	private static int contadorCoins = 0;
	private boolean alive;
	
	public Turbo(Game game, int x, int y) {
		super(game, x, y);
		columna_print = y;
		this.symbol = ">>>";
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
		if(alive) {
			player.saltarTres();
			alive = false;
		}
        return false;
    }
	
	@Override
	public void onEnter() {
		contadorCoins++;
	}

	@Override
	public void update() {
		columna_print--;
	}
	
	public void Update() {
		
	}

	@Override
	public void onDelete() {
		contadorCoins--;
	}

	public boolean isAlive() {
		return true;
	}
	
	public static int getColumnaPrint() {
		return columna_print;
	}
	
	public static int getContador() {
		return contadorCoins;
	}
	
	public static void reset() {
		contadorCoins = 0;
	}

	public static int getCoinsCount() {
		return contadorCoins;
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
		// TODO Auto-generated method stub
		return false;
	}

}