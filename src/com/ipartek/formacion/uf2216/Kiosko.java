package com.ipartek.formacion.uf2216;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kiosko implements Leible {

	static final int LIST_OPTION = 1;
	static final int CREATE_OPTION = 2;
	static final int FILE_OPTION = 3;
	static final int EXIT_OPTION = 0;

	static final int MIN_ISBN = 10;
	static final int MIN_CHAR = 3;
	static final int MAX_CHAR = 150;
	static final int MIN_PAGES = 1;
	static final char ES_DIGITAL = 'd';
	static final char ES_PAPEL = 'p';

	static String title = "";
	static String isbn = "";
	static int nPages = 0;
	static boolean respuesta = true;
	static char format;
	static Revistas rev;
	static int optionSelected;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Revistas> listMagazine = null;
	static String fichero = "C:\\1713\\eclipse-workspace\\examenrevistas\\almacen.txt";

	public static void main(String[] args) throws Exception {

		// Inicializamos la lista de revistas y damos paso al programa
		listMagazine = new ArrayList<Revistas>();

		do {

			rev = new Revistas();
			menu();

			switch (optionSelected) {
			case 1:
				askTitle();
				askIsbn();
				askPages();
				askIsDigital();
				listMagazine.add(rev);
				askSaveFile();

				break;

			case 2:
				magazineList();
				break;

			default:
				break;
			}
		} while (optionSelected != EXIT_OPTION);
		System.out.println("Finish");
	}

	// Metodo que sirve para pintar el menú
	public static void menu() {

		System.out.println("********************");
		System.out.println("Please, choose an option:");
		System.out.println("*********************");
		System.out.println("1.- Create magazine.");
		System.out.println("2.- Magazine list.");
		System.out.println("0.- Exit.");
		System.out.println("**********************");

		// Lanzará una excepción si se introduce una opcion incorrecta
		try {

			optionSelected = Integer.parseInt(sc.nextLine());

		} catch (Exception e) {

			System.out.println("Invalid option. Repeat again");

			menu();

		}
	}

	// En este método pedimos el titulo. Lanzará una excepcion si los datos no son
	// validos
	private static void askTitle() throws Exception {
		respuesta = true;

		do {
			System.out.println("Please, write a title...");

			try {
				title = sc.nextLine();
				rev.setTitle(title);
				respuesta = false;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				respuesta = true;
			}
		} while (respuesta == true);

	}

	// En este método pedimos el codigo isbn. Lanzará una excepcion si los datos no
	// son validos
	private static void askIsbn() throws Exception {
		respuesta = true;

		while (respuesta) {
			System.out.println("Please, write the ISBN...");

			try {
				isbn = sc.nextLine();
				respuesta = false;
				rev.setIsbn(isbn);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				respuesta = true;
				askIsbn();
			}
		}

	}

	// En este método pedimos el numero de paginas. Lanzará una excepcion si los
	// datos no son validos
	private static void askPages() throws Exception {
		respuesta = true;
		System.out.println("Please, write the number of pages...");

		try {
			nPages = Integer.parseInt(sc.nextLine());
			rev.setPages(nPages);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta = true;
			askPages();

		}
	}

	// En este método pedimos el titulo. Lanzará una excepcion si los datos no son
	// validos
	private static void askIsDigital() throws Exception {

		try {
			boolean scformato2;
			System.out.println("Introduce format(p=paper, d=digital)");
			String scformato = sc.nextLine();

			if ("d".equals(scformato)) {
				scformato2 = true;
				rev.setisDigital(scformato2);
			} else if ("p".equals(scformato)) {
				scformato2 = false;
				rev.setisDigital(scformato2);

			}

			System.out.println("el formato es" + scformato);
			respuesta = false;

		} catch (Exception e) {
			System.out.println("******ERROR******el formato *NO* es correcto");
			System.out.println(e.getMessage());
			respuesta = true;
		}

		/*
		 * try {
		 * 
		 * 
		 * 
		 * 
		 * format = sc.nextLine().toLowerCase().charAt(0);
		 * 
		 * switch (format) { case ES_DIGITAL:
		 * System.out.println("el formato antes de ponerlo a true es:" +
		 * rev.isDigital()); boolean scformato2=true; rev.setisDigital(scformato2);
		 * System.out.println("el formato es:" + rev.isDigital()); break;
		 * 
		 * case ES_PAPEL: rev.setisDigital(false); break;
		 * 
		 * default: askIsDigital(); break; }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); askIsDigital(); }
		 * 
		 */}

	// En este metodo pedimos si se quiere guardar la revista creada en un archivo
	// de texto
	private static void askSaveFile() {

		System.out.println(" TITLE: " + rev.getTitle() + "\n ISBN: " + rev.getIsbn() + " \n PAGES: " + rev.getPages()
				+ " \n FORMAT: " + rev.isDigital());
		System.out.println("Do you want to save the magazine in a file? Y/N");
		String res = sc.nextLine();
		if ("y".equalsIgnoreCase(res)) {
			try {
				FileWriter fileWriter = new FileWriter(fichero, true);
				PrintWriter pw = new PrintWriter(fileWriter);

				pw.println(rev);
				System.out.println("Magazine saved!");
				fileWriter.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("n".equalsIgnoreCase(res)) {
			System.out.println("Magazine not saved. Starting menu...");
			menu();
		}
	}

	// En este método mostramos la lista ordenada en funcion del numero de paginas
	// mediante Collections.sort
	public static void magazineList() {

		Collections.sort(listMagazine);

		for (int i = 0; i < listMagazine.size(); i++) {
			System.out.println(listMagazine.get(i).toString());
		}

	}

}
