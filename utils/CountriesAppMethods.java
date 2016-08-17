package com.Wednesday.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CountriesAppMethods {

	public static void overWriteFile(String causeToPrint, File aNewFile, ArrayList<String> fromOurTextFile) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(aNewFile)))) {

			for (int i = 0; i < fromOurTextFile.size(); i++) {
				causeToPrint = fromOurTextFile.get(i);
				out.println(causeToPrint);
			}

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // overWriteFile

	public static void appendToTextFile(String causeToPrint, File aNewFile) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(aNewFile, true)))) {
			out.println(causeToPrint);

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // appendToTextFile

	public static ArrayList<String> ourReader(ArrayList<String> fromOurTextFile, File aNewFile) {
		try (BufferedReader in = new BufferedReader(new FileReader(aNewFile))) {
			String readingStuff;

			while ((readingStuff = in.readLine()) != null) {
				fromOurTextFile.add(readingStuff);
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fromOurTextFile;
	} // ourReader
	
}