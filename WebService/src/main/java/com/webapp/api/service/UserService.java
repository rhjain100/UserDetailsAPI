package com.webapp.api.service;

import com.webapp.api.model.request.UpdateUserDetailsRequestModel;
import com.webapp.api.model.request.UserDetailsRequestModel;
import com.webapp.api.model.response.UserRest;
import org.springframework.http.ResponseEntity;

public interface UserService {
	public UserRest createUser(UserDetailsRequestModel userDetails);
	public ResponseEntity<UserRest> getUser(String userId);
	public ResponseEntity<Object> deleteUser(String id);
	public UserRest updateUser(String userId, UpdateUserDetailsRequestModel updateUserDetailsRequestModel);
}
