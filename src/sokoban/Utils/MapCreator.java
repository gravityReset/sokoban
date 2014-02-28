
package sokoban.Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MapCreator
{

	ArrayList<String> map;


	public MapCreator()
	{
		Boolean personnage = false;

		map = new ArrayList<String>();
		EntreeClavier ec = new EntreeClavier();
		do
		{
			String m = ec.NextLine();
			String stringToSave = ""; // string qu'on va enregistrer après
										// chaque truc

			if (m.charAt(0) != 'q')
			{
				for (int i = 0; i < m.length(); i++)// on parcours la ligne pour
													// vérifier les entrés
				{
					if (m.charAt(i) == 'X') // si c'est un personnage
						if (!personnage) // si il y en a
						{
							personnage = true; // on passe a vraie
							stringToSave += m.charAt(i);
						}
						else
							stringToSave += ' ';

					// les entrés non valide sont remplacé par espace
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

	/**
	 * enregistrer le niveau
	 */
	public void Save()
	{
		try
		{
			FileWriter fw = new FileWriter("map.sok", true);
			fw.write(Integer.toString( getLastLevel()+1));
			fw.write("\r\n");
			
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

	/**
	 * recupérer le dernier niveau enregistré
	 * @return le niveau en int
	 */
	private int getLastLevel()
	{
		String ligne;
		
		int lastLevel = 1;
		
		try
		{
		InputStream ips=new FileInputStream("map.sok"); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		
			while ((ligne=br.readLine())!=null)
			{
				int level;
				if((level = TryParseInt(ligne)) != -1)
					lastLevel = level;
			}
			
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return lastLevel;
	}


	/**
	 * essai de parser en int
	 * @param text a parser
	 * @return le parse ou -1 
	 */
	private int TryParseInt(String text)
	{
		try
		{
			return Integer.parseInt(text);
		}
		catch (NumberFormatException ex)
		{
			return -1;
		}
	}

}
