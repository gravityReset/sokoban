package sokoban.Utils;
import java.util.Scanner;

public class EntreeClavier {
	
	private Scanner sc;
	
	/**
	 * Constructeur du Scanner
	 */
	public EntreeClavier() {
		sc = new Scanner(System.in);
	}

	/**
	 * Détection de la touche appuyée
	 * @return l'entrée clavier
	 */
	public String NextEntree(){

		String str = sc.nextLine();
		char carac = str.charAt(0);
		return String.valueOf(carac);
	}
	
	public String NextLine(){
		String str = sc.nextLine();
		return str;
	}

}
