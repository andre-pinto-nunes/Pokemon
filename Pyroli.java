public class Pyroli extends Feu{
	/**
	 *Pyroli est un pokemon de type Feu et Terre
	 */

	private Terre t;

	public Pyroli (String nom, int pvmax, int attaque){
	
		super(nom, pvmax, attaque);

		t = new Terre(nom, pvmax, attaque);

		if (nbAttaques < 5){
	
			attaquesDisponibles[nbAttaques++] = "Ampleur";
	
		}
	}

	public Pyroli(){
	
		this("Pyroli", 200, 50);
	}

	@Override
	public Pokemon get_secondary_type(){return t;}

	@Override
	public void attaque (Pokemon adversaire, String choixAttaque){

		// si on choisi une attaque type Terre, c'est la "personnalite" t qui attaque, sinon c'est sa "personnalite" principale qui attaque
		if (choixAttaque == "Ampleur"){

			t.attaque(adversaire, choixAttaque);

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
				"                         /|     '                                            " 					+ "\n" +
				"                        / `.  ,'|,-.____                                     " 					+ "\n" +
				"                       /    `'  `       `\"\"----...,                          " 					+ "\n" +
				"             .    ,__.'                        .-'._                         " 					+ "\n" +
				"            / |   ' .'                   ,_         `'`--.._                 " 					+ "\n" +
				"         _.'  . ,'                        `.`-._            `'.              " 					+ "\n" +
				"        |      `                            .  .`-._,\"'--._    `-.           " 					+ "\n" +
				"     ,_.'     `                              `. .`._`.     `-._   '          " 					+ "\n" +
				"      .                                     ..'  `. `.`.       `-. `.        " 					+ "\n" +
				"      |                                       `.   `. `.`.        `. \\       " 					+ "\n" +
				"      |                                       ,',.'\"-\\  \\ `.         `       " 					+ "\n" +
				"    ,-'                                       /     .\"\\  `  \\                " 					+ "\n" +
				"     .                              '`._ ,.  /      |  '  `. \\               " 					+ "\n" +
				" ..._)                               |  \"  `.        `-'.  |  .              " 					+ "\n" +
				"   \\        '.---.._'._  .\"'-._     .'      |            `.|  '              " 					+ "\n" +
				"    `.         `._ .._ `-'     `.`-.|       '              ` /               " 					+ "\n" +
				"      `.          `-. `. `-.__   '-  `._     \\              |.               " 					+ "\n" +
				"       L_            `._ `.   `\"--..__  `\"-../\\             ||-.,\\           " 				+ "\n" +
				"         `.'            `-.`.         `-._     `-._       .' |`.  \\          " 					+ "\n" +
				"            .           _..`.`.._       ..`      __`\"-..-'   |.'  '-'        " 					+ "\n" +
				"            /___     .\"'     `-._`\"----\"'   `  .( )`.          `.  .         " 					+ "\n" +
				"                -.,./      `\"\"   `\"\"'\"\"'`--.   `._   `.        /    \\        " 				+ "\n" +
				"                   /        ,               `._   `\"\"'  _____.'      '       " 					+ "\n" +
				"                             .                 `._      \"...'       /        " 					+ "\n" +
				"                  .         .'                    `\"\"-----'        ' _       " 					+ "\n" +
				"                  '         `-.                                    .'        " 					+ "\n" +
				"                ,'            /                                   _,         " 					+ "\n" +
				"               /         _..-\"|\"--..                             |           " 					+ "\n" +
				"              /       .\"'     |  .'.,----,                  ,.-'\"|           " 					+ "\n" +
				"             .      ,'        |     \\   `--'.        __...-\"`...-'           " 					+ "\n" +
				"             '     /          '      \\       `-----\"'                        " 					+ "\n" +
				"            /     '            .      \\        \\                             " 					+ "\n" +
				"           .       .           '._,'_.'`.       \\                            " 					+ "\n" +
				"           '._.  ).'                    `        `.                          " 					+ "\n" +
				"              `\"'                        \\         `                         " 					+ "\n" +
				"                                          `.   .   ,'                        " 					+ "\n" +
				"                                            `\"-'--'                          ";
	}
}