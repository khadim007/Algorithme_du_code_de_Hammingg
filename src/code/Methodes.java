package code;

public class Methodes {
	
	public static boolean comp(String b, String c){
		if(b.length() > c.length())
			return true;
		else if(b.length() < c.length())
			return false;
		else {
			for(int i = 0; i < b.length(); i++){
				int elB = b.charAt(i);
				int elC = b.charAt(i);
				if(elB < elC)
					return false;
			}
			return true;
		}
	}
	
	// Ajoute un bit a une position donnes
	public static String addChar(String str, char ch, int position) {
	    return str.substring(0, position) + ch + str.substring(position);
	}
}
