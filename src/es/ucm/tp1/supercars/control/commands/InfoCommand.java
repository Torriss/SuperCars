package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.StringUtils;
import es.ucm.tp1.supercars.view.GamePrinter;

public class InfoCommand extends Command {

	private static final String NAME = "info";
	private static final String DETAILS = "[i]nfo";
	private static final String SHORTCUT = "i";
	private static final String HELP = "prints gameobject info";

	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:" + "\n");
		buffer.append("[Player] you car" + "\n");
		buffer.append("[Obstacle] kills your car" + "\n");
		buffer.append("[Coin] you earn a coin" + "\n");
		buffer.append("[GRENADE] Explodes in 3 cycles, harming everyone around" + "\n");
		buffer.append("[WALL] hard obstacle" + "\n");
		buffer.append("[TURBO] pushes the car 3 columns" + "\n");
		buffer.append("[SUPERCOIN] gives 1000 coins" + "\n");
		buffer.append("[TRUCK] moves towards the player" + "\n");
		buffer.append("[PEDESTRIAN] person crossing the road up and down" + "\n");
		

		System.out.println(buffer.toString());
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

}