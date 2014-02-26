package sokoban.Elements;

import java.util.ArrayList;

import sokoban.Map;



public abstract class ElementMovable  extends Element {
	
	//=================================
	//===========Attributs :===========
	//=================================
	

	
	//=================================
	//===========M�thodes :============
	//=================================
	
	public abstract String Show();
	public void Deplacer(String s, Map m)
	{
		//
		//
		//On r�cup�re la map
		ArrayList<ArrayList<ElementNonMovable>> map = m.getStructure();
		//On r�cup�re les �l�ments mouvable :
		ArrayList<ElementMovable> elMouv = m.getElemMouvable();
		
		switch (s) {
		
		case "z": // Si on veux d�placer vers le haut :
		{
			//Si on a un ElementNonMovable :
			if( map.get(CoordonneeX).get(CoordonneeY-1) instanceof Wall)
			{
				
				break;
			}
			else
			{
				
				//On parcourt le tableau d'�l�ment mouvable :
				ElementMovable el;
				if( (el =  m.getElemMovable(CoordonneeX, CoordonneeY-1)) != null)
				{
					//Si on a une Box au dessus de Mario on tente de d�placer
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
	 * Re�ois la coordonn�es X :
	 */
	public int getCoordonneeX()
	{
		return this.CoordonneeX;
	}
	
	/*
	 * Re�oi la coordonnee Y :
	 */
	public int getCoordonneeY()
	{
		return this.CoordonneeY;
	}
}
