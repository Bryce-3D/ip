package homura;

// Copied from https://se-education.org/guides/tutorials/javaFxPart4.html
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

//    private Duke duke;
//    private Homura homura;
    private boolean isOffing = false;

    private Image madoImage = new Image(this.getClass()
            .getResourceAsStream("/images/Mado_pfp.png"));
    private Image homuImage = new Image(this.getClass()
            .getResourceAsStream("/images/Homu_pfp.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        // Send the on message
        dialogContainer.getChildren().addAll(
                DialogBox.getHomuDialog(Ui.introMsgJavafx(), homuImage)
        );

        // Read the saved todo list
        Homura.setTodos(Storage.readTodos(Homura.TODOS_FILENAME));
    }

//    /** Injects the Duke instance */
//    public void setDuke(Homura h) {
//        homura = h;
//    }

    /**
     * Creates two dialog boxes, one echoing user input and the other
     * containing Homura's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        // Extra logic for turning off (1/2)
        if (isOffing) {
            // Inspired by asking ChatGPT the following query
            // "Hi! I'm now trying to make my application exit upon receiving
            // the command "bye". However, I'm not sure how to do this. I
            // currently have this handler to handle the user's inputs.
            //
            //```
            //    @FXML
            //    private void handleUserInput() {
            //        String inp = userInput.getText();
            //        String response = Homura.cmdJavafx(inp);
            //        dialogContainer.getChildren().addAll(
            //                DialogBox.getUserDialog(inp, madoImage),
            //                DialogBox.getHomuDialog(response, homuImage)
            //        );
            //        userInput.clear();
            //
            //        if (inp.split(" ")[0].equals("bye")) {
            //            // Do something to make the program exit
            //        }
            //    }
            //```"
            Platform.exit();   // Close Homura
            return;
        }

        String inp = userInput.getText();
        String response = Homura.cmdJavafx(inp);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(inp, madoImage),
                DialogBox.getHomuDialog(response, homuImage)
        );
        userInput.clear();

        if (inp.split(" ")[0].equals("bye")) {
            isOffing = true;
        }
    }
}