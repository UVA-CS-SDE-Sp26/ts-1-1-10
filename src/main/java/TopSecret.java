/**
 * Commmand Line Utility
 */
public class TopSecret {

    public static void main(String[] args) {

        CliArgs ui = new CliArgs(args);
        ProgramControl program = new ProgramControl(args);

        if (ui.getErrorMessage() != null) {
            System.out.println(ui.getErrorMessage());
            return;
        }

        if (ui.getFileNumber() == null) {
            System.out.println("01 filea.txt");
            System.out.println("02 fileb.txt");
            System.out.println("03 filec.txt");
        }

        System.out.println("Displaying file " + ui.getFileNumber());
        System.out.println(program.decipher());

        if (ui.getKey() != null) {
            System.out.println("Using alterate key: " + ui.getKey());
        }
    }
}
