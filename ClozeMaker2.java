import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClozeMaker2 {

    private String words = "생태계,재편,공급,대체,구도,과시,부상,기반,제공,대응,수요,역량,구현,격전지,지속,좌우";
    private String[] wordsToReplace = words.split(",");
    private String content;

    public ClozeMaker2(String passageFileName) throws FileNotFoundException {

        content = new Scanner(new File("Passage1.txt")).useDelimiter("\\Z").next();
        for (int i = 0; i < wordsToReplace.length; i++) {
            String word = wordsToReplace[i];
            if (content.contains(word)) {
                content = content.replace(word, "||" + word + "||");
            }
        }
    }

    public void savePassageToFile(String filename) {
        try {
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(filename);
            PrintWriter pw = new PrintWriter(filename);
            pw.println(content);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ClozeMaker2 clozeMaker2 = new ClozeMaker2("Passage1.txt");
        clozeMaker2.savePassageToFile("updatedFile.txt");
    }
}

