package homura;

// Copied from https://se-education.org/guides/tutorials/javaFxPart4.html
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

    private Image madoImage = new Image(this.getClass()
            .getResourceAsStream("/images/Mado_pfp.png"));
    private Image homuImage = new Image(this.getClass()
            .getResourceAsStream("/images/Homu_pfp.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
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
        String input = userInput.getText();
        String response = Homura.cmdJavafx(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, madoImage),
                DialogBox.getHomuDialog(response, homuImage)
        );
        userInput.clear();
    }
}