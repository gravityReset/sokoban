
package sokoban.Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Score
{

	private String nom;
	private int niveau;
	private int score;


	public Score(String nom, int niveau, int score)
	{
		this.nom = nom;
		this.niveau = niveau;
		this.score = score;
	}


	// ======================
	// getter and setter=====
	// ======================

	public String getNom()
	{
		return nom;
	}


	public int getNiveau()
	{
		return niveau;
	}


	public int getScore()
	{
		return score;
	}


	// _____________method static

	public static void AddScore(long score, int level)
	{

		// Recuperation du pseudo et du chrono
		System.out.println("indiquez votre pseudo");
		EntreeClavier e = new EntreeClavier();
		String pseudo = e.NextLine();
		System.out.println("Votre chrono est de:" + score);
		EnregistrementScore(score, pseudo, level);
	}


	public static void ShowScore(int lvl)
	{
		try
		{
			InputStream ips = new FileInputStream("score.txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			ArrayList<Score> listScore = new ArrayList<Score>();
			String ligne;
			
			//on lis le fichier score
			while ((ligne = br.readLine()) != null)
			{
				String[] ligneSplite = ligne.split(":");//on split pour avoir nom score niveau
				
				if(Integer.parseInt(ligneSplite[2])==lvl) // si on est dans le bon niveau
					listScore.add(new Score(ligneSplite[0], //on ajoute score
									Integer.parseInt(ligneSplite[2]),
									Integer.parseInt( ligneSplite[1])));
			}
			
			br.close();
			
			if(!listScore.isEmpty())
			{
			//on trie les scores
			Collections.sort(listScore, new ScoreComparator());
			
			for(Score s : listScore)//on affiche les score trier
				System.out.println(s.getNom() + " score de : " + s.getScore());
			
			}
			else
				System.out.println("Aucun score pour ce niveau!");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}


	private static void EnregistrementScore(long score, String pseudo, int level)
	{
		// Ecriture de ces derniers dans un fichier texte
		try
		{
			FileWriter fw = new FileWriter("Score.txt", true);

			fw.write(pseudo);
			fw.write(":" + String.valueOf(score));
			fw.write(":" + level);
			fw.write("\r\n");
			fw.close();

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
