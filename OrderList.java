import java.util.*;

class OrderList extends ParentList {

    private static final long serialVersionUID = 1L;
    private LinkedList<Order> orderList = new LinkedList<Order>();
    private static OrderList OrderListObject;

    public static OrderList instance() {
        if (OrderListObject == null) {
            return (OrderListObject = new OrderList());
        } else
            return OrderListObject;
    }

    public Order searchOrder(int orderID) {
        if (orderList.isEmpty())
            return null;
        else {
            Iterator<Thing> orderList1 = OrderListObject.getList();
            while (orderList1.hasNext()) {
                Order order = (Order) orderList1.next();
                int checkID = order.getOrderID();
                if (checkID == orderID) {
                    return order;
                }
            }
        }
        return null;
    }
}