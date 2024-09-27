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
				+ " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + " « " + texte + " »");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	private void preparerPotion() {
		Random potion = new Random();
		potion.nextInt(effetPotionMax);
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5 , 10 );
	}
}
