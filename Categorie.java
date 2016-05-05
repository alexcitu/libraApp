package Model;

public class Categorie {

	private String numeCat;
	private String descriere;

	public Categorie() {
		this.numeCat = null;
		this.descriere = null;
	}

	public String getNumeCat() {
		return numeCat;
	}

	public void setNumeCat(String numeCat) {
		this.numeCat = numeCat;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
}
