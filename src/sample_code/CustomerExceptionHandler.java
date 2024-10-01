package sample_code;

public class CustomerExceptionHandler extends Exception {
	
	String message;
	
	public CustomerExceptionHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}
