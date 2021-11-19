package StudentException;

public class StudentDeleteException extends Exception {

	public StudentDeleteException(String message) {
		super(message);
	}

	public StudentDeleteException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
