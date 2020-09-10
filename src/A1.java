import java.nio.file.Files;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

//  TODO: Test dispatch time
//  TODO: Generate report using a report class? method generateReport in SchedulingAlgo?
//  TODO: Clean up file exception stuff

public class A1 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) { // If no args given, exit
            System.out.println("Usage: A1 [file]");
            return;
        }
        Path filePath = Paths.get(args[0]);
        System.out.println(filePath);
        if (!Files.exists(filePath)) {
            System.out.println("File " + filePath.getFileName() + " is not found");
            System.out.println("Exiting...");
            return;
        }
//        If given file exits, run method "run"
        A1 main = new A1();
        main.run(filePath);

    }

    private void run(Path p) throws FileNotFoundException {

        ArrayList<Job> jobs = new ArrayList<Job>(); // Create an ArrayList object

        FileData data = readJobsFromFile(p);
        int disp = data.getDisp();
        jobs = data.getJobs();

//
//        FCFS algoFCFS = new FCFS(disp);
//        algoFCFS.addJobs(jobs);
//        Result resultFCFS = algoFCFS.run();
//        resultFCFS.printResult();

//        SPN algoSPN = new SPN(disp);
//        algoSPN.addJobs(jobs);
//        Result resultSPN = algoSPN.run();
//        resultSPN.printResult();
//
//        PP algoPP = new PP(disp);
//        algoPP.addJobs(jobs);
//        Result resultPP = algoPP.run();
//        resultPP.printResult();

        PRR algoPRR = new PRR(disp);
        algoPRR.addJobs(jobs);
        Result resultPRR = algoPRR.run();
        resultPRR.printResult();


//        TODO: Print results


    }

    private FileData readJobsFromFile(Path p) throws FileNotFoundException {
        Scanner inputStream;
        inputStream = new Scanner (new File(String.valueOf(p.getFileName())));
        ArrayList<Job> jobs = new ArrayList<>(); // Create an ArrayList object

        int disp = 0;
        String id = null;
        int arrive = -1;
        int execSize = -1;
        int priority = -1;


        while (inputStream.hasNextLine()) {  // While until end of file
            String line = inputStream.nextLine();
//            System.out.println(line);
            if (line.contains("DISP: ")) {
                String[] splitLine = line.split(" ", 2);
                disp = Integer.parseInt(splitLine[1]);
            } else if (line.contains("ID: ")) {
                String[] splitLine = line.split(" ", 2);
                id = splitLine[1];
            } else if (line.contains("Arrive: ")) {
                String[] splitLine = line.split(" ", 2);
                arrive = Integer.parseInt(splitLine[1]);
            } else if (line.contains("ExecSize: ")) {
                String[] splitLine = line.split(" ", 2);
                execSize = Integer.parseInt(splitLine[1]);
            } else if (line.contains("Priority: ")) {
                String[] splitLine = line.split(" ", 2);
                priority = Integer.parseInt(splitLine[1]);
            }
            if (id != null && arrive != -1 && execSize != -1 && priority != -1) { // process is ready to be added to arraylist
                Job temp = new Job(id, arrive, execSize, priority);
                jobs.add(temp);
                // reset vars once job added to list
                id = null;
                arrive = -1;
                execSize = -1;
                priority = -1;
            }
        }
        return new FileData(disp, jobs);
    }
}
