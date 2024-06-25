package edu.icet.dao.sales;

import edu.icet.dao.SuperDAO;
import edu.icet.entity.OrderEntity;

import java.util.List;

public interface SalesDao extends SuperDAO {
    List<OrderEntity> retriveTodaysOrders();
}
