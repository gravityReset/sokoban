/**
 * 
 */
package sokoban;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import sokoban.Elements.*;



/**
 * @author 15824_000
 *
 */
public class Map {
	private int level;
	private ArrayList<ArrayList<Element>> structure ;//tableau de Element
	
	/**
	 * Map
	 * @param level
	 */
	public Map(int level )
	{
		this.level = level;
		structure=  new ArrayList<ArrayList<Element>>();// -> structure[0][0] = new ArrayList< ArrayList<Element>>;
		
	}
	//=================================
	//===========Méthodes :============
	//=================================
	public void Show()
	{
		for(ArrayList<Element> tabElements : structure)
		{
			for(Element elem  : tabElements)
			{
				System.out.print(elem.Show());
			}
			System.out.println();
		}
	}
	
	public void Load()
	{
		structure.clear();
		String fichier ="test_map.sok";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				
				structure.add(new ArrayList<Element>());
				for(int i=0;i<ligne.length();i++)
				{
					
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	//=================================
	//===========Getter et setter :====
	//=================================
	
	/**
	 * @return the structure
	 */
	public ArrayList<ArrayList<Element>> getStructure()
	{
		return structure;
	}



	/**
	 * @return the level
	 */
	public int getLevel()
	{
		return level;
	}


	
}
