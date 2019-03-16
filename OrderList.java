import java.util.*;
import java.text.*;
import java.io.*;

class OrderList implements Serializable{

    private static final long serialVersionUID = 1L;
    private List orderList = new LinkedList();
    private static OrderList OrderListObject;

    private OrderList(){

    }

    public static OrderList instance(){
        if(OrderListObject == null){
            return (OrderListObject = new OrderList());
        }
        else
          return OrderListObject;
    }

    public Boolean addOrder(Order order){
        orderList.add(order);
        return true;
    }

    public Iterator getOrder(){
        return orderList.iterator();
    }

    public Order searchOrder(int orderID){
        if(orderList.isEmpty())
          return null;
        else{
            Iterator orderList1 = OrderListObject.getOrder();
            while(orderList1.hasNext()){

                Order order = (Order) orderList1.next();
                int checkID  = order.getOrderID();
                
                 if(checkID == orderID){
                     return order;
                 }

            }
        }
        return null;
    }




    
}