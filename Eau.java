public class Eau extends Pokemon{

	public Eau(String nom, int pvmax, int attaque){

		super(nom, pvmax, attaque);

		if (nbAttaques < 5) {

			attaquesDisponibles[nbAttaques++] = "Hydroblast";

		}
	}
	
	@Override
	public void talent(){}

	@Override
	public boolean fortContre(Pokemon a){

		return (a instanceof Feu || a instanceof Terre);

	}

	@Override
	public boolean faibleContre(Pokemon a){

		return (a instanceof Eau || a instanceof Herbe || a instanceof Electricite);

	}

	@Override
	public void attaque (Pokemon adversaire, String choixAttaque){
		// on appelle la methode qui verifie si l'attaque choisie est "defaut" et attaque si c'est le cas, sinon ne fait rien
		super.attaque(adversaire, choixAttaque);

		// Hydroblast inflige 220% de degats mais a 20% de chances d'echouer et s'il n'echoue pas, le pokemon n'attaque pas au tour suivant (paralyse)
		if (choixAttaque == "Hydroblast"){
			
			// on a 80% de chances que (Math.random() > 0.2) == true 
			if(Math.random() > 0.2){
				
				multiplicateur *= 2.2;
	
				super.attaque(adversaire);
	
				paralyse = 1;
	
			}else{
	
				System.out.println ("\t\t" + this.nom + " a utilise Hydroblast mais cela a echoue !");	
	
			}	
		}
	}
}
