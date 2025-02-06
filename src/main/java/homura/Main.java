package homura;

// Copied from https://se-education.org/guides/tutorials/javaFxPart4.html
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

//    private Duke duke = new Duke();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
//            fxmlLoader.<MainWindow>getController().setDuke(duke);  // inject the Duke instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





// Recycling Bin ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//// Copied from https://se-education.org/guides/tutorials/
//// javaFxPart2.html#designing-the-layout
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import javafx.scene.image.Image;
//import javafx.scene.layout.Region;
//
//
//public class Main extends Application {
//
//    private ScrollPane scrollPane;
//    private VBox dialogContainer;
//    private TextField userInput;
//    private Button sendButton;
//    private Scene scene;
//
//    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
//    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));
//    private Duke duke = new Duke();
//
//    @Override
//    public void start(Stage stage) {
//        //Setting up required components
//
//        scrollPane = new ScrollPane();
//        dialogContainer = new VBox();
//        scrollPane.setContent(dialogContainer);
//
//        userInput = new TextField();
//        sendButton = new Button("Send");
//
////        DialogBox dialogBox = new DialogBox("Hello!", userImage);
////        dialogContainer.getChildren().addAll(dialogBox);
//
//        AnchorPane mainLayout = new AnchorPane();
//        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);
//
//        scene = new Scene(mainLayout);
//
//        stage.setScene(scene);
//        stage.show();
//
//        //Formatting the window to look as expected
//
//        stage.setTitle("Duke");
//        stage.setResizable(false);
//        stage.setMinHeight(600.0);
//        stage.setMinWidth(400.0);
//
//        mainLayout.setPrefSize(400.0, 600.0);
//
//        scrollPane.setPrefSize(385, 535);
//        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//
//        scrollPane.setVvalue(1.0);
//        scrollPane.setFitToWidth(true);
//
//        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);
//
//        userInput.setPrefWidth(325.0);
//
//        sendButton.setPrefWidth(55.0);
//
//        AnchorPane.setTopAnchor(scrollPane, 1.0);
//
//        AnchorPane.setBottomAnchor(sendButton, 1.0);
//        AnchorPane.setRightAnchor(sendButton, 1.0);
//
//        AnchorPane.setLeftAnchor(userInput , 1.0);
//        AnchorPane.setBottomAnchor(userInput, 1.0);
//
//        //More code to be added here later
//
//        //Handling user input
//
//        sendButton.setOnMouseClicked((event) -> {
//            handleUserInput();
//        });
//        userInput.setOnAction((event) -> {
//            handleUserInput();
//        });
//
//        //Scroll down to the end every time dialogContainer's height changes.
//        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));
//    }
//
//    /**
//     * Creates a dialog box containing user input, and appends it to
//     * the dialog container. Clears the user input after processing.
//     */
//    private void handleUserInput() {
////        dialogContainer.getChildren().addAll(new DialogBox(userInput.getText(), userImage));
////        userInput.clear();
//        String userText = userInput.getText();
//        String dukeText = duke.getResponse(userInput.getText());
//        dialogContainer.getChildren().addAll(
//                DialogBox.getUserDialog(userText, userImage),
//                DialogBox.getDukeDialog(dukeText, dukeImage)
//        );
//        userInput.clear();
//    }
//}
//
//
//
////// Copied from https://se-education.org/guides/tutorials/
////// javaFxPart1.html#guides-for-se-student-projects
////import javafx.application.Application;
////import javafx.scene.Scene;
////import javafx.scene.control.Label;
////import javafx.stage.Stage;
////
////public class Main extends Application {
////
////    @Override
////    public void start(Stage stage) {
////        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
////        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label
////
////        stage.setScene(scene); // Setting the stage to show our scene
////        stage.show(); // Render the stage.
////    }
////}
