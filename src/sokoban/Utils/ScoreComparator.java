
package sokoban.Utils;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score>
{

	@Override
	public int compare(Score o1, Score o2)
	{
		if (o1.getScore() < o2.getScore())
			return -1;
		else if (o1.getScore() == o2.getScore())
			return 0;
		else
			return 1;
	}

}
