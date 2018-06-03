package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

public class OrderFactory {
	public final static int ABS = 0;
	public final static int SIZE = 1;
	public final static int TYPE = 2;
	public final static int DEFAULT_COMPERATOR = ABS;

	public static Order[] orders = new Order[3];

	public OrderFactory() {
		orders[ABS] = new AbsOrder();
		orders[SIZE] = new SizeOrder();
		orders[TYPE] = new TypeOrder();
	}

	public Comparator<File> getOrderComparator(String order, boolean oppositeRule) throws OrderException {
		Comparator<File> comparator;
		switch (order) {
			case "abs":
				comparator = orders[OrderFactory.ABS];
				break;
			case "type":
				comparator = orders[OrderFactory.TYPE];
				break;
			case "size":
				comparator = orders[OrderFactory.SIZE];
				break;
			default:
				throw new OrderException();
		}
		if (oppositeRule) {
			comparator = comparator.reversed();
		}
		return comparator;
	}

	public Comparator<File> getDefaultOrder() {
		return orders[OrderFactory.DEFAULT_COMPERATOR];
	}
}


