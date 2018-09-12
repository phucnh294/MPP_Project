package Controller;

import java.util.*;

import User.User;

public class UserController {
	User user;
	ArrayList<User> users;
	
	public void createUser() {
		
	}
	public boolean updateUser(int id) {
		return true;
	}
	
	public User getUser(int id) {
		return user;
	}
	
	public ArrayList<User> getAllUser(){
		return users;
	}
}
