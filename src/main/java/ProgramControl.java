import cipher.CipherClass;

import javax.crypto.Cipher;

public class ProgramControl {
    String[] args;
    CipherClass cipher;
    CliArgs ui;

    public ProgramControl(String[] args) {
      this.args = args;
      this.cipher = new CipherClass();
      this.ui = new CliArgs(args);
    }


    String fileNumber = ui.getFileNumber();

    public String getFileContent(){
        //call filemanager class
        return "";
    }

    String fileContent = getFileContent();

    public String decipher(){
        return cipher.decipher(fileContent);
    }


}
