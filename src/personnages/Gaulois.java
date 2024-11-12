package personnages;

import java.util.Random;

public class Gaulois {
	private String nom;
	private int force;
	private int nbtrophees; 
	private int effetPotion = 1;
	private Equipement[] trophees= new Equipement[100];

	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}


	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + " « " + texte + " » ");
	}


//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de "
//		+ romain.getNom());
//		romain.recevoirCoup(force*effetPotion / 3);
//		}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion
				+ " fois multipliee par l'effet de la potion.");
	}
	
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) { 
			System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
			Equipement[] romainTrophees = romain.recevoirCoup((force / 3) * effetPotion);
			for (int i = 0; romainTrophees != null && i < romainTrophees.length; i++, nbtrophees++) { 
				this.trophees[nbtrophees] = romainTrophees[i];
			} 
		}
	
	
	public void faireUneDonnation(Musee musee) {
		if (nbtrophees>0) {
			nbtrophees = 0;
			parler("Je donne au musee tous mes trophees :\n");
			for (int i=0; i<nbtrophees; i++) {
				musee.donnerTrophees(this, trophees[i]);
				System.out.println("- " + trophees[i] +"\n");
			}
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix" , 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour");
		asterix.boirePotion(6);
	}
	
	

}
