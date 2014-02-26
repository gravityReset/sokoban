package sokoban;
import java.util.Scanner;

public class Launcher
{

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("coucou");
		
		// ---------- test timer (attendre 3sec) -------------
		Timer.StartTimer();
		
		Thread.sleep(3000);
		
		
		
		System.out.println(Timer.StopTimer());
		//----------------- Fin Test Timer ------------------- 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un mot :");
		String str = sc.nextLine();
		char carac = str.charAt(0);
		System.out.println("Vous avez saisi la lettre: " + carac);
	}

}
