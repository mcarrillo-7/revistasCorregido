package com.ipartek.formacion.uf2216;

public class Revistas implements Leible, Comparable<Revistas> {

	// Variables de la revista
	static final int MIN_ISBN = 10;
	static final int MIN_CHAR = 3;
	static final int MAX_CHAR = 150;
	static final int MIN_PAGES = 1;

	private String title = "";
	private String isbn = "";
	private int pages = 0;
	private boolean isDigital;

	// constructor

	public Revistas() {
		super();

	}

	public Revistas(String title, String isbn, int pages, boolean format) throws Exception {
		super();
		setTitle(title);
		setIsbn(isbn);
		setisFormat(isDigital);
		setPages(pages);
	}

	// Getters y setters
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title para comprobar que el título tenga entre 3 y 150 caracteres
	 * @throws Exception cuando se escriba un titulo inferior a 3 o superior a 150
	 */
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

	/**
	 * 
	 * @param isbn para comprobar que el isbn tenga maximo 11 caracteres
	 * @throws Exception cuando se escriba un isbn superior o inferior a 11
	 *                   caracteres
	 */
	public void setIsbn(String isbn) throws Exception {
		if (isbn.length() == MIN_ISBN) {
			this.isbn = isbn;
		} else {
			throw new Exception("The isbn data must have 10 digits");

		}
	}

	public int getPages() {
		return pages;
	}

	/**
	 * 
	 * @param pages para comprobar que se esciban minimo una pagina
	 * @throws Exception cuando se escriba el usuario escriba menos de 1 página
	 */
	public void setPages(int pages) throws Exception {
		if (pages >= MIN_PAGES) {
			this.pages = pages;
		} else {
			throw new Exception("Please, minimum " + MIN_PAGES + " pages.");
		}

	}

	public boolean isDigital() {
		return isDigital;
	}

	// Metodo para saber si el formato de la revista es digital (true) o papel
	// (false)
	public void setisFormat(boolean isDigital) throws Exception {
		this.isDigital = isDigital;

	}

	// método toString para mostrar los datos.
	@Override
	public String toString() {
		return "Revistas [title=" + title + ", isbn=" + isbn + ", pages=" + pages + ", format=" + isDigital + "**]";
	}

	// Método compareTo para ordenar la lista de revistas según el número de paginas
	@Override
	public int compareTo(Revistas o) {

		return this.pages - o.getPages();

	}

}
