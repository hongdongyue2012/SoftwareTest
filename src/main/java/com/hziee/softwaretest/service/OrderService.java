package com.hziee.softwaretest.service;

import com.hziee.softwaretest.entity.Order;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */
public interface OrderService {

	//添加订单信息
	int insertOrder(Order order);

	//删除订单信息
	int deleteOrder(int order_id);

	//修改订单信息
	int updateOrder(Order order);

	//查询所有订单信息
	List<Order> selectAllOrder();

	//查询某条订单信息
	Order selectAOrder(int order_id);
}
