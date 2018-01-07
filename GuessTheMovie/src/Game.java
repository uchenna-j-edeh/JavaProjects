import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;


public class Game {
    public String randMovie;
    public String [] moviesArr = new String[100];
    public String guessString = "";

    char [] letters ={
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', ' ', '\''
    };



     public Game() {
         try {
            File file = new File("MovieList.txt");
            Scanner scanner = new Scanner(file);
            int indx = 0;

            while(scanner.hasNextLine()){
                this.moviesArr[indx] = scanner.nextLine();
                indx++;
            }
            int randInt = (int)(Math.random() * indx) + 1;

            this.randMovie = this.moviesArr[randInt];

             for (int i = 0; i<this.randMovie.length(); i++) {
                 this.guessString += "_";
             }
         }
         catch(FileNotFoundException e){
             System.err.println("Error: file does not exist...");
         }

    }

    public boolean updateGuessString(char c){
         int pos = -1;
         String newString = "";
         for (int i = 0; i<this.randMovie.length(); i++){
             if (this.randMovie.charAt(i) == c){
                 pos = i;
                 newString += c;
             }else{
                 newString += this.guessString.charAt(i);
             }
         }
         this.guessString = newString;
        return pos != -1;
    }

    public boolean isValidChar(char c) {
        boolean found = false;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == c) {
                found = true;
            }
        }
        return found;
    }


}
