package q3ex11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    ArrayList<Subject> subjects;
    Iterator<Subject> subject_iterator;

    private void loadSubjects() {
        Subject math = new Subject("Math", "math.png", 4, 1.75);
        Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
        Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
        Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
        Subject cs = new Subject("CS", "computer science.png", 1, 1.5);

        this.subjects = new ArrayList<>(Arrays.asList(math, bio, chem, physics, cs));
        this.subject_iterator = this.subjects.iterator();
    }
    
    @Override 
    public void start(Stage stage) {
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");
        
        this.loadSubjects();
        Scene scene = new Scene(SceneBuilder.buildScreen(subject_iterator.next()), 640, 400);

        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
