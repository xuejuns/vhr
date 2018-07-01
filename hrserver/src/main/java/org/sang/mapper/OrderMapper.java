package org.sang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Order;

public interface OrderMapper {
	public int insertOrder(@Param("order") Order order);
	public int updateOrder(@Param("order") Order order);
	public int deleteOrder(@Param("orderid") int orderid);
	public List<Order> findAllOrder();
	public List<Order> findOrderByPage(@Param("start") int start,@Param("size") int size);
	public Order findOneOrder(@Param("orderid") int orderid);

}
