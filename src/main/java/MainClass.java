import java.io.File;
import java.util.HashMap;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        File file = FileHandler.getFile();
        String fileAsString = Parser.fileToString(FileHandler.getFilePath(file));
        HashMap<String, List<String>> tokens = EntityMention.getAnnotations(fileAsString);
        System.out.println(tokens.get("PERSON"));

    }
}
