package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois obelix = new Gaulois("Obelix" , 25);
		Gaulois asterix = new Gaulois("Asterix" , 8);
		Druide panoramix = new Druide("Panoramix", 5 , 10 );
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Belenos, ce n'est pas juste ! ");
		panoramix.booster(asterix);
		
		asterix.parler("Bonjour a tous");
		
		Romain minus = new Romain("Minus" , 6);
		minus.parler("UN GAU... UN GAUGAU...");
		
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}
