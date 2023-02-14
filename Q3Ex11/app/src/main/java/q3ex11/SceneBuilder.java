package q3ex11;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SceneBuilder {
    public static Pane buildScreen (Subject subject) {
        Label subject_name = new Label(subject.getName());
        VBox central_display = new VBox(subject_name);
        
        central_display.setAlignment(Pos.CENTER);
            
        // important stuff for hbox
        Button button_left = new Button("", new ImageView("arrow_back_ios.png")); // 2nd argument for graphics
        button_left.setAlignment(Pos.CENTER_LEFT);
        button_left.setOnAction(event -> {
            try {
                SwitchboardSingleton.get_instance().alert("change_screen_event", new EventWrapper(event, "left"));
            } catch (Exception e) {
                System.err.print("Impossible error: unknown change screen");
                System.exit(1);
            }
        });
        
        Button button_right = new Button("", new ImageView("arrow_forward_ios.png")); // 2nd argument for graphics
        button_right.setAlignment(Pos.CENTER_RIGHT);
        button_right.setOnAction(event -> {
            try {
                SwitchboardSingleton.get_instance().alert("change_screen_event", new EventWrapper(event, "right"));
            } catch (Exception e) {
                System.err.print("Impossible error: unknown change screen");
                System.exit(1);
            }
        });
        
        HBox overarching = new HBox(button_left, central_display, button_right);
        
        return overarching;
    }
}
