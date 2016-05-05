package Model;

public class Autor {

	private String autorCNP;
	private String nume;
	private String prenume;

	public Autor() {
		this.autorCNP = null;
		this.nume = null;
		this.prenume = null;
	}

	public String getAutorCNP() {
		return autorCNP;
	}

	public void setAutorCNP(String autorCNP) {
		this.autorCNP = autorCNP;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
}
