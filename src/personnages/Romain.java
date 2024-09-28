package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] stuff = new Equipement[2];
	private int nbEquipement;
	
	public Romain(String nom, int force) {
		assert force>=0;
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + " « " + texte + " » ");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert force>=0;
		int forcedep = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forcedep>force;
	}
	
	
	public void sEquiper(Equipement equipement){
		switch(nbEquipement) {
			case (2) :
				System.out.println("Le soldat "+ nom + " est deja bien equipe");
				break;
			case (1):
				if (stuff[0] == equipement) {
				System.out.println("Le soldat "+ nom +" possede deja un "+ equipement+ " !");
				break;
				}
			case (0):
				stuff[1] = equipement;
				nbEquipement += 1;
				System.out.println("Le soldat "+ nom +" s'equipe avec un "+ equipement + ".");
				break;
				
		}
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus" , 6);
		System.out.println(minus.getNom());
		System.out.println(minus.prendreParole());
		minus.parler("Bonjour");
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
