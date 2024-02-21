package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;

public class ShotCommand extends Command {
	
	private static final String NAME = "shot";
	private static final String DETAILS = "[s]hot";
	private static final String SHORTCUT = "s";
	private static final String HELP = "shot a bullet";

	public ShotCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws NotEnoughCoinsException {
		if(buy(game)) {
			game.shot();
			game.restarCoin();
		} else throw new NotEnoughCoinsException("Shot Command", "Shot");
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 1;
	}
	

}