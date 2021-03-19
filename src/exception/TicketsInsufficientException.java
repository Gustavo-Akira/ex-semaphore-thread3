package exception;

public class TicketsInsufficientException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public TicketsInsufficientException() {
		super("The tickets are insufficient please choose less number of tickets");
	}
}
