import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFXApp extends Application {
  public static void main(String ...args) {
    launch(args);
  }

  @Override
  public void init() throws Exception {
    System.out.println("init");
  }

  @Override
  public void stop() throws Exception {
    System.out.println("stop");
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Ololo");
    primaryStage.setResizable(false);
    primaryStage.setHeight(250);
    primaryStage.setWidth(250);

    Pane pane;
    pane = getBorderPane();
    pane = getHBoxPane();

    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private BorderPane getBorderPane() {
    BorderPane pane = new BorderPane();

    Label label1 = new Label("I'm a label1");
    Label label2 = new Label("I'm a label2");
    Label label3 = new Label("I'm a label3");
    Label label4 = new Label("I'm a label4");
    Label label5 = new Label("I'm a label5");


    pane.setPadding(new Insets(10, 10, 10, 10));
    pane.setCenter(label1);
    pane.setLeft(label2);
    pane.setRight(label3);
    pane.setTop(label4);
    pane.setBottom(label5);

    return pane;
  }

  private Pane getHBoxPane() {
    int c = 0;
    Label[] labels = new Label[5];
    for (int i = 0; i < labels.length; i++) {
      labels[i] = new Label("Label_" + i);
    }
    HBox pane = new HBox(labels);
    Button button = new Button("0");
    pane.getChildren().add(button);
    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        Button src = (Button) event.getSource();
        int count = Integer.parseInt(src.getText());
        labels[(int)(Math.random()*5)].setText("kill");
        src.setText("" + ++count);
      }
    });
    return pane;
  }
}
