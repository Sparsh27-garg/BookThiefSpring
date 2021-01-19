package com.bookthief.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookthief.dao.BookThiefDAO;
import com.bookthief.model.Best;
import com.bookthief.model.Fictional;
import com.bookthief.model.Login;

@Service(value="bookthiefService")
@Transactional
public class BookThiefServiceImpl implements BookThiefService {

	@Autowired
	private BookThiefDAO bookthiefDAO;
	
	@Override
	public List<Login> login() throws Exception{
		// TODO Auto-generated method stub
		return bookthiefDAO.login();
		
	}

	@Override
	public List<Fictional> getFictionBooks() throws Exception{
		// TODO Auto-generated method stub
		return bookthiefDAO.getFictionBooks();
	}

	@Override
	public List<Best> getBestBooks() throws Exception{
		// TODO Auto-generated method stub
		return bookthiefDAO.getBestBooks();
	}

	@Override
	public Fictional updateBookPrice(String productCode, Integer price) throws Exception{
		// TODO Auto-generated method stub
		return bookthiefDAO.updateBookPrice(productCode, price);
	}

	@Override
	public Best updateBookBestprice(String productCode, Integer price) throws Exception{
		// TODO Auto-generated method stub
		return bookthiefDAO.updateBookBestprice(productCode, price);
	}

	@Override
	public Fictional addFictionalBook(Fictional ficBook) throws Exception {
		// TODO Auto-generated method stub
		return bookthiefDAO.addFictionalBook(ficBook);
	}

	@Override
	public Best addBestBook(Fictional bBook) throws Exception {
		// TODO Auto-generated method stub
		return bookthiefDAO.addBestBook(bBook);
	}

	@Override
	public int deleteFicBook(String productCode) throws Exception {
		// TODO Auto-generated method stub
		int v= bookthiefDAO.deleteFicBook(productCode);
		if(v==1)
			return v;
		else
			throw new Exception("API.DELETE_ERROR");
	}

	@Override
	public int deleteBestBook(String productCode) throws Exception {
		// TODO Auto-generated method stub
		int a= bookthiefDAO.deleteBestBook(productCode);
		if(a==1)
			return a;
		else
			throw new Exception("API.DELETE_ERROR");
	}

}
