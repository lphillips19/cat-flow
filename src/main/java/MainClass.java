import java.io.File;

public class MainClass {
    public static void main(String[] args) {
        File file = FileHandler.getFile();
        String fileAsString = Parser.fileToString(FileHandler.getFilePath(file));
        EntityMention.getAnnotations(fileAsString);

    }
}
