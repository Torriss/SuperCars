package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;

public interface InstantAction { 
	
	boolean execute(Game game) throws CommandExecuteException;
	
}

