package q3continuing.app.scenemanagers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import q3continuing.app.App;
import q3continuing.app.subject.Subject;
import q3continuing.app.subject.SubjectList;

import java.io.InputStream;
import java.net.URL;

public class HomeSceneManager {
    final App appInstance;
    final SubjectList subjectList;
    Scene homeScene;

    public HomeSceneManager(App appInstance) {
        this.appInstance = appInstance;
        this.subjectList = appInstance.subjectListLoader.loadSampleSubjectList();
    }

    public void generateScene() {
        if (this.subjectList == null) {
            throw new NullPointerException("No initial scene for home screen: aborting.");
        }

        URL fxmlURL = this.getClass().getResource("HomeScene.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlURL);
        try {
            Parent sceneRoot = loader.load();
            this.homeScene = new Scene(sceneRoot);
        } catch (Exception e) {
            // That's future mes problem!
            throw new RuntimeException(e);
        }

        HomeSceneFXMLController controller = loader.getController();
        controller.setManager(this);
        controller.setSubjectIcons();
    }

    public Scene getScene() {
        if (this.homeScene == null) {
            throw new NullPointerException("Uninitialized home scene: aborting.");
        }
        return this.homeScene;
    }

    void presentSubject(Subject subject)  {
        this.appInstance.presentSubjectScene(subject);
    }
}
