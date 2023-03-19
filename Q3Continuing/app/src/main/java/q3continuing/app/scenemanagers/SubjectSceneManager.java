package q3continuing.app.scenemanagers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import q3continuing.app.App;
import q3continuing.app.subject.Subject;
import q3continuing.app.subject.SubjectList;

import java.net.URL;

public class SubjectSceneManager {
    final App appInstance;
    SubjectList subjectList;
    Subject currentSubject;
    Scene subjectScene;

    public SubjectSceneManager(App appInstance) {
        this.appInstance = appInstance;
        this.subjectList = appInstance.subjectListLoader.loadSampleSubjectList();
    }

    public void generateScene(Subject subject) {
        this.currentSubject = subject;

        if (this.currentSubject == null) {
            throw new NullPointerException("No subject given to SubjectSceneManager to read: aborting.");
        }

        URL fxmlURL = this.getClass().getResource("SubjectScene.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlURL);
        try {
            Parent sceneRoot = loader.load();
            this.subjectScene = new Scene(sceneRoot);
        } catch (Exception e) {
            // That's future mes problem!
            throw new RuntimeException(e);
        }

        SubjectSceneFXMLController controller = loader.getController();
        controller.setManager(this);
        controller.setSubjectInformation(this.currentSubject);
    }

    public Scene getScene() {
        if (this.subjectScene == null) {
            throw new NullPointerException("Uninitialized subject scene: aborting.");
        }
        return this.subjectScene;
    }

    void callPreviousSubject() {
        appInstance.presentSubjectScene(subjectList.previousSubject(currentSubject));
    }

    void callNextSubject() {
        appInstance.presentSubjectScene(subjectList.nextSubject(currentSubject));
    }
    
    void callSubject(Subject s) {
        appInstance.presentSubjectScene(s);
    }

    void returnHome() {
        this.currentSubject = null;
        this.subjectScene = null;
        this.appInstance.presentHomeScene();
    }
}
