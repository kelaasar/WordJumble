import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class WordJumble {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		
		String word = "";
	
		ArrayList<String> vocabList=  new ArrayList<String>();
		Scanner reader = new Scanner(new File("VocabList.txt"));
		
		while (reader.hasNext()) {

			vocabList.add(reader.nextLine());
		}
		
		word = getWord(vocabList);
		char[] wordArray = scramble(word);
		userGuess(word, wordArray);

	}
	
	
	//-------------------------------------------------------------------------------------
	
	public static String getWord(ArrayList<String> vocabList) {
		
		int i = (int) (Math.random()*(vocabList.size()));		
		return vocabList.get(i);
	}	
	
	
	public static char[] scramble(String word) {
		
		char[] tempArray = word.toCharArray();
		
		for (int i = 0; i <= tempArray.length-1; i++ ) {
			int r = (int) (Math.random()*(tempArray.length));
            char temp = tempArray[r];
            tempArray[r] = tempArray[i];
            tempArray[i] = temp;
		}
		return tempArray;	
	}
	
	
	public static void userGuess(String word, char[] wordArray) {
		
		Scanner reader = new Scanner(System.in);
		String guess = "";
		boolean hasGuessed = false;
		System.out.println(word);
		
		for (int i = 0; i <= word.length()-1; i++) {
			
			int guessLeft = word.length()-i;
			System.out.println();
			System.out.println("You have " + guessLeft + " guesses left.");
			System.out.println("Word: " + String.valueOf(wordArray));
			System.out.print("Guess: ");
			guess = reader.nextLine();
		
			if (guess.equals(word)) {
				hasGuessed = true;
				i=word.length()-1;
			}
		}
		
		if (hasGuessed == true)
			System.out.println("You guessed the word!");
		else System.out.println("You lose!");
		
	}	
	
	
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	