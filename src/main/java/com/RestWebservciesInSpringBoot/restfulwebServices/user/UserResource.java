package com.RestWebservciesInSpringBoot.restfulwebServices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// autowired - what ever bean we have created that will be auto wired to every controller
//@valid  - used for valdation -its part of java validation api jar
//HATEOS -hypermedia as the engine of service - used to provide hyper link with our resource /services 
//Internationalization(I18N) - customizing your application for diff people around the world
// I18N  - for this we need to LocaleResolver - defaultLocale- Locale.US and also we need to 
// customize  resource bundl. ResourceBundleMessageSoure - there will be list for properties which will be I18N 
// and we would store them in resourcebundle, 
// ResourceBundleMessageSoure - is spring mvc concept for handleling properties 
// after updting above we need to use message source and we need to use header "Accept-language"
// All the binding from object to JSON  and json to object are happing here through jackson
//Swagger - used for documentation purpose
@RestController
public class UserResource extends ResponseEntityExceptionHandler{
//private static final String ResponseEntity = null;
// getAllUsers
	@Autowired
	UserDAOService userDAOService; 
	
	@GetMapping(path="/getUsers1")
	public List<User> getAllUsers(){
		
		return userDAOService.getAllUser();
	}
	
// getUserById
	@GetMapping(path="/getUserById/id/{id}")
	public Resource<User> getAllUsersById(@PathVariable int id){
		
		User user = userDAOService.getAllUserById(id);
		if(user ==  null){
			throw new userNotFoundException("id :" + id);
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-user"));
		return resource;
// Resource is present in HATEOAS(Hypermedia As The Engine Of Application Sate), we can add links to this resource 
// controllerLinkbuilder enables us to create links from method, linkTo method 
//of controllerLinkBuilder class is used create link... We will add linkTo instance to resource, 
//withRel method we give name what is that extra resource we are providing to method
		
	}
	
	@PostMapping(path="/saveUser")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
		User savedUser = userDAOService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
		               buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	   @DeleteMapping(path="/users/id/{id}")	
	   public void deleteById(@PathVariable int id) {
			
			User user = userDAOService.deleteById(id);
			if(user ==  null){
				throw new userNotFoundException("id :" + id);
			}
		}
}
