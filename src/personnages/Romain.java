package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement=0;
	private String texte;
	
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
//	public void recevoirCoup(int forceCoup) {
//		assert force>=0;
//		int forcedep = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forcedep>force;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) { 
		Equipement[] equipementEjecte = null; 
		// pr�condition assert force > 0;
		int oldForce = force; 
		
		forceCoup = CalculResistanceEquipement(forceCoup); 
		
		force -= forceCoup; 
//		 if (force > 0) { 
//			 parler("A�e"); 
//		 } else { 
//			 equipementEjecte = ejecterEquipement(); 
//			 parler("J'abandonne..."); 
//		 } 
		switch (force) { 
		case 0: 
			parler("A�e");
		default: 
			equipementEjecte = ejecterEquipement(); 
			parler("J'abandonne..."); 
			break; 
		} 
		// post condition la force a diminu�e 
		assert force < oldForce; 
		return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) { 
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;	
		if (!(nbEquipement == 0)) { 
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;) { 
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) { 
					resistanceEquipement += 8; 
				} else { 
					System.out.println("Equipement casque"); 
					resistanceEquipement += 5; 
				} 
				i++; 
			} 
			texte =+ resistanceEquipement + "!"; 
		} 
		parler(texte); 
		forceCoup -= resistanceEquipement; 
		return forceCoup; 
	}
	
				private Equipement[] ejecterEquipement() { 
					Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
					System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup."); 
					//TODO 
					int nbEquipementEjecte = 0; 
					for (int i = 0; i < nbEquipement; i++) {
						if (equipements[i] == null) { 
							continue;
						} else { 
							equipementEjecte[nbEquipementEjecte]             =
equipements[i];
							nbEquipementEjecte++; 
							equipements[i] = null;
				}
		}
		return equipementEjecte;
		
	}
	
	private void ajouterEquipement(Equipement equipement) {
		if (nbEquipement<=2) {
			equipements[nbEquipement]=equipement;
			nbEquipement+=1;
		}
	}
	
	public void sEquiper(Equipement equipement){
		switch(nbEquipement) {
			case (2) :
				System.out.println("Le soldat "+ nom + " est deja bien protege !");
				break;
			case (1):
				if (equipements[0].equals(equipement)) {
				System.out.println("Le soldat "+ nom +" possede deja un "+ equipement+ " !");
				break;
				}
			case (0):
				ajouterEquipement(equipement);
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
