package our_code;

public class CustomerExceptionHandler extends Exception
{	
	String message;
	
	
	public CustomerExceptionHandler(String errorMessage){
		message = errorMessage;
	}
	
	public String getMessage() {
		return message;
	}

}
