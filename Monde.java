import java.util.ArrayList;
import java.io.Reader;
import java.util.Scanner;
import java.io.InputStreamReader;

public class Monde{
	private int[][] cases;
	private double probabilitePresenceInitiale;
	public Joueur joueur;
	private ArrayList<Dresseur> tab_dress = new ArrayList<Dresseur>(); // puisqu'il existe une limite max, on aurait aussi pu utiliser Dresseur[]
	private int nbDresseurs, nbDresseursActifs;
	private Reader rd = new InputStreamReader(System.in);
	private int os = 1;
	private int nbInfirmerie;
	private int clavier = 1;

	public Monde(int x,  int y, double probabilitePresenceInitiale, int niveau_max_dresseur){
		
		this.probabilitePresenceInitiale = probabilitePresenceInitiale;
		
		nbDresseurs = 0;
		
		nbInfirmerie = 0;

		//	on initialise le tableau avec les coordonees passees en parametre
		cases = new int[x][y];																			

		//	on parcourt le tableau
		for(int i = 0; i < x ; i++ ){ 		// lignes
			for (int j = 0; j < y ; j++ ) {	// colonnes
				
				// si on a deja 20 dresseurs, on sort de la premiere boucle (colonnes)
				if (nbDresseurs == 20 || nbInfirmerie == 5) {

					break;
				}

				// on a une certaine probabilite (passee en parametre) d'ajouter un dresseur dans cette case
				if (Math.random() <= probabilitePresenceInitiale) {	
				
					// la case devient ocuppee par une dresseur
					cases[i][j] = 1;
				
					// le nombre total de dresseurs est augmente
					nbDresseurs ++;
				
					// on cree un nouveau dresseur avec  des coordonées i, j et un niveau aleatoire entre 1 et niveau_max_dresseur
					// on ajoute ce dresseur a notre arraylist
					tab_dress.add(new Dresseur(j, i, (int)(Math.random()*niveau_max_dresseur + 1)));
				
				// on a 0.1*ProbabilitePresenceInitiale de probabilite d'ajouter une infirmerie dans la case
				}else if(Math.random() <= probabilitePresenceInitiale/10){
				
					// la case devient ocuppee par une infirmerie
					cases[i][j] = 3;
				
					// on augmente le nombre d'infirmeries
					nbInfirmerie ++;
				
				}else{
				
					// si on ne met rien sur une case, elle est vide ( = 0 )
					cases[i][j] = 0;
				
				}

			}

			//	si on a deja 20 dresseurs, on sort de la deuxieme boucle (lignes),  pour eviter de faire des tours de boucle inutiles
			if (nbDresseurs == 20 || nbInfirmerie == 5) {

					break;																				

			}
		}

		// si aucun dresseur n'a ete place sur le monde 
		if (nbDresseurs == 0) {

			// on en place un aleatoirement
			int i = (int)(Math.random()*(x - 1));
			int j = (int)(Math.random()*(y - 1)); 
			
			// on se certifie que l'on ne le place pas sur une case deja occupee
			while (cases[i][j] != 0){

				i = (int)(Math.random()*(x - 1));

				j = (int)(Math.random()*(y - 1));

			}

			cases[i][j] = 1;
			
			tab_dress.add(new Dresseur(i, j, (int)(Math.random()*niveau_max_dresseur + 1)));

			nbDresseurs ++;
		}

		// si aucune infirmerie n'a ete place sur le monde 
		if (nbInfirmerie == 0) {

			// on en place une aleatoirement
			int i = (int)(Math.random()*(x - 1));
			int j = (int)(Math.random()*(y - 1));

			// on se certifie que l'on ne la place pas sur une case deja occupee
			while (cases[i][j] != 0){

				i = (int)(Math.random()*(x - 1));

				j = (int)(Math.random()*(y - 1));

			}

			cases[i][j] = 3;

			nbInfirmerie ++;
		}

		//	au debut, tous les dresseurs sont actifs
		nbDresseursActifs = nbDresseurs;


		//	on cree un joueur et on le place aleatoirement
		joueur = new Joueur((int)(Math.random()*(x - 1)), (int)(Math.random()*(y - 1)));

		//le joueur ne commencera jamais dans une case deja occupee par un dresseur
		
		// si le joueur est placee sur la meme case qu'un dresseur
		while (cases[joueur.getPosY()][joueur.getPosX()] == 1){

			// on le deplace
			joueur.deplacer((int)(Math.random()*(x - 1)), (int)(Math.random()*(y - 1)));

		}
	}

	/**
	 * Affiche les dimensions du monde, le nombre de Dresseurs Restants,
	 * le nombre de victoires et le nombre de defaites
	 */
	public String toString(){

		return String.format("Dimensions du Monde : \t(%s, %s)\n\nDresseurs Restants : \t%s\n\nVictoires : \t\t%s\n\nDefaites : \t\t%s", cases.length, cases[0].length, nbDresseursActifs, joueur.getVictoires(), joueur.getDefaites());
	}

	/**
	 * Affiche une representation du monde
	 */
	public void afficheMondeTerminal(){
		
		//premiere et derniere lignes
		String l1 = "_";
		for(int i = 0; i < cases.length; i++){
			l1 += "____";
		}
		l1 += "\n";

		//lignes centrales
		String l2 = "";
		for(int i = 0; i < cases.length; i++){					
			l2 += "|";
			for(int j = 0; j < cases.length; j++){				
				if (joueur.getPosX() == j && joueur.getPosY() == i){
					l2 += " J |";
				}else{
					switch (cases[i][j]){
						case 0:
							l2 += " . |";		// case vide
							break;
						case 1:
							l2 += " D |";		// dresseur actif
							break;
						case 2:
							l2 += " X |";		// dresseur vaincu
							break;
						case 3:
							l2 += " I |";		// infirmerie
							break;
					}
				}
			}
			l2 += "\n";
		}
		
		System.out.println(this);
		System.out.println(l1 + l2 + l1);
	}
  	
  	/**
  	 * Nettoie le terminal sur Linux
  	 */
 	public static void clearScreenLinux() {
 		System.out.print("\033[H\033[2J");
 		System.out.flush();
 	}
 	
 	/**
 	 * Nettoie le terminal sur Windows
 	 */
 	public static void clearScreenWindows() {
		// source : stackoverflow 
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(Exception e){}
	}
	
	/**
	 * Appelle la methode clearScreenLinux() ou clearScreenWindows()
	 * selon l'OS choisi
	 */
	public void clearScreen() {
 		if (os == 1){
			clearScreenLinux();
		}else{
			clearScreenWindows();
		}	 
 	}
 
	/**
	 * Demande a l'utilisateur de choisir un clavier: AZERTY ou QWERTY
	 */
 	public void choix_clavier(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nChoisissez votre clavier : \n\t(1) AZERTY\n\t(2) QWERTY\n");
		
		try{																			
		
			clavier = sc.nextInt();
		
			if (clavier != 1 && clavier != 2){
		
				// Si l'entier donne n'est pas valide, on appelle cette meme fonction encore une fois
				System.out.println("\n Clavier non valide");									
				choix_clavier();	
		
			}
			
		}catch(Exception e){														

			// En cas de InputMissmatchException, on appelle cette meme fonction encore une fois
			System.out.println("\n Clavier non valide");									
			choix_clavier();													
	
		}
	}
	
	/**
	 * Demande a l'utilisateur de choisir un OS: Linux ou Windows
	 */
	public void choix_OS(){
	
		Scanner sc = new Scanner(System.in);
	
		System.out.println("\nChoisissez votre OS : \n\t(1) Linux\n\t(2) Windows\n");
	
		try{																			
	
			os = sc.nextInt();
	
			if (os != 1 && os != 2){
	
				// Si l'entier donne n'est pas valide, on appelle cette meme fonction encore une fois
				System.out.println("\n OS non valide");									
				choix_OS();	
	
			}
			
		}catch(Exception e){																
	
			// En cas de InputMissmatchException, on appelle cette meme fonction encore une fois
			System.out.println("\n OS non valide");									
			choix_OS();													
	
		}
	}

	/**
	 * Demande a l'utilisateur de choisir une direction et retourne
	 * la direction choisie
	 * 
	 * Si l'utilisateur fournit une String, elle est transformee en un
	 * tableau de char, et tous les char sont interpretes
	 */
	public char lire(){

		char direction;

		try{

			// on prend le input de l'utilisateur
			direction = (char) rd.read();

			// si on a choisi QWERTY
			if (clavier == 2){

				// si le input est different de w, a, s, d, W, A, S, D
				if (direction != 'w' && direction != 'W' && direction != 'a' && direction != 'A' && direction != 's' && direction != 'S' && direction != 'd' && direction != 'D'){

					// on appelle cette meme fonction encore une fois
					direction = lire();

				}

			// si on a choisi AZERTY
			}else if (clavier == 1){

				// si le input est different de z, q, s, d, Z, Q, S, D
				if (direction != 'z' && direction != 'Z' && direction != 'q' && direction != 'Q' && direction != 's' && direction != 'S' && direction != 'd' && direction != 'D'){

					// on appelle cette meme fonction encore une fois
					direction = lire();

				}
			}
		}
		catch(Exception e){

			// En cas de IOException, on appelle cette meme fonction encore une fois
			direction = lire();
		}

		return direction;
	}
	
	/**
	 * Change la position du joueur
	 */
	public void bouger_QWERTY(char direction){
		switch (direction){
			
			// (x, y) = (0, 0)  =>  coin superieur gauche
			
			case 'W': case 'w':

				// on ne bouge que si on n'est pas en y = 0
				if (joueur.getPosY() > 0){

					// vers le haut => x ne change pas et y diminue
					joueur.deplacer(joueur.getPosX(), joueur.getPosY() - 1);

				}

				// si on est a la limite du haut (y = 0) on ne bouge pas

				break;

			case 'A': case 'a':

				// on ne bouge que si on n'est pas en x = 0
				if (joueur.getPosX() > 0){

					// vers la gauche => x diminue et y ne change pas
					joueur.deplacer(joueur.getPosX() - 1, joueur.getPosY());

				}

				// si on est a la limite gauche (x = 0) on ne bouge pas

				break;

			case 'S': case 's':

				// on ne bouge que si on n'est pas en y = cases.length
				if (joueur.getPosY() < cases.length - 1){

					// vers le bas => x ne change pas et y augmente
					joueur.deplacer(joueur.getPosX(), joueur.getPosY() + 1);

				}

				// si on est a la limite du bas (y = cases.length) on ne bouge pas

				break;

			case 'D': case 'd':

				// on ne bouge que si on n'est pas en x = cases.length
				if (joueur.getPosX() < cases[0].length - 1){

					// vers la droite => x augmente et y ne change pas
					joueur.deplacer(joueur.getPosX() + 1, joueur.getPosY());

				}

				// si on est a la limite droite (x = cases.length) on ne bouge pas

				break;
		}
	}
	
	/**
	 * Change la position du joueur
	 */
	public void bouger_AZERTY(char direction){
		switch (direction){

			// (x, y) = (0, 0)  =>  coin superieur gauche

			case 'Z': case 'z':

				// on ne bouge que si on n'est pas en y = 0
				if (joueur.getPosY() > 0){

					// vers le haut => x ne change pas et y diminue
					joueur.deplacer(joueur.getPosX(), joueur.getPosY() - 1);

				}

				// si on est a la limite du haut (y = 0) on ne bouge pas

				break;

			case 'Q': case 'q':

				// on ne bouge que si on n'est pas en x = 0
				if (joueur.getPosX() > 0){

					// vers la gauche => x diminue et y ne change pas
					joueur.deplacer(joueur.getPosX() - 1, joueur.getPosY());

				}

				// si on est a la limite gauche (x = 0) on ne bouge pas

				break;

			case 'S': case 's':

				// on ne bouge que si on n'est pas en y = cases.length
				if (joueur.getPosY() < cases.length - 1){

					// vers le bas => x ne change pas et y augmente
					joueur.deplacer(joueur.getPosX(), joueur.getPosY() + 1);

				}

				// si on est a la limite du bas (y = cases.length) on ne bouge pas

				break;

			case 'D': case 'd':

				// on ne bouge que si on n'est pas en y = cases.length
				if (joueur.getPosX() < cases[0].length - 1){

					// vers la droite => x augmente et y ne change pas
					joueur.deplacer(joueur.getPosX() + 1, joueur.getPosY());

				}

				// si on est a la limite droite (x = cases.length) on ne bouge pas

				break;
		}
	}
	
	/**
	 * Appelle bouger_AZERTY() ou bouger_QWERTY() selon le clavier choisi
	 */
	public void bouger(char direction){	
		if (clavier == 1){
			bouger_AZERTY(direction);
		}else{
			bouger_QWERTY(direction);
		}
		 
	}
	
	/**
	 * Gere le jeu
	 */
	public void jouer(){

		clearScreen();
		
		// cette variable sert a ne pas relancer un combat lors d'un abandon (car si on abandonne, on se trouve sur une case dresseur ce qui lancerait le combat)
		boolean deja_combatu = false; 
		
		// le jeu ne termine pas tant qu'il y a des adversaires actifs (nbDresseursActifs != 0)
		// on a aussi ajoute un nombre maximal de defaites et abandons (joueur.getDefaites() < (int)(nbDresseurs/2))
		// s'il y a 10 dresseurs, on a le droit a 5 defaites/abandons
		while(nbDresseursActifs != 0 && joueur.getDefaites() < (int)(nbDresseurs/2)){
		
			// on affiche le monde
			afficheMondeTerminal();
			
			if (cases[joueur.getPosY()][joueur.getPosX()] == 1 && (joueur.getNbValides() == 0)){

				System.out.println("\n\tVous ne pouvez pas vous battre! Vous devez soigner vos pokemons !\n\n");

			}

			//	s'il y a un adversaire actif dans la meme case que le joueur, contre lequel on ne vient pas de se battre (abandon ou defaite) et les pokemons du joueur ne sont pas tous KO
			if (cases[joueur.getPosY()][joueur.getPosX()] == 1 && !deja_combatu && (joueur.getNbValides() != 0)){

				// on parcourt la liste de dresseurs
				for (int i = 0; i < tab_dress.size(); i++){
					
					// on cherche le dresseur qui a les memes coordonees que le joueur
					if(tab_dress.get(i).getPosX() == joueur.getPosX() && tab_dress.get(i).getPosY() == joueur.getPosY()){
		
						clearScreen();				
		
						// on lance le combat
						if(joueur.combat(tab_dress.get(i))){

							//si on gagne, adv devient vaincu
							cases[joueur.getPosY()][joueur.getPosX()] = 2;

							clearScreen();
		
							System.out.println("\n\n\t\tVous avez gagne !\n\n");
							System.out.println("\n\t\t\tVictoire de " + joueur + " !\n\n");

							nbDresseursActifs --;
		
						}else{

							// si on n'a pas gagne, c'est soit une defaite soit une egalite soit un abandon 
							
							// dans les trois cas, on ne relance pas le combat au tour suivant, (car dans la case ou on se trouve, il y a un dresseur actif)
							// on se donne la possibilite de sortir de la case
							deja_combatu = true;

							clearScreen();

							// si le joueur a des pokemons valides alors qu'il n'a pas gagne, c'est qu'il a abandone
							if (joueur.getNbValides() != 0){

								System.out.println("\n\n\t\tVous avez abandone le combat !\n\n");

							} 

							// sinon, si le joueur n'a plus de pokemons mais l'adversaire en a encore, c'est une defaite
							else if (tab_dress.get(i).getNbValides() != 0) {

								System.out.println("\n\n\t\tVous avez perdu !\n\n");
								System.out.println("\n\t\t\tVictoire de " + tab_dress.get(i) + " !\n\n");
								
							}

							// sinon, c'est une egalite
							else{

								System.out.println("\n\n\t\tEgalite !\n\n");

							}

						}

						// les pokemons de l'adversaire sont soignes en cas de victoire, defaite, egalite ou abandon
						tab_dress.get(i).infirmerie();
		
						break;
		
					}
		
				}
			}else{
				
				// on ne fais pas de combat, donc au tour suivant on pourra combattre
				deja_combatu = false;
				
				// si on est dans l'infirmerie, on soigne nos pokemons et on affiche qu'ils ont bien ete soignes
				if (cases[joueur.getPosY()][joueur.getPosX()] == 3){ 
		
					joueur.infirmerie();
		
					System.out.println("Vous avez soigne vos pokemons !");
		
				}
		
				// on demande a l'utilisateur de bouger
				char direction = lire();
		
				bouger(direction);
		
				clearScreen();
			}
		}

		if (nbDresseursActifs == 0) {

			clearScreen();

			System.out.println(
				"888     888 8888888 .d8888b. 88888888888 .d88888b. 8888888 8888888b.  8888888888 " + "\n" +
				"888     888   888  d88P  Y88b    888    d88P\" \"Y88b  888   888   Y88b 888        " + "\n" +
				"888     888   888  888    888    888    888     888  888   888    888 888        " + "\n" +
				"Y88b   d88P   888  888           888    888     888  888   888   d88P 8888888    " + "\n" +
				" Y88b d88P    888  888           888    888     888  888   8888888P\"  888        " + "\n" +
				"  Y88o88P     888  888    888    888    888     888  888   888 T88b   888        " + "\n" +
				"   Y888P      888  Y88b  d88P    888    Y88b. .d88P  888   888  T88b  888        " + "\n" +
				"    Y8P     8888888 \"Y8888P\"     888     \"Y88888P\" 8888888 888   T88b 8888888888 \n\n");

		}

		if (joueur.getDefaites() == (int)(nbDresseurs/2)){
			
			clearScreen();

			System.out.println(
				"8888888b.  8888888888 8888888888     d8888 8888888 88888888888 8888888888 " + "\n" +
				"888  \"Y88b 888        888           d88888   888       888     888        " + "\n" +
				"888    888 888        888          d88P888   888       888     888        " + "\n" +
				"888    888 8888888    8888888     d88P 888   888       888     8888888    " + "\n" +
				"888    888 888        888        d88P  888   888       888     888        " + "\n" +
				"888    888 888        888       d88P   888   888       888     888        " + "\n" +
				"888  .d88P 888        888      d8888888888   888       888     888        " + "\n" +
				"8888888P\"  8888888888 888     d88P     888 8888888     888     8888888888 \n\n");

		}
	}
}
