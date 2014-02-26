package sokoban;

import sokoban.Utils.Timer;

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
		

	}

}
