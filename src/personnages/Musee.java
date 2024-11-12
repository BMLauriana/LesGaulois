package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200] ;
	private int nbTrophee ;
	
	public void donnerTrophees(Gaulois donateur, Equipement equipement) {
		if (nbTrophee <= trophees.length) {
		Trophee don = new Trophee(donateur, equipement);
		trophees[nbTrophee] = don;
		nbTrophee += 1 ;	
		}
	}
	
}
