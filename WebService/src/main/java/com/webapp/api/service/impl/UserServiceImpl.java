package com.webapp.api.service.impl;

import com.webapp.api.Utils.IdGenerator;
import com.webapp.api.model.request.UpdateUserDetailsRequestModel;
import com.webapp.api.model.request.UserDetailsRequestModel;
import com.webapp.api.model.response.UserRest;
import com.webapp.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
	
	Map <String, UserRest> users;
	
	IdGenerator utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(IdGenerator utils) {
		this.utils=utils;
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		// TODO Auto-generated method stub
		UserRest returnValue = new UserRest();
	    returnValue.setFirstName(userDetails.getFirstName());
	    returnValue.setLastName(userDetails.getLastName());
	    returnValue.setEmail(userDetails.getEmail());
	    String userId = utils.generateUserId();
	    returnValue.setUserId(userId);
	    
		if(users ==  null) {
	    	users = new HashMap<>();
	    }
	    users.put(userId, returnValue);
	    return returnValue;
	}
	
	@Override
	public ResponseEntity<UserRest> getUser(String userId){
		if(users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails) {
		// TODO Auto-generated method stub
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		users.put(userId, storedUserDetails);
		return storedUserDetails;
	}
}
