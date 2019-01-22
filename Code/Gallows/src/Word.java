import java.util.HashSet;
import java.util.Set;

public class Word {
	static String Word;
	static String secret;
	static Set<Character> position= new HashSet<Character>();
	public static void setWord(String word) {
		Word=word;
	}
	
	public static String getWord() {
		return Word;
	}
	
	public static void restartPosition() {
		position.clear();
	}

	public static String hideSecret() {
		secret="";
		for (int i=0; i<Word.length();i++) {
			 if(Character.isWhitespace(Word.charAt(i))){
				 secret = secret+ "  ";
			} else {
				secret = secret+ "_ ";
			}
		}
		return secret;
	}
	
	public static boolean checkLetter(String letter) {
		if(Word.contains(letter)){
			return true;
		} else return false;
	}
	
	public static String addLetter(String slovo) {
		for (int i=0; i<Word.length();i++) {
			if(Word.charAt(i)==slovo.charAt(0)) {
				position.add(slovo.charAt(0));			
			}
		}
		changeSecret(position);
		return secret;
	}
	
	public static String changeSecret(Set<Character> position) {
		secret="";
		for (int i=0; i<Word.length();i++) {
			 if(Character.isWhitespace(Word.charAt(i))){
				 secret = secret+ "  ";
			} else if(!position.contains(Word.charAt(i))) {
				secret = secret+ "_ ";
			} else secret = secret+ Word.charAt(i)+ " ";
		}
		return secret;
	}
	
}
