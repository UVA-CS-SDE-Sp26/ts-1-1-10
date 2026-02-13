import FileHandler.FileHandler;
import cipher.CipherClass;
import javax.crypto.Cipher;
import java.io.FileNotFoundException;

public class ProgramControl {
    String[] args;
    CipherClass cipher;
    CliArgs ui;
    FileHandler file = new FileHandler();
    String fileNumber;
    String fileContent;

    public ProgramControl(String[] args) throws FileNotFoundException {
      this.args = args;
      this.cipher = new CipherClass();
      this.ui = new CliArgs(args);

      fileNumber = ui.getFileNumber();
    }

    public ProgramControl() throws FileNotFoundException {
        this.cipher = new CipherClass();

    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getFileNumber() {
        return fileNumber;
    }



    public String getFileContent() throws FileNotFoundException {
        //call filemanager class
        assert ui != null;
        return file.readFile(fileNumber);
        //return "";
    }


    public String decipher() throws FileNotFoundException {
        fileContent = getFileContent();
        return cipher.decipher(fileContent);
    }

    public String decipherTest() throws FileNotFoundException {
        return cipher.decipher(fileContent);
    }


}
