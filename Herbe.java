public class Herbe extends Pokemon{
	
	public Herbe (String nom, int pvmax, int attaque){
		super(nom, pvmax, attaque);
		if (nbAttaques < 5) {
			attaquesDisponibles[nbAttaques++] = "vege-attaque";
		}
	}

	@Override
	public void talent(){}

	@Override
	public boolean fortContre(Pokemon a){
	
		return (a instanceof Terre); //Question 6
	
	}

	@Override
	public boolean faibleContre(Pokemon a){
	
		return (a instanceof Feu || a instanceof Herbe);
	
	}

	@Override
	public void attaque (Pokemon adversaire, String choixAttaque){
	
		// on appelle la methode qui verifie si l'attaque choisie est "defaut" et attaque si c'est le cas, sinon ne fait rien
		super.attaque(adversaire, choixAttaque);

		// si on choisi l'attaque "vege-attaque" on augmente le multiplicateur de 250% et on n'attaque pas (donc le multiplicateur n'est pas remis a 1)
		// on peut choisir "vege-attaque" plusieurs fois de suite et le multiplicateur augmente a chaque fois, il n'est remis a 1 que lors d'une attaque
		// l'augmentation de 250% s'applique a l'attaque totale, pas a l'attaque de base seulement
		if (choixAttaque == "vege-attaque"){
	
			multiplicateur *= 2.5;
	
			System.out.println ("\t\t" + this.nom + " a augmente son attaque de 250 % : attaque = " + String.format("%.2f", (attaque*multiplicateur)) + " x att !");
	
		}
	}	
}
