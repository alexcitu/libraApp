package Model;

public class Client {

	private String clientCNP;
	private String nume;
	private String prenume;
	private String adresa;

	public Client() {
		this.clientCNP = null;
		this.nume = null;
		this.prenume = null;
		this.adresa = null;
	}

	public String getClientCNP() {
		return clientCNP;
	}

	public void setClientCNP(String clientCNP) {
		this.clientCNP = clientCNP;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
}
