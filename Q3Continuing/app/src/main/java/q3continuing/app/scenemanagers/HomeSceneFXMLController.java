package q3continuing.app.scenemanagers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView icon1, icon2, icon3;
    @FXML
    private Button prev, next;

    private int pageNo;
    private int maxPage;
    private List<ImageView> iconList;

    private SubjectList subjectList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iconList = List.of(icon1, icon2, icon3);
        pageNo = 0;
    }

    public void setSubjectList(SubjectList subjectList) {
        this.subjectList = subjectList;
    }

    public void setSubjectIcons() {
        if (subjectList == null) {
            throw new NullPointerException("Uninitialized subjectList in Home Screen. Aborting.");
        }

        int index = pageNo * 3;
        for (int i = 0; i < iconList.size(); ++i) {
            Subject s = subjectList.getSubject(index + i);
            Image img = new Image(s.getImgFileName());
            iconList.get(i).setImage(img);
        }
    }

    public void clearIcons() {
        for (ImageView i : iconList) {
            i.setImage(null);
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
