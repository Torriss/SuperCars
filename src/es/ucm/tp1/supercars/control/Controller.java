package es.ucm.tp1.supercars.control;

import java.util.Scanner;

import es.ucm.tp1.supercars.control.commands.Command;
import es.ucm.tp1.supercars.control.exceptions.GameException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";
	private static final String DEBUG_MSG = "[DEBUG] Executing: %s%n";
	private static final String UNKNOWN_COMMAND_MSG = "Comando erroneo";
	private Game game;
	private Scanner scanner;
	private GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;

		this.printer = new GamePrinter(game);

	}

	public void printGame() {
		System.out.println(printer);
		//System.out.println(printer.toString());
	}

	public void printEndMessage() {
		printGame();
		System.out.println(printer.endMessage());
	}

	public void run() {
		boolean refreshDisplay = true;
		boolean comandoError = false;

		while (!game.isFinished() && refreshDisplay) {
			if (refreshDisplay && !comandoError) {
				printGame();
			}
			refreshDisplay = false;
			comandoError = false;
			System.out.println(PROMPT);
			String s = scanner.nextLine();

			String[] parameters = s.toLowerCase().trim().split(" ");
			System.out.format(DEBUG_MSG, s);
			try {
				Command command = Command.getCommand(parameters);
				refreshDisplay = command.execute(game);
			}
			catch(GameException ex) {
				System.out.format(ex.getMessage() + " %n %n");
			}
			if(game.collision()) {
				printGame();
				game.updatePost();
			}
			if(!refreshDisplay || game.isFinished()) printEndMessage();
		}
	}
}
