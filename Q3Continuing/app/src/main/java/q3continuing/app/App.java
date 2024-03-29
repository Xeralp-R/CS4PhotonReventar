package q3continuing.app;

import javafx.application.Application;
import javafx.stage.Stage;
import q3continuing.app.scenemanagers.HomeSceneManager;
import q3continuing.app.scenemanagers.SubjectSceneManager;
import q3continuing.app.subject.Subject;
import q3continuing.app.subject.SubjectListLoader;
import q3continuing.utilities.CircularDoublyLinkedList;
import q3continuing.utilities.DoublyLinkedNode;

public class App extends Application {
    final static public int PREFERRED_WIDTH = 600;
    final static public int PREFERRED_HEIGHT = 240;

    public final SubjectListLoader subjectListLoader = new SubjectListLoader();
    HomeSceneManager homeSceneManager;
    SubjectSceneManager subjectSceneManager;

    Stage stage;

    public void presentHomeScene() {
        if (this.homeSceneManager == null) {
            this.homeSceneManager = new HomeSceneManager(this);
        }
        this.homeSceneManager.generateScene();
        this.stage.setScene(homeSceneManager.getScene());
    }

    public void presentSubjectScene(Subject s) {
        if (this.subjectSceneManager == null) {
            this.subjectSceneManager = new SubjectSceneManager(this);
        }
        this.subjectSceneManager.generateScene(s);
        this.stage.setScene(subjectSceneManager.getScene());
    }

    @Override
    public void start(Stage stage) {
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");

        this.stage = stage;

        presentHomeScene();

        this.stage.setTitle("Q3Continuing");
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
