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
				+ " et ma potion peut aller d'une force de " + 
				effetPotionMin + " a " + effetPotionMax + ".");
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + " « " + texte + " » ");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public int preparerPotion(){
		Random objet = new Random();
		int puissPotion = objet.nextInt(effetPotionMax-effetPotionMin) + effetPotionMin;
		forcePotion = puissPotion;
		if (puissPotion > 7){
			parler("J'ai prepare une super potion de force " + puissPotion);
		}else {
			parler("Je n'ai pas trouve tous les ingredients,"
					+ " ma potion est seulement de la force de " + puissPotion);
		}
		return forcePotion;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obelix") {
			parler("Non, Obelix ! ... Tu n'aura pas de potion magique ! ");
		}else{
			gaulois.boirePotion(forcePotion);
		}
	}


	public static void main(String[] args) {
		Gaulois obelix = new Gaulois("Obelix" , 25);
		Gaulois asterix = new Gaulois("Asterix" , 8);
		Druide panoramix = new Druide("Panoramix", 5 , 10 );
		panoramix.booster(obelix);
		panoramix.booster(asterix);
	}
}
