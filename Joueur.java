import java.util.Scanner;
public class Joueur extends Dresseur{
	//atributs
	private static int nbJoueurs = 0;		// initialisation obligatoire
	private int nombreVictoires = 0;	// initialisation facultative
	private int nombreDefaites = 0;		// initialisation facultative
	private static int round = 1;			// initialisation obligatoire
	private boolean termine;
	private boolean abandonne = false;	// initialisation facultative
	private boolean peut_choisir_poke;
	private String vs = "                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"  ____        ____             \n" +
						"  \\###\\      /###/             \n" +
						"   \\###\\    /###/_____         \n" +
						"    \\###\\  /###/______'        \n" +
						"     \\###\\/###/_______         \n" +
						"      \\######/._____  '.       \n" +
						"       \\####/  _____7  |       \n" +
						"              '._____.'        \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               \n" +
						"                               ";


	// constructeurs
	public Joueur(String nom, int x, int y) {

		super(nom, x, y);

		nbJoueurs ++;
	}

	public Joueur(String nom){

		this(nom, 0, 0);
	}

	public Joueur(int x, int y){

		this("Joueur " + (nbJoueurs + 1), x, y);
	}

	public Joueur(){

		this("Joueur " + (nbJoueurs + 1));
	}

	/**
	 * Demande a l'utilisateur de choisir un pokemon et renvoie d'indice du pokemon choisi
	 */
	public int choisir_pokemon(){
		
		int pokemon_choisi;
		
		Scanner sc = new Scanner(System.in);
		
		String s = "";

		for(int i = 0; i < nbPokemons ; i++){
		
			// si un pokemon n'est pas KO on affiche un indice et son nom  : (1) Bulbizarre
			// si le pokemon est KO on affiche X a la place de son indice  : (X) Bulbizarre
		
			if (!pokemons[i].estKO()) {
		
				s += String.format("(%s) : " + pokemons[i].nom + " ;\n", i + 1 );	
		
			}else{
		
				s += "(X) : " + pokemons[i].nom + " ;\n";
		
			}
		}

		// on donne l'option "revenir en arriere"

		s += "(0) : <--- ;\n";

		// on affiche le String que l'on vient de construire
		System.out.println("\nChoisir  le  pokemon:\n" + s);
			
		
		// sc.nextInt() peut originer InputMissmatchException car on s'attend a recevoir un int et l'utilisateur pourrait nous donner un String
		try{ 
		
			pokemon_choisi = sc.nextInt() - 1;
		
			// si l'utilisateur veut revenir en arriere, alors pokemon_choisi = -1
			// on est oblige de traiter ce cas a part pour eviter de creer un IndexOutOfBoundsException plus loin
			if (pokemon_choisi == -1) {
			
				// on retourne cette valeur
				return pokemon_choisi;
		
			}
		
			// si le input de l'utilisateur est acceptable (un entier), mais n'est pas valide (ne correspond pas a un pokemon disponible)
			if (pokemon_choisi >= nbPokemons || pokemon_choisi < 0 || pokemons[pokemon_choisi].estKO()){
			
				System.out.println("\nPokemon non valide");
				
				// on appelle cette meme fonction encore une fois
				pokemon_choisi = choisir_pokemon();
		
			}
		}
		
		// en cas d'exception, notament InputMissmatchException
		catch(Exception e){
		
			System.out.println("\nPokemon non valide");		

			// on appelle cette meme fonction encore une fois
			pokemon_choisi = choisir_pokemon();				
		
		}
		
		// on ne sort que quand pokemon_choisi est valable
		return pokemon_choisi;
	}

	/**
	 * Demande a l'utilisateur de choisir une action (attaquer, changer de pokemon, abandonner)
	 * Retourne un entier selon l'action choisie
	 */
	public int lireAction(int index_pokemon_choisi){
		int choix = 0;
		
		Scanner scan_int = new Scanner(System.in);

		String s = " (1) : Attaquer\n (2) : Changer de Pokemon\n (3) : Abandonner";
		
		System.out.println(s);

		// scan_int.nextInt() peut originer InputMissmatchException car on s'attend a recevoir un int et l'utilisateur pourrait nous donner un String
		try{
			choix = scan_int.nextInt();
		}

		// en cas d'exception, notament InputMissmatchException
		catch(Exception e){
			// on appelle cette meme fonction encore une fois
			choix = lireAction(index_pokemon_choisi);
		}
		
		switch (choix){
			
			// si on a choisi d'attaquer 
			case 1:
				return 1;

			// si on a choisi de changer de pokemon
			case 2:
				return 2;

			// si on a choisi d'abandonner le combat
			case 3:
				abandonne = true;
				return 3;
			// si aucun des cas precedents n'est verifie
			default:
				// on appelle cette meme fonction encore une fois
				return 0;
		}
	}

