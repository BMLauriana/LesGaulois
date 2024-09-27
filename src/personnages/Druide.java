package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion = 1;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom
				+ " et ma potion peut aller d'une force de " + effetPotionMin + " a "
				+ effetPotionMax + ".");
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + " « " + texte + " » ");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	private void preparerPotion() {
		Random objet = new Random();
		int forcePotion = objet.nextInt(effetPotionMax-effetPotionMin) + effetPotionMin;
		if (forcePotion > 7){
			parler("J'ai prepare une super potion de force " + forcePotion);
		}else {
			parler("Je n'ai pas trouve tous les ingredients,"
					+ " ma potion est seulement de la force de " + forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5 , 10 );
		panoramix.preparerPotion();
	}
}
