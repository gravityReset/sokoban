
package sokoban.Utils;

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

		} while (map.get(map.size()) != "exit");
	}
	
	void Save()
	{
		
	}

}
