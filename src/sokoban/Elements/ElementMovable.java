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
		ArrayList<ArrayList<ElementNonMovable>> map = m.getStructure();
		//On récupère les éléments mouvable :
		ArrayList<ElementMovable> elMouv = m.getElemMouvable();
		
		switch (s) {
		
		case "z": // Si on veux déplacer vers le haut :
		{
			//Si on a un ElementNonMovable :
			if( map.get(CoordonneeX).get(CoordonneeY-1) instanceof Wall)
			{
				
				break;
			}
			else
			{
				//On parcourt le tableau d'élément mouvable :
				for (ElementMovable i : elMouv) {
					//On test si une Box se trouve au dessus de mario :
					if(i.CoordonneeY == this.CoordonneeY-1)
					{
						//Si c'est le cas, on test si elle peux elle aussi se déplacer vers le haut
						Deplacer("z", m);
						break;
					}
				}
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
