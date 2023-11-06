import java.io.File;
import java.util.ArrayList;

abstract class Parse {
    ArrayList<String> contents;
    File sourceFile;

    abstract boolean readFile(); //{
    //     try {
    //         Scanner in = new Scanner(this.sourceFile);
    //         in.useDelimiter(" ");
    //         while (in.hasNextLine()) {
    //             contents.add(in.nextLine());
    //         }
    //         in.close();
    //         return true;
    //     } catch (FileNotFoundException e) {
    //         return false;
    //     }
        
    // }

    abstract boolean writeFile(Object o);
}
