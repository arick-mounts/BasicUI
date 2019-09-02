import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

/*
 *This program is a basic ui text case updater. 
 *It utilizes buttons to edit the phrase on screen
 *Java @ TCC
 *Arick Mounts
 */

public class Main extends Application {

	String Input = "Hello World";
	
    public void start(Stage primaryStage) throws Exception{
        




		
        Label lbl = new Label(Input);
        Button btn1 = new Button("Uppercase" );
        Button btn2 = new Button("Lowercase" );
        Button btn3 = new Button("New Phrase" );
        Button btn4 = new Button("Reset" );


		btn1.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent ae ){
					lbl.setText(Input.toUpperCase());
				}
			}
		);
		btn2.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent ae ){
					lbl.setText(Input.toLowerCase());
				}
			}
		);
		btn3.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent ae ){
					getIn();
					lbl.setText(Input);
				}
			}
		);
		btn4.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent ae ){
					reset();
					lbl.setText(Input);
				}
			}
		);
        lbl.setPrefSize( 160, 40 );
        btn1.setPrefSize( 80, 40);
        btn2.setPrefSize( 80, 40);
        btn3.setPrefSize( 80, 40);
        btn4.setPrefSize( 80, 40);

        lbl.setAlignment(Pos.CENTER);

        GridPane root= new GridPane();
        //root.setGridLinesVisible (true);
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding( new Insets( 25, 10, 25, 10 ));
        root.add(lbl, 0, 0, 2, 1);
        root.add(btn1, 0, 1);
        root.add(btn2, 1, 1);
        root.add(btn3, 0, 2);
        root.add(btn4, 1, 2);



        Scene scene = new Scene( root, 200, 200);

        primaryStage.setTitle("HelloWorld!");
        primaryStage.setScene(scene);
        primaryStage.show();

		

    }


    public static void main(String[] args) {
        launch(args);
    }
	
	public void reset (){
		Input = "Hello World";
	}
	public void getIn(){
		TextInputDialog text = new TextInputDialog();
		text.setTitle("Please Enter Text");
		text.setHeaderText( "Please enter sample text" );
		text.setContentText("Please enter text here:");
		
		Optional< String > result = text.showAndWait();
		if (result.isPresent()){
			Input=result.get();
		}
		
	}
	
}
