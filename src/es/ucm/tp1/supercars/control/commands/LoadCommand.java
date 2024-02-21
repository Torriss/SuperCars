package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
//import es.ucm.tp1.supercars.logic.InstantAction;

public class LoadCommand extends Command {
	
	private static final String NAME = "load";
	private static final String DETAILS = "l[o]ad";
	private static final String SHORTCUT = "o";
	private static final String HELP = "loads records";
	int x;
	int y;

	public LoadCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean execute(Game game) throws InputOutputRecordException {
		game.cargar();
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}
}