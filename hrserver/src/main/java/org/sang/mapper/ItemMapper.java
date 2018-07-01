package org.sang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Item;
import org.sang.bean.Order;

public interface ItemMapper {
	public int insertItem(@Param("item") Item item);
	public int updateItem(@Param("item") Order item);
	public int deleteItem(@Param("itemid") int item);
	public List<Item> findAllItem();
	public Item findOneItem(@Param("itemid") int itemid);
	public List<Item> findItemByOrderid(@Param("orderid")int orderid);

}
