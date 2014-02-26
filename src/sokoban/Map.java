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
	private ArrayList<ArrayList<ElementNonMovable>> structure ;//tableau de Element
	private ArrayList<ElementMovable> elemMouvable ;//tableau de Element
	


	/**
	 * Map
	 * @param level
	 */
	public Map(int level )
	{
		this.level = level;
		structure=  new ArrayList<ArrayList<ElementNonMovable>>();// -> structure[0][0] = new ArrayList< ArrayList<Element>>;
		elemMouvable = new ArrayList<ElementMovable>();
	}
	
	
	//=================================
	//===========Méthodes :============
	//=================================
	
	/**
	 * affiche la map en console
	 */
	public void Show()
	{
		int x = 0, y = 0;
		ElementMovable elemM;
		for(ArrayList<ElementNonMovable> tabElements : structure)
		{
			x = 0;
			for(ElementNonMovable elem  : tabElements)
			{
				if( (elemM = getElemMovable(x, y)) != null)
				{
					System.out.print(elemM.Show());
				}
				else
				{
					System.out.print(elem.Show());
				}
				
				x++;
			}
			y++;
			System.out.println();
		}
	}
	
	
	/**
	 * Charge la map demandé
	 */
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
			Boolean read = false;
			
			int x=0,y=0;
			
			
			while ((ligne=br.readLine())!=null){
				
				if(ligne.contains(Integer.toString(level))  ) //si on arrive au bon niveau on permet de lire
					read = true;
				if(ligne.contains(Integer.toString(level+1)) )//si on arrie au niveau d'après on arrette de lire
				{
					read = false;
					break;
				}
					
				
				if(read)
				{
					structure.add(new ArrayList<ElementNonMovable>());
					y = structure.size()-1;
					for(int i=0;i<ligne.length();i++)
					{
						x=i;
						 Element elem =  GetElem(ligne.charAt(i),x,y); //on ajoute un element a la fin
						 if(elem instanceof ElementNonMovable)
							 structure.get(y).add((ElementNonMovable)elem);
						 else
						 {
							 elemMouvable.add((ElementMovable)elem);
							 structure.get(y).add(new ElementVide(x, y));
						 }
							 
					}
				}
				
			}
			br.close(); 
			
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}

	}
	
	/**
	 * 
	 * @param caratere de l'element
	 * @return l'element en raport avec sont caratere
	 */
	private Element GetElem(char type,int x,int y)
	{
		switch (type)
		{
		case ' ':
			return new ElementVide(x,y);
		case '=':
			return new Wall(x,y);
		case 'X':
			return new Personnage(x,y);
		case 'B':
			return new Box(x,y);
		case 'O':
			return new Storage(x,y);
		default:
			break;
		}
		return new ElementVide(x,y);
	}
	
	public ElementMovable getElemMovable(int x,int y)
	{
		for(ElementMovable elem  : elemMouvable)
		{
			if(elem.getCoordonneeX() == x && elem.getCoordonneeY()==y)
				return elem;
		}
		return null;
	}
	
	//=================================
	//===========Getter et setter :====
	//=================================
	
	/**
	 * @return the structure
	 */
	public ArrayList<ArrayList<ElementNonMovable>> getStructure()
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


	public ArrayList<ElementMovable> getElemMouvable()
	{
		return elemMouvable;
	}
}
