package sokoban.Elements;

public class ElementVide extends ElementNonMovable{

	//=================================
	//===========Attributs :===========
	//=================================
	
	String id=" ";
	
	
	//=================================
	//===========M�thodes :============
	//=================================
	
	/*
	 * Constructeur :
	 */
	public ElementVide() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Getter de id
	 * @see sokoban.Elements.Element#Show()
	 */
	@Override
	public String Show() {
		// TODO Auto-generated method stub
		return id;
	}

}
