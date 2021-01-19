package com.bookthief.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bookthief.model.Best;
import com.bookthief.model.Fictional;
import com.bookthief.model.Login;
import com.bookthief.service.BookThiefService;


@RestController
@RequestMapping(value="/bookthiefAPI")
public class BookThiefAPI {
	@Autowired
	private BookThiefService bookthiefService;
	
	@Autowired
	public Environment environment;
	
	
	@PostMapping(value="/addBook/{category}")
	public ResponseEntity<Fictional> addForm(@PathVariable String category,@RequestBody Fictional ficBook) {
		ResponseEntity<Fictional> re=null;
		String bookT=category.substring(0,1);
		
		if(bookT.equals("F")){
			try{
				
			Fictional f=bookthiefService.addFictionalBook(ficBook);
			
			re=new ResponseEntity<Fictional>(f, HttpStatus.OK);
			}catch(Exception exception){
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty("SERVICE.ADD_ERROR"), exception);

			}
			
			
		}else{
			try{
			
			Best b=bookthiefService.addBestBook(ficBook);
            Fictional f1=new Fictional();
            f1.setProductCode(b.getProductCode());
            f1.setProductName(b.getProductName());
            f1.setPrice(b.getPrice());
            f1.setProductId(b.getProductId());
			
			re=new ResponseEntity<Fictional>(f1, HttpStatus.OK);
			}catch(Exception exception){
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty("SERVICE.ADD_ERROR"), exception);

			}
		}
		return re;
	}
	
	@DeleteMapping(value="/deleteBook/{productCode}")
	public ResponseEntity<Fictional> deleteForm(@PathVariable String productCode){
		String booktype=productCode.substring(0,1);
		ResponseEntity<Fictional> re=null;
		if(booktype.equals("F")){
		try{
			bookthiefService.deleteFicBook(productCode);
			Fictional fa=new Fictional();
			fa.setDescription("Deletion Successfull");
			re=new ResponseEntity<Fictional>(fa, HttpStatus.OK);
		}
		catch(Exception exception){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty("SERVICE.DELETE_ERROR"), exception);

		}
		}else {
			try{
				bookthiefService.deleteBestBook(productCode);
				Fictional fa=new Fictional();
				fa.setDescription("Deletion Successfull");
				re=new ResponseEntity<Fictional>(fa, HttpStatus.OK);
			}
			catch(Exception exception){
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty("SERVICE.DELETE_ERROR"), exception);

			}
		}
		return re;
	}
	
	@PostMapping(value="/updateBook/{productCode}")
	public ResponseEntity<Fictional> updateForm(@PathVariable String productCode,@RequestBody Integer price){
		String booktype=productCode.substring(0,1);
		ResponseEntity<Fictional> re=null;
		if(booktype.equals("F")){
		try{
			Fictional f=bookthiefService.updateBookPrice(productCode, price);
			re=new ResponseEntity<Fictional>(f, HttpStatus.OK);
		}
		catch(Exception exception){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty("SERVICE.CODE_MISMATCH"), exception);

		}
		}else {
			try{
				Best b=bookthiefService.updateBookBestprice(productCode, price);
				Fictional f1=new Fictional();
	            f1.setProductCode(b.getProductCode());
	            f1.setProductName(b.getProductName());
	            f1.setPrice(b.getPrice());
	            f1.setProductId(b.getProductId());
				re=new ResponseEntity<Fictional>(f1, HttpStatus.OK);
			}
			catch(Exception exception){
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty("SERVICE.CODE_MISMATCH"), exception);

			}
		}
		return re;
	}
	

	@GetMapping(value = "/getLC")
	public ResponseEntity<List<Login>> getAllAadhars()  {

		try {
		List<Login> lc = bookthiefService.login();

		return new ResponseEntity<>(lc, HttpStatus.OK);
		} catch (Exception exception) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	
	@GetMapping(value = "/getFiction")
	public ResponseEntity<List<Fictional>> getFictionalBooks()  {

		try {
		List<Fictional> fb= bookthiefService.getFictionBooks();

		return new ResponseEntity<>(fb, HttpStatus.OK);
		} catch (Exception exception) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	@GetMapping(value = "/getBest")
	public ResponseEntity<List<Best>> getBestBooks()  {

		try {
		List<Best> bb = bookthiefService.getBestBooks();

		return new ResponseEntity<>(bb, HttpStatus.OK);
		} catch (Exception exception) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	
	
}

