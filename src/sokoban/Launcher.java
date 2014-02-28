package sokoban;

import sokoban.Utils.MapCreator;
import sokoban.Utils.Score;
import sokoban.Utils.Timer;

public class Launcher
{

	public static void main(String[] args) 
	{
		System.out.println("coucou");
		
		MapCreator mc = new MapCreator();
		mc.Save();
		
		/*
		
		Map map = new Map(1);
		map.Load();
		Timer.StartTimer();
		
		map.Show();
		int i=0;

		int level=1;
		while(i!=20)
		{
			map.Deplacer();
			map.Show();
			i++;
		}
		
		// ---------- test timer (attendre 3sec) -------------
		long score = Timer.StopTimer();
		//----------------- Fin Test Timer ------------------- 
		Score.AddScore(score, level);
		*/
	}

}
