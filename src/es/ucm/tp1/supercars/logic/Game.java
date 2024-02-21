package es.ucm.tp1.supercars.logic;


import java.util.Random;
import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;
import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.Pedrestrian;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.view.Record;
//import es.ucm.tp1.supercars.logic.actions.InstantAction; 
import es.ucm.tp1.supercars.logic.Container; 
import es.ucm.tp1.supercars.logic.GameObjectGenerator;


public class Game {
	
	private static final String GAME_OVER_MSG = "[GAME OVER]";
	private Level level;
	private Long seed;
	private Random rand;
	private int ciclo;
	private Container contenedor;
	private  long time; //Para saber tiempo transcurrido de partida System.currentTimeMillis() - initialTime
	private long ellapsedTime;
	//private GamePrinter printer;
	private Player player;
	private boolean hayThunder;
	private int posThunder;
	private String deleteThunder;

	public Game(Long seed, Level level) {
		time = System.currentTimeMillis();
		ellapsedTime = 0;
		ciclo = 0;
		this.level = level;
		this.seed = seed;
		this.rand = new Random(this.seed);
		contenedor = new Container();
		this.player = new Player(this, 0 ,1);
		GameObjectGenerator.generateGameObjects (this, this.level);
		this.hayThunder = false;
		this.posThunder = -1;
		this.deleteThunder = null;
		//this.printer = new GamePrinter(this);
	}
	
	
	public Level getLevel() {
		return this.level;
	}
	
	public int getRandomWidth() {
		return (int) (rand.nextDouble()*level.getWidth());
	}
	
	public int getRandomX() {
		int x = (int) (rand.nextDouble()*level.getVisibility());
		while (x == getColumnaPlayer()) {
			x = (int) (rand.nextDouble()*level.getVisibility());
		}
		return x;
	}
	
	public int getRandomLength() {
		return (int) (rand.nextDouble()*level.getLength());
	}
	
	public boolean getThunder() {
		return hayThunder;
	}
	
	public String getDeleteThunder() {
		return deleteThunder;
	}
	
	public void update() {
		
		contenedor.Update();
		player.update();
		contenedor.update();
		ciclo++;
		if(level == Level.ADVANCED) {
			if (hayThunder) {
				contenedor.deleteThunder(posThunder);
				hayThunder = false;
				posThunder = -1;
				deleteThunder = null;
			}
			posThunder = tryToAddThunder(contenedor.crearThunder(getRandomX(), getRandomWidth(), this) , level.getObstacleFrequency());
			if(posThunder != -1){
				hayThunder = true;
				deleteThunder = contenedor.caidaThunder(posThunder);
				if(deleteThunder != null && deleteThunder != "") {
					posThunder -= 1;
				}
			}
		}
	}
	
	public void updatePost() {
		player.updatePost();
	}
	
	public void restFiveCoins() {
		player.waveBack();
	}
	
	public void updateWave() {
		int pos = -1;
		for (int y = (getWidth() - 1); y >= 0; y--) {
			for (int x = (getColumnaPlayer() + getVisibility() - 1); x >= getColumnaPlayer(); x--) {
				pos = contenedor.posContainer(x,y);
				if (pos != -1) {
					contenedor.moveWave(pos);
					pos = -1;
				}
			}
		}
		ciclo++;
	}
	
	public boolean collision() {
		return player.doCollision();
	}
	
	public void setCiclo() {
		ciclo = 0;
	}
	
	public void setEllapsedTime() {
		ellapsedTime = 0;
	}
	
	public int getWidth() {
		return level.getWidth();
	}
	
	public int getLength() {
		return level.getLength();
	}
	
	public int getVisibility() {
		return level.getVisibility();
	}
	
	public long getinitialTime() {
		return ellapsedTime;
	}
	
	//private int getRandomNumber() {
		//return this.rand;
	//}
	
	public void reset() {
		initGame(seed);
	}
	
	public void reset (Long seed, Level level) {
		this.level = level;
		initGame(seed);
	}
	
	public void initGame(long seed) {
		rand = new Random(seed);
		//record = new Record(Level);
		player = new Player(this, 0 ,1);
		setCiclo();
		setEllapsedTime();
		contenedor.delete();
		GameObjectGenerator.generateGameObjects (this, this.level);
		
	}
	
	public void tryToAddObject(GameObject obj, double frequencia) {
		if(rand.nextDouble() < frequencia) contenedor.add(obj);
	}
	
