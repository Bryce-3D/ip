package homura;

// Credits to https://se-education.org/guides/tutorials/javaFxPart4.html
// for most of the code below
import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a dialog box consisting of an ImageView to represent the
 * speaker's face and a label containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(img);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and
     * text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections
                .observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img);
    }

    public static DialogBox getHomuDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        db.flip();
        return db;
    }
}


//// Copied from https://se-education.org/guides/tutorials/
//// javaFxPart2.html#designing-the-layout
//import javafx.geometry.Pos;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.HBox;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.Node;
//
//public class DialogBox extends HBox {
//
//    private Label text;
//    private ImageView displayPicture;
//
//    public DialogBox(String s, Image i) {
//        text = new Label(s);
//        displayPicture = new ImageView(i);
//
//        //Styling the dialog box
//        text.setWrapText(true);
//        displayPicture.setFitWidth(100.0);
//        displayPicture.setFitHeight(100.0);
//        this.setAlignment(Pos.TOP_RIGHT);
//
//        this.getChildren().addAll(text, displayPicture);
//    }
//
//    /**
//     * Flips the dialog box such that the ImageView is on the left and
//     * text on the right.
//     */
//    private void flip() {
//        this.setAlignment(Pos.TOP_LEFT);
//        ObservableList<Node> tmp = FXCollections
//                .observableArrayList(this.getChildren());
//        FXCollections.reverse(tmp);
//        this.getChildren().setAll(tmp);
//    }
//
//    public static DialogBox getUserDialog(String s, Image i) {
//        return new DialogBox(s, i);
//    }
//
//    public static DialogBox getDukeDialog(String s, Image i) {
//        var db = new DialogBox(s, i);
//        db.flip();
//        return db;
//    }
//}
