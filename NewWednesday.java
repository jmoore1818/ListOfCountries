package com.Wednesday;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.Wednesday.utils.CountriesAppMethods;
import com.Wednesday.utils.Validator;

public class NewWednesday {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int indexToDelete = 0;
		boolean contApp = true;
		boolean correctInput = true;
		String menuInput = null;
		String causeToPrint = null;
		String countryToDelete = null;

		ArrayList<String> fromOurTextFile = new ArrayList<>();

		Path ourNewestPath = Paths.get("\\Users\\erine\\SSAResart\\WeekThree\\src\\com\\wednesday\\mycountries.txt");
		File aNewFile = ourNewestPath.toFile();

		do {
			do {
				helloAndWelcome();
				menuInput = sc.nextLine();

				correctInput = Validator.userInputForMenu(menuInput, correctInput);
				// wrote in main, extracted to main class, moved to valid class

			} while (correctInput);

			switch (menuInput) {
			case "1": // Read from the file
				fromOurTextFile = CountriesAppMethods.ourReader(fromOurTextFile, aNewFile);

				for (int i = 0; i < fromOurTextFile.size(); i++) {
					System.out.println(fromOurTextFile.get(i));
				}
				System.out.println();
				fromOurTextFile.clear();
				break;

			case "2": // Add to the file
				System.out.println("Which country would you like to add?");
				causeToPrint = sc.nextLine();
				CountriesAppMethods.appendToTextFile(causeToPrint, aNewFile);
				break;

			case "3": // Delete from the file
				System.out.println("Which county would you like to remove?");

				fromOurTextFile = CountriesAppMethods.ourReader(fromOurTextFile, aNewFile);

				do {
					correctInput = true;
					for (int i = 0; i < fromOurTextFile.size(); i++) {
						System.out.println(i + ". " + fromOurTextFile.get(i));
					}
					countryToDelete = sc.nextLine();

					correctInput = Validator.testingDeleteInput(correctInput, countryToDelete, fromOurTextFile);

				} while (correctInput);
				
				CountriesAppMethods.overWriteFile(causeToPrint, aNewFile, fromOurTextFile);

				System.out.println();
				fromOurTextFile.clear();
			}

		} while (contApp);

	} // main

	public static void helloAndWelcome() {
		System.out.println("Hello and welcome to the Countries List App\n");
		System.out.println("Would you like to view my list of countries? Press 1");
		System.out.println("Would you like to add to the list? Press 2");
		System.out.println("Or remove from the list? Press 3");
		System.out.println("Finally you may leave the app. Press 4");
	} // helloAndWelcome

	

} // class