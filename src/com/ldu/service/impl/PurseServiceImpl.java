package com.ldu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldu.dao.PurseMapper;
import com.ldu.pojo.Goods;
import com.ldu.pojo.Purse;
import com.ldu.service.PurseService;

@Service("PurserService")
public class PurseServiceImpl implements PurseService{
	 @Resource
	 private PurseMapper purseMapper;


	public void updatePurseByuserId(Integer userId, Float balance) {
		// TODO Auto-generated method stub
		purseMapper.updatePurseByuserId(userId, balance);
		
	}


	public void updatePurseOfdel(Integer userId, Float balance) {
		// TODO Auto-generated method stub
		purseMapper.updatePurseOfdel(userId, balance);
	}


	public void addPurse(Integer userId) {
		// TODO Auto-generated method stub
		purseMapper.addPurse(userId);
	}


	public Purse getPurseByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		return purseMapper.selectPurseByUserId(user_id);
	}


	public void updatePurse(Purse purse) {
		// TODO Auto-generated method stub
		purseMapper.updatePurse(purse);
		
	}


	public int getPurseNum() {
		List<Purse> purse= purseMapper.selectPurseList();
		return purse.size();
	}


	public List<Purse> getPagePurse(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Purse> purse =purseMapper.selectPurseList();
		return purse;
	}


//	@Override
//	public List<Purse> getPagePurseByPurse(Integer userId,Integer state, int pageNum, int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);
//		List<Purse> purse =purseMapper.getPagePurseByPurse(userId,state);
//		return purse;
//	}


	public Purse getPurseById(int id) {
		return purseMapper.selectPurseById(id);
	}


	public void updateByPrimaryKey(Integer id, Purse purse) {
		purse.setId(id);
		purseMapper.updateByPrimaryKey(purse);
		
	}


	public void updatePursePassById(Integer id,Purse purse) {
		purse.setId(id);
		purseMapper.updatePurseById(purse);
		
	}


	public void updatePurseRefuseById(Integer id,Purse purse) {
		purse.setId(id);
		purseMapper.updatePurseById(purse);
		
	}


	public PageInfo<Purse> getPagePurseByPurse(int pageNum, int pageSize, Purse searchPurse) {
		int start = (pageNum-1)*pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Purse> List = this.purseMapper.getPagePurseByPurse(searchPurse);
		for (Purse good : List) {
			System.out.print(good.getId()+"   ");
		}
		PageInfo<Purse> pageResult = new PageInfo<Purse>(List);
		return pageResult;
	}


}
