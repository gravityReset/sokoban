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
	public boolean Deplacer(String s, Map m)
	{
		//
		//
		//On récupère la map
		ArrayList<ArrayList<ElementNonMovable>> map = m.getStructure();
		
		switch (s) {
		
			case "z": // Si on veux déplacer vers le haut :
			{
				if(testCollision(m, map, CoordonneeX,CoordonneeY-1,"z"))
				{
					CoordonneeY -= 1;
					return true;
				}
				else
					return false;
			}
			case "s": // Si on veux déplacer vers le Bas :
			{
				if(testCollision(m, map, CoordonneeX,CoordonneeY+1,"s"))
				{
					CoordonneeY += 1;
					return true;
				}
				else
					return false;
			}
			case "q": // Si on veux déplacer vers la Gauche :
			{
				if(testCollision(m, map, CoordonneeX-1,CoordonneeY,"q"))
				{
					CoordonneeX -= 1;
					return true;
				}
				else
					return false;
			}
			case "d": // Si on veux déplacer vers la Droite :
			{
				if(testCollision(m, map, CoordonneeX+1,CoordonneeY,"d"))
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
		
		// Tester si on a un Storage full :
		
		
	}
	
	/*
	 * Test Collision :
	 */
	private boolean testCollision(Map m,ArrayList<ArrayList<ElementNonMovable>> map, int X, int Y,String dep) {
		//Si on a un ElementNonMovable de type WALL :
		if( map.get(Y).get(X) instanceof Wall)
		{
			return false;
		}
		else
		{
			
			// Si on a un élément mouvable (box) :
			if( (m.getElemMovable(X, Y)) != null)
			{
				//Si on a une Box dans la direction de Mario on tente de la déplacer
				if(!m.getElemMovable(X, Y).Deplacer(dep, m))
				{
					return false;
				}
				
				//Si la case derriere une caisse est un Storage : on le remplis : => Boolean full=true;
				switch(dep)
				{
					case "z" :
					{
						if (map.get(Y-1).get(X) instanceof Storage)
						{
							map.get(Y-1).get(X).full = true;
						}
						break;
					}
					case "s" :
					{
						if (map.get(Y+1).get(X) instanceof Storage)
						{
							map.get(Y+1).get(X).full = true;
						}
						break;
					}
					case "q" :
					{
						if (map.get(Y).get(X-1) instanceof Storage)
						{
							map.get(Y).get(X-1).full = true;
						}
						break;
					}
					case "d" :
					{
						if (map.get(Y).get(X+1) instanceof Storage)
						{
							map.get(Y).get(X+1).full = true;
						}
						break;
					}
					default :
						break;
				}
				
				
			}
		
		
		
			
			return true;
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
