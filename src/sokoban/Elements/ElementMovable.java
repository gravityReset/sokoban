package sokoban.Elements;

import java.util.ArrayList;

import sokoban.Map;



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
		//
		//
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
				ElementMovable el;
				if( (el =  m.getElemMovable(CoordonneeX, CoordonneeY-1)) != null)
				{
					//Si on a une Box au dessus de Mario on tente de déplacer
					el.Deplacer("z", m);
				}
				this.CoordonneeY -= 1;
			}
			break;
			
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
