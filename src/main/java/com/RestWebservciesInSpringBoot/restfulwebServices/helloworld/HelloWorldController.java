package com.RestWebservciesInSpringBoot.restfulwebServices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource  messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path ="	")
	public String helloworld(){
		return "Hello -Word";
	}
	@GetMapping(path ="/hello-world-piyush")
	public String helloworldP(){
		return "Hello -Word-piyush";
	}
	@GetMapping(path="/hello-world-bean-piyush")
	public HelloWorldDBean helloworldbean(){
		return new HelloWorldDBean("hello-world-bean-piyush");
	}
	
    @GetMapping(path ="/HelloWorldDBean/path-vari/{name}")
	public HelloWorldDBean pathVariableFuc(@PathVariable String name){
		return new HelloWorldDBean(String.format("Hello world, %s" , name));
	}
    @GetMapping(path ="/hello-world-internationization")
   	public String helloWorldI18N(@RequestHeader(name="Accept-Language", required=false) Locale locale){
   		return messageSource.getMessage("good.morning.message", null , locale);
   	}
}
