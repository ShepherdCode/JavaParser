import java.io.*;
import java.nio.*;
import java.util.*;


/** 
 * JavaParser.
 * Parse a Java program into individual words.
 *
 * @author Jason Miller Editors: Isaac and Jason
 * @version 1.0
 */
public class JasonAndIsaac {
    BufferedReader reader;
    String filename;
    String delimiters = " ";
    ArrayList<String> wordsArray = new ArrayList<String>();

    /**
     * Constructor for objects of class JavaParser.
     * @param filename Name of file to read. Current directory assumed.
     */
    public JasonAndIsaac(String filename) {
        this.filename = filename;
    }
    /**
     * Show the filename associated with this class.
     * @return filename that was given to the constructor.
     */
    public String getFilename() {
        return filename;
    }
    /**
     * Open the file associated with this class.
     * If a file was already open, this would close it.
     * @return true if the file could be opened.
     */
    public void openFile () throws FileNotFoundException {
        reader = null;
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        reader = new BufferedReader(fr);
    }
    /**
     * Demonstrates how to use this class.
     * Parses this Java program.
     * Assumes the program is in the current directory.
     * @param No parameter is required.
     */
    public static void main (String[] args) {
        JasonAndIsaac ji = new JasonAndIsaac("JasonAndIsaac.java");
        try {
            ji.openFile();
            ji.printLineByLine();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: cannot open "+ji.getFilename());
        } catch (IOException e) {
            System.err.println("ERROR: while reading "+ji.getFilename());
        }
        ji.alphabetizeArray();
        ji.printout();
        
    }   
    /**
     * Take input from the reader.
     * Break the input into lines.
     * On each line, call printWordByWord().
     * Do nothing unless openFile() has run successfully.
     */
    public void printLineByLine() throws IOException {
        String line;
        if (reader!=null) {
            do {  
                line=reader.readLine();
                if (line != null) {
                    arrayWordByWord(line);
                }
            } while (line != null);
        }
    }
    /**
     * Break the given string into words.
     * Use the delimiter that belongs to this.
     * On each word, call printout().
     */
    public void arrayWordByWord (String oneline) {
        String word;
        StringTokenizer splitter = new StringTokenizer (oneline,delimiters);
        while (splitter.hasMoreTokens()) {
            word = splitter.nextToken();
            wordsArray.add(word);
        }
    }
    public void printout () {
        for (int i = 0; i < wordsArray.size(); i++){
            System.out.println(wordsArray.get(i));
        }
    }
    /**
     * Send the given string to the console.
     */
    public void alphabetizeArray () {
        Collections.sort(wordsArray);
    }
}
