package q3continuing.app;

import q3continuing.utilities.CircularDoublyLinkedList;

import java.util.Optional;

public class SubjectList {
    CircularDoublyLinkedList<Subject> subjects = new CircularDoublyLinkedList<>();

    public SubjectList() {}

    public void registerSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public Optional<Subject> searchSubject(String subject_name) {
        for(int i = 0; i < subjects.size(); ++i) {
            if (subjects.getElement(i).getName().toLowerCase().equals(subject_name.toLowerCase())) {
                return Optional.ofNullable(subjects.getElement(i));
            }
        }
        return Optional.empty();
    }

    public Subject nextSubject(Subject currentSubject) {
        return subjects.findNode(currentSubject).getNext().getData();
    }

    public Subject previousSubject(Subject currentSubject) {
        return subjects.findNode(currentSubject).getPrevious().getData();
    }
}
