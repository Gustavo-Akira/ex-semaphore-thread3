package exception;

public class TimeOutException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public TimeOutException(String operation) {
		super("The operation "+ operation +" timeouted");
	}
	
}
