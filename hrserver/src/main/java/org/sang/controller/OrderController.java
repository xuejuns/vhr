package org.sang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sang.bean.Order;
import org.sang.bean.OrderBo;
import org.sang.bean.RespBean;
import org.sang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/add", method = RequestMethod.POST,consumes = "application/json")
	public RespBean addOrder(@RequestBody OrderBo order){
		try{
			orderService.addOrder(order);
			return new RespBean("success","新增成功");
		}catch(Exception e){
			return new RespBean("error",e.getMessage());
		}
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public RespBean updateOrder(Order order){
		if(orderService.updateOrder(order)==1){
			return new RespBean("success","新增成功");
		}
		return new RespBean("error","新增失败");
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public RespBean deleteOrder(@PathVariable int id){
		if(orderService.deleteOrder(id)==1){
			return new RespBean("success","新增成功");
		}
		return new RespBean("error","新增失败");
	}


	@RequestMapping(value="/getAll", method = RequestMethod.POST)
	public Map<String, Object> getAll(){
		
        Map<String, Object> map = new HashMap<>();
        map.put("orders", orderService.getAllOrders());
		return map;
	}

	@RequestMapping(value="/getbypage", method = RequestMethod.POST)
	public Map<String, Object> getByPage(int start,int size){
		
        Map<String, Object> map = new HashMap<>();
        map.put("orders", orderService.getOrdersByPage(start,size));
		return map;
	}


	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public Map<String,Object> getOrder(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        map.put("order", orderService.findOne(id));
		
		return map;
	}

}
