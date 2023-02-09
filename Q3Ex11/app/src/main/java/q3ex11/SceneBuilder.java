package q3ex11;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SceneBuilder {
    public static Pane buildScreen (Subject subject) {
        VBox central_display = new VBox();
        
        central_display.setAlignment(Pos.CENTER);
            
        // important stuff for hbox
        Button button_left = new Button("", new ImageView("arrow_back_ios.png")); // 2nd argument for graphics
        button_left.setAlignment(Pos.CENTER_LEFT);
        
        Button button_right = new Button("", new ImageView("arrow_forward_ios.png")); // 2nd argument for graphics
        button_right.setAlignment(Pos.CENTER_RIGHT);
        
        HBox overarching = new HBox(button_left, central_display, button_right);
        
        return overarching;
    }
}
