package com.bookthief.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bookthief.entity.BestEntity;
import com.bookthief.entity.FictionalEntity;
import com.bookthief.entity.LoginEntity;
import com.bookthief.model.Best;
import com.bookthief.model.Fictional;
import com.bookthief.model.Login;

@Repository(value="bookthiefDAO")
public class BookThiefDAOImpl implements BookThiefDAO {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Login> login() throws Exception {
		// TODO Auto-generated method stub
		List<Login> loginCred=null;
		Query query=entityManager.createQuery("SELECT lc FROM LoginEntity lc ");
        List<LoginEntity> entities=query.getResultList();
        
        loginCred=new ArrayList<>();
        for(LoginEntity entity:entities){
        	Login lc=new Login();
        	lc.setUserName(entity.getName());
        	lc.setPassword(entity.getPassword());
        	
        	loginCred.add(lc);
        }
		return loginCred;
	}

	@Override
	public List<Fictional> getFictionBooks() throws Exception{
		// TODO Auto-generated method stub
		List<Fictional> ficBooks=null;
		Query query=entityManager.createQuery("SELECT fb FROM FictionalEntity fb ");
        List<FictionalEntity> entities=query.getResultList();
        
        ficBooks=new ArrayList<>();
        for(FictionalEntity e:entities){
        	Fictional f=new Fictional();
        	f.setProductId(e.getProductId());
        	f.setDescription(e.getDescription());
        	f.setImageUrl(e.getImageUrl());
        	f.setManufacturer(e.getManufacturer());
        	f.setPrice(e.getPrice());
        	f.setProductCode(e.getProductCode());
        	f.setProductName(e.getProductName());
        	f.setRating(e.getRating());
        	f.setOstype(e.getOstype());
        	
        	ficBooks.add(f);
        	
        }
		return ficBooks;
		
	}

	@Override
	public List<Best> getBestBooks() throws Exception{
		// TODO Auto-generated method stub
		List<Best> bestBooks=null;
		Query query=entityManager.createQuery("SELECT b FROM BestEntity b ");
        List<BestEntity> entities=query.getResultList();
        
        bestBooks=new ArrayList<>();
        for(BestEntity e:entities){
        	Best b=new Best();
        	b.setProductId(e.getProductId());
        	b.setDescription(e.getDescription());
        	b.setImageUrl(e.getImageUrl());
        	b.setManufacturer(e.getManufacturer());
        	b.setPrice(e.getPrice());
        	b.setProductCode(e.getProductCode());
        	b.setProductName(e.getProductName());
        	b.setRating(e.getRating());
        	b.setOstype(e.getOstype());
        	
        	bestBooks.add(b);
        	
        }
		return bestBooks;
		
	}

	@Override
	public Fictional updateBookPrice(String productCode,Integer price) throws Exception{
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT fb FROM FictionalEntity fb WHERE fb.productCode=?1");
		query.setParameter(1, productCode);
		Object o=query.getSingleResult();
		FictionalEntity f1=(FictionalEntity)o;
		f1.setPrice(price);
		entityManager.persist(f1);
		Fictional f=new Fictional();
		f.setProductName(f1.getProductName());
		f.setPrice(f1.getPrice());
		f.setProductCode(f1.getProductCode());

		return f;
	}

	@Override
	public Best updateBookBestprice(String productCode,Integer price) throws Exception{
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT b FROM BestEntity b WHERE b.productCode=?1");
		query.setParameter(1, productCode);
		Object o=query.getSingleResult();
		BestEntity b1=(BestEntity)o;
		b1.setPrice(price);
		entityManager.persist(b1);
		Best b=new Best();
		b.setProductName(b1.getProductName());
		b.setPrice(b1.getPrice());
		b.setProductCode(b1.getProductCode());

		return b;
	}

	@Override
	public Fictional addFictionalBook(Fictional ficBook) throws Exception {
		// TODO Auto-generated method stub

		FictionalEntity fe=new FictionalEntity();
		fe.setDescription(ficBook.getDescription());
		fe.setImageUrl(ficBook.getImageUrl());
		fe.setManufacturer(ficBook.getManufacturer());
		fe.setPrice(ficBook.getPrice());
		fe.setProductName(ficBook.getProductName());
		fe.setRating(ficBook.getRating());
		entityManager.persist(fe);
		
		
		fe.setProductCode("FIC-"+fe.getProductId());
		entityManager.persist(fe);
        Fictional f=new Fictional();
        f.setProductCode(fe.getProductCode());
        f.setProductName(fe.getProductName());
        f.setPrice(fe.getPrice());
        f.setProductId(fe.getProductId());
		
		
		return f;
	}

	@Override
	public Best addBestBook(Fictional bBook) throws Exception {
		// TODO Auto-generated method stub
		BestEntity be=new BestEntity();
		be.setDescription(bBook.getDescription());
		be.setImageUrl(bBook.getImageUrl());
		be.setManufacturer(bBook.getManufacturer());
		be.setPrice(bBook.getPrice());
		be.setProductName(bBook.getProductName());
		be.setRating(bBook.getRating());
		entityManager.persist(be);
		
		be.setProductCode("BS-"+be.getProductId());
		entityManager.persist(be);

		Best b=new Best();
        b.setProductCode(be.getProductCode());
        b.setProductName(be.getProductName());
        b.setPrice(be.getPrice());
        b.setProductId(be.getProductId());
		
		
		return b;
	}

	@Override
	public int deleteFicBook(String productCode) throws Exception {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("DELETE from FictionalEntity fe WHERE fe.productCode=?1");
		query.setParameter(1, productCode);
		int updatedEntities = query.executeUpdate();
		
		if(updatedEntities==1)
		 return updatedEntities;
		else
			return 0;
	}

	@Override
	public int deleteBestBook(String productCode) throws Exception {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("DELETE from BestEntity be WHERE be.productCode=?1");
		query.setParameter(1, productCode);
		int updatedEntities = query.executeUpdate();
		if(updatedEntities==1)
			 return updatedEntities;
			else
				return 0;
	}

}
