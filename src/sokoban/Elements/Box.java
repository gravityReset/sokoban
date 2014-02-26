package sokoban.Elements;

public class Box extends ElementMovable {

	
	//=================================
	//===========Attributs :===========
	//=================================
	
	String id="B";
	
	
	//=================================
	//===========Méthodes :============
	//=================================
	
	/**
	 * @author 160794
	 * Constructeur
	 *
	 */
	public Box(int x, int y) {
		// TODO Auto-generated constructor stub
		this.CoordonneeX=x;
		this.CoordonneeY=y;
		
	}
	
	/*
	 * Getter de id : "B"
	 * @160794
	 */
	@Override
	public String Show()
	{
		return id;
		
	}
			
	

	/*
	 * Déplace un objet mobil
	 * @160794
	 */
	public void Deplacer(String s) {
		// TODO Auto-generated method stub
						
	}

	

}
