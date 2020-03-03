package org.csu.mypetstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.domain.Sequence;


import org.csu.mypetstore.persistence.ItemDAO;
import org.csu.mypetstore.persistence.OrderDAO;
import org.csu.mypetstore.persistence.LineItemDAO;
import org.csu.mypetstore.persistence.SequenceDAO;
import org.csu.mypetstore.persistence.impl.ItemDAOImpl;
import org.csu.mypetstore.persistence.impl.LineItemDAOImpl;
import org.csu.mypetstore.persistence.impl.OrderDAOlmpl;
import org.csu.mypetstore.persistence.impl.SequenceDAOlmpl;


public class OrderService {


  private ItemDAO ItemDAO;

  private OrderDAO OrderDAO;

  private SequenceDAO SequenceDAO;

  private LineItemDAO LineItemDAO;
 public OrderService()
 {
  ItemDAO = new ItemDAOImpl();
  OrderDAO = new OrderDAOlmpl();
  SequenceDAO = new SequenceDAOlmpl();
  LineItemDAO = new LineItemDAOImpl();
}
  public void insertOrder(Order order) {
    order.setOrderId(getNextId("ordernum"));
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      String itemId = lineItem.getItemId();
      Integer increment = new Integer(lineItem.getQuantity());
      Map<String, Object> param = new HashMap<String, Object>(2);
      param.put("itemId", itemId);
      param.put("increment", increment);
      ItemDAO.updateInventoryQuantity(param);
    }

    OrderDAO.insertOrder(order);
    OrderDAO.insertOrderStatus(order);
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      lineItem.setOrderId(order.getOrderId());
      LineItemDAO.insertLineItem(lineItem);
    }
  }


  public Order getOrder(int orderId) {
    Order order = OrderDAO.getOrder(orderId);
    order.setLineItems(LineItemDAO.getLineItemsByOrderId(orderId));

    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      Item item = ItemDAO.getItem(lineItem.getItemId());
      item.setQuantity(ItemDAO.getInventoryQuantity(lineItem.getItemId()));
      lineItem.setItem(item);
    }

    return order;
  }

  public List<Order> getOrdersByUsername(String username) {
    return OrderDAO.getOrdersByUsername(username);
  }

  public int getNextId(String name) {

    Sequence sequence = new Sequence(name, -1);
    sequence = (Sequence) SequenceDAO.getSequence(sequence);
    if (sequence == null) {
      throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
          + " sequence).");
    }
    Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
    SequenceDAO.updateSequence(parameterObject);
    return sequence.getNextId();
  }

}

