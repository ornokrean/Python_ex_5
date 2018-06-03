package filesprocessing.Orders;

public class OrderException extends Exception {
	private static final long serialVersionUID = 1L;

	public OrderException() {
		super("Warning in line %d \n");
	}
	public OrderException(String s){
		super(s);
	}

}
