package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}
		
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+ chef.getNom() +" vivent les legendaires gaulois :\n");
		for(int i = 0; i < nbVillageois ; i+=1) {
			System.out.println("-" + trouverHabitant(i) + "\n");
		}
	}
	
	public static void main(String[] args) {
		Village village1 = new Village("Village des Irreductibles", 30);
		
//		Gaulois gaulois = village.trouverHabitant(30);
//		On obtion null car il n'y a pas encore d'habitant dans le tableau a l'indice 29
		
		Chef abraracourcix = new Chef("Abraracourcix", 6, village1);
		village1.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",8);
		village1.ajouterHabitant(asterix);
		Gaulois gaulois = village1.trouverHabitant(1);

//		System.out.println(gaulois);
//		On obtient les references d'Asterix car ses références ont 
//		ete sauvegarder dans gaulois avec la methode trouverHabitant + toString dans la classe Gaulois;
		
		Gaulois obelix = new Gaulois("Obelix",25);
		village1.ajouterHabitant(obelix);
		System.out.println(village1.nbVillageois);
		village1.afficherVillageois();
	}
}
