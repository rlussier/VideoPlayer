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
            }
	    });
    }
}
