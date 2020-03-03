package org.csu.mypetstore.persistence;


import java.util.List;

import org.csu.mypetstore.domain.LineItem;

public interface LineItemDAO {

    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);

}
