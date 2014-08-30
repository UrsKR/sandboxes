package bugs.table.pending;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Arrays;

public class StyleDoesNotApplyToColumn extends Application {
  public static void main(String[] arguments) {
    launch(arguments);
  }

  @Override
  public void start(Stage stage) throws Exception {
    TableView table = new TableView<>();
    TableColumn<Integer, Number> column = createColum();
    table.getColumns().addAll(column);
    table.getStyleClass().add("right-aligned");
    table.setItems(new ObservableListWrapper(Arrays.asList(1, 2, 3, 4, 5)));
    Scene scene = new Scene(table);
    scene.getStylesheets().add(this.getClass().getResource("align.css").toExternalForm());
    stage.setScene(scene);
    stage.show();
  }

  private TableColumn<Integer, Number> createColum() {
    TableColumn<Integer, Number> pointColumn = new TableColumn<>("Numbers should be right-aligned");
    pointColumn.setCellValueFactory(
            new Callback<TableColumn.CellDataFeatures<Integer, Number>, ObservableValue<Number>>() {
              @Override
              public ObservableValue<Number> call(
                      TableColumn.CellDataFeatures<Integer, Number> features) {
                return new SimpleIntegerProperty(features.getValue());
              }
            });
    pointColumn.getStyleClass().add("right-aligned");
    return pointColumn;
  }
}
