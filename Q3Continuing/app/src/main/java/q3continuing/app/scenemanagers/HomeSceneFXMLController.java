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
import java.util.ResourceBundle;

/**
 * @author Lauan 03
 */
public class HomeSceneFXMLController implements Initializable {

    @FXML
    private VBox subject1, subject2, subject3;
    @FXML
    private Button prev, next;

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

    public void setSubjectIcons() {
        if (subjectList == null) {
            throw new NullPointerException("Uninitialized subjectList in Home Screen. Aborting.");
        }

        int index = pageNo * 3;
        for (int i = 0; i < subjectBoxes.size(); ++i) {
            Subject s = subjectList.getSubject(index + i);

            // set the image
            ImageView imageview = (ImageView)(subjectBoxes.get(i).getChildren().get(0));
            imageview.setImage(new Image(s.getImgFileName()));

            // set the text
            Text text = (Text)(subjectBoxes.get(i).getChildren().get(1));
            text.setText(s.getName());
        }
    }

    public void clearIcons() {
        for (VBox i : subjectBoxes) {
            ImageView imageView = (ImageView)(i.getChildren().get(0));
            imageView.setImage(null);
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
}
