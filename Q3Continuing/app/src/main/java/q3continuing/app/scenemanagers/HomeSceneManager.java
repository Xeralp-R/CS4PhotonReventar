package q3continuing.app.scenemanagers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import q3continuing.app.App;
import q3continuing.app.subject.Subject;
import q3continuing.app.subject.SubjectList;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class HomeSceneManager {
    final App appInstance;
    SubjectList subjectList;
    Scene homeScene;

    public HomeSceneManager(App appInstance) {
        this.appInstance = appInstance;
        this.subjectList = null;
    }

    public void generateScene() {
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

    public SubjectList loadSubject() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv files", "*.csv"));
        File fileSelected = fileChooser.showOpenDialog(homeScene.getWindow());

        if (fileSelected == null) {
            return null;
        }
        this.subjectList = appInstance.subjectListLoader.loadSubjectList(fileSelected);

        return this.subjectList;
    }

    void presentSubject(Subject subject)  {
        this.appInstance.presentSubjectScene(subject);
    }
}
