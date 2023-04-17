package q3continuing.app.subject;

import java.io.*;

public class SubjectListLoader {
    public SubjectList loadSampleSubjectList() {
        SubjectList sampleSubjectList = new SubjectList();

        sampleSubjectList.registerSubject(new Subject("Math", "math.png", 4, 1.75));
        sampleSubjectList.registerSubject(new Subject("Biology", "biology.png", 3, 2.0));
        sampleSubjectList.registerSubject(new Subject("Chemistry", "chemistry.png", 3, 1.5));
        sampleSubjectList.registerSubject(new Subject("Physics", "physics.png", 3, 1.75));
        sampleSubjectList.registerSubject(new Subject("Computer Science", "computer_science.png", 1, 1.5));
        sampleSubjectList.registerSubject(new Subject("Social Science", "social_science.png", 1, 1.5));
        sampleSubjectList.registerSubject(new Subject("English", "english.png", 1, 1.75));
        sampleSubjectList.registerSubject(new Subject("Research", "research.png", 5, 1.5));

        return sampleSubjectList;
    }

    public SubjectList loadSubjectList(File subjectFile) {
        try {
            SubjectList returner = new SubjectList();

            FileReader inter_reader = new FileReader(subjectFile);
            BufferedReader reader = new BufferedReader(inter_reader);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(",");
                returner.registerSubject(new Subject(array[0],
                        array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3])));
            }

            reader.close();

            return returner;
        } catch (IOException fe) {
            throw new RuntimeException("Error in parsing file. Details: " + fe);
        }
    }
}
