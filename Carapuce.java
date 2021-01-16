public class Carapuce extends Eau{

	public Carapuce (String nom, int pvmax, int attaque){

		super(nom, pvmax, attaque);
	}

	public Carapuce(){

		this("Carapuce", 200, 50);
	}	

	@Override
	public void talent(){
		
		/**
		 * Carapuce recupere 10% de ses PVmax a chaque tour, sans depasser ses PVmax
		 */

		pv += 0.1 * pvmax;
		
		if (pv > pvmax) {pv = pvmax;}		
	}

	@Override
	public String toString(){		
		return 	"          PV :" + health_bar() + "                                           "	+ "\n" + 
				"                                  " 			+ "\n" + 
				"" + super.toString() + "                                         "							+ "\n" +
				"                                                                     "     				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"                                                                     "        				+ "\n" +				
				"               _,........__                                          "        				+ "\n" +
				"            ,-'            \"`-.                                      "       				+ "\n" +
				"          ,'                   `-.                                   "        				+ "\n" +
				"        ,'                        \\                                  "       				+ "\n" +
				"      ,'                           .                                 "        				+ "\n" +
				"      .'\\               ,\"\".       `                                 "       			+ "\n" +
				"     ._.'|             / |  `       \\                                "       				+ "\n" +
				"     |   |            `-.'  ||       `.                              "        				+ "\n" +
				"     |   |            '-._,'||       | \\                             "       				+ "\n" +
				"     .`.,'             `..,'.'       , |`-.                          "        				+ "\n" +
				"     l                       .'`.  _/  |   `.                        "        				+ "\n" +
				"     `-.._'-   ,          _ _'   -\" \\  .     `                       "      				+ "\n" +
				"`.\"\"\"\"\"'-.`-...,---------','         `. `....__.                     "    			+ "\n" +
				".'        `\"-..___      __,'\\          \\  \\     \\                    "    			+ "\n" +
				"\\_ .          |   `\"\"\"\"'    `.           . \\     \\                   "  			+ "\n" +
				"  `.          |              `.          |  .     L                  "        				+ "\n" +
				"    `.        |`--...________.'.        j   |     |                  "        				+ "\n" +
				"      `._    .'      |          `.     .|   ,     |                  "        				+ "\n" +
				"         `--,\\       .            `7\"\"' |  ,      |                  "      			+ "\n" +
				"            ` `      `            /     |  |      |    _,-'\"\"\"`-.    "      			+ "\n" +
				"             \\ `.     .          /      |  '      |  ,'          `.  "       				+ "\n" +
				"              \\  v.__  .        '       .   \\    /| /              \\ "      			+ "\n" +
				"               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |"       	+ "\n" +
				"                `        .        `._ ___,j.  `/ .-       ,---.     |"        				+ "\n" +
				"                ,`-.      \\         .\"     `.  |/        j     `    |"        			+ "\n" +
				"               /    `.     \\       /         \\ /         |     /    j"        			+ "\n" +
				"              |       `-.   7-.._ .          |\"          '         / "       				+ "\n" +
				"              |          `./_    `|          |            .     _,'  "        				+ "\n" +
				"              `.           / `----|          |-............`---'     "        				+ "\n" +
				"                \\          \\      |          |                       "        			+ "\n" +
				"               ,'           )     `.         |                       "        				+ "\n" +
				"                7____,,..--'      /          |                       "        				+ "\n" +
				"                                  `---.__,--.'                       ";
	}
}