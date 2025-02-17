ChatGPT (free version) as used occasionally for help throughout this iP. The 
following questions were asked.
</br></br></br>

1.) Hi! Given an ArrayList<String> in Java, is there a function to concatenate 
them along another string. As an example, I would like to concatenate 
{"hi, "bye", "what"} along " - " to get "hi - bye - what".

2.) Hi! Does Java have a built in function to split a string on another string 
rather than a regular expression?

3.) Hi! I want to remove a file using the `rm` command on a command line 
interface. However, I don't want it to give me the "file does not exist" 
notification if it does not exist. Is there a way for me to do this? Thanks!

4.) Hi! I currently have the following shell script mean to run some test 
cases on my code

```
#!/usr/bin/env bash

# create bin directory if it doesn't exist
if [ ! -d "../bin" ]
then
    mkdir ../bin
fi

# delete output from previous run
if [ -e "./ACTUAL.TXT" ]
then
    rm ACTUAL.TXT
fi

#How to make the compilation not get bricked inspired by
#https://stackoverflow.com/questions/4927575/java-compiler-platform-file-encoding-problem
# compile the code into the bin folder, terminates if error occurred
if ! javac -cp ../src/main/java -Xlint:none -d ../bin ../src/main/java/*.java
then
    echo "********** BUILD FAILURE **********"
    exit 1
fi

# run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ../bin Homura < input.txt > ACTUAL.TXT

# convert to UNIX format
cp EXPECTED.TXT EXPECTED-UNIX.TXT
dos2unix ACTUAL.TXT EXPECTED-UNIX.TXT

# OWN EDIT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#Inspired by ChatGPT with query "Hi! I want to remove a file using
#the rm command on a command line interface. However, I don't want
#it to give me the "file does not exist" notification if it does
#not exist. Is there a way for me to do this? Thanks!".
rm HomuraTodos.txt 2>/dev/null
# END OF OWN EDIT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# compare the output to the expected output
diff ACTUAL.TXT EXPECTED-UNIX.TXT
if [ $? -eq 0 ]
then
    echo "Test result: PASSED"
    exit 0
else
    echo "Test result: FAILED"
    exit 1
fi
```

However, after putting my Java code inside a package called "Homura", it now 
gives the following error

```
error: Invalid filename: ..\src\main\java\*.java
Usage: javac <options> <source files>
use --help for a list of possible options
```

How can I fix this? Thanks!

5.) Hi! I also have a batch file that serves the same purpose as the shell 
script above, and I want to also fix it to run properly as well. How can I fix 
it? Here is the batch file

```
@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

REM compile the code into the bin folder
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin Homura < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT

REM How to delete a file inspired by
REM https://stackoverflow.com/questions/13764103/batch-script-to-delete-files
del "HomuraTodos.txt"
```

6.) Hi! Could you explain in simple terms what a Java module is? Thanks!

7.) A quick follow up question. Is a Java package just a folder containing 
Java files? Or is there more to it? Thanks!

8.) Could you also please give me a quick summary on what exactly Gradle is 
and how it functions? Thanks!

9.) Hi! What is a task in gradle? Thanks!

10.) Yes, that was helpful, thanks!

11.) Hi! How can I check if a string `s0` is contained as a substring of 
another string `s` in Java? Thanks!

12.) Hi!

I'm currently trying to learn about javafx using an online tutorial and am 
currently in a section introducing FXML. I came across this sentence that 
confused me.

"FXML allows you to separate the GUI design (the so-called view), from the 
code that controls the GUI (the so-called controllers)."

But I don't see what exactly is being split. Isn't the GUI design part of how 
you control the GUI? What is the separation between the view and the 
controllers?

Thanks!

13.) Quick follow up question, what is an XML-based language?

14.) I see, I think that helps me understand it better. Thanks!

15.) Hi! I'm confused as to what the code below is doing. Could you please 
explain what is happening?

In particular, I'm not familiar with most of the functions here, so a brief 
explanation of their function would be helpful

```java
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

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }
}
```

Thanks!

16.) How does the line

```
scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
```

make it scroll down to the bottom when a message is sent? Also, when is the 
initialize function called?

17.) Hi! Could you help me understand this error?

