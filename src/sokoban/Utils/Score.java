package sokoban.Utils;

import java.io.FileWriter;
import java.io.IOException;

public class Score{
	

	public static void AddScore(long score, int level){
		
		//Recuperation du pseudo et du chrono
		System.out.println("indiquez votre pseudo");
		EntreeClavier e = new EntreeClavier();
		String pseudo = e.NextLine();
		System.out.println("Votre chrono est de:"+ score);		
		EnregistrementScore(score, pseudo, level);
	}
	public static void EnregistrementScore(long score, String pseudo, int level)
	{
	//Ecriture de ces derniers dans un fichier texte
			  try {
				FileWriter fw = new FileWriter("Score.txt", true);
				
				fw.write(pseudo);
				fw.write((int) score);
				fw.write(level);
				fw.write("\n");
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
  
	}
}
