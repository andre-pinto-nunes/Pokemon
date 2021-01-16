public class Terre extends Pokemon{

	public Terre(String nom, int pvmax, int attaque){

		super(nom, pvmax, attaque);

		if (nbAttaques < 5) {

			attaquesDisponibles[nbAttaques++] = "Ampleur";

		}
	}
	
	@Override
	public void talent(){}

	@Override
	public boolean fortContre(Pokemon a){

		return (a instanceof Feu || a instanceof Electricite);

	}

	@Override
	public boolean faibleContre(Pokemon a){

		return (a instanceof Eau || a instanceof Herbe|| a instanceof Terre);

	}

	@Override
	public void attaque (Pokemon adversaire, String choixAttaque){

		// on appelle la methode qui verifie si l'attaque choisie est "defaut" et attaque si c'est le cas, sinon ne fait rien
		super.attaque(adversaire, choixAttaque);
		
		// si on choisi l'attaque "Ampleur" on augmente le multiplicateur d'une quantite entre 80% et 150% et on attaque (150% non inclus mais cela ne change rien)
		if (choixAttaque == "Ampleur"){

			multiplicateur *= Math.random()*0.7 + 0.8; // 1.5 n'est pas inclus mais sa probabilité est 0

			super.attaque(adversaire);

		}
	}
}
