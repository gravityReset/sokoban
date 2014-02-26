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
	 * D�tection de la touche appuy�e
	 * @return l'entr�e clavier
	 */
	public char NextEntree(){

		String str = sc.nextLine();
		char carac = str.charAt(0);
		return carac;
	}
	
	public String NextLine(){
		String str = sc.nextLine();
		return str;
	}

}
