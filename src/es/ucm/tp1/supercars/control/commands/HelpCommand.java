package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.StringUtils;

public class HelpCommand extends Command {

	private static final String NAME = "help";
	private static final String DETAILS = "[h]elp";
	private static final String SHORTCUT = "h";
	private static final String HELP = "show this help";

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:" + "\n");
		buffer.append("[h]elp: show this help" + "\n");
		buffer.append("[i]nfo: prints gameobjet info" + "\n");
		buffer.append("[n]one | []: update" + "\n");
		buffer.append("[q]: go up" + "\n");
		buffer.append("[a]: go down" + "\n");
		buffer.append("[e]xit: exit game" + "\n");
		buffer.append("[r]eset [<level> <seed>]: reset game" + "\n");
		buffer.append("[s]hoot: shoot bullet" + "\n");
		buffer.append("[g]renade <x> <y>: add a grenade in position x, y" + "\n");
		buffer.append("[w]ave: do wave" + "\n");
		buffer.append("[z]: serializa la partida" + "\n");
		buffer.append("seriali[z]e: serializa la partida" + "\n");
		buffer.append("sa[v]e <filename>: Save the state of the game to a file." + "\n");
		buffer.append("rec[o]rd: show level record" + "\n");

		System.out.println(buffer.toString());

		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
