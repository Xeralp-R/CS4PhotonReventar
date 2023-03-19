package q3continuing.app.scenemanagers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import q3continuing.app.subject.Subject;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SubjectSceneFXMLController implements Initializable {
    @FXML
    private Text titleText;
    @FXML
    private Text unitText, gradeText, errorText;
    @FXML
    private Button prevButton, nextButton, backButton;
    @FXML
    private ImageView subjectPicture;
    @FXML
    private Button subjectSearchButton;
    @FXML
    private TextField subjectSearchBox;

    private SubjectSceneManager manager;
    private Subject subject;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setManager(SubjectSceneManager manager) {
        this.manager = manager;
    }

    public void setSubjectInformation(Subject subject) {
        if (this.manager == null) {
            throw new NullPointerException("No manager: aborting.");
        }

        this.subject = subject;
        this.clearSubjectInformation();

        this.titleText.setText(subject.getName());
        this.unitText.setText(String.format("%.2f", subject.getUnits()));
        this.gradeText.setText(String.format("%.2f", subject.getGrade()));
        this.subjectPicture.setImage(new Image(subject.getImgFileName()));
    }

    public void clearSubjectInformation() {
        this.unitText.setText(null);
        this.gradeText.setText(null);
        this.subjectPicture.setImage(null);
        this.titleText.setText(null);
        this.subject = null;
    }

    @FXML
    private void searchAction() {
        String searchQuery = this.subjectSearchBox.getCharacters().toString();
        Optional<Subject> subjectSearched = manager.subjectList.searchSubject(searchQuery);

        if (subjectSearched.isEmpty()) {
            // error dialog
            /*
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Subject Not Found");
            alert.setHeaderText("Error: Subject Not Found");
            alert.setContentText("It looks like you're looking for a subject that this student isn't taking. Please try again.");

            alert.showAndWait();
            return;*/
            errorText.setText("Subject not found.");
            return;
        }

        // presumed has a subject
        errorText.setText(null);
        this.manager.callSubject(subjectSearched.get());
    }

    @FXML
    private void previousAction() {
        manager.callPreviousSubject();
    }

    @FXML
    private void nextAction() {
        manager.callNextSubject();
    }

    //@FXML
    private void backAction() {
        manager.returnHome();
    }
}
