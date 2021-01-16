public class Gobou extends Eau {
	/**
	 * Gobou est un pokemon de type Eau et Terre
	 */

	private Terre t;

	public Gobou (String nom, int pvmax, int attaque){
		super(nom, pvmax, attaque);

		t = new Terre(nom, pvmax, attaque);

		if (nbAttaques < 5)
		{
			attaquesDisponibles[nbAttaques++] = "Ampleur";
		}
	}

	public Gobou(){

		this("Gobou", 200, 50);

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
		return 	"          PV :" + health_bar() + "                                           "	+ "\n" + 
				"                                  " 			+ "\n" + 
				"" + super.toString() + "                                                     "						+ "\n" +
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                                                                                           "        				+ "\n" +				
				"                             ',-~^'\"'^*~-,_                                                " + "\n" +
				"                            f           '| \"'-,                                            " + "\n" +
				"                          f'\\            |     '\\,                                         " + "\n" +
				"                          |' '\\           |      '\\,                                       " + "\n" +
				"                          |    '\\          |       '\\,                                     " + "\n" +
				"                          '|,    '\\         |        '|                                    " + "\n" +
				"                           '\\      '\\        '|        '|                                  " + "\n" +
				"                             '\\      \\       '|,        '|                                 " + "\n" +
				"                              '\\      \\       '|         '|,                               " + "\n" +
				"                                '\\     '\\       |         |                                " + "\n" +
				"                                  '\\     '\\      '|,      '|                               " + "\n" +
				"                                    '\\           '|      '|_                               " + "\n" +
				"                                     ,'\\-~               |\"\"'*^~,                          " + "\n" +
				"   ,-----,_                      ,~\"                   '|        *^-,                      " + "\n" +
				"  f        \"'~,              ,~'                       '            '/~, _,--~/            " + "\n" +
				"  |            '~,        ,/'                             ,-,       |' '\\'\"   /            " + "\n" +
				"  '|              '~,   ,/'_            ,--,            '|   '\\   '|    '\\    '~-,_        " + "\n" +
				"  '|\"'^~-,_         '\\,/^\" \"'~-,       |    \\           '\\   '|    '|      |         \",>   " + "\n" +
				"   |        \"'~-, . \\~--,|_     '~,    '\\    |'            '\"      '|    /       ,~'       " + "\n" +
				"   '|             \"'~\\     \"'~-    '\\      \"                _,-~^*/|   /     ,~'           " + "\n" +
				"    '|               /'              '\\~---,,_____,,,---~^*'\"-,   /''\\/-,___'\\             " + "\n" +
				"     '|             ,/'               '|                      '\\f    f                     " + "\n" +
				"      '|          /                /   |\\                   _.,~\" _,~'                     " + "\n" +
				"       '\\,       /__,,,----,--,   /-,_|' .'~-,_        __,-~_,-^'\"                         " + "\n" +
				"         '\\~-,___     ,/'    '\\ '/     \"'^~---,,_\"''''''''\"_,,-~/'\"'~-,_                   " + "\n" +
				"          '\\,        \"/       V ,            |/ \"'''''''\"     /          \"'^~-,            " + "\n" +
				"             '~,     /        '\\  '|            |          ,~',__           _,/'           " + "\n" +
				"                '~-,,|           '\\,'|            |   _,,-~/'    \"''*^~~^*\"                " + "\n" +
				"                    '|          f  '\\           |\\\"   f                                    " + "\n" +
				"                      \\      ,~'     '\\         |  '~-~'                                   " + "\n" +
				"                        '~~'           '^~,,,/'                                            ";
	}
}