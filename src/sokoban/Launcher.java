
package sokoban;

import sokoban.Utils.MapCreator;
import sokoban.Utils.Score;
import sokoban.Utils.Timer;

public class Launcher
{

	public static void main(String[] args)
	{
		try
		{
			System.out.println("_______________SOKOBAN______________");
			System.out.println("____________________________________");
			String choixJeu = args[0];

			String lvl;
			if (args[1] != null)
				lvl = args[1];
			else
				lvl = "1";
			
			switch (choixJeu)
			{
			case "--create":
				MapCreator mc = new MapCreator();
				mc.Save();
				break;
				
				
			case "--score":
				int levl = Integer.parseInt(lvl);
				
				Score.ShowScore(levl);
				
				break;
				
				
			case "--level":
				

				// ====================== JEU ========================
				int level = Integer.parseInt(lvl);
				Map map = new Map(level);
				map.Load();
				map.Show();

				Timer.StartTimer();

				while (true)// on arrete seulement si on a gagné
				{

					// Si tout les Storage sont rempli, on arrete la partie :
					if (map.CountStorageFull())
						break;
					else
					{
						map.Deplacer();
						map.Show();
					}

				}

				long score = Timer.StopTimer();

				Score.AddScore(score, level);

				// =================== FIN JEU =======================
				break;
			default:
				break;
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
