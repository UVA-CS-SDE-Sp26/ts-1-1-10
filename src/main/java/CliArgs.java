public class CliArgs {

    private String fileNumber;
    private String key;
    private String errorMessage;



    public CliArgs(String[] args) {

        if (args.length ==0) {
            return;
        }

        if (args.length > 2) {
            setErrorMessage("Error: Too many arguments." );
            return;
        }

        if(!args[0].equals("01") && !args[0].equals("02") && !args[0].equals("03")) {
            setErrorMessage("Error: Can only be file 01, 02, or 03");
            return;
        }

        setFileNumber(args[0]);

        if (args.length ==2) {
            setKey(args[1]);
        }
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
