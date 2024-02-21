package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;

public abstract class Command implements InstantAction, Buyable{

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";

	/* @formatter:off */
	protected static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new ResetCommand(),
		new UpCommand(),
		new DownCommand(),
		new ExitCommand(),
		new ShotCommand(),
		new WaveCommand(),
		new SerializeCommand(),
		new SaveCommand(),
		new GrenadeCommand(),
		new LoadCommand()
	};
	/* @formatter:on */

	public static Command getCommand(String[] commandWords) throws CommandParseException{
		/*Command command = null;
		// TODO Add your code
		command.parse(commandWords);
		System.out.format("[ERROR]: %s%n%n", UNKNOWN_COMMAND_MSG);
		return command;*/
		for(Command c : AVAILABLE_COMMANDS) { //RECORRE TODOS LOS PROTOTIPOS DEL COMMAND
            Command parsedCommand = c.parse(commandWords);
                if(parsedCommand != null) return parsedCommand;
            }
        return null;
	}

	private final String name;
	private final String shortcut;
	private final String details;
	private final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game) throws CommandExecuteException;

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				throw new CommandParseException(String.format("[ERROR]:Command %s: %s", name, INCORRECT_NUMBER_OF_ARGS_MSG));
			} 
			else return this;
		}
		return null;
	}

	// TODO Add your code

}
