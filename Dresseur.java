public class Dresseur {
	protected String nom;
	protected Pokemon[] pokemons;
	protected int nbPokeballs;
	protected int nbPokemons;
	protected static int nbDresseurs = 1;
	protected boolean vaincu;
	protected int nbValides;
	protected int x, y;


	public Dresseur(String nom, int x, int y, int niveau) {

		// on initialise les attributs

		this.nom = nom;

		pokemons = new Pokemon[10];

		nbPokeballs = 10;

		nbPokemons = 0;

		this.x = x;

		this.y = y;

		nbDresseurs++;

		vaincu = false;

		capturePokemons(3); 			

		nbValides = nbPokemons;

		vaincu = false;
		
		// si le niveau du joueur peut etre X alors on fait ses pokemons gagner des niveaux aleatoirement, sans depasser le niveau X

		// pour chaque pokemon
		for (int i = 0; i < nbPokemons; i++){

			// on appelle la fonction gagnerNiveauSansAffichage(), n fois  (avec n = (int)(Math.random()*niveau))
			for (int j = 0; j < (int)(Math.random()*niveau); j++){

				pokemons[i].gagnerNiveauSansAffichage();
			}
		}		
	}
	
	public Dresseur(String nom, int x, int y) {

		this(nom, x, y, 1);
	}

	public Dresseur(String nom) {

		this(nom, 0, 0);
	}

	public Dresseur(int x, int y, int niveau) {

		this("Dresseur " + (nbDresseurs), x, y, niveau);
	}
	
	public Dresseur(int x, int y) {

		this(x, y, 1);
	}

	public Dresseur() {

		this("Dresseur " + (nbDresseurs));
	}

	/**
	 * Donne au dresseur une certaine liste de pokemons (avec un max de 10)
	 */
	public void capturePokemons(Pokemon[] nouveauxPokemons) {

		for (int pokemonNum = 0; pokemonNum < nouveauxPokemons.length; pokemonNum++) {

			if (nbPokemons == 10 || nbPokeballs == 0) {

				break;

			}

			pokemons[nbPokemons] = nouveauxPokemons[pokemonNum];

			nbPokemons++;

			nbValides++;
		}
	}

	/**
	 * Donne au dresseur un certain nombre de pokemons aleatoires
	 */
	public void capturePokemons(int nbPokemons) {

		Pokemon[] nouveauxPokemons = new Pokemon[nbPokemons];

		for (int n = 0; n < nbPokemons; n++) {

			nouveauxPokemons[n] = Pokemon.pokemonAleatoire();

		}

		capturePokemons(nouveauxPokemons);
	}

	/**
	 * Soigne tous les pokemons du dresseur
	 */
	public void infirmerie() {

		for (int pokemonNum = 0; pokemonNum < nbPokemons; pokemonNum++) {

			pokemons[pokemonNum].soigner();

		}

		nbValides = nbPokemons;
	}

	/**
	 * Retourne le nom du Dresseur
	 */
	public String toString() {return nom;}

	/**
	 * Retourne la valeur de l'atribut nbValides
	 */
	public int getNbValides(){return nbValides;}

	/**
	 * Retourne la valeur de l'atribut vaincu
	 */
	public boolean getVaincu(){return vaincu;}

	/**
	 * Retourne la valeur de la coordonee X
	 */
	public int getPosX(){return x;}

	/**
	 * Retourne la valeur de la coordonee Y
	 */
	public int getPosY(){return y;}
}
