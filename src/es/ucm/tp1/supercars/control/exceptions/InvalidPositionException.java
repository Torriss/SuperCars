package es.ucm.tp1.supercars.control.exceptions;

public class InvalidPositionException extends CommandExecuteException {

	public InvalidPositionException(String a, String nombre) {
		super(a, nombre);
	}

}
