package com.RestWebservciesInSpringBoot.restfulwebServices.exception;

import java.util.Date;

public class ExceptionResponse {
   private Date time;
   private String  messsage ;
   private String details;
   
    
public Date getTime() {
	return time;
}
public String getMesssage() {
	return messsage;
}
public String getDetails() {
	return details;
}
public ExceptionResponse(Date time, String messsage, String details) {
	super();
	this.time = time;
	this.messsage = messsage;
	this.details = details;
}

   
   
}