	public int tryToAddThunder(GameObject obj, double frequencia) {
		if(rand.nextDouble() < frequencia) {
			contenedor.add(obj);
			return contenedor.getContador() - 1;
		}
		return - 1;
	}
	
	public void addObje(GameObject o) {
		contenedor.add(o);
	}
	
	public void primerUpdate() {
		contenedor.primerUpdate();
	}
	
	public void addSupercoin(GameObject obj) {
		contenedor.add(obj);
	}
	

	public boolean isFinished() {
		if(hasArrived() || hasCrashed()) return true;
		return false;
	}

	public void goUp() throws InvalidPositionException {
		try {player.goUp();}
		catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
			throw new InvalidPositionException("Game", "Go up");
		}
	}

	public void goDown() throws InvalidPositionException {
		try {player.goDown();}
		catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
			throw new InvalidPositionException("Game", "Go down");
		}
	}

	public String getEndGameMessage() {
		String s = GAME_OVER_MSG;
		
		if(hasCrashed()) return s + "Player crashed!";
		else if(hasArrived()) return s + "New Record!: " + (ellapsedTime) + " s.";
		
		return s;
	}
	
	public String setUserExit() {
		return GAME_OVER_MSG;
	}
	
	public boolean hasArrived() {
		if(player.getX() == level.getLength()) return true;
		return false;
	}

	public boolean hasCrashed() {
		if(player.isAliveGame()) return false;
		return true;
	}
	
	public int getColumnaPlayer() {
		return player.getX();
	}
	
	public int getFilaPlayer() {
		return player.getY();
	}
	
	//public void dibujar() {
		//System.out.println(printer.toString());
	//}

	public int distanceToGoal() {
		return level.getLength() - player.getX();
	}

	public int playerCoins() {
		return player.getCoins();
	}

	public int getCycle() {
		return ciclo;
	}

	public boolean isTestMode() {
		// TODO Auto-generated method stub
		return false;
	}

	public String positionToString(int x, int y) {
        if(!player.isInPosition(y, x)) {
            if(!contenedor.isOnPosition(y, x)) {
                return "";
            }else {return contenedor.toString(y, x);}
        }else {return player.toString() + contenedor.toString(y, x);}
    }

	public boolean isNewRecord() {
		if(level == Level.ADVANCED && Record.getAdvanced() > ellapsedTime) {
			Record.setAdvanced(ellapsedTime);
			Record.cargar();
			return true;
		} else if(level == Level.HARD && Record.getHard() > ellapsedTime) {
			Record.setHard(ellapsedTime);
			Record.cargar();
			return true;
		}else if(level == Level.EASY && Record.getEasy() > ellapsedTime) {
			Record.setEasy(ellapsedTime);
			Record.cargar();
			return true;
		}
		return false;
	}

	public long elapsedTime() {
		ellapsedTime = ellapsedTime + (time / 1000000000);
		return ellapsedTime;
	}


	public Collider getObjectInPosition(int x, int y) {
		return contenedor.interfazInPos(x, y);
	}

	public void shot() {
		int x = (player.getX() + 1);
		boolean ok = true;
		while (x < (player.getX() + level.getVisibility()) && ok) {
			if (contenedor.isOnPosition(player.getY(), x)) {
				player.recieveShot(player, x);
				ok = false;
			}
			x++;
		}
	}
	
	public void grenade(int x, int y) {
		player.grenade();
		contenedor.add(new Grenade(this, x + getColumnaPlayer(), y));
		
	}
	
	public void explota(int x, int y) {
		for(int i = 0; i < getWidth(); i++) {
			if(contenedor.isOnPosition(i, x)) {
				player.recieveExplosion(x, i);
			}
		}
	}
	
	public void restarCoin() {
		player.restarCoin();
	}

	//public void printGame() {
		//System.out.println(printer);
		
	//}
	
	public int getThunderX() {
		return contenedor.getThunderX(posThunder);
	}
	
	public int getThunderY() {
		return contenedor.getThunderY(posThunder);
	}
	
	public boolean isInPosition(int y, int x) {
		return contenedor.isOnPosition(y, x);
	}
	
	public String serialize(int x, int y) {
		return contenedor.info(x, y);
	}
	
	public void cargar() throws InputOutputRecordException {
		Record.cargar();
		System.out.println(Record.pintar(this.level));
	}
}