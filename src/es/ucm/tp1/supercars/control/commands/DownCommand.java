package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.StringUtils;

public class DownCommand extends Command {
	
	private static final String NAME = "down";
	private static final String DETAILS = "[a] down";
	private static final String SHORTCUT = "a";
	private static final String HELP = "car go down";

	public DownCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
		game.goDown();
		game.update();
		}
		catch(InvalidPositionException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException("Down command", "Go down");
		}
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