```
Feb 01, 2025 10:48:42 PM com.sun.javafx.application.PlatformImpl startup
WARNING: Unsupported JavaFX configuration: classes were loaded from 'unnamed module @5617c7f7'
javafx.fxml.LoadException: 
/C:/Users/Bryce/Documents/NUS/NUS-Year-4/NUS-Sem-8/CS2103T/Playgrounds/javafx-tutorial-fork/build/resources/main/view/MainWindow.fxml

	at javafx.fxml.FXMLLoader.constructLoadException(FXMLLoader.java:2714)
	at javafx.fxml.FXMLLoader.loadImpl(FXMLLoader.java:2657)
	at javafx.fxml.FXMLLoader.loadImpl(FXMLLoader.java:2555)
	at javafx.fxml.FXMLLoader.load(FXMLLoader.java:2523)
	at Main.start(Main.java:21)
	at com.sun.javafx.application.LauncherImpl.lambda$launchApplication1$9(LauncherImpl.java:847)
	at com.sun.javafx.application.PlatformImpl.lambda$runAndWait$12(PlatformImpl.java:484)
	at com.sun.javafx.application.PlatformImpl.lambda$runLater$10(PlatformImpl.java:457)
	at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
	at com.sun.javafx.application.PlatformImpl.lambda$runLater$11(PlatformImpl.java:456)
	at com.sun.glass.ui.InvokeLaterDispatcher$Future.run(InvokeLaterDispatcher.java:96)
	at com.sun.glass.ui.win.WinApplication._runLoop(Native Method)
	at com.sun.glass.ui.win.WinApplication.lambda$runLoop$3(WinApplication.java:184)
	at java.base/java.lang.Thread.run(Thread.java:842)
Caused by: javax.xml.stream.XMLStreamException: ParseError at [row,col]:[2,6]
Message: The processing instruction target matching "[xX][mM][lL]" is not allowed.
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.next(XMLStreamReaderImpl.java:652)
	at java.xml/javax.xml.stream.util.StreamReaderDelegate.next(StreamReaderDelegate.java:84)
	at javafx.fxml.FXMLLoader.loadImpl(FXMLLoader.java:2627)
	... 12 more
```

18.) Hi! My `MainWindow.fxml` file starts with
```
<!--Copied from https://se-education.org/guides/tutorials/javaFxPart4.html-->
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.ScrollPane?>
```
Is this not allowed?

19.) Thanks! It worked

20.) Hi! I'm now trying to make my application exit upon receiving the command 
"bye". However, I'm not sure how to do this. I currently have this handler to 
handle the user's inputs.

```
    @FXML
    private void handleUserInput() {
        String inp = userInput.getText();
        String response = Homura.cmdJavafx(inp);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(inp, madoImage),
                DialogBox.getHomuDialog(response, homuImage)
        );
        userInput.clear();

        if (inp.split(" ")[0].equals("bye")) {
            // Do something to make the program exit
        }
    }
```

21.) Thanks! That was a very helpful answer

22.) Hi! I'm trying to learn about doing continuous integration (CI) on GitHub 
and wish to use it for a chatbot in java. I was provided the following sample 
.yml file used for a similar project, but I don't really understand how it 
works. Could you help explain how this file works?

```
name: Java CI

on: [push, pull_request]

jobs:
  build:
    strategy:
      matrix:
        platform: [ubuntu-latest, macos-latest, windows-latest]
    runs-on: ${{ matrix.platform }}

    steps:
      - name: Set up repository
        uses: actions/checkout@master

      - name: Set up repository
        uses: actions/checkout@master
        with:
          ref: master

      - name: Merge to master
        run: git checkout --progress --force ${{ github.sha }}

      - name: Validate Gradle Wrapper
        uses: gradle/wrapper-validation-action@v1

      - name: Setup JDK 17
        uses: actions/setup-java@v1
        with:
          java-version: '17'
          java-package: jdk+fx

      - name: Build and check with Gradle
        run: ./gradlew check

      - name: Perform IO redirection test (*NIX)
        if: runner.os == 'Linux'
        working-directory:  ${{ github.workspace }}/text-ui-test
        run: ./runtest.sh

      - name: Perform IO redirection test (MacOS)
        if: always() && runner.os == 'macOS'
        working-directory:  ${{ github.workspace }}/text-ui-test
        run: ./runtest.sh

      - name: Perform IO redirection test (Windows)
        if: always() && runner.os == 'Windows'
        working-directory:  ${{ github.workspace }}/text-ui-test
        shell: cmd
        run: runtest.bat
```

Thanks!

23.) Hi! How can I get github actions to trigger on every commit using the 
.github/workflows/something.yml files? Thanks!

24.) Thanks!

25.) Hi! What does the following  command do in gradle?
```
./gradlew check
```

26.) Hi! Can I check if this is the correct syntax for a .yml file for setting 
up github actions to trigger on pushes to the master branch, on pull 
requestions, and for manual runs

```
on: #[push, pull_request]
  push:
    branches: [ main ]
  pull_request:
  workflow_dispatch:
```

27.) Hi! How can I check if a string contains a character in Java? Thanks!

28.) Hi! How can I move a google doc into a google drive folder

29.) Thanks!
