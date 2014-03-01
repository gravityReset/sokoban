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
import sokoban.Utils.EntreeClavier;



/**
 * @author 15824_000
 *
 */
public class Map {
	private int level;
	private ArrayList<ArrayList<ElementNonMovable>> structure ;//tableau de Element
	private ArrayList<ElementMovable> elemMouvable ;//tableau de Element
	
	private EntreeClavier clavier;
	private int nbStorageTrue;
	private int nbStorage;


	/**
	 * Map
	 * @param level
	 */
	public Map(int level )
	{
		this.level = level;
		structure=  new ArrayList<ArrayList<ElementNonMovable>>();// -> structure[0][0] = new ArrayList< ArrayList<Element>>;
		elemMouvable = new ArrayList<ElementMovable>();
		clavier = new EntreeClavier();
	}
	
	
	//=================================
	//===========M�thodes :============
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
	
	
	public void Deplacer()
	{
		for(ElementMovable elem  : elemMouvable)
		{
			if(elem instanceof Personnage)
			{
				elem.Deplacer(clavier.NextEntree() , this);
				break;
			}
				
		}
	}
	
	/**
	 * Charge la map demand�
	 */
	public void Load()
	{
		structure.clear();
		String fichier ="map.sok";
		
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
				if(ligne.contains(Integer.toString(level+1)) )//si on arrie au niveau d'apr�s on arrette de lire
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
			
			// On compte le nombre d'�l�ments Storage non-remplis au d�but de la map :
			for (ArrayList<ElementNonMovable> nomStorage : structure ) {
				for (ElementNonMovable Storage : nomStorage) {
					if(Storage instanceof Storage)
					{
						nbStorage +=1;
					}
				}
			} 

			nbStorageTrue = nbStorage;
			
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
	
	
	
	/**
	 * Compte le nombre de case rempli
	 * @return vrai si on est a 0 et false sinon
	 */
	public Boolean CountStorageFull()
	{
		//On compte le nombre de Storage full:
		for (ArrayList<ElementNonMovable> nomStorage : structure ) {
			for (ElementNonMovable Storage : nomStorage) {
				if(Storage instanceof Storage)
				{
					if(Storage.full==true)
						nbStorageTrue -=1;
					
				}
			}
		}
		
		if(nbStorageTrue==0)
			return true;
		else
		{
			nbStorageTrue = nbStorage;
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param x coordonn�e en x
	 * @param y coordonn�e en y
	 * @return renvoie null ou l'objet movable de cette position
	 */
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

	/**
	 * 
	 * @return the element Movable array
	 */
	public ArrayList<ElementMovable> getElemMouvable()
	{
		return elemMouvable;
	}
}
