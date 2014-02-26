package sokoban.Elements;

public class Storage extends ElementNonMovable{

	//=================================
	//===========Attributs :===========
	//=================================
	
	String id="O";
	
	
	//=================================
	//===========Méthodes :============
	//=================================
	
	/*
	 * Constructeur 
	 */
	public Storage(int x, int y) {
		// TODO Auto-generated constructor stub
		this.CoordonneeX=x;
		this.CoordonneeY=y;
	}
	
	/*
	 * Getter de l'ID : "O"
	 */
	@Override
	public String Show()
	{
		return id;
	}
}
