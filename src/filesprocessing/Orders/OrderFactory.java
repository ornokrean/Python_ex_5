package filesprocessing.Orders;

public class OrderFactory {
	final static int ABS = 0;
	final static int SIZE = 1;
	final static int TYPE = 2;

	public Order[] orders = new Order[9];

	public Order[] createFilters() {
		orders[ABS] = new AbsOrder();
		orders[SIZE] = new SizeOrder();
		orders[TYPE] = new TypeOrder();
		return orders;
	}
}


