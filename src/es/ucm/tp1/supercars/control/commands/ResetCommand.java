package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.StringUtils;

public class ResetCommand extends Command {
	
	private static final String NAME = "reset";
	private static final String DETAILS = "[r]eset";
	private static final String SHORTCUT = "r";
	private static final String HELP = "reset game";
	Long seed;
	Level level;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length > 3) {
				System.out.format("[ERROR]: Command %s: %s%n%n", INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} 
			else {
				seed = Long.parseLong(words[1]);
				level = Level.valueOfIgnoreCase(words[2]);
				
				return this;
			}
		}
		return null;
	}
	
	@Override
	public boolean execute(Game game) {
		if(seed == null) {
			game.reset();
		} else {
			game.reset(seed, level);
		}
		
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
