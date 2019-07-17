package com.ipartek.formacion.uf2216;

public class Revistas implements Leible, Comparable<Revistas> {

	// Variables de la revista
	static final int MAX_ISBN = 10;
	static final int MIN_CHAR = 3;
	static final int MAX_CHAR = 150;
	static final int MIN_PAGES = 1;
	private static final char FORMATO_DIGITAL = 'd';
	private static final char FORMATO_PAPEL = 'p';

	private String title = "";
	private String isbn = "";
	private int pages = 0;
	private boolean format;

	public Revistas() {
		super();

	}

	// constructor
	public Revistas(String title, String isbn, int pages, boolean format) throws Exception {

	}

	// Getters y setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws Exception {
		if (title.length() >= MIN_CHAR && title.length() <= MAX_CHAR) {
			this.title = title;
		} else {
			throw new Exception("Title between " + MIN_CHAR + " - " + MAX_CHAR + " characters.");
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws Exception {
		if (isbn.length() == MAX_ISBN) {
			this.isbn = isbn;
		} else {
			throw new Exception("The isbn data must have 10 digits");

		}
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) throws Exception {
		if (pages >= MIN_PAGES) {
			this.pages = pages;
		} else {
			throw new Exception("Please, minimum " + MIN_PAGES + "pages.");
		}

	}

	public boolean isDigital() {
		return format;
	}

	public void setisDigital(boolean format) throws Exception {
		this.format = format;

	}

	// método toString para mostrar los datos.
	@Override
	public String toString() {
		return "Revistas [title=" + title + ", isbn=" + isbn + ", pages=" + pages + ", format=" + format + "]";
	}

	@Override
	public int compareTo(Revistas o) {
		return this.pages - o.getPages();
	}

}
