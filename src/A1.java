import java.nio.file.Files;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A1 {
    public static void main(String[] args) {

        if (args.length != 1) { // If no args given, exit
            System.out.println("Usage: A1 [file]");
            return;
        }

        Path filePath = Paths.get(args[0]);
        System.out.println(filePath);

        if (!Files.exists(filePath)) {
            System.out.println("File" + filePath.getFileName() + " is not found");
            System.out.println("Exiting...");
            return;
        }

//        If given file exits, run method "run"
        A1 main = new A1();
        main.run(filePath);

    }

    private void run(Path p) {

        ArrayList<Job> jobs = new ArrayList<Job>(); // Create an ArrayList object

        Job test = new Job("test", 1, 2, 3);

//        jobs.add(test);
//        System.out.println(jobs.get(0));

    }

}
