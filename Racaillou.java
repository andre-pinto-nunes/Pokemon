public class Racaillou extends Terre{

	public Racaillou (String nom, int pvmax, int attaque){

		super(nom, pvmax, attaque);
	}


	public Racaillou(){

		this("Racaillou", 200, 50);
	}

	@Override
	public void subire(Pokemon adversaire, int degats){
		
		/**
		 * Racaillou a 70% de chances de subir 85% de degats et 30% de chances d'esquiver l'attaque (et rien subire)
		 */
		
		if(Math.random() > 0.3){
		
			super.subire(adversaire, (int)(0.85*degats));
		
		}else{
			
			// aucun degat subit pas d'appel subire()

			System.out.println ("\t\t" + this.nom + " s'est esquive !");	
		
		}
	}

	@Override
	public String toString(){		
		return 	"          PV :" + health_bar() + "                                                   "	+ "\n" + 
				"                                  " 			+ "\n" + 
				"" + super.toString() + "                                                 "							+ "\n" +
				"                                                                         "     				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                                                         "        				+ "\n" +				
				"                                            _,.---.                      " + "\n" +
				"                                        _,-'       `.                    " + "\n" +
				"                                     _,'  ,          \\                   " + "\n" +
				"                                   ,'  _,'   .        `.                 " + "\n" +
				"                                  /  ,'     ,'          `.               " + "\n" +
				"         __                       .,'    _,'              `.             " + "\n" +
				"    _,..'  `-....___              :    ,'     '             \\            " + "\n" +
				"  ,'   /            :             /`.,'      /               `           " + "\n" +
				" /    /  ._         |         __..|  `.    .'       ,         `.         " + "\n" +
				" |   |   ,'\"--._    |      ,-'    `-._`.,-'       ,:            .        " + "\n" +
				".'\\   \\     _,'.    `'___.'           `\"`.     _,' /            |        " + "\n" +
				"|  \\   \\---'       ,\"'  .-\"\"'\"----.       `.  '  ,'             |        " + "\n" +
				" `. `-.'          /    /                    `-..^._             '        " + "\n" +
				"   |._|    _.    /    /                            `._           .       " + "\n" +
				"   `...:--'--+..'   ,'                              /            |       " + "\n" +
				"       '._  `|   ,-'       _..._                   j     \\       |       " + "\n" +
				"         |` |   /       ,-'     `-.__              |      L      |       " + "\n" +
				"         |  |  /      ,'                           |      |      |       " + "\n" +
				"         |_,'        /         _,-                  .     |      |       " + "\n" +
				"        ,'  ,   |  ,'        ,|            ,..._     \\    |      '       " + "\n" +
				"       ,     \\ j  '       _.\" |           /     `-.__'    '    ,'        " + "\n" +
				"        +._   '|       ,'|    |          /        ,'    .'    /          " + "\n" +
				"        |  `._  `-' .:|  |    '.       -'        '           j           " + "\n" +
				"        '    |`    ' |'  |     |                             |           " + "\n" +
				"         `.  |       |--'     _|        .                    |           " + "\n" +
				"           \\ |       '----'\"\"\"           \\      __,....-+----'           " + "\n" +
				"           | '                            `---\"\"      .'                 " + "\n" +
				"           `. `.                                     ,                   " + "\n" +
				"             `\" \\_...-\"\"\"'--..         _+          ,'                    " + "\n" +
				"                  '            -.'  `-'  `.  .\"-..'                      " + "\n" +
				"                   `-..._            _____,.'                            " + "\n" +
				"                         `--.....,-\"'                                    ";
	}
}