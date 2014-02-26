package sokoban.Elements;

public class Wall extends ElementNonMovable {

	//=================================
	//===========Attributs :===========
	//=================================
	
	String id="=";
	
	
	//=================================
	//===========Méthodes :============
	//=================================
	
	/*
	 * Constructeur de Wall
	 */
	public Wall(int x,int y) {
		// TODO Auto-generated constructor stub
		this.CoordonneeX=x;
		this.CoordonneeY=x;
	}
	
	/*
	 * Getter de id : "="
	 */
	@Override
	public String Show()
	{
		return id;
	}

}
