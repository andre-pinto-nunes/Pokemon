public class Pikachu extends Electricite{

	public Pikachu (String nom, int pvmax, int attaque){

		super(nom, pvmax, attaque);
	}

	public Pikachu(){

		this("Pikachu", 200, 50);
	}

	@Override
	public void attaque (Pokemon adversaire){
		
		/**
		 * Pikachu a 20% de chances de paralyser son adversaire pour 2 tours a chaque fois qu'il attaque
		 */
		
		super.attaque(adversaire);
		
		if (Math.random() < 0.2) {
		
			adversaire.paralyse += 2;	
		
		}
	}

	@Override
	public String toString(){		
		return 	"          PV :" + health_bar() + "                              "									+ "\n" + 
				"                             "											+ "\n" + 
				"" + super.toString() + "                                        "											+ "\n" +				
				"                                             ,-.         " + "\n" +
				"                                          _.|  '         " + "\n" +
				"                                        .'  | /          " + "\n" +
				"                                      ,'    |'           " + "\n" +
				"                                     /      /            " + "\n" +
				"                       _..----\"\"---.'      /             " + "\n" +
				" _.....---------...,-\"\"                  ,'              " + "\n" +
				" `-._  \\                                /                " + "\n" +
				"     `-.+_            __           ,--. .                " + "\n" +
				"          `-.._     .:  ).        (`--\"| \\               " + "\n" +
				"               7    | `\" |         `...'  \\              " + "\n" +
				"               |     `--'     '+\"        ,\". ,\"\"-        " + "\n" +
				"               |   _...        .____     | |/    '       " + "\n" +
				"          _.   |  .    `.  '--\"   /      `./     j       " + "\n" +
				"         \\' `-.|  '     |   `.   /        /     /        " + "\n" +
				"         '     `-. `---\"      `-\"        /     /         " + "\n" +
				"          \\       `.                  _,'     /          " + "\n" +
				"           \\        `                        .           " + "\n" +
				"            \\                                j           " + "\n" +
				"             \\                              /            " + "\n" +
				"              `.                           .             " + "\n" +
				"                +                          \\             " + "\n" +
				"                |                           L            " + "\n" +
				"                |                           |            " + "\n" +
				"                |  _ /,                     |            " + "\n" +
				"                | | L)'..                   |            " + "\n" +
				"                | .    | `                  |            " + "\n" +
				"                '  \\'   L                   '            " + "\n" +
				"                 \\  \\   |                  j             " + "\n" +
				"                  `. `__'                 /              " + "\n" +
				"                _,.--.---........__      /               " + "\n" +
				"               ---.,'---`         |   -j\"                " + "\n" +
				"                .-'  '....__      L    |                 " + "\n" +
				"              \"\"--..    _,-'       \\ l||                 " + "\n" +
				"                  ,-'  .....------. `||'                 " + "\n" +
				"               _,'                /                      " + "\n" +
				"             ,'                  /                       " + "\n" +
				"            '---------+-        /                        " + "\n" +
				"                     /         /                         " + "\n" +
				"                   .'         /                          " + "\n" +
				"                 .'          /                           " + "\n" +
				"               ,'           /                            " + "\n" +
				"             _'....----\"\"\"\"\"                             ";
	}
}