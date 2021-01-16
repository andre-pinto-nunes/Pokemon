public class Feu extends Pokemon{
	protected double mult_feu = 1; 			// multiplicateur qui ne s'applique qu'aux abilitées feu, utile au talent de Salameche

	public Feu(String nom, int pvmax, int attaque){

		super(nom, pvmax, attaque);

		if (nbAttaques < 4) {

			attaquesDisponibles[nbAttaques++] = "boutefeu";

			attaquesDisponibles[nbAttaques++] = "surchauffe";

		} else if (nbAttaques < 5) {

			attaquesDisponibles[nbAttaques++] = "boutefeu";

		}
	}

	@Override
	public void talent(){}

	@Override
	public boolean fortContre(Pokemon a){

		return (a instanceof Herbe);
	}

	@Override
	public boolean faibleContre(Pokemon a){
		//return (a instanceof Eau || a instanceof Terre); //question 4
		return (a instanceof Eau || a instanceof Terre || a instanceof Feu); //Question 6

	}
	
	@Override
	public void attaque (Pokemon adversaire, String choixAttaque){

		// on appelle la methode qui verifie si l'attaque choisie est "defaut" et attaque si c'est le cas, sinon ne fait rien
		super.attaque(adversaire, choixAttaque);

		double multiplicateurAvantage = 1;
		
		// on considere un pokemon A fort contre un pokemon B, s'il est fort contre au moins une des natures de B
		if (fortContre(adversaire) || fortContre(adversaire.get_secondary_type())) {

			multiplicateurAvantage = 2;
		
		}

		// on considere un pokemon A faible contre un pokemon B, s'il est faible contre au moins une des natures de B
		if (faibleContre(adversaire) || faibleContre(adversaire.get_secondary_type())) {
		
			multiplicateurAvantage = 0.5;
		
		}

		switch (choixAttaque) {
			case "boutefeu":
				// boutefeu inflige 120% de degats a l'adversaire et 10% de degats au pokemon qui l'utilise
				System.out.println ("\t\t" + this.nom + " attaque avec un multiplicateur de " + String.format("%.2f", (1.2*multiplicateur*mult_feu*multiplicateurAvantage)) + " : " + String.format("%.2f", (1.2*attaque*multiplicateur*mult_feu*multiplicateurAvantage)) + " !");
				
				adversaire.subire(this, (int)(attaque*1.2*mult_feu*multiplicateur*multiplicateurAvantage));
				
				this.subire(this, (int)(attaque*0.1*mult_feu*multiplicateur*multiplicateurAvantage));
				
				multiplicateur = 1;
				
				break;

			case "surchauffe":
				// surchauffe inflige 130% de degats mais a 20% de chances d'echouer

				// on a 80% de chances que (Math.random() < 0.8 == true)
				if (Math.random() < 0.8) {

					System.out.println ("\t\t" + this.nom + " attaque avec un multiplicateur de " + String.format("%.2f", (1.3*multiplicateur*multiplicateur*mult_feu*multiplicateurAvantage)) + " : " + String.format("%.2f", (1.3*attaque*multiplicateur*mult_feu*multiplicateurAvantage)) + " !");
					
					adversaire.subire(this, (int)(attaque*1.3*mult_feu*multiplicateur*multiplicateurAvantage));

				}else{
					System.out.println ("\t\t" + this.nom + " a utilise surchauffe mais cela a echoue !");
				}
				
				multiplicateur = 1;
				
				break;
		}
	}

}
