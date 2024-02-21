package es.ucm.tp1.supercars.control.exceptions;

public class CommandExecuteException extends GameException {
	public CommandExecuteException(String a, String nombre) {
		super(a + "%n" + "[ERROR]: Failed to " + nombre);
	}

}
