import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
    String[] fruits = {
    "apple", "banana", "cherry", "grape", "mango",
    "orange", "peach", "plum", "kiwi", "melon"
};
String[] animals = {
    "elephant", "giraffe", "tiger", "lion", "zebra",
    "wolf", "panda", "rabbit", "fox", "monkey"
};
String[] countries = {
    "canada", "brazil", "france", "poland", "japan",
    "spain", "italy", "egypt", "india", "mexico"
};
String[] sports = {
    "soccer", "tennis", "hockey", "boxing", "golf",
    "cricket", "volleyball", "rugby", "cycling", "skiing"
};
String[] objects = {
    "window", "laptop", "camera", "guitar", "bottle",
    "pencil", "notebook", "marker", "wallet", "backpack"
};
String[] colors = {
    "purple", "orange", "yellow", "silver", "gold",
    "violet", "beige", "brown", "pink", "black"
};
String[] food = {
    "pizza", "pasta", "sushi", "burger", "cookie",
    "waffle", "salad", "tacos", "noodles", "steak"
};
String[] nature = {
    "forest", "mountain", "ocean", "desert", "river",
    "island", "valley", "canyon", "meadow", "waterfall"
};
String [][] themes = { animals, food, countries, colors, objects, nature, sports, fruits };
String [] themeNames ={ "animals" , "food", "countries", "colors", "objects", "nature", "sports", "fruits" };
        Random random = new Random();
        int themeIndex = random.nextInt(themes.length);
        String[] chosenTheme = themes[themeIndex];
        String chosenThemeName = themeNames[themeIndex];
        String word = chosenTheme[random.nextInt(chosenTheme.length)];
        char[] revealed = new char[word.length()];
        for( int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            revealed[i] = Character.isLetter(c) ? '_' : c;
        }
        System.out.println("Welcome to Hangman!");
            System.out.println("===================");
            System.out.println("Try to guess the word!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the difficulty: ");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        System.out.println("4 - Extreme");
        int difficulty = scanner.nextInt();
        Set<Character> guessed = new HashSet<>();
        int maxAttempts;
        switch (difficulty) {
            case 1:
                maxAttempts = 10;
                break;
            case 2:
            maxAttempts = 6;
                break;
                case 3:
                maxAttempts = 5;
                break;
                case 4:
                maxAttempts = 3;
                default:
                maxAttempts = 6;
                break;
        }
        scanner.nextLine();
        int attemptsLeft = maxAttempts;
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
