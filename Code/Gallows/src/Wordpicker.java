import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Wordpicker {
	public static String getWord() throws IOException {
		BufferedReader read = new BufferedReader(new FileReader("./gallows/word.txt"));
		String line;
		ArrayList<String> lista = new ArrayList<String>();
		while((line = read.readLine()) != null) {
			lista.add(line);
		}
		Random rand = new Random();
		int index = rand.nextInt(lista.size());
		String word = lista.get(index);
		read.close();
		return word;
	}
}