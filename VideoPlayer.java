package player;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MoviePlayer extends Application {
    	public static void main(String[] args) {
            lauch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	    stage.setTitle("Adoni TV");
	    Group root = new Group();
	    
	    Media media = new Media(" ");
	    MediaPlayer player = new MediaPayer(media);
	    MediaView view = new MediaView(player);
	    
	    // System.out.print("media.width: " + media.getWidth());
	    
	    final VBoc vbox = new VBox();
	    Slider slider = new Slider();
	    vbox.getChildren().add(slider);
	    
	    root.getChildren().add(vbox);
	    root.getChildren().add(view);
	    media.getWidth();
	    media.getHeight();
	    
	    root.getChildren().add(view);
        Scene scene = new Scene(root, 1200, 800, color.GREEN);
	    stage.setScene(scene);
	    stage.show();
	    
	    player.play();
	    player.setOnReady(new Runnable()
        {
            
        @Override 
        public void run() {
             int w = player.getMedia().getWidth();
             int h = player.getMedia().getHeight();
        
             stage.setMinWidth(w);
             stage.setMinHeight(h);
             
             vbox.setMinSize(w, 100);
             vbox.setTranslateY(h-25);
             
             slider.setMin(0.0);
             slider.setValue(0.0);
             slider.setMax(player.getTotalDuration().toSeconds());
            }
	    });
	    
	    player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
	        @Override
	        public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, duration current) {
	            slider.setValue(current.toSeconds());
	        }
	    });
	    
	    slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent mouseEvent) {
	            player.seek(Duration.seconds(slider.getValue()));
	        }
	    }
	    // Controller
	    
    }
}
