package filesprocessing.Orders;

public class OrderFactory {
	public final static int ABS = 0;
	public final static int SIZE = 1;
	public final static int TYPE = 2;

	public Order[] orders = new Order[3];

	public Order[] createFilters() {
		orders[ABS] = new AbsOrder();
		orders[SIZE] = new SizeOrder();
		orders[TYPE] = new TypeOrder();
		return orders;
	}
}


