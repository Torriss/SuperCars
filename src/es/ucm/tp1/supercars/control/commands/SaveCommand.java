package es.ucm.tp1.supercars.control.commands;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerializer;

public class SaveCommand extends Command {

	private static final String NAME = "save";
	private static final String DETAILS = "sa[v]e";
	private static final String SHORTCUT = "v";
	private static final String HELP = "saves the game";
	String file;
	private GameSerializer serializado;

	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 2) {
				System.out.format("[ERROR]: Command %s: %s%n%n", INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} 
			else {
				file = words[1];
				return this;
			}
		}
		return null;
	}
	
	@Override
	public boolean execute(Game game) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file + ".txt"))) {
			serializado = new GameSerializer(game);
			bw.write(serializado.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}