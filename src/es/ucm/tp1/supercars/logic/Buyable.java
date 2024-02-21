package es.ucm.tp1.supercars.logic;

public interface Buyable {
	public int cost();
	public default boolean buy(Game game){ 
		// TODO add your code
		
		if ((game.playerCoins() - cost()) < 0) {
			return false;
		}
		return true;
	}; 

}