	/**
	 * Demande a l'utilisateur de choisir une attaque
	 * Retourne un entier selon l'attaque choisie
	 */
	public int lireAttaqueClavier(int index_pokemon_choisi){
		int choix = 0;
		
		Scanner scan = new Scanner(System.in);

		String s = "";
			
		for(int i = 0; i < pokemons[index_pokemon_choisi].nbAttaques; i++){

			s += String.format("(%s) : " + pokemons[index_pokemon_choisi].attaquesDisponibles[i] + " ;\n", i + 1 );
		
		}

		// on donne l'option "revenir en arriere"
		s += "(0) : <--- ;\n";
		
		// on affiche le String que l'on vient de construire
		System.out.println("\nChoisir  attaque:\n" + s);

		// sc.nextInt() peut originer InputMissmatchException car on s'attend a recevoir un int et l'utilisateur pourrait nous donner un String
		try{		
		
			choix = scan.nextInt() - 1;
		
		}
		
		// en cas d'exception, notament InputMissmatchException
		catch(Exception e){
		
			System.out.println("\nAttaque non valide");
		
			// on appelle cette meme fonction encore une fois
			choix = lireAttaqueClavier(index_pokemon_choisi);
		
		}
		
		// si le input de l'utilisateur est acceptable (un entier), mais n'est pas valide (ne correspond pas a une attaque disponible)
		if (choix >= pokemons[index_pokemon_choisi].nbAttaques || choix < -1){
		
			System.out.println("\nAttaque non valide");
		
			// on appelle cette meme fonction encore une fois
			choix = lireAttaqueClavier(index_pokemon_choisi);
		
		}

		// on ne sort que quand choix est valable
		return choix;
	}

