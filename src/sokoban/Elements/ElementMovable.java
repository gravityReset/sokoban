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
		
		switch (s) {
		
		case "z": // Si on veux d�placer vers le haut :
		{
			if(testCollision(m, map, CoordonneeX,CoordonneeY-1,"z"))
			{
				CoordonneeY -= 1;
				return true;
			}
			else
				return false;
		}
		case "s": // Si on veux d�placer vers le Bas :
		{
			if(testCollision(m, map, CoordonneeX,CoordonneeY-1,"s"))
			{
				CoordonneeY += 1;
				return true;
			}
			else
				return false;
		}
		case "q": // Si on veux d�placer vers la Gauche :
		{
			if(testCollision(m, map, CoordonneeX,CoordonneeY-1,"q"))
			{
				CoordonneeX -= 1;
				return true;
			}
			else
				return false;
		}
		case "d": // Si on veux d�placer vers la Droite :
		{
			if(testCollision(m, map, CoordonneeX,CoordonneeY-1,"d"))
			{
				CoordonneeX += 1;
				return true;
			}
			else
				return false;
		}
		default:
			return false;
		}
	}
	
	/*
	 * Test Collision :
	 */
	private boolean testCollision(Map m,ArrayList<ArrayList<ElementNonMovable>> map, int X, int Y,String dep) {
		//Si on a un ElementNonMovable :
		if( map.get(X).get(Y) instanceof Wall)
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
				if(!el.Deplacer(dep, m))
				{
					return false;
				}
			}
			
			
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
