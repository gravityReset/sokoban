package sokoban;

public class Timer {
	// Fonctions pour le chronometre 
	static long chrono = 0 ; 
	 
	// Lancement du chrono 
	static void StartTimer() { 
		chrono = java.lang.System.currentTimeMillis() ; 
	} 
	 
	// Arret du chrono 
	static void StopTimer() { 
	long minute=0, seconde=0;
	long chrono2 = java.lang.System.currentTimeMillis() ; 
	long temps = chrono2 - chrono ;
	
	// on retranche les ms car inutile du point de vue humain
	temps/=1000;
	minute=temps/60;
	seconde=temps%60;	
	System.out.println("Temps ecoule = " + minute + "min"+seconde+"s") ; 
	} 
}
