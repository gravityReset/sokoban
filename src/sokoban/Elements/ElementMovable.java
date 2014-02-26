package sokoban.Elements;

import java.util.ArrayList;

import sokoban.Map;
import sun.nio.cs.ext.ISCII91;


public abstract class ElementMovable  extends Element {
	
	//=================================
	//===========Attributs :===========
	//=================================
	

	
	//=================================
	//===========Méthodes :============
	//=================================
	
	public abstract String Show();
	public void Deplacer(String s, Map m)
	{
		//On récupère la map
		ArrayList< ArrayList<Element>> map = m.getStructure();
		switch (s) {
		
		case "z": // Si on veux déplacer vers le haut :
		{
			//Si on a un ElementNonMovable :
			if( map.get(CoordonneeX).get(CoordonneeY-1) instanceof Wall)
			{
				break;
			}
			//Si on a un ElementMovable :
			else if ( map.get(CoordonneeX).get(CoordonneeY-1) instanceof ElementMovable) {
				Deplacer("z", m);
				break;
			}
			else
			{
				break;
			}
			
		}
			
		default:
			break;
		}
	}
	
	
	//--- MES GETTER : ---
	
	/*
	 * Reçois la coordonnées X :
	 */
	public int getCoordonneeX()
	{
		return this.CoordonneeX;
	}
	
	/*
	 * Reçoi la coordonnee Y :
	 */
	public int getCoordonneeY()
	{
		return this.CoordonneeY;
	}
}
