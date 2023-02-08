package q3ex11;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SceneBuilder {
    private SceneBuilder() {}
    
    public static Scene buildScreen (Subject subject) {
        VBox central_display = new VBox();
        
        central_display.setAlignment(Pos.CENTER);
            
        // important stuff for hbox
        Button button_left = new Button("", new ImageView("arrow_back_ios.png")); // 2nd argument for graphics
        button_left.setAlignment(Pos.CENTER_LEFT);
        
        Button button_right = new Button("", new ImageView("arrow_forward_ios.png")); // 2nd argument for graphics
        button_right.setAlignment(Pos.CENTER_RIGHT);
        
        HBox overarching = new HBox();
        
        Scene scene = new Scene(overarching, 640, 400);
        return scene;
    }
}
