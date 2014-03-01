package sokoban;

import java.io.Console;
import java.util.ArrayList;

import sokoban.Elements.Element;
import sokoban.Elements.ElementNonMovable;
import sokoban.Elements.Storage;
import sokoban.Utils.MapCreator;
import sokoban.Utils.Score;
import sokoban.Utils.Timer;

public class Launcher
{

	public static void main(String[] args) 
	{
		try
		{
			System.out.println("coucou");
			 
			String choixJeu = args[0];
			
			switch(choixJeu)
			{
				case "--create":
				{
					MapCreator mc = new MapCreator();
					mc.Save();
					break;
				}
				case "--level":
				{
					System.out.println("tu as tape --level");
					String lvl=args[1];
					
					// ====================== JEU ========================
					int level=Integer.parseInt(lvl);
					Map map = new Map(level);
					map.Load();
					map.Show();
					
					Timer.StartTimer();
					
					int i=0;
					int nbStorage=0;
					int nbStorageTrue;
					
					
					// On compte le nombre d'éléments Storage non-remplis au début de la map :
					for (ArrayList<ElementNonMovable> nomStorage : map.getStructure() ) {
						for (ElementNonMovable Storage : nomStorage) {
							if(Storage instanceof Storage)
							{
								nbStorage +=1;
							}
						}
					} 

					nbStorageTrue = nbStorage;
					
					System.out.println(nbStorage);
					
					while(i!=100)

					{
						//On compte le nombre de Storage full:
						for (ArrayList<ElementNonMovable> nomStorage : map.getStructure() ) {
							for (ElementNonMovable Storage : nomStorage) {
								if(Storage instanceof Storage)
								{
									if(Storage.full==true)
										nbStorageTrue -=1;
									
								}
							}
						}
						
						// Si tout les Storage sont rempli, on arrete la partie :
						if (nbStorageTrue ==0)
							break;
						else
						{
							nbStorageTrue = nbStorage;
							map.Deplacer();
							map.Show();
							i++;
						}
						
						

					}
					
					// ---------- test timer (attendre 3sec) -------------
					long score = Timer.StopTimer();
					System.out.println(score);
					//----------------- Fin Test Timer ------------------- 
					Score.AddScore(score, level);
					
					// =================== FIN JEU =======================
					break;
				}
				default:
					break;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
		
		
		
	}

}