	/**
	 * Gere le combat entre le joueur et un dresseur
	 * Retourne vrai si le joueur a gagne le combat
	 */
	public boolean combat(Dresseur adversaire) {
		
		int action_choisie;
		
		int attaque_choisie;
		
		int pokemonNum = 0, pokemonNumAdv = 0;
		
		Dresseur vainqueur = null;
		
		peut_choisir_poke = false;
		
		termine = false;
		
		// par defaut on prend le premier pokemon de la liste
		// si le pokemon choisi par defaut est KO, on prends le suivant
		while (pokemons[pokemonNum].estKO()){
			pokemonNum ++;
		}

		System.out.println(this + " affronte " + adversaire);

		while (!termine) {

			// on casse les toString des pokemons et le string 'vs' pour les mettre cote a cote
			String[] pokemon_joueur = pokemons[pokemonNum].toString().split("\n");
			String[] versus = vs.split("\n");
			String[] pokemon_adversaire = adversaire.pokemons[pokemonNumAdv].toString().split("\n");
			String affiche_combat = "";
			for(int i = 0; i < pokemon_joueur.length; i++){
				affiche_combat += pokemon_joueur[i] + versus[i] + pokemon_adversaire[i] + "\n";
			}

			// on affiche la combinaison des 3 strings que l'on vient de construire
			System.out.println("\nRound " + round + " !\n" + affiche_combat);

			// on initialise attaque_choisie a une valeur invalide pour rentrer dans la boucle dont on ne sort que quand cette variable prend une valeur valide
			attaque_choisie = -1;

			// on demande a l'utilisateur de choisir une action (attaquer, changer de pokemon, abandonner)
			action_choisie = lireAction(pokemonNum);	

			// on ne lance pas le combat tant qu'on n'a pas choisi une attaque valide
			while (attaque_choisie > pokemons[pokemonNum].nbAttaques || attaque_choisie < 0){ 
				
				// si l'action choisie est invalide, lireAction() revoie 0. Alors on relance lireAction()
				if (action_choisie == 0) {
		
					action_choisie = lireAction(pokemonNum);
		
				}

				// si on choisi de changer de pokemon, lireAction revoie 2. Alors on change de pokemon
				else if (action_choisie == 2) {
					
					// on stocke pokemonNum dans une variable temporaire
					int pokemonNum_initial = pokemonNum;		
		
					// on change de pokemon
					pokemonNum = choisir_pokemon();
					
					// si on decide de revenier en arriere (pokemonNum == -1)
					if (pokemonNum == -1) {						
						
						// on relance lireAction (action_choisie = 0)
						action_choisie = 0;						
						
						// on remet pokemonNum a son etat initial
						pokemonNum = pokemonNum_initial;		
					}

					// si on choisi le pokemon qu'on avait deja en main, on ne le paralyse pas
					else if (pokemonNum == pokemonNum_initial) {
						action_choisie = 1;
					}

					else{
						
						// sinon, si on a bien change de pokemon, on est obliges de combattre lors du tour suivant
						action_choisie = 1;
						
						// Cependant, on paralyse notre pokemon pour 1 tour car on n'a pas le droit d'attaquer quand on change de pokemon
						pokemons[pokemonNum].setParalyse(1);	
		
					}
				}

				// si on choisi de abandonner le combat, lireAction revoie 3. Alors on sort de la 1ere boucle while
				else if (action_choisie == 3) {
				
					break;
				
				}

				// si on choisi d'attaquer, lireAction revoie 1. Alors on attaque. (le choix d'une attaque valide provoque la sortie de cette boucle while et lance le combat)
				else if (action_choisie == 1) {
					
					// si mon pokemon peut attaquer
					if (pokemons[pokemonNum].peut_attaquer()) {
						
						// je choisis mon attaque
						attaque_choisie = lireAttaqueClavier(pokemonNum);					
				
					}else{
						
						// s'il ne peut pas attaquer je ne choisis pas l'attaque car quel que soit mon choix, rien ne se passe
						// alors on impose attaque_choisie = 0, ce qui est arbitraire et insignifiant
						attaque_choisie = 0;
				
					}
				
					// si on choisi de revenir en arriere
					if (attaque_choisie == -1) {
						
						// on relance lireAction
						action_choisie = 0;
				
					}
				
				}
			}

			// si on choisi de abandonner le combat, lireAction revoie 3. Alors on sort de la 2eme boucle while (il nous faut 2 break pour les 2 boucles)
			if(action_choisie == 3){

				round = 1;
				
				break;
			}

			// on lance le combat
			Pokemon.combat(pokemons[pokemonNum], adversaire.pokemons[pokemonNumAdv], this.pokemons[pokemonNum].attaquesDisponibles[attaque_choisie], adversaire.pokemons[pokemonNumAdv].attaqueAleatoire());
			
			// si le pokemon du joueur est KO et l'adversaire a encore des pokemons (cad le jeu n'est pas fini), on change de pokemon sans le paralyser
			if (pokemons[pokemonNum].estKO() && pokemonNumAdv != adversaire.nbPokemons) {
				
				// on decremente le nombre de pokemons valides du joueur
				nbValides --;
				
				// si le joueur a encore des pokemons valides
				if (nbValides > 0) {
				
					// il change de pokemon
					pokemonNum = choisir_pokemon();
			
					// on interdit le retour en arriere, on oblige l'utilisateur a changer de pokemon
					while (pokemonNum == -1){
			
						System.out.println("Vous devez choisir un pokemon");
						
						// si le joueur essaye de revenir en arriere, on relance la fonction choisir_pokemon ()
						pokemonNum = choisir_pokemon();
			
					}
			
					round = 1;	
				}			
			}


			// si le pokemon de l'adversaire est KO,  il prend le pokemon suivant
			if (adversaire.pokemons[pokemonNumAdv].estKO()) {

				pokemonNumAdv++;

				round = 1;

			}


			if (nbValides == 0) {										// si je n'ai plus de pokemons

				termine = true;											// |	

				if (pokemonNumAdv != adversaire.nbPokemons) { 			// |	et si l'adversaire a encore des pokemons

					vainqueur = adversaire;								// |	|	 il a gagne

					nombreDefaites ++;

				} else{

					/* egalité */										// |	sinon egalité

				}									

			} else if (pokemonNumAdv == adversaire.nbPokemons) { 		// sinon, si seulement l'adversaire n'a plus de pokemons

				termine = true;											// 		j'ai gagne

				vainqueur = this;

				nombreVictoires ++;

				adversaire.vaincu = true;

			}		

			round ++;
		}
		
		// si le joueur a abandonne
		if (abandonne) {

			// un abandon est considere comme une defaite (pour eviter des abus)
			nombreDefaites ++;
		
		}
		
		abandonne = false;
		
		return vainqueur == this;
	}

	/**
	 * Change les coordones x, y du joueur en se basant sur les coordonees pasees en parametre
	 */
	public void deplacer(int x, int y){
		this.x = x;
		this.y = y;
	}

	/**
	 * Retourne le nombre de victoires
	 */
	public int getVictoires(){return nombreVictoires;}
	
	/**
	 * Retourne le nombre de defaites
	 */
	public int getDefaites(){return nombreDefaites;}

}
