package sokoban.Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Score{
	

	public static void AddScore(long score, int level){
		
		//Recuperation du pseudo et du chrono
		System.out.println("indiquez votre pseudo");
		EntreeClavier e = new EntreeClavier();
		String pseudo = e.NextLine();
		System.out.println("Votre chrono est de:"+ score);		
		EnregistrementScore(score, pseudo, level);
	}
	
	
	public static void ShowScore(int lvl)
	{
		try{
			InputStream ips=new FileInputStream("score.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			
			
			
			while ((ligne=br.readLine())!=null)
			{
				
			}
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	
	private static void EnregistrementScore(long score, String pseudo, int level)
	{
	//Ecriture de ces derniers dans un fichier texte
			  try {
				FileWriter fw = new FileWriter("Score.txt", true);
				
				fw.write(pseudo);
				fw.write(":"+String.valueOf(score));
				fw.write(":"+level);
				fw.write("\r\n");
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
  
	}
}
