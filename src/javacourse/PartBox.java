package javacourse;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PartBox {

    public static void display(String type) {
        Stage partStage = new Stage();
        partStage.initModality(Modality.APPLICATION_MODAL);
        partStage.setTitle(type + " Part");

        // Buttons
        Button saveButton = new Button("Save");
        saveButton.setAlignment(Pos.CENTER_LEFT);
        saveButton.setOnAction(event -> partStage.close());
        Button cancelButton = new Button("Cancel");
        cancelButton.setAlignment(Pos.CENTER_RIGHT);
        cancelButton.setOnAction(event -> partStage.close());

        // Labels for text fields
        Label partTitle = new Label(type + " Part");
        Label idLabel = new Label("ID:");
        Label nameLabel = new Label("Name:");
        Label invLabel = new Label("Inv:");
        Label priceLabel = new Label("Price/Cost");
        Label maxLabel = new Label("Max:");
        Label minLabel = new Label("Min:");
        Label inOutLabel = new Label("Machine ID:        ");

        // Text fields to extract data for parts
        TextField idField = new TextField("Auto Gen - Disabled");
        idField.setDisable(true);
        TextField nameField = new TextField();
        nameField.setPromptText("Part Name");
        TextField invField = new TextField();
        invField.setPromptText("Inv");
        TextField priceField = new TextField();
        priceField.setPromptText("Price/Cost");
        TextField maxField = new TextField();
        maxField.setPromptText("Max");
        TextField minField = new TextField();
        minField.setPromptText("Min");
        TextField inOutField = new TextField();
        inOutField.setPromptText("Machine ID");

        //Check boxes for in house and Outsourced
        ToggleGroup inOutToggle = new ToggleGroup();
        RadioButton inHouse = new RadioButton("In-House");
        inHouse.setToggleGroup(inOutToggle);
        inHouse.setSelected(true);
        RadioButton outSourced = new RadioButton("Outsourced");
        outSourced.setToggleGroup(inOutToggle);
        inHouse.setOnAction(event -> {
            inOutLabel.setText("Machine ID:        ");
            inOutField.setPromptText("Machine ID");
        });
        outSourced.setOnAction(event -> {
            inOutLabel.setText("Company Name:");
            inOutField.setPromptText("Company Name");
        });

        // Grid Layout for Label, Text Fields and Buttons
        GridPane partGrid = new GridPane();
        partGrid.setPadding(new Insets(25, 25 ,25 , 25));
        partGrid.setVgap(10);
        partGrid.setHgap(12);
        // Row 1
        GridPane.setConstraints(partTitle, 0, 0);
        GridPane.setConstraints(inHouse,1, 0);
        GridPane.setConstraints(outSourced, 3, 0);
        // Row 2
        GridPane.setConstraints(idLabel,0,1);
        GridPane.setConstraints(idField, 1,1);
        // Row 3
        GridPane.setConstraints(nameLabel, 0,2);
        GridPane.setConstraints(nameField, 1,2);
        // Row 4
        GridPane.setConstraints(invLabel, 0,3);
        GridPane.setConstraints(invField, 1,3);
        // Row 5
        GridPane.setConstraints(priceLabel, 0,4);
        GridPane.setConstraints(priceField, 1,4);
        // Row 6
        GridPane.setConstraints(maxLabel, 0,5);
        GridPane.setConstraints(maxField, 1,5);
        GridPane.setConstraints(minLabel, 2,5);
        GridPane.setConstraints(minField, 3,5);
        // Row 7
        GridPane.setConstraints(inOutLabel, 0,6);
        GridPane.setConstraints(inOutField, 1,6);
        // Row 8
        GridPane.setConstraints(saveButton, 3,7);
        GridPane.setConstraints(cancelButton, 4,7);

        partGrid.getChildren().addAll(partTitle, inHouse, outSourced, idField, idLabel, nameField, nameLabel, invField, invLabel,
                priceField, priceLabel, maxField, maxLabel, minField, minLabel, inOutField, inOutLabel, saveButton,
                cancelButton);
        Scene partScene = new Scene(partGrid, 650, 375);

        partStage.setScene(partScene);
        partStage.showAndWait();

    }

}
