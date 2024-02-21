package es.ucm.tp1.supercars.control.commands;


import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerializer;

public class SerializeCommand extends Command {

	private static final String NAME = "serialize";
	private static final String DETAILS = "seriali[z]e";
	private static final String SHORTCUT = "z";
	private static final String HELP = "serializes the game";
	private GameSerializer serializado;

	public SerializeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		serializado = new GameSerializer(game);
		System.out.println(serializado.toString());
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}


}