public class Combat{
	public static void main(String[] args) {
		/* Note:
		 * pour que l'affichage se passe correctement, 
		 * il faut beaucoup de place sur l'ecran (la totalite de l'ecran)
		 * s'il y a un probleme d'affichage, redimensionez le terminal
		 *
		 * Ceci a ete teste sur PowerShell et sur le terminal debian (en salle tme)
		 */
		  
//		Dresseur d_a = new Joueur("Anne");
//		Dresseur d_b = new Dresseur("Basile");
//		d_a.combat(d_b);

		Monde m = new Monde(10, 10, 0.1, 2);

		// on choisi le OS (pour un bon fonctionnement de la fonction clearScreen())
		// par defaut l'OS choisi est Linux
		m.choix_OS();
		
		// on choisi le clavier (pour un bon fonctionnement de la fonction bouger())
		// par defaut le clavier choisi est AZERTY
		m.choix_clavier();
		
		m.jouer();

	}
}