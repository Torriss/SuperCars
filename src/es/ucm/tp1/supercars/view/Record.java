package es.ucm.tp1.supercars.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;

public class Record {
	private static long hard;
	private static long easy;
	private static long advanced;
	private static long test;
	
	public static long getHard() {
		return hard;
	}
	
	public static long getEasy() {
		return easy;
	}
	
	public static long getAdvanced() {
		return advanced;
	}
	
	public static long getTest() {
		return test;
	}
	
	public static void setHard(long record) {
		hard = record;
	}
	
	public static void setEasy(long record) {
		easy = record;
	}
	
	public static void setAdvanced(long record) {
		advanced = record;
	}
	
	public static void setTest(long record) {
		test = record;
	}
	
	public static void guardar() throws InputOutputRecordException {
		FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("record.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			//escribe los datos en el archivo
			bfwriter.write("HARD:" + " " + hard + "\n" + "EASY:" + " "  + easy + "\n" + "ADVANCED:" + " " + advanced + "\n" + "TEST:" + " " + test + "\n");
			//cierra el buffer intermedio
			bfwriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new InputOutputRecordException("Record", "Fallo al guardar en archivo");
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
					throw new InputOutputRecordException("Record", "Fallo al guardar en archivo");
				}
			}
		}
	}
	
	public static void cargar() throws InputOutputRecordException {
		// crea el flujo para leer desde el archivo
				File file = new File("record.txt");	
				Scanner scanner;
				List<Long> lista = new ArrayList<Long>();
				try {
					//se pasa el flujo al objeto scanner
					scanner = new Scanner(file);
					//BufferedReader br = new BufferedReader(new FileReader(file));
					String linea = scanner.nextLine();
					Record.setHard((Long.parseLong(linea)));
					
					String linea1 = scanner.nextLine();
					Record.setTest((Long.parseLong(linea1)));
					
					String linea2 = scanner.nextLine();
					Record.setEasy((Long.parseLong(linea2)));
					
					String linea3 = scanner.nextLine();
					Record.setAdvanced((Long.parseLong(linea3)));
					//se cierra el ojeto scanner
					scanner.close();
				} catch (FileNotFoundException e) {
					throw new InputOutputRecordException("le", "le");
				}
				
	}
	
	public static String pintar(Level l) {
		StringBuilder buffer = new StringBuilder();
		if (Level.ADVANCED == l) {buffer.append("ADVANCED : " + Record.getAdvanced());}
		if (Level.TEST == l) {buffer.append("TEST : " + Record.getTest());}
		if (Level.EASY == l) {buffer.append("EASY : " + Record.getEasy());}
		if (Level.HARD == l) {buffer.append("HARD : " + Record.getHard());}
		return buffer.toString();
	}
}