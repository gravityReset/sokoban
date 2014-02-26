/**
 * 
 */
package sokoban;

import java.util.ArrayList;

import sokoban.Elements.*;



/**
 * @author 15824_000
 *
 */
public class Map {
	private int level;
	private ArrayList<ArrayList<Element>> structure ;//tableau de Element
	
	
	public Map(int level )
	{
		this.level = level;
		structure=  new ArrayList<ArrayList<Element>>();// -> structure[0][0] = new ArrayList< ArrayList<Element>>;
	}

	/**
	 * @return the structure
	 */
	public ArrayList<ArrayList<Element>> getStructure()
	{
		return structure;
	}



	/**
	 * @return the level
	 */
	public int getLevel()
	{
		return level;
	}


	
}
