package q3ex11.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import q3ex11.utils.CircularDoublyLinkedList;
import q3ex11.utils.DoublyLinkedNode;

public class App extends Application implements EventReceiverInterface {
    CircularDoublyLinkedList<Subject> subjects = new CircularDoublyLinkedList<>();
    DoublyLinkedNode<Subject> current_subject;

    Stage stage;

    private void loadSubjects() {
        Subject math = new Subject("Math", "math.png", 4, 1.75);
        Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
        Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
        Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
        Subject cs = new Subject("CS", "computer_science.png", 1, 1.5);

        // make more efficient
        this.subjects.add(math);
        this.subjects.add(bio);
        this.subjects.add(chem);
        this.subjects.add(physics);
        this.subjects.add(cs);
        this.current_subject = this.subjects.getNode(0);
    }

    public void receiveEvent(String eName, EventWrapper eWrapper) {
        if (eName == "change_screen_event") {
            change_screen(eWrapper);
        }
    }

    public void change_screen(EventWrapper change_screen_event) {
        switch (change_screen_event.message) {
            case "left":
                current_subject = current_subject.getPrevious();
                break;
            case "right":
                current_subject = current_subject.getNext();
                break;
            default:
                System.err.println("invalid arrow direction");
                break;
        }
        this.stage.setScene(new Scene(SceneBuilder.buildScreen(current_subject.getData())));
    }

    @Override
    public void start(Stage stage) {
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");

        this.stage = stage;

        this.loadSubjects();

        SwitchboardSingleton
            .get_instance()
            .subscribe("change_screen_event", this);

        var overarching_node = SceneBuilder.buildScreen(
            current_subject.getData()
        );

        Scene scene = new Scene(overarching_node);

        this.stage.setScene(scene);
        this.stage.setTitle("Q3Ex11");
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
