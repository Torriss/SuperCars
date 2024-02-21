package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.logic.Game;

public class UpCommand extends Command {
	
	private static final String NAME = "up";
	private static final String DETAILS = "[q]";
	private static final String SHORTCUT = "q";
	private static final String HELP = "car go up";

	public UpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws InvalidPositionException {
		try {
		game.goUp();
		game.update();
		}
		catch(InvalidPositionException e) {
			System.out.println(e.getMessage());
			throw new InvalidPositionException("Up command", "Go up");
		}
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
