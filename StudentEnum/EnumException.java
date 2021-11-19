package StudentEnum;

public enum EnumException {

	ESTUDENT_NOT_FOUND_DELETE("This student do not exist in list. It's impossible to delete."), 
	ESTUDENT_NOT_FOUND_UPDATE("This student do not exist in list. It's impossible to update."), 
	ESTUDENT_NOT_FOUND_READ("This student do not exist in list. It's impossible to read."), 
	ESTUDENT_NOT_FOUND_GET("This student do not exist in list. It's impossible to get."), 
	ESTUDENT_NOT_FOUND("This student do not exist in list. "), 
	NO_STUDENT_IN_LIST("Do not exist student in list"),
	
	INVALID_STUDENT("Invalid student, insert a valid \"ID\" and \"Name\" ");
	
	public final String message;
	private Throwable throwable;

	private EnumException(String message) {
		this.message = message;
	}
	
}
