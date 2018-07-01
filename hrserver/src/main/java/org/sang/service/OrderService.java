package org.sang.service;

import java.util.ArrayList;
import java.util.List;

import org.sang.bean.Item;
import org.sang.bean.Order;
import org.sang.bean.OrderBo;
import org.sang.mapper.ItemMapper;
import org.sang.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private ItemMapper itemMapper;
	
	public int addOrder(OrderBo orderbo){
		Order order = orderbo.getOrder();
		int result = orderMapper.insertOrder(order);
		List<Item> items = orderbo.getItems();
		for(Item item:items){
			item.setOrderid(order.getOrderid());
			itemMapper.insertItem(item);
		}
		return result;
	}
	
	public int updateOrder(Order order){
		return orderMapper.updateOrder(order);
	}
	
	public int deleteOrder(int orderid){
		return orderMapper.deleteOrder(orderid);
	}
	
	public List<OrderBo> getAllOrders(){
		try{
			List<Order> orders = orderMapper.findAllOrder();
			List<OrderBo> orderBos = new ArrayList<OrderBo>(orders.size());
			for(Order order:orders){
				OrderBo bo = new OrderBo();
				bo.setOrder(order);
				List<Item> items = itemMapper.findItemByOrderid(order.getOrderid());
				bo.setItems(items);
				orderBos.add(bo);
			}
			return orderBos;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Order findOne(int orderid){
		return orderMapper.findOneOrder(orderid);
	}

	public Object getOrdersByPage(int start, int size) {
		try{
			List<Order> orders = orderMapper.findOrderByPage(start, size);
			List<OrderBo> orderBos = new ArrayList<OrderBo>(orders.size());
			for(Order order:orders){
				OrderBo bo = new OrderBo();
				bo.setOrder(order);
				List<Item> items = itemMapper.findItemByOrderid(order.getOrderid());
				bo.setItems(items);
				orderBos.add(bo);
			}
			return orderBos;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
