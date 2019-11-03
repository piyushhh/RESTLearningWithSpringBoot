package com.RestWebservciesInSpringBoot.restfulwebServices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
private static List<User> users = new ArrayList<>();
 int count = 401;
static {
	users.add(new User(101, "lee", new Date()));
	users.add(new User(201, "jack", new Date()));
	users.add(new User(301, "law", new Date()));
	users.add(new User(401, "jin", new Date()));
}
//find all user
// save
//find by id
public List<User> getAllUser(){
	return users;
}
public User saveUser(User user){
	if(user.getId() == null){
		user.setId(++count);
	}
	users.add(user);
	return user;
}
public User getAllUserById(int id){
	for(User user:users){
		if(user.getId()==id){
			return user; 
		}
	}
	return null;
}

public User deleteById(int id){
	Iterator<User> it = users.iterator();
	while(it.hasNext()){
		 User user = it.next();
		if(user.getId() == id){
			return user;
		}
	}
	return null;
   }
}
