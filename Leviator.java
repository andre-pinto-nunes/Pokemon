public class Leviator extends Eau{
	/**
	 * Leviator est un pokemon de type Feu et Eau
	 */

	private Feu f;

	public Leviator (String nom, int pvmax, int attaque){

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

	public Leviator(){

		this("Leviator", 200, 50);
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
		return 	"          PV :" + health_bar() + "                                           "	+ "\n" + 
				"                                  " 			+ "\n" + 
				"" + super.toString() + "                                                     "						+ "\n" +
				"                                                                             "     				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                                                                             "        				+ "\n" +				
				"                            /|                                               " 					+ "\n" +
				"                /`     |   / |                                               " 					+ "\n" +
				"               . |     |`.'  |  ,          .                                 " 					+ "\n" +
				"               | |     |     `\"'/       _,'           ,\"'                    " 					+ "\n" +
				"               | |     |       /      .\" ,'         ,'/_                     " 					+ "\n" +
				"               | |   ,\"| .-\"\"\"''`,`.,'  /      /|  /  ' )                    " 				+ "\n" +
				"     .'.       | |\"\"+._|'   .    '     ,__    / ) /   .'                     " 					+ "\n" +
				"      `.`.   .'| |     '_,\".`     \\     .'   '   '   /  _                    " 					+ "\n" +
				"        `.`./ j  |  _,-'_,'.       `-..'    .        `-'/                    " 					+ "\n" +
				"         _\\' `   |,\" _.' `. `.     _..|     |         ,'                     " 					+ "\n" +
				" .    .\"'  \\._____.-' '    `-|  .-'  ,|    _|   ___  /                       " 					+ "\n" +
				"  \\`._ `-. `|.___,'| /     _.'      / |  ,\" |.-'   `.'.                      " 					+ "\n" +
				"   \\-.`\"-'  _______`'    ,' __.---.' ,^.' _.'_    __ `.`.                    " 					+ "\n" +
				"   |    `-.,...... `.   |,-\"     / .'. |-'    `-.\"  | |` \\                   " 					+ "\n" +
				"   '      ||\\/  |/`.|  .`       (,'   `|         `.'  '.| \\                  " 					+ "\n" +
				"   `-..--.||       || j      ____\\     |       _  |  /     `.---------.      " 					+ "\n" +
				"      |   ||  ___..|||,.--\"\"'|.      .\"|     ,' | |\"/ `. ,'. .   ,.--\"       " 				+ "\n" +
				"      |  .||.'      ||.._    ' )  _,'\\ |`'-.'   | |/    ||.' |   `.          " 					+ "\n" +
				"      |,',|||      . |\"-.`._  `+`\"    \"      `.'  ^,.__,'.   |  ,--'         " 					+ "\n" +
				"       // |||      |j  |\\\\  \"'  `.     |   ,-` `./ '     |   |`.\\            " 				+ "\n" +
				"      .'  |||      ||  | .'      |   .\"`..|_ |  .   \\    |  /|               " 					+ "\n" +
				"      ||  ||`.___.'f   ' ||     ,'--\"`._|,-.`|  '    +.._|,'.|               " 					+ "\n" +
				"      ||  |`-.....'|    .'`.\"\"'`.       /\\ | `.'     |    |  |               " 					+ "\n" +
				" .'`  ''   `--....-'    | \\|   ``\\     '  \\|   |     |`._,'-\"'               " 				+ "\n" +
				" |`..''                 |  '    )|.   /`..|'   '     |   \\  /                " 					+ "\n" +
				"  `\"\"'                  |   `-..''|  /    |   /    _..\"`.` /                 " 					+ "\n" +
				"                        `         |,'     |  /  ,\"'_,|     \\                 " 					+ "\n" +
				"                         `,_   _.-'.      |,' .'-'\"  '    , \\                " 					+ "\n" +
				"                          `.\"\"'     `.   .' .'      /   ,' | .               " 					+ "\n" +
				"                            `._       \\,'  .       /   /   | |               " 					+ "\n" +
				"                               `\"----\"'     \\  _  /  ,'    | |               " 					+ "\n" +
				"                                             `\" 7._,`      | |               " 					+ "\n" +
				"                                                    \\      | '               " 					+ "\n" +
				"                                                     `-. ,.|/                " 					+ "\n" +
				"                                                        '  |                 ";
	}
}