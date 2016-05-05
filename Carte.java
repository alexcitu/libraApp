package Model;

public class Carte {
	private int ISBN;
	private String titlu;
	private double pret;
	private String editura;
	private String autorCNP;
	private String clientCNP;
	private String numeCat;
	private String rezervataDe;

	public Carte() {
		this.ISBN = 0;
		this.titlu = null;
		this.pret = 0.0;
		this.editura = null;
		this.autorCNP = null;
		this.clientCNP = null;
		this.numeCat = null;
		this.rezervataDe = null;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	public String getAutorCNP() {
		return autorCNP;
	}

	public void setAutorCNP(String autorCNP) {
		this.autorCNP = autorCNP;
	}

	public String getClientCNP() {
		return clientCNP;
	}

	public void setClientCNP(String clientCNP) {
		this.clientCNP = clientCNP;
	}

	public String getNumeCat() {
		return numeCat;
	}

	public void setNumeCat(String numeCat) {
		this.numeCat = numeCat;
	}

	public String getRezervataDe() {
		return rezervataDe;
	}

	public void setRezervataDe(String rezervataDe) {
		this.rezervataDe = rezervataDe;
	}

}
