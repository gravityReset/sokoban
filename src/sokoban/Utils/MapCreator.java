
package sokoban.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MapCreator
{

	ArrayList<String> map;


	MapCreator()
	{
		Boolean personnage = false;

		map = new ArrayList<String>();
		EntreeClavier ec = new EntreeClavier();
		do
		{
			String m = ec.NextLine();
			String stringToSave = ""; // string qu'on va enregistrer apr�s
										// chaque truc

			if (m != "exit")
			{
				for (int i = 0; i < m.length(); i++)// on parcours la ligne pour
													// v�rifier les entr�s
				{
					if (m.charAt(i) == 'X') // si c'est un personnage
						if (!personnage) // si il y en a
						{
							personnage = true; // on passe a vraie
							stringToSave += m.charAt(i);
						}
						else
							stringToSave += ' ';

					// les entr�s non valide sont remplac� par espace
					else if (m.charAt(i) != ' ' && m.charAt(i) != 'O'
							&& m.charAt(i) != 'B' && m.charAt(i) != '=')
						stringToSave += ' ';

					else
						stringToSave += m.charAt(i);

				}

				map.add(stringToSave);// on ajoute la ligne
			}
			else
				// on quite quand on est egale a exit
				break;

		} while (true);
	}


	void Save()
	{
		try
		{
			FileWriter fw = new FileWriter("map.sok", true);

			for (String m : map)
			{
				fw.write(m);
				fw.write("\r\n");
			}
			fw.close();

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
