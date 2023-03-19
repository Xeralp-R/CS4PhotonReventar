package q3continuing.app.subject;

import q3continuing.utilities.CircularDoublyLinkedList;

import java.util.Optional;

public class SubjectList {
    CircularDoublyLinkedList<Subject> subjects = new CircularDoublyLinkedList<>();

    public SubjectList() {}

    public void registerSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public Subject getSubject(int i) {
        return subjects.getElement(i);
    }

    public Optional<Subject> searchSubject(String subject_name) {
        for(int i = 0; i < subjects.size(); ++i) {
            if (subjects.getElement(i).getName().equalsIgnoreCase(subject_name)) {
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

    public boolean isFirst(Subject subject) {
        return subjects.getFirstElement().equals(subject);
    }

    public boolean isLast(Subject subject) {
        return subjects.getLastElement().equals(subject);
    }

    public int size() {
        return subjects.size();
    }
}
