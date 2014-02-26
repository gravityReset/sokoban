package sokoban.Utils;

public class Timer {
	
	//Attribut de la Classe :
	
	static long chrono = 0 ; 
	 
	// Lancement du chrono 
	public static void StartTimer() { 
		chrono = java.lang.System.currentTimeMillis() ; 
	} 
	 
	// Arret du chrono 
	public static long StopTimer() { 
		long chrono2 = java.lang.System.currentTimeMillis() ; 
		long temps = chrono2 - chrono ;
		
		// on retranche les ms car inutile du point de vue humain
		temps/=1000;
		
		return temps; 
	} 
}
