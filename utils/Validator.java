package com.Wednesday.utils;

import java.util.ArrayList;

public class Validator {

	public static boolean userInputForMenu(String menuInput, boolean correctInput) {
		switch (menuInput) {
		case "1":
		case "2":
		case "3":
		case "4":
			correctInput = false;
			break;
		default:
			System.out.println("I'm sorry that is not a valid option\n");
		}
		return correctInput;
	}  //userInputFOrMenu
	
	public static boolean testingDeleteInput(boolean correctInput, String countryToDelete,
			ArrayList<String> fromOurTextFile) {
		int indexToDelete;
		indexToDelete = Integer.parseInt(countryToDelete);

		if (indexToDelete >= 0 || indexToDelete < fromOurTextFile.size()) {
			fromOurTextFile.remove(indexToDelete);
			correctInput = false;
		}
		return correctInput;
	} //testingDeleteInput
	
} //class