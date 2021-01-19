package com.bookthief.dao;

import java.util.List;

import com.bookthief.model.Best;
import com.bookthief.model.Fictional;
import com.bookthief.model.Login;

public interface BookThiefDAO {
	public List<Login> login() throws Exception;
	
	public List<Fictional> getFictionBooks() throws Exception;
	
	public List<Best> getBestBooks() throws Exception;
	
	public Fictional updateBookPrice(String productCode,Integer price) throws Exception;
	
	public Best updateBookBestprice(String productCode,Integer price) throws Exception;

	public Fictional addFictionalBook(Fictional ficBook) throws Exception;
	
	public Best addBestBook(Fictional bBook) throws Exception;
    
	public int deleteFicBook(String productCode) throws Exception;
	
	public int deleteBestBook(String productCode) throws Exception;
}
