package com.hziee.softwaretest.service.imp;

import com.hziee.softwaretest.entity.Order;
import com.hziee.softwaretest.mapper.OrderMapper;
import com.hziee.softwaretest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */
@Service
public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public int insertOrder(Order order) {
		return orderMapper.insertOrder(order);
	}

	@Override
	public int deleteOrder(int order_id) {
		return orderMapper.deleteOrder(order_id);
	}

	@Override
	public int updateOrder(Order order) {
		return orderMapper.updateOrder(order);
	}

	@Override
	public List<Order> selectAllOrder() {
		return orderMapper.selectAllOrder();
	}

	@Override
	public Order selectAOrder(int order_id) {
		return orderMapper.selectAOrder(order_id);
	}
}
