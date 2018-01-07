import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String[] arg) throws Exception{

        String runingChar = "";

        Game movie = new Game();
        String randomMovie = movie.randMovie;
        Scanner reader = new Scanner(System.in);

        int counter = 10;

        while(counter > 0){
            System.out.println("Guess a Movie:");
            String  myGuess =  reader.nextLine();
            myGuess = myGuess.toLowerCase();
            char c = myGuess.charAt(0);

            System.out.println("Printing " + c + " Charater.");
            if (!movie.isValidChar(c)){
                System.err.println("Error. We are looking for only letters a-z");
                System.exit(0);
            }
            if (!movie.updateGuessString(c)){
                counter--;
                runingChar += c + " ";
            }

            movie.updateGuessString(c);
            if (movie.guessString.equals(movie.randMovie)){
                break;
            }
            System.out.println("You are guessing:" + movie.guessString);
            int diff = 10 - counter;
            System.out.println("You have guesses (" + diff + ") wrong letters:" + runingChar);
        }

        if (counter == 0){
            System.out.println("Sorry you lost. The correct answer is " + movie.randMovie);
        }else{
            System.out.println("You guessed " + movie.guessString + " correctly." );
        }
    }
}
