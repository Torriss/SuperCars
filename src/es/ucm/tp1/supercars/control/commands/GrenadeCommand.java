package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
//import es.ucm.tp1.supercars.logic.InstantAction;

public class GrenadeCommand extends Command {
	
	private static final String NAME = "grenade";
	private static final String DETAILS = "[g]renade";
	private static final String SHORTCUT = "g";
	private static final String HELP = "creates a grenade";
	int x;
	int y;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length > 3 || Integer.parseInt(words[1]) > 8 || Integer.parseInt(words[2]) > 3) {
				System.out.format("[ERROR]: Command %s: %s%n%n", INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} 
			else {
				x = Integer.parseInt(words[1]);
				y = Integer.parseInt(words[2]);
				return this;
			}
		}
		return null;
	}
	
	@Override
	public boolean execute(Game game) throws NotEnoughCoinsException {
		if(buy(game)) {
			game.grenade(x, y);
		} else throw new NotEnoughCoinsException("Grenade Command", "Grenade");
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 3;
	}
}