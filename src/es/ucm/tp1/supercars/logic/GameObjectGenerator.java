package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.*;


public class GameObjectGenerator {
	
	public static boolean superCoin = false;
	
	public static void generateGameObjects(Game game, Level level) { 
		for(int x = game.getVisibility()/2; x < game.getLength(); x ++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomWidth()) , level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomWidth()) , level.getCoinFrequency());
			if (level.hasAdvancedObjects()) {
				game.tryToAddObject(new Wall(game, x, game.getRandomWidth()), level.getAdvObjFrequency());
				game.tryToAddObject(new Turbo(game, x, game.getRandomWidth()), level.getAdvObjFrequency()); 
				if (!superCoin) {
				game.tryToAddObject(new SuperCoin(game, x, game.getRandomWidth()) , level.getAdvObjFrequency());
				superCoin = true;
				}
				game.tryToAddObject(new Truck(game, x, game.getRandomWidth()), level.getAdvObjFrequency());
				game.tryToAddObject(new Pedrestrian(game, x, 0), level.getAdvObjFrequency());
			//} }
			}
		}
		game.primerUpdate();
	}

	public static void reset(Level level) {
		Obstacle.reset() ;
		Coin.reset() ;
	}

	public static void generateRuntimeObjects(Game game) {
		// TODO add your code
	}
}
