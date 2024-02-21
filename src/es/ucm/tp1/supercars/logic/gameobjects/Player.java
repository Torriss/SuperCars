package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {
	
	private int coins;
	private boolean movido;
	private boolean alive;

	public Player(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = ">";
		coins = 0;
		movido = false;
		alive = true;
	}

	@Override
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y); 
		if (other != null) {
			return other.receiveCollision(this); 
		}
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
        return false;
    }
	
	public boolean recieveShot(Player player, int x) {
		Collider other = game.getObjectInPosition(x, this.y); 
		if (other != null) {
			return other.recieveShot(this, x); 
		}
		return false;
	}
	
	public void addCoins() {
		coins++;
	}
	
	public int getCoins() {
		return coins;
	}

	public void goUp() throws InvalidPositionException {
		 if (y != (0)) {
             y--;
             x++; 
             movido = true;
         }
		 else throw new InvalidPositionException("Player", "Go up");
	}
	
	public void goDown() throws InvalidPositionException {
		 if (y != (game.getWidth() - 1)) {
			 y++;
			 x++; 
			 movido = true;
		 }
		 else throw new InvalidPositionException("Player", "Go down");
	}

	public void onEnter() {
		
		
	}
	
	public void Update() {
		
	}

	public void update() {
		if(!movido){
			x++;
		}
		if(doCollision()) {
			//symbol = "@";
			alive = false;
			movido = true;
		}
		movido = false;
	}
	
	public void updatePost() {
		if(doCollision()) {
			symbol = "@";
			alive = false;
		}
	}

	public void onDelete() {

	}

	public boolean isAlive() {
		return true; //true si esta vivo
	}
	
	public boolean isAliveGame() {
		return alive; //true si esta vivo
	}

	public boolean isInPosition(int fila, int columna) {
        if(fila == getY() && columna == getX()) return true;
        return false;
    }

	public void addSuperCoin() {
		coins += 1000;
	}
	
	public void addFiveCoins() {
		coins +=5;
	}
	
	public void restarCoin() {
		coins--;
	}
	
	public void resetearCoin() {
		coins = 0;
	}
	
	public void saltarTres() {
		x += 3;
	}

	@Override
	public void waveBack() {
		coins -= 5;
		
	}
	
	public void grenade() {
		coins -= 3;
		
	}
	
	public void restFiveCoins() {
		coins -=5;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean recieveExplosion(int x, int y) {
		Collider other = game.getObjectInPosition(x, y); 
		if (other != null) {
			return other.recieveExplosion(x, y); 
		}
		return false;
	}
}
