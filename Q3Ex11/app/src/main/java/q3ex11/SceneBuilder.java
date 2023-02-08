package q3ex11;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class SceneBuilder {
    private SceneBuilder() {}
    
    public static Screen buildScreen (Subject s) {
        VBox central_display = new VBox();
        
        central_display.setAlignment(pos.CENTER);
            
        // important stuff for hbox
        Button button_left = new Button("", ""); // 2nd argument for graphics
        button_left.setAlignment(pos.CENTER_LEFT);
        
        Button button_right = new Button("", ""); // 2nd argument for graphics
        button_right.setAlignment(pos.CENTER_RIGHT);
        
        HBox overarching = new HBox();
        
        Scene scene = new Scene(overarching, 640, 400);
        return scene;
    }
}
