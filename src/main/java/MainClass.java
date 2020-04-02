import java.io.File;
import java.util.HashMap;
import java.util.List;
import Database.*;
import Output.AnonymisedCV;
public class MainClass {
    public static void main(String[] args) {
        populate();
        File file = FileHandler.getFile();
        String fileAsString = Parser.fileToString(FileHandler.getFilePath(file));
        HashMap<String, List<String>> tokens = EntityMention.getAnnotations(fileAsString);
        System.out.println(tokens.get("PERSON"));
        Parser.outputHashmap(tokens);
        AnonymisedCV anonymisedCV = new AnonymisedCV();
        anonymisedCV.readQualifications();
    }

    public static void populate(){
        Manager m = new Manager();
        Candidates candidate = m.newCandidate("Matthew","Houghton","Male","Caucasian","b9028561@newcastle.ac.uk",
                "11111111111");
        Companies company = m.newCompany("Car-Flow", "111111111111", "b9028561@newcastle.ac.uk");
        Jobs job = m.newJob(company.getCompanyID(), "Software Engineer",
                "A java Software Engineer competent in hibernate so we don't have too");
        Applications application = m.newApplication(candidate.getCandidateID(), job.getJobID());
        Qualifications qualification1 = m.newQualification(application.getApplicationID(), "Computer Science", "Bachelore's"
        , "First"); //;)
        Qualifications qualification2 = m.newQualification(application.getApplicationID(), "Maths", "A-Level",
                "C");

    }

}
