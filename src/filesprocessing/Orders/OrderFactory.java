package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

public class OrderFactory {
	public final static String REVERSE_SUFFIX = "#REVERSE";


	private final static String ABS_NAME = "abs";
	private final static String TYPE_NAME = "type";
	private final static String SIZE_NAME = "size";
	private final static int ABS = 0;
	private final static int SIZE = 1;
	private final static int TYPE = 2;


	private final static int DEFAULT_COMPARATOR = ABS;
	public final static String DEFAULT_ORDER_NAME = ABS_NAME;


	private static Order[] orders = new Order[3];

	public OrderFactory() {
		orders[ABS] = new AbsOrder();
		orders[SIZE] = new SizeOrder();
		orders[TYPE] = new TypeOrder();
	}

	public Comparator<File> getOrderComparator(String order, boolean oppositeRule) throws OrderException {
		Comparator<File> comparator;
		switch (order) {
			case ABS_NAME:
				comparator = orders[OrderFactory.ABS];
				break;
			case TYPE_NAME:
				comparator = orders[OrderFactory.TYPE];
				break;
			case SIZE_NAME:
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
		return orders[OrderFactory.DEFAULT_COMPARATOR];
	}
}


