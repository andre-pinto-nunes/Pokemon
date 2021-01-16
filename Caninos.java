public class Caninos extends Herbe{
	/**
	 * Caninos est un pokemon de type Herbe et Feu
	 */

	private Feu f;

	public Caninos (String nom, int pvmax, int attaque){
		super(nom, pvmax, attaque);

		f = new Feu(nom, pvmax, attaque);
		
		if (nbAttaques < 4)	{

			attaquesDisponibles[nbAttaques++] = "boutefeu";

			attaquesDisponibles[nbAttaques++] = "surchauffe";

		}

		else if (nbAttaques < 5){

			attaquesDisponibles[nbAttaques++] = "boutefeu";

		}
	}

	public Caninos(){

		this("Caninos", 200, 50);

	}

	@Override
	public Pokemon get_secondary_type(){return f;}

	@Override
	public void attaque (Pokemon adversaire, String choixAttaque){

		// si on choisi une attaque type feu, c'est la "personnalite" f qui attaque, sinon c'est sa "personnalite" principale qui attaque
		if(choixAttaque == "boutefeu" || choixAttaque == "surchauffe"){
		
			f.attaque(adversaire, choixAttaque);
		
		}else{
		
			super.attaque(adversaire, choixAttaque);
		
		}
	}

	@Override
	public String toString(){
		return 	"          PV :" + health_bar() + "                                           "						+ "\n" + 
				"                                                                             "        				+ "\n" +
				"" + super.toString() + "                                                     "						+ "\n" +
				"                                                                             "     				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                   _,                                                        " 					+ "\n" +
				"                 .',_..,                                                     " 					+ "\n" +
				"               ,'     /,--                                                   " 					+ "\n" +
				"             .'       ,./.__                                                 " 					+ "\n" +
				"             |_,.----/,,'`.  _                                               " 					+ "\n" +
				"            .'__     //    `...>                                             " 					+ "\n" +
				"       ____//|) |    `      /.'                                              " 					+ "\n" +
				"      (/    `-.-'.._     _,|                 ,.-------.._                    " 					+ "\n" +
				"      .             `.  '   \\               /            `-._                " 					+ "\n" +
				"      `..---._       |       `.            j                 `.              "				 		+ "\n" +
				"        >-,-\"`\"\"'    |        |`\"+-..__    |              -. `-.             " 				+ "\n" +
				"       ( /|         /____     |  |  |  \\\"\"|+-.._     ___    `.  `.           " 					+ "\n" +
				"        \" `-..._     \"--,_    |  |  `   | |   | `.-.\"   \"-._  |  -`          " 				+ "\n" +
				"             ,'        '_>_   j ,'  '. ,` |,  |   `. `.-v.' `-+..._`.        " 					+ "\n" +
				"            '.         >       '     | |  ' \\ L     ..`.  '        `._       " 					+ "\n" +
				"             '.       /              '|`     \\|      '^,         ..,{ `.     " 					+ "\n" +
				"            / /      /                '       v          |__    ___,'\"\"      " 					+ "\n" +
				"          ,'  >---+-+.        |   __,..--\"`-._          /.-'`\"----'          " 					+ "\n" +
				"         /`.       `. '.      |-\"'            `\"--....-'._                   " 					+ "\n" +
				"       .'___'        `._`,    j             ___,-','      `-..._             " 					+ "\n" +
				"  _ _.'    '/.-          '  ,'       __..<\"\"__,.-'              `.           " 					+ "\n" +
				" `.)         |'---\"\"`.+-.--'-------\"\"-...__  ,-'/ .\"\\          _  |          " 				+ "\n" +
				",\"\\ ,--.  _,-          ` `'                `'\"\"\"'`\"'\"\"\"`--._  . `/           " 			+ "\n" +
				" `-`.___.'                                                  `\"-\"'            "					+ "\n" +
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             ";
	}
}