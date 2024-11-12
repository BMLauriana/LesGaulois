package personnages;

public class Trophee {
	private Gaulois gaulois;
	private Equipement equiment;
	public Trophee(Gaulois gaulois, Equipement equiment) {
		this.gaulois = gaulois;
		this.equiment = equiment;
	}
	public Gaulois getGaulois() {
		return gaulois;
	}
	public Equipement getEquiment() {
		return equiment;
	}
	
	public String donnerNom() {
		Gaulois proprietaire = getGaulois();
		return proprietaire.getNom();
	}
	
}
