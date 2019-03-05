import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Mp3Player extends Application{
	public static void main(String[] args) {
	       launch(args);
	    }  
    ListView<SelectingMp3File> List_Songs;
    Button play;
    Button next;
    Button back;

    public void start(Stage primaryStage) throws Exception {

        List_Songs = new ListView<>();
        List_Songs.getItems().addAll(loadSomeSongs());// This code lists all the song
        play = new Button("Play"); // This code shows Play button
        back = new Button("Back");// This code show Back Button
        next = new Button("Next");// This code shows Next Button
        
        HBox buttons = new HBox(play, back, next); //These codes allows the user to see the buttons and use it
        HBox rows = new HBox( List_Songs, buttons);

        Pane panel = new Pane(rows);
        Scene view = new Scene(panel);
        primaryStage.setScene(view);         //These code shows the table where the list of songs are stored
        primaryStage.setTitle("Music");
        primaryStage.show();

        play.setOnAction(e -> {

        });// this code is used to play songs

        next.setOnAction(e -> {

            List_Songs.getSelectionModel().selectNext();
            
        });// this code allows the user  to click next and go to the next song

        back.setOnAction(e -> {

            List_Songs.getSelectionModel().selectPrevious();

        });// this code allows the user to click back and go to the previous song

    }

    public ArrayList<SelectingMp3File> loadSomeSongs() {

        ArrayList<SelectingMp3File> MusicList = new ArrayList<>();

        MusicList.add(new SelectingMp3File("No tears left to cry")); //These are list of songs
        MusicList.add(new SelectingMp3File("Focus"));
        MusicList.add(new SelectingMp3File("Havana"));
        MusicList.add(new SelectingMp3File("Never Be The Same"));
        
        return MusicList;

    }
}

