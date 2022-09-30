public class Requirement {

    public enum Subject {
        Math,
        Physics,
        Chemistry,
        Biology,
        CS,
        SS, // add more later
    }

    int number;
    Subject subject;
    String name;
    boolean is_finished;

    public Requirement(int num, Subject subj, String nam, boolean is_fin) {
        number = num;
        subject = subj;
        name = nam;
        is_finished = is_fin;
    }

    @Override
    public final String toString() {
        return String.format(
            "Requirement Number: %d%nSubject: %s%nName: %s%nFinished? %s%n%n",
            this.number,
            this.subject.name(),
            this.name,
            this.is_finished ? "Yes" : "No"
        );
    }
}
