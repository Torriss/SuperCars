package es.ucm.tp1.supercars.control.exceptions;

public abstract class GameException extends Exception {
	String mensaje;
	public GameException(String a) {
		this.mensaje = a;
	}
	public String getMessage() {
		return mensaje;
	}
}
