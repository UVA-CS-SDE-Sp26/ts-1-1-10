import java.io.FileNotFoundException;

/**
 * Commmand Line Utility
 */
public class TopSecret {

    public static void main(String[] args) throws FileNotFoundException {

        CliArgs ui = new CliArgs(args);


        if (ui.getErrorMessage() != null) {
            System.out.println(ui.getErrorMessage());
            return;
        }

        if (ui.getFileNumber() == null) {
            System.out.println("01 filea.txt");
            System.out.println("02 fileb.txt");
            System.out.println("03 filec.txt");
            return;
        }

        ProgramControl program = new ProgramControl(args);

        try {
            System.out.println("Displaying file " + ui.getFileNumber());
            System.out.println(program.decipher());

            if (ui.getKey() != null) {
                System.out.println("Using alternate key: " + ui.getKey());
            }

        } catch (Exception e) {
            System.out.println("Error: Unable to decipher using the provided key.");
        }

    }
}
