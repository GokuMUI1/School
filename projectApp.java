import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    private static ArrayList<Task> playerList = new ArrayList<>();
    private static int experience = 0;
    private static int level = 1;

    private TextField taskInputField;
    private ListView<HBox> playerListView;
    private Label levelLabel;
    private Label xpLabel;

    @Override
    public void start(Stage primaryStage) {
        // Initialize UI components
        taskInputField = new TextField();
        Button addButton = new Button("Add Task");
        playerListView = new ListView<>();
        levelLabel = new Label("Level: " + level);
        xpLabel = new Label("XP: " + experience + "/10");

        addButton.setOnAction(e -> addTask());

        // Layout
        VBox root = new VBox(10);
        VBox xpBox = new VBox(5);
        xpBox.getChildren().addAll(new Label("Player App"), levelLabel, xpLabel);
        root.getChildren().addAll(xpBox, playerListView, taskInputField, addButton);

        // Scene
        Scene scene = new Scene(root, 300, 400);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Player App");
        primaryStage.show();
    }

    private void addTask() {
        String taskDescription = taskInputField.getText();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription, levelLabel, xpLabel);
            playerList.add(newTask);
            playerListView.getItems().add(newTask.getView());
            taskInputField.clear();
            updateXP(); // Update XP when a task is added
        }
    }

    // Public method to update XP
    public static void updateXP() {
        experience++;
        if (experience >= 10) {
            level++;
            experience = 0;
        }
        // Update labels
        for (Task task : playerList) {
            task.updateLabels(level, experience);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Task {
    private String description;
    private CheckBox checkBox;
    private Label levelLabel;
    private Label xpLabel;

    Task(String description, Label levelLabel, Label xpLabel) {
        this.description = description;
        this.checkBox = new CheckBox(description);
        this.levelLabel = levelLabel;
        this.xpLabel = xpLabel;
    }

    public HBox getView() {
        HBox view = new HBox(5);
        view.getChildren().add(checkBox);
        checkBox.setOnAction(e -> markAsCompleted());
        return view;
    }

    private void markAsCompleted() {
        Main.updateXP(); // Call the public method in Main to update XP
    }

    public void updateLabels(int level, int experience) {
        levelLabel.setText("Level: " + level);
        xpLabel.setText("XP: " + experience + "/10");
    }
}