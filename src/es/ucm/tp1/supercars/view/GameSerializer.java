package es.ucm.tp1.supercars.view;


import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;

public class GameSerializer {
	private Game game;
	
	public GameSerializer(Game game) {
		this.game = game;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("---- ROAD FIGHTER SERIALIZED ----" + "\n");
		if(game.getLevel() == Level.EASY) {
			str.append("LEVEL: EASY" + "\n");
		} else if(game.getLevel() == Level.HARD) {
			str.append("LEVEL: HARD" + "\n");
		}else if(game.getLevel() == Level.ADVANCED) {
			str.append("LEVEL: ADVANCED" + "\n");
		}
		str.append("Ciclo : " + game.getCycle() + "\n");
		str.append("Ciclo : " + game.getCycle() + "\n");
		str.append("Coins : " + game.playerCoins() + "\n");
		str.append("EllapsedTime : " + game.elapsedTime() + "\n");
		// Paint game

		
		str.append("Game Objects: " + "\n");
		str.append("> (" + game.getColumnaPlayer() + ", " + game.getFilaPlayer() + ")" + "\n");
		for (int x = (game.getVisibility() / 2); x < game.getLength(); x++) {
			for (int y = 0; y < game.getWidth(); y++) {
				if(game.isInPosition(y, x)) {
					str.append(game.positionToString(x, y) + " (" + x + ", " + y + ") " + game.serialize(x, y) + "\n");
				}
			}
		}
		
		// Game Status

		

		return str.toString();
	}
}
