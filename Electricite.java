public class Electricite extends Pokemon{

	public Electricite(String nom, int pvmax, int attaque){

		super(nom, pvmax, attaque);

		if (nbAttaques < 5) {

			attaquesDisponibles[nbAttaques++] = "Elecanon";

		}
	}

	@Override	
	public void talent(){}

	@Override
	public boolean fortContre(Pokemon a){

		return (a instanceof Eau);

	}

	@Override
	public boolean faibleContre(Pokemon a){

		return (a instanceof Electricite || a instanceof Terre);

	}

	@Override
	public void attaque (Pokemon adversaire, String choixAttaque){
		// on appelle la methode qui verifie si l'attaque choisie est "defaut" et attaque si c'est le cas, sinon ne fait rien
		super.attaque(adversaire, choixAttaque);

		// Elecanon ne fait que 60% de degats mais avec 60% de changes de paralyser l'adversaire
		if (choixAttaque == "Elecanon"){

			multiplicateur *= 0.6;

			super.attaque(adversaire);

			// on a 60% de chances de paralyser l'adversaire (s'il est deja paralyse, il le reste pour un tour de plus)
			if(Math.random() < 0.6){

				adversaire.paralyse += 1;

			}
		}
	}
}
