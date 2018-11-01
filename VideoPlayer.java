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
	    
	    final VBox vbox = new VBox();
	    Slider slider = new Slider();
	    vbox.getChildren().add(slider);
		
	    final HBox hbox- new HBox(2);
	    final int bands = player.getAudioSpectrumMumBands();
	    final Rectangle[] rects = new Rectangle[bands};
	    for (int i=0; i<rects.length i++) {
		    rects[i] = new Rectangle();
		    rects[i].setFill(Color.BLUE);
		    hbox.getChildren().add(rects[i]);
	    }		

	    vbox.getChildren().add(hbox);
						    
	    root.getChildren().add(vbox);
	    root.getChildren().add(view);
						    
	    media.getWidth();
	    media.getHeight();
	    
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
        
	     hbox.setMinWidth(w);
	     int bandWidth = w/rects.length;
		for (Rectangle r:rects) {
			r.setWidth(bandWidth);
			r.setHeight(2);
			
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
