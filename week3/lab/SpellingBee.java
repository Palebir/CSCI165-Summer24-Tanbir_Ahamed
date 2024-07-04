/*
 * File: SpellingBee.java
 * ----------------------
 * This program contains the starter file for the SpellingBee application.
 * 
 * Your work will all go here
 * 
 * BE SURE TO CHANGE THIS COMMENT WHEN YOU COMPLETE YOUR SOLUTION.
 * 
 * to run this app, at the terminal, type:
 * 	javac SpellingBee.java
 * 	java SpellingBee
 */

 import java.awt.Color;	// import the Color class
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 
 public class SpellingBee {
	 private String letters;
	 
	 public void run() {
		 sbg = new SpellingBeeGraphics();
 
		 sbg.addField("Puzzle", (s) -> puzzleAction(s));
		 sbg.addButton("Solve", (s) -> solveAction());
		 sbg.addButton("Shuffle", (s) -> shuffleAction());
	 }
 
	 private void puzzleAction(String s) {
		 if (isLegalPuzzle(s)) {
			 sbg.setBeehiveLetters(s);
		 } else {
			 sbg.showMessage("Illegal puzzle", Color.RED);
		 }
	 }
 
	 private boolean isLegalPuzzle(String puzzle) {
		 if (puzzle.length()!= 7) {
			 return false;
		 }
		 for (char c : puzzle.toCharArray()) {
			 if (!Character.isLetter(c)) {
				 return false;
			 }
		 }
		 return!hasDuplicates(puzzle);
	 }
 
	 private boolean hasDuplicates(String puzzle) {
		 for (int i = 0; i < puzzle.length() - 1; i++) {
			 for (int j = i + 1; j < puzzle.length(); j++) {
				 if (puzzle.charAt(i) == puzzle.charAt(j)) {
					 return true;
				 }
			 }
		 }
		 return false;
	 }
 
	 private void solveAction() {
		 List<String> words = readDictionary();
		 int totalScore = 0;
		 int wordCount = 0;
		 for (String word : words) {
			 if (isLegalWord(word)) {
				 int score = calculateScore(word);
				 sbg.addWord(word, new Color(score));
				 totalScore += score;
				 wordCount++;
			 }
		 }
		 sbg.showMessage("Words found: " + wordCount + ", Total score: " + totalScore, Color.BLACK);
	 }
 
	 private List<String> readDictionary() {
		 List<String> words = new ArrayList<>();
		 try (Scanner scanner = new Scanner(ENGLISH_DICTIONARY)) {
			 while (scanner.hasNextLine()) {
				 words.add(scanner.nextLine());
			 }
		 } catch (Exception e) {
			 sbg.showMessage("Error reading dictionary", Color.RED);
		 }
		 return words;
	 }
 
	 private boolean isLegalWord(String word) {
		 if (word.length() < 4) {
			 return false;
		 }
		 for (char c : word.toCharArray()) {
			 if (!letters.contains(String.valueOf(c).toLowerCase())) {
				 return false;
			 }
		 }
		 return word.contains(letters.substring(0, 1));
	 }
 
	 private int calculateScore(String word) {
		 int score = word.length();
		 if (isPangram(word)) {
			 score += 7;
		 }
		 return score;
	 }
 
	 private boolean isPangram(String word) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'isPangram'");
	}

	private void shuffleAction() {
			// Get the current letters in the beehive
			String currentLetters = sbg.getBeehiveLetters();
		
			// Create a list of characters from the current letters
			List<Character> lettersList = new ArrayList<>();
			for (char c : currentLetters.toCharArray()) {
				lettersList.add(c);
			}
		
			// Shuffle the list of characters
			for (int i = lettersList.size() - 1; i > 0; i--) {
				int j = (int) (Math.random() * (i + 1));
				Character temp = lettersList.get(i);
				lettersList.set(i, lettersList.get(j));
				lettersList.set(j, temp);
			}
		
			// Build a new string with the shuffled letters
			StringBuilder shuffledLetters = new StringBuilder();
			for (char c : lettersList) {
				shuffledLetters.append(c);
			}
		
			// Set the new shuffled letters in the beehive
			sbg.setBeehiveLetters(shuffledLetters.toString());
		}
	 
 
	 /* Constants */
	 // The name of the file containing the puzzle dictionary
	 private static final String ENGLISH_DICTIONARY = "EnglishWords.txt";
 
	 /* Private instance variables */
	 private SpellingBeeGraphics sbg;	// no instance created yet, just scoped the reference variable
 
	 /* Startup code */
	 public static void main(String[] args) {	// application starts here
		 SpellingBee sb = new SpellingBee();
		 sb.run();// call the run method (defined below)
	 }
 }