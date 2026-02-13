import FileHandler.FileHandler;
import cipher.CipherClass;
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
        assert ui != null;

        int index;
        try {
            index = Integer.parseInt(fileNumber) - 1;
        } catch (NumberFormatException e) {
            throw new FileNotFoundException("Invalid file number: " + fileNumber);
        }

        var files = file.listFiles(); // sorted list of filenames

        if (index < 0 || index >= files.size()) {
            throw new FileNotFoundException("File not found: " + fileNumber);
        }

        return file.readFile(files.get(index));
    }



    public String decipher() throws FileNotFoundException {
        fileContent = getFileContent();
        if(ui.getKey() != null) {
            return cipher.decipher(fileContent, ui.getKey());
        }
        return cipher.decipher(fileContent);
    }

    public String decipherTest() throws FileNotFoundException {
        return cipher.decipher(fileContent);
    }

    public String getKey() throws FileNotFoundException {
        return ui.getKey();
    }


}
