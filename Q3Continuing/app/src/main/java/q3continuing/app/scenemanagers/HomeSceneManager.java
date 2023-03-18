package q3continuing.app.scenemanagers;

import javafx.scene.Scene;
import q3continuing.app.subject.SubjectList;

public class HomeSceneManager {
    SubjectList subjectList;
    Scene homeScene;

    public HomeSceneManager(SubjectList subjectList) {
        this.subjectList = subjectList;
    }

    public void generateScene() {
        if (this.subjectList == null) {
            throw new NullPointerException("No initial scene for home screen: aborting.");
        }


    }
}
