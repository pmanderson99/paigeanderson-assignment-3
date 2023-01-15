package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		User test = null;
		
		String[] users = new String[4];
		String[] usernames = new String[4];
		String[] passwords = new String[4];
		String[] names = new String[4];
		Boolean validLogin = false;

		UserService userService = new UserService();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {

				users[i] = line;
				i++;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 4; i++) {

			test = userService.createUser(users[i].split(","));
			usernames[i] = test.getUsername();
			passwords[i] = test.getPassword();
			names[i] = test.getName();
		}
		try (Scanner scanner = new Scanner(System.in)) {
			int i = 0;
			while (i < 5) {
				System.out.println("Enter your username: ");
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				for (int i1 = 0; i1 < 4; i1++) {
					if (usernames[i1].toLowerCase().matches(username.toLowerCase()) && passwords[i1].matches(password)) {
						System.out.println("Welcome " + names[i1]);
						validLogin = true;
						break;
					}

				}
				if (validLogin == false) {
					System.out.println("Invalid Login Attempt. Try Again.");
				}
				if (validLogin == false && i == 4) {
					System.out.println("Too many failed login attempts. You are now locked out.");
				}

				i++;
			}

			scanner.close();

		}
	}
}
