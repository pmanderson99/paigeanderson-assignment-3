package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	public final String FILENAME = "data.txt";

	public User[] readUsersFromFile() {
		User[] users = new User[4];
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILENAME));
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {

				users[i] = new User(line.split(","));
				i++;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
}
