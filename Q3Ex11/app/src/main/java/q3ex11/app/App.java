package q3ex11.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import q3ex11.utils.CircularDoublyLinkedList;
import q3ex11.utils.DoublyLinkedNode;

public class App extends Application {
    CircularDoublyLinkedList<Subject> subjects = new CircularDoublyLinkedList<>();
    DoublyLinkedNode<Subject> current_subject;

    private void loadSubjects() {
        Subject math = new Subject("Math", "math.png", 4, 1.75);
        Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
        Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
        Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
        Subject cs = new Subject("CS", "computer science.png", 1, 1.5);

        // make more efficient
        this.subjects.add(math);
        this.subjects.add(bio);
        this.subjects.add(chem);
        this.subjects.add(physics);
        this.subjects.add(cs);
        this.current_subject = this.subjects.getNode(0);
    }
    
    @Override 
    public void start(Stage stage) {
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");
        
        this.loadSubjects();

        
        while(true) {
            try {
                var change_screen_future = SwitchboardSingleton.get_instance().subscribe("change_screen_event");
                var overarching_node = SceneBuilder.buildScreen(current_subject.getData());
        
                Scene scene = new Scene(overarching_node, 640, 400);

                stage.setScene(scene);
                stage.show();

                change_screen_future.get();

                if (change_screen_future.get().message == "left") {
                    current_subject = current_subject.getPrevious();
                    continue;
                } else if (change_screen_future.get().message == "right") {
                    current_subject = current_subject.getNext();
                    continue;
                } else {
                    System.err.print("Impossible error");
                    System.exit(2);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
    
    public static void main(String[] args) {
        launch();
    }
}
