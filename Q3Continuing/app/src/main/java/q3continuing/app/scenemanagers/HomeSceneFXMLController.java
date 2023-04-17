package q3continuing.app.scenemanagers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import q3continuing.app.subject.Subject;
import q3continuing.app.subject.SubjectList;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Lauan 03
 */
public class HomeSceneFXMLController implements Initializable {

    @FXML
    private VBox subject1, subject2, subject3;
    @FXML
    private Button prev, next, load;

    private int pageNo;
    private List<VBox> subjectBoxes;
    private HomeSceneManager manager;
    private SubjectList subjectList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectBoxes = List.of(subject1, subject2, subject3);
        pageNo = 0;
    }

    public void setManager(HomeSceneManager manager) {
        this.manager = manager;
        this.subjectList = manager.subjectList;
    }

    public void setSubjectList(SubjectList subjectList) {
        if (subjectList != manager.subjectList) {
            throw new RuntimeException("Error: discrepancy in manager and controller subject lists.");
        }
        this.subjectList = subjectList;
        this.subjectList.fitSubjects(this.subjectBoxes.size());
    }

    public void setSubjectIcons() {
        if (subjectList == null) {
            return; // if there's nothing, no need for anything
        }

        int index = pageNo * 3;
        for (int i = 0; i < subjectBoxes.size(); ++i) {
            Optional<Subject> subj_opt = Optional.ofNullable(subjectList.getSubject(index + i));
            if (subj_opt.isEmpty()) {
                continue;
            }
            Subject s = subj_opt.get();

            // set the image
            ImageView imageview = (ImageView)(subjectBoxes.get(i).getChildren().get(0));
            imageview.setImage(new Image(s.getImgFileName()));
            imageview.setOnMouseClicked((event) -> {
                goToSubject(s);
            });

            // set the text
            Text text = (Text)(subjectBoxes.get(i).getChildren().get(1));
            text.setText(s.getName());
        }
    }

    public void clearIcons() {
        for (VBox i : subjectBoxes) {
            ImageView imageView = (ImageView)(i.getChildren().get(0));
            imageView.setImage(null);
            Text text = (Text)(i.getChildren().get(1));
            text.setText(null);
        }
    }

    @FXML
    private void next() {
        clearIcons();
        ++pageNo;
        setSubjectIcons();
    }

    @FXML
    private void previous() {
        clearIcons();
        --pageNo;
        setSubjectIcons();
    }

    @FXML
    private void load() {
        this.clearIcons();
        this.pageNo = 0;
        this.setSubjectList(this.manager.loadSubject());
        this.setSubjectIcons();
    }

    private void goToSubject(Subject subject) {
        manager.presentSubject(subject);
    }
}
