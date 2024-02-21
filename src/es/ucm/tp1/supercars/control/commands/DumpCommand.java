package es.ucm.tp1.supercars.control.commands;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.Record;

public class DumpCommand extends Command {
	
	private String name;
	private String file;

	public DumpCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		
	}
	
	public Command parse(String[] words) throws CommandParseException {
		if(matchCommandName(words[0])) {
			if(words.length != 2) {
				throw new CommandParseException(String.format("[ERROR]:Command %s: %s", name, INCORRECT_NUMBER_OF_ARGS_MSG));
			}
			else {
				file = words[1];
				return this;
			}
		}
		return null;
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
			
		try{
			Scanner scanner = new Scanner(file);
		
			//BufferedReader br = new BufferedReader(new FileReader(file));
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		}
		catch (FileNotFoundException e) {
			throw new CommandExecuteException("le", "le");
		}
		return false;
	}

}
