package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		Boolean validLogin = false;

		UserService userService = new UserService();

		for (int i = 0; i < 4; i++) {

		}
		try (Scanner scanner = new Scanner(System.in)) {
			int i = 0;
			User loggedInUser = null;
			while (i < 5) {
				System.out.println("Enter your username: ");
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				loggedInUser = userService.getUserByUsernameAndPassword(username, password);
				if (loggedInUser != null) {
					System.out.println("Welcome, " + loggedInUser.getName());
					break;
				} else {
					System.out.println("Invalid Login Attempt. Try Again.");

					if (validLogin == false && i == 4) {
						System.out.println("Too many failed login attempts. You are now locked out.");
					}
				}
				i++;
			}

			scanner.close();

		}
	}
}
