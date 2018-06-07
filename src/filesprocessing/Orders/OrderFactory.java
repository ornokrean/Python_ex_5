package filesprocessing.Orders;

import filesprocessing.FileProcessingExceptions.OrderException;

import java.io.File;
import java.util.Comparator;
/**
 * This class create array with all the type of comparator represent the orders.
 */
public class OrderFactory {

	/* *********************************** Constant *********************************************** */
	public final static String REVERSE_SUFFIX = "#REVERSE";
	private final static String ABS_NAME = "abs";
	public final static String DEFAULT_ORDER_NAME = ABS_NAME;
	private final static String TYPE_NAME = "type";
	private final static String SIZE_NAME = "size";
	private final static int ABS = 0;
	private final static int SIZE = 1;
	private final static int TYPE = 2;
	private final static int DEFAULT_COMPARATOR = ABS;
	/* ************************************* fields ************************************************** */
	private static Order[] orders = new Order[3];

	private static OrderFactory factory = new OrderFactory();

	/**
	 * constructor, create array with all type of order comparator.
	 */
	private OrderFactory() {
		orders[ABS] = new AbsOrder();
		orders[SIZE] = new SizeOrder();
		orders[TYPE] = new TypeOrder();
	}

	public static OrderFactory instance() {
		return factory;
	}

	/**
	 * k
	 *
	 * @param order        -type of order
	 * @param oppositeRule - true if reverse , else false
	 * @return comparator
	 * @throws OrderException if the type of order doesnt fit
	 */
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

}


