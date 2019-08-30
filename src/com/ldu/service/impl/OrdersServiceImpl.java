package com.ldu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldu.dao.OrdersMapper;
import com.ldu.pojo.Goods;
import com.ldu.pojo.Orders;
import com.ldu.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	
	@Resource
	private OrdersMapper ordersMapper;

	public List<Orders> getOrdersByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		List<Orders> orders=ordersMapper.selectOrdersByUserId(user_id);
		return orders;
	}

	
	public List<Orders> getOrdersByUserAndGoods(Integer user_id) {
		// TODO Auto-generated method stub
		
		List<Orders> ordersOfSell=ordersMapper.selectOrdersByUserAndGoods(user_id);
		return ordersOfSell;
	}

	
	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		
		ordersMapper.addOrders(orders);
		
	}


	public void deliverByOrderNum(Integer orderNum) {
		// TODO Auto-generated method stub
		ordersMapper.deliverByOrderNum(orderNum);
	}


	public void receiptByOrderNum(Integer orderNum) {
		// TODO Auto-generated method stub
		ordersMapper.receiptByOrderNum(orderNum);
		
	}


	public int getOrdersNum() {
		List<Orders> orders = ordersMapper.getOrdersList();
	    return orders.size();
	}


	public List<Orders> getPageOrders(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Orders> list =ordersMapper.getOrdersList();
		return list;
	}

	public Orders getOrdersById(int ordersId) {
		Orders orders = ordersMapper.selectById(ordersId);
	        return orders;
	}


	public void updateByPrimaryKey(Integer id, Orders orders) {
			orders.setId(id);
	        this.ordersMapper.updateByPrimaryKey(orders);
		
	}


	public void deleteOrdersByPrimaryKeys(int id) {
		 ordersMapper.deleteByPrimaryKeys(id);
	}

//	@Override
//	public List<Orders> getPageOrdersByOrders(Long orderNum, String orderInformation, Integer orderState, int pageNum,
//			int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);
//		List<Orders> orders = ordersMapper.getPageOrdersByOrders(orderNum,orderInformation,orderState);
//		return orders;
//	}


	public PageInfo<Orders> getPageOrdersByOrders(int pageNum, int pageSize, Orders searchOrders) {
		int start = (pageNum-1)*pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Orders> List = this.ordersMapper.getPageOrdersByOrders(searchOrders);
		for (Orders good : List) {
			System.out.print(good.getId()+"   ");
		}
		PageInfo<Orders> pageResult = new PageInfo<Orders>(List);
		return pageResult;
	}


}
