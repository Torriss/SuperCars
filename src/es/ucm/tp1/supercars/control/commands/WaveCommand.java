package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;

public class WaveCommand extends Command {
	
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "push all the objects";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws NotEnoughCoinsException {
		if(buy(game)) {
			game.updateWave();
			game.restFiveCoins();
		} else throw new NotEnoughCoinsException("Wave", "execute Wave");
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 5;
	}
	

}