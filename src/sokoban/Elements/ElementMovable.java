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
	public boolean Deplacer(String s, Map m)
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
			return testCollision(m, map, CoordonneeX,CoordonneeY-1);
		}
		case "s": // Si on veux d�placer vers le Bas :
		{
			return testCollision(m, map, CoordonneeX,CoordonneeY+1);
		}
		case "q": // Si on veux d�placer vers la Gauche :
		{
			return testCollision(m, map, CoordonneeX-1,CoordonneeY);
		}
		case "d": // Si on veux d�placer vers la Droite :
		{
			return testCollision(m, map, CoordonneeX+1,CoordonneeY);
		}
		default:
			return false;
		}
	}
	
	/*
	 * Test Collision :
	 */
	private boolean testCollision(Map m,ArrayList<ArrayList<ElementNonMovable>> map, int X, int Y) {
		//Si on a un ElementNonMovable :
		if( map.get(X).get(Y-1) instanceof Wall)
		{
			return false;
		}
		else
		{
			
			//On parcourt le tableau d'�l�ment mouvable :
			ElementMovable el;
			if( (el =  m.getElemMovable(X, Y)) != null)
			{
				//Si on a une Box au dessus de Mario on tente de d�placer
				if(!el.Deplacer("z", m))
				{
					return false;
				}
			}
			this.CoordonneeY -= 1;
			return true;
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
