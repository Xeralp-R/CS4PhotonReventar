package q3continuing.app;

public class SubjectListLoader {
    public SubjectList loadSampleSubjectList () {
        SubjectList sampleSubjectList = new SubjectList();

        sampleSubjectList.registerSubject(new Subject("Math", "math.png", 4, 1.75));
        sampleSubjectList.registerSubject(new Subject("Biology", "biology.png", 3, 2.0));
        sampleSubjectList.registerSubject(new Subject("Chemistry", "chemistry.png", 3, 1.5));
        sampleSubjectList.registerSubject(new Subject("Physics", "physics.png", 3, 1.75));
        sampleSubjectList.registerSubject(new Subject("CS", "computer_science.png", 1, 1.5));

        return sampleSubjectList;
    }
}
