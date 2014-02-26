package sokoban.Elements;

public class Personnage extends ElementMovable{

	//=================================
	//===========Attributs :===========
	//=================================
	
	String id="X";
	
	
	//=================================
	//===========Méthodes :============
	//=================================
	
	
	/*
	 * Constructeur de Personnage :
	 */
	public Personnage(int x, int y) {
		// TODO Auto-generated constructor stub
		this.CoordonneeX=x;
		this.CoordonneeY=y;
	}
	
	/*
	 * Getter de id : "X"
	 */
	@Override
	public String Show()
	{
		return id;
	}

	

	

}
