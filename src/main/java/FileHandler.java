import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileHandler {

    private static File chooseFile(){
        File file = null;
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();

        }
        return file;
    }

    public static String getFilePath(File file) {
        return file.getAbsolutePath();
    }

    private static String getFileExt(String path){
        String ext = "";
        int slashIndex = path.lastIndexOf("\\");
        int dotIndex = path.lastIndexOf(".");
        if (dotIndex > slashIndex){
            ext = path.substring(dotIndex+1);
        }
        return ext;
    }

    private static boolean checkFileExt(File file){
        boolean acceptable = false;
        String ext = getFileExt(getFilePath(file));
        String[] fileFormats = new String[]{"txt"}; // more file formats will be added for final product
        for (String format: fileFormats){ // checks that the given file format is in the list of allowed formats
            if (format.equals(ext)){
                acceptable = true;
                break;
            }
        }
        return acceptable;
    }

    public static File getFile(){
        boolean accepted = false;
        File file = null;
        while (!accepted){
            file = chooseFile();
            accepted = checkFileExt(file);
            if (!accepted){
                System.out.println("Invalid file format, please choose a valid file");
            }
        }
        return file;
    }


}
