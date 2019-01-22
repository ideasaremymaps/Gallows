import java.io.IOException;


public class Start {
	
	public static void main(String[] args) throws IOException {
		Start s = new Start();
		s.start();
	}
	public void start() throws IOException {
		String word = Wordpicker.getWord();
		Word.setWord(word);
		String secret = Word.hideSecret();
		Screen s = new Screen();
		s.go(word, secret, 0, "",false);
	}
}
