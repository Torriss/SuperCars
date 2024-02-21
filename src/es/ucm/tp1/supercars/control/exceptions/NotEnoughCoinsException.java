package es.ucm.tp1.supercars.control.exceptions;

public class NotEnoughCoinsException extends CommandExecuteException {

	public NotEnoughCoinsException(String a, String nombre) {
		super(a, nombre);
	}

}
