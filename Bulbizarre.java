public class Bulbizarre extends Herbe{

	private boolean pv_superieur_a_un_tiers = true;
	
	public Bulbizarre (String nom, int pvmax, int attaque){

		super(nom, pvmax, attaque);
	}

	public Bulbizarre(){

		this("Bulbizarre", 200, 50);
	}

	@Override
	public void talent(){
		
		/**
	 	 * Augmente le multiplicateur (attaque) de bulbizarre de 150 % si ses points de vie tombent en dessous de 1/3, pour un seul tour.
	 	 * La methode super.attaque() remet le multiplicateur a 1 a la fin de l'attaque
	 	 * Si on choisi vege-attaque, le talent se maintient au tour suivant
	 	 */

		if((pv <= (int)((double)(pvmax)/3)) && pv_superieur_a_un_tiers){				// si on descend en dessous de 1/3*PV et 'pv_superieur_a_un_tiers == true' (c'est a dire, on était au dessus de 1/3*PV)

			multiplicateur *= 1.5;  													// on augmente de 50% l'attaque Totale (stack avec d'autres multiplicateurs)

			pv_superieur_a_un_tiers = false;											// on change 'pv_superieur_a_un_tiers' en false => on passe en dessous de 1/3*PV

		}else if((pv >= (int)((double)(pvmax)/3)) && !pv_superieur_a_un_tiers){			// si on passe au dessus de 1/3*PV et 'pv_superieur_a_un_tiers == false' (c'est a dire, on était en dessous de 1/3*PV)

			pv_superieur_a_un_tiers = true;												// on change 'pv_superieur_a_un_tiers' en true => on passe au dessus de 1/3*PV

		}
	}	

	@Override
	public String toString(){		
		return 	"          PV :" + health_bar() + "                                           "	+ "\n" + 
				"                                  " 			+ "\n" + 
				"" + super.toString() + "                                                     "						+ "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                                            " + "\n" +
				"                                           /                " + "\n" +
				"                        _,.------....___,.' ',.-.           " + "\n" +
				"                     ,-'          _,.--\"        |           " + "\n" +
				"                   ,'         _.-'              .           " + "\n" +
				"                  /   ,     ,'                   `          " + "\n" +
				"                 .   /     /                     ``.        " + "\n" +
				"                 |  |     .                       \\.\\       " + "\n" +
				"       ____      |___._.  |       __               \\ `.     " + "\n" +
				"     .'    `---\"\"       ``\"-.--\"'`  \\               .  \\    " + "\n" +
				"    .  ,            __               `              |   .   " + "\n" +
				"    `,'         ,-\"'  .               \\             |    L  " + "\n" +
				"   ,'          '    _.'                -._          /    |  " + "\n" +
				"  ,`-.    ,\".   `--'                      >.      ,'     |  " + "\n" +
				" . .'\\'   `-'       __    ,  ,-.         /  `.__.-      ,'  " + "\n" +
				" ||:, .           ,'  ;  /  / \\ `        `.    .      .'/   " + "\n" +
				" j|:D  \\          `--'  ' ,'_  . .         `.__, \\   , /    " + "\n" +
				"/ L:_  |                 .  \"' :_;                `.'.'     " + "\n" +
				".    \"\"'                  \"\"\"\"\"'                    V       " + "\n" +
				" `.                                 .    `.   _,..  `       " + "\n" +
				"   `,_   .    .                _,-'/    .. `,'   __  `      " + "\n" +
				"    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .     " + "\n" +
				"   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |     " + "\n" +
				"  .   _  `\"\"'--.._____..--\"   ,             '         |     " + "\n" +
				"  | .\" `. `-.                /-.           /          ,     " + "\n" +
				"  | `._.'    `,_            ;  /         ,'          .      " + "\n" +
				" .'          /| `-.        . ,'         ,           ,       " + "\n" +
				" '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'        " + "\n" +
				" `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--'         ";
	}
}