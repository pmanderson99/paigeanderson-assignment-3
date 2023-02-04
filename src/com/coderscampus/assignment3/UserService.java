package com.coderscampus.assignment3;


public class UserService {
	
	private User[] users;
	
	public UserService() {
		FileService fileService = new FileService();
		users = fileService.readUsersFromFile();
	}
	
		
	public User getUserByUsernameAndPassword(String username, String password) {

		for (User user: users) {
			if (username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {
				return user;
			}
		 }
		return null;
	}

  }

