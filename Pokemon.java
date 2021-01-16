public abstract class Pokemon {
	protected static int aleaNum = 1;
	protected String nom;										// nom du Pokémon
	protected int pvmax;										// vie totale du Pokémon
	protected int niveau, pv, attaque;							// niveau, vie et attaque du Pokémon
	protected String[] attaquesDisponibles;						// liste des attaques connues du Pokémon	
	protected int nbAttaques;									// nombre d'attaques du Pokémon  (nbAttaques < 6)
	protected double multiplicateur;
	protected int paralyse;
	
	// Constructeur de base
	public Pokemon(String nom, int pvmax, int attaque) {
		
		this.nom = nom;
		
		this.pvmax = pvmax;
		
		pv = pvmax;
		
		niveau = 1;
		
		this.attaque = attaque;
		
		attaquesDisponibles = new String[5];
		
		attaquesDisponibles[0] = "defaut";
		
		nbAttaques = 1;
		
		multiplicateur = 1.0;
		
		paralyse = 0;	
	}
	
	// Constructeur sans parametres
	public Pokemon() {
		this("Anonyme" + aleaNum, 100 + (int) (Math.random() * 100), 40 + (int) (Math.random() * 100));
		aleaNum++;
	}

	/**
	 * Renvoie un pokemon aleatoire
	 */
	public static Pokemon pokemonAleatoire() {
		Pokemon pokemon_aleatoire = null;
		// on prend un entier aleatoire  entre 0 et 9 et on cree le pokemon correspondant
		switch ((int)(Math.random()*10)) {
			case 0:
				pokemon_aleatoire = new Bulbizarre();
				break;
			case 1:
				pokemon_aleatoire = new Pyroli();
				break;
			case 2:  
				pokemon_aleatoire = new Carapuce();
				break;
			case 3: 
				pokemon_aleatoire = new Gobou();
				break;
			case 4: 
				pokemon_aleatoire = new Leviator();
				break;
			case 5: 
				pokemon_aleatoire = new Pikachu();
				break;
			case 6:
				pokemon_aleatoire = new Racaillou();
				break;
			case 7:
				pokemon_aleatoire = new Salameche();
				break;
			case 8: 
				pokemon_aleatoire = new Voltali();
				break;
			case 9: 
				pokemon_aleatoire = new Caninos();
				break;
		}
		return pokemon_aleatoire;
	}

	/**
	 * Renvoie le niveau du pokemon
	 */
	public int getNiveau() {return niveau;}

	/**
	 * Verifie si ce pokemon est KO
	 */
	public boolean estKO() {return pv == 0;}

	/**
	 * Verifie si le pokemon peut attaquer
	 */
	public boolean peut_attaquer() {return paralyse == 0;}

	/**
	 * Remets les points de vie et le multiplicateur du pokemon a 0 et 1 respectivement
	 */
	public void perdu() {pv = 0;multiplicateur = 1;}

	/**
	 * Redonne tous les points de vie au pokemon
	 * soigne la paralysie
	 */
	public void soigner() {
		pv = pvmax;
		paralyse = 0;
	}

	/**
	 * Renvoie une instance du type secondaire du pokemon
	 */ 
	public Pokemon get_secondary_type(){return null;}
	
	/**
	 * Verifie si ce pokemon est fort contre le pokemon adversaire passe en parametre
	 */
	public abstract boolean fortContre (Pokemon adversaire);

	/**
	 * Verifie si ce pokemon est fort contre le pokemon adversaire passe en parametre
	 */
	public abstract boolean faibleContre (Pokemon adversaire);

	/**
	 * Retourne la liste des attaques disponibles
	 */
	public String[] getAttaquesDisponibles() {return attaquesDisponibles.clone();}

	/**
	 * Retourne une attaque aleatoire parmi celles disponibles
	 */
	public String attaqueAleatoire(){
		
		return attaquesDisponibles[(int)(Math.random()*nbAttaques)];
	}

	/**
	 * Affiche les attaques disponibles
	 */
	public void afficheAttaques() {
		String s = "";
		for (int i = 0; i < attaquesDisponibles.length; i++)
			s += i + "        \t";
		System.out.println(s);
		s = "";
		for (String attaque : attaquesDisponibles)
			s += attaque + "\t";
		System.out.println(s);
	}

	/**
	 * Active un pouvoir specifique au pokemon
	 */
	public abstract void talent();

	/**
	 * Diminue les PV du pokemon en se basant sur les degats recus
	 * et affiche le nom du pokemon et les degats subits
	 */
	public void subire(Pokemon adversaire, int degats) {
		pv -= degats;
		
		if (pv < 0){
			pv = 0;
		}
		
		System.out.println("\t\t\t" + this.nom + " subit " + degats + " ! ");
	}
	
	/**
	 * Gere les attaques
	 */
	public void attaque (Pokemon adversaire) {
		/**
		 * Note:
		 * 
		 * Quels que soient les types d'un certain pokemon
		 * s'il attaque avec une attaque type Feu (par exemple),
		 * on agira comme si le type du pokemon etait Feu car ce qui compte
		 * c'est le type de l'attaque et la nature du pokemon qui subit.
		 * 
		 * Cependant, dans le cas du pokemon qui subit,
		 * on prend en compte ses deux types (s'il en a deux)
		 */
		
		double multiplicateurAvantage = 1; 		
		
		// on considere un pokemon A fort contre un pokemon B, s'il est fort contre au moins une des natures de B
		if (fortContre(adversaire) || fortContre(adversaire.get_secondary_type())) {
			multiplicateurAvantage = 2;
		}
		
		// on considere un pokemon A faible contre un pokemon B, s'il est faible contre au moins une des natures de B
		if (faibleContre(adversaire) || faibleContre(adversaire.get_secondary_type())) {
			multiplicateurAvantage = 0.5;
		}
		
		// un pokemon A peut etre a la fois fort et faible contre un pokemon B auquel cas:
		// multiplicateurAvantage == 1 * 2 * 0.5 == 1
		
		// meme si un pokemon a plusieurs types, lors de l'attaque il n'en a qu'un seul
		
		System.out.println ("\t\t" + this.nom + " attaque avec un multiplicateur de " + String.format("%.2f", (multiplicateur*multiplicateurAvantage)) + " : " + String.format("%.2f", (attaque*multiplicateur*multiplicateurAvantage)) + " !");
		
		adversaire.subire(this, (int)(attaque * multiplicateur * multiplicateurAvantage));
		
		multiplicateur = 1;
	}

	/**
	 * --Version ennoncé
	 * Verifie si choixAttaque == "defaut"
	 * si oui, appelle attaque(adversaire), si non, ne fait rien
	 
	public void attaque(Pokemon adversaire, String choixAttaque) {
		System.out.println("\t" + this.nom + ", Attaque " + choixAttaque + " ! ");
		if (choixAttaque.equals("defaut")){
			attaque(adversaire);
		}
	}
	*/
	
	
	/**
	 * ---Version changee
	 * Verifie si choixAttaque == "defaut"
	 * si oui, attaque avec choixAttaque = defaut, si non, ne fait rien
	 * 
	 * Ne prends pas en compte multiplicateurAvantage car defaut est 
	 * une attaque neutre (qui n'a pas de type)
	 *  
	 */
	public void attaque(Pokemon adversaire, String choixAttaque) {
		
		System.out.println("\t" + this.nom + ", Attaque " + choixAttaque + " ! ");
		
		if (choixAttaque.equals("defaut")){
		
			System.out.println ("\t\t" + this.nom + " attaque avec un multiplicateur de " + String.format("%.2f", (multiplicateur)) + " : " + String.format("%.2f", (attaque*multiplicateur)) + " !");
			
			adversaire.subire(this, (int)(attaque * multiplicateur));
			
			multiplicateur = 1;
		}
	}

	/**
	 * Gere le combat entre deux pokemons 
	 */
	public static void combat (Pokemon p1, Pokemon p2, String attaque1, String attaque2) {

		p1.talent();
		p2.talent();
		
		if (p1.peut_attaquer() || p2.peut_attaquer()){
			// si au moins l'un des deux peut attaquer
			if (p1.peut_attaquer()){
				// si p1 peut attaquer, p1 attaque
				p1.attaque (p2, attaque1);
				if (p2.peut_attaquer()){
					// si p1 peut attaquer, p1 attaque
					p2.attaque (p1, attaque2);
				}else{
					// sinon, on diminue la paralyse de p2
					System.out.println ("\t\t" + p2.nom + " ne peut pas attaquer !");	
					p2.paralyse --;

				}
			}else{
				// sinon, on diminue la paralyse de p1 et p2 attaque 
				System.out.println ("\t\t" + p1.nom + " ne peut pas attaquer !");
				p1.paralyse --;
				p2.attaque (p1, attaque2);
			}

		}else{
			// sinon on diminue la paralyse des deux pokemons
			System.out.println ("\t\t" + p1.nom + " ne peut pas attaquer !");
			System.out.println ("\t\t" + p2.nom + " ne peut pas attaquer !");

			p1.paralyse --;
			p2.paralyse --;
		}

		if (p1.estKO() && p2.estKO()) {					//Si les 2 sont KO
			p1.gagnerNiveau();
			p2.gagnerNiveau();
			p1.perdu();
			p2.perdu();
		} else if(p1.estKO()) {							// Si seulement le Pokemon 1 est KO
			p2.gagnerNiveau();
			p1.perdu();
		} else if(p2.estKO()) {							// Si seulement le Pokemon 2 est KO
			p1.gagnerNiveau();
			p2.perdu();
		}
	}

	/**
	 * Augmente le niveau du pokemon
	 * Augmente ses PVmax
	 * Augmente son attaque
	 * Soigne partiellement le pokemon
	 */
	public void gagnerNiveauSansAffichage() {
		
		niveau++;
		
		pvmax += 20;
		
		pv += pvmax/2;
		
		if (pv > pvmax){
		
			pv = pvmax;
		
		}
		
		attaque += 10;
	}
	
	/**
	 * Appelle gagnerNiveauSansAffichage()
	 * Affiche que le pokemon a gagne un niveau
	 */
	public void gagnerNiveau() {
		gagnerNiveauSansAffichage();
		System.out.println (this.nom + " passe au niveau " + niveau + " !");
	}
	
	/**
	 * Change le nom du pokemon
	 */
	public void changerNom(String nouveauNom){

		nom = nouveauNom;
	}
	
	/**
	 * Affiche le niveau, le nom, les PV, PVmax et attaque du pokemon
	 */
	public String toString() {

		return "lvl." + niveau + " " + nom + " (" + pv + "/" + pvmax + "pv, " + attaque + " att)";
	}

	/**
	 * Retourne le nom du pokemon
	 */
	public String getNom() {

		return nom;
	}
	
	/**
	 * Retourne l'espece et le nom du pokemon
	 */
	public String getId() {

		return "Pas d’espece ! " + nom;
	}

	/**
	 * Change la paralyse
	 */
	public void setParalyse(int a){
	
		paralyse = a;
	}

	/**
	 * Retourne la barre de vie du pokemon
	 */
	public String health_bar(){
		/**
		 *  La barre de pv
		 * O (majuscule) represente 10 %
		 * o (minuscule) represente < 10%
		 * . represente 0%
		 * Exemple : (OOOOOOOo..) = 70-80%
		 */
		
		int pourcentage = (int)(((double)pv / pvmax) * 100);			// pourcentage PV
		
		String barre ="(";

		for(int i = 0; i < pourcentage/10; i++){						// on ajoute un 'O' pour chaque 10%
			barre += "O";
		}
		
		if (pourcentage % 10 != 0) {									// si le pourcentage n'est pas un multiple de 10, on ajoute un 'o'
			barre += "o";
			for(int i = pourcentage/10 + 1; i < 10; i++){	 			// on rempli de reste de la barre avec des '.'
				barre += ".";
			}

			barre += ")";
			
			return barre;												// sortie anticipee
		}

		for(int i = pourcentage/10; i < 10; i++){						// on rempli de reste de la barre avec des '.'
			barre += ".";
		}
		
		barre +=")";
		
		return barre;
	}
}
