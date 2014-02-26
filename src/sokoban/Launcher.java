package sokoban;

import sokoban.Utils.Timer;

public class Launcher
{

	public static void main(String[] args) 
	{
		System.out.println("coucou");
		
		
		Map map = new Map(1);
		map.Load();
		
		map.Show();
		int i=0;
		while(i!=20)
		{
			map.Deplacer();
			map.Show();
			i++;
		}
		
		// ---------- test timer (attendre 3sec) -------------
		Timer.StartTimer();
		
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(Timer.StopTimer());
		//----------------- Fin Test Timer ------------------- 
		
		
	}

}
