package com.paceclasses.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

class World{

	private String lastupdate;
	private String madeBy;
	public World(String lastupdate, String madeBy) {
		
		this.lastupdate = lastupdate;
		this.madeBy = madeBy;
	}
	public String getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}
	public String getMadeBy() {
		return madeBy;
	}
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}
	
}
@RestController
public class Hello {
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public World get()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		World w = new World(dtf.format(now),"Subhankar Dutta");
		return w;
		
	}
}
