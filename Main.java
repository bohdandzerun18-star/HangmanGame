import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
    String[] easyFruits = {"apple", "kiwi", "plum", "pear", "lime"};
String[] easyAnimals = {"lion", "wolf", "bear", "duck", "frog"};
String[] easyCountries = {"peru", "laos", "iraq", "cuba", "mali"};
String[] easySports = {"golf", "ski", "judo", "rugby", "swim"};
String[] easyObjects = {"book", "pen", "cup", "lamp", "key"};
String[] easyColors = {"red", "blue", "pink", "gold", "teal"};
String[] easyFood = {"rice", "cake", "fish", "bread", "milk"};
String[] easyNature = {"hill", "tree", "lake", "rain", "sand"};
String[] mediumFruits = {"banana", "orange", "mango", "papaya", "cherry"};
String[] mediumAnimals = {"rabbit", "giraffe", "penguin", "dolphin", "kangaroo"};
String[] mediumCountries = {"canada", "france", "brazil", "spain", "poland"};
String[] mediumSports = {"soccer", "tennis", "hockey", "boxing", "cricket"};
String[] mediumObjects = {"camera", "laptop", "guitar", "bottle", "wallet"};
String[] mediumColors = {"purple", "orange", "yellow", "silver", "violet"};
String[] mediumFood = {"pizza", "pasta", "sushi", "burger", "waffle"};
String[] mediumNature = {"forest", "desert", "river", "island", "valley"};
String[] hardFruits = {"pineapple", "strawberry", "blueberry", "blackberry", "pomegranate"};
String[] hardAnimals = {"elephant", "alligator", "chimpanzee", "kangaroo", "crocodile"};
String[] hardCountries = {"argentina", "australia", "venezuela", "thailand", "philippines"};
String[] hardSports = {"basketball", "volleyball", "snowboarding", "badminton", "weightlifting"};
String[] hardObjects = {"microphone", "notebook", "backpack", "binoculars", "headphones"};
String[] hardColors = {"turquoise", "magenta", "maroon", "lavender", "chartreuse"};
String[] hardFood = {"chocolate", "lasagna", "croissant", "spaghetti", "hamburger"};
String[] hardNature = {"waterfall", "mountain", "meadow", "canyon", "rainforest"};
String[] extremeFruits = {"cranberry", "persimmon", "pomegranate", "blackcurrant", "dragonfruit"};
String[] extremeAnimals = {"chimpanzee", "hippopotamus", "rhinoceros", "orangutan", "crocodilian"};
String[] extremeCountries = {"turkmenistan", "liechtenstein", "papua new guinea", "kazakhstan", "madagascar"};
String[] extremeSports = {"synchronizedswimming", "extremecycling", "snowboarding", "weightlifting", "skydiving"};
String[] extremeObjects = {"thermometer", "microscope", "stereoscope", "refrigerator", "telescope"};
String[] extremeColors = {"chartreuse", "ultramarine", "cerulean", "vermillion", "indigo"};
String[] extremeFood = {"bouillabaisse", "ratatouille", "carbonara", "sauerbraten", "ceviche"};
String[] extremeNature = {"photosynthesis", "glaciation", "thermodynamics", "geosynchronous", "electromagnetic"};
String[][] easyThemes = {easyFruits, easyAnimals, easyCountries, easySports, easyObjects, easyColors, easyFood, easyNature};
String[][] mediumThemes = {mediumFruits, mediumAnimals, mediumCountries, mediumSports, mediumObjects, mediumColors, mediumFood, mediumNature};
String[][] hardThemes = {hardFruits, hardAnimals, hardCountries, hardSports, hardObjects, hardColors, hardFood, hardNature};
String[][] extremeThemes = {extremeFruits, extremeAnimals, extremeCountries, extremeSports, extremeObjects, extremeColors, extremeFood, extremeNature};
String[][][] themes = {easyThemes, mediumThemes, hardThemes, extremeThemes };
String[] themeNames = {"Fruits","Animals","Countries","Sports","Objects","Colors","Food","Nature"};
        Random random = new Random();
        int difficultyIndex = random.nextInt(themes.length);
        String[][] chosenTheme = themes[difficultyIndex];
        int categoryIndex = random.nextInt(chosenTheme.length);
        String chosenThemeName = themeNames[categoryIndex];
        String[] chosenCategory = chosenTheme[categoryIndex];
        String word = chosenCategory[random.nextInt(chosenCategory.length)];
        char[] revealed = new char[word.length()];
        for( int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            revealed[i] = Character.isLetter(c) ? '_' : c;
        }
        System.out.println("Welcome to Hangman!");
            System.out.println("===================");
            System.out.println("Try to guess the word!");
        System.out.println("Choose the difficulty: ");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        System.out.println("4 - Extreme");
        Scanner scanner = new Scanner(System.in);
        int difficulty = scanner.nextInt();
        int maxAttempts;
        switch (difficulty) {
            case 1:
                maxAttempts = 8;
                break;
            case 2:
            maxAttempts = 6;
                break;
                case 3:
                maxAttempts = 5;
                break;
                case 4:
                maxAttempts = 3;
                break;
                default:
                maxAttempts = 6;
                break;
        }
        Set<Character> guessed = new HashSet<>();
        int attemptsLeft = maxAttempts;
        scanner.nextLine();
        while (attemptsLeft > 0) {
            System.out.println("Theme is: " +chosenThemeName);
            System.out.println("Word: " + String.valueOf(revealed));
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.println("Guessed letters: " + guessed);
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine().toLowerCase().trim();
            System.out.println("\n===================");
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }
            char guess = input.charAt(0);
            if (guessed.contains(guess)) {
                System.out.println("You've already guessed that letter.");
                continue;
            }
            guessed.add(guess);
            if (word.indexOf(guess) != -1) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        revealed[i] = guess;
                    }
                }
                System.out.println("Good guess!");
            } else {
                attemptsLeft--;
                System.out.println("Wrong guess!");
            }
            if (String.valueOf(revealed).indexOf('_') == -1) {
                System.out.println("Congratulations! You've guessed the word: " + word);
                break;
            }
        }
        if (attemptsLeft == 0) {
            System.out.println("Game over! The word was: " + word);
        }
        scanner.close();
}
}
