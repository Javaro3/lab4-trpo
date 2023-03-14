package com.example.lab6;


import com.example.Buns.Bun;
import com.example.Buns.BunWithPoppySeeds;
import com.example.Buns.Cheesecake;
import com.example.Buns.Donut;
import com.example.Ingredients.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    private BunsControl bunsControl = new BunsControl();

    @FXML
    private AnchorPane MenuAnchorPane;

    @FXML
    private Button ShowBunsBtn;

    @FXML
    private Button AddBunBtn;

    @FXML
    private Button DeleteBunBtn;

    @FXML
    private Button ShowBunsMake5MinAgoBtn;

    @FXML
    private Button ShowBunsWithPoppy;


    @FXML
    private AnchorPane ShowAnchorPane;

    @FXML
    private Label ShowLabel;

    @FXML
    private Button BackToMenuFromShowBtn;


    @FXML
    private AnchorPane AddAnchorPane;

    @FXML
    private Button BackToMenuFromAddBtn;

    @FXML
    private ComboBox TypeComboBox;

    @FXML
    private TextField IngredientInput;

    @FXML
    private Button AddConfirmBtn;

    @FXML
    private TextField PriceInput;

    @FXML
    private TextField TimeInput;


    @FXML
    private AnchorPane DeleteAnchorPane;

    @FXML
    private Button BackToMenuFromDeleteBtn;

    @FXML
    private TextField DeleteInput;

    @FXML
    private Button DeleteBtn;

    @FXML
    void initialize(){
        TypeComboBox.getItems().addAll("Булочка с маком", "Чизкейк", "Пончик");
        ShowBunsBtn.setOnAction(e -> showAllBuns());
        ShowBunsMake5MinAgoBtn.setOnAction(e -> showAllBunsMake5MinAgo());
        ShowBunsWithPoppy.setOnAction(e -> showAllBunsWithPoppy());
        AddConfirmBtn.setOnAction(e -> addBun());
        DeleteBtn.setOnAction(e -> bunsControl.removeBunByIndex(Integer.parseInt(DeleteInput.getText())-1));
        AddBunBtn.setOnAction(e -> {MenuAnchorPane.setVisible(false); AddAnchorPane.setVisible(true);});
        DeleteBunBtn.setOnAction(e -> {MenuAnchorPane.setVisible(false); DeleteAnchorPane.setVisible(true);});
        BackToMenuFromShowBtn.setOnAction(e -> {ShowAnchorPane.setVisible(false); MenuAnchorPane.setVisible(true);});
        BackToMenuFromAddBtn.setOnAction(e -> {AddAnchorPane.setVisible(false); MenuAnchorPane.setVisible(true);});
        BackToMenuFromDeleteBtn.setOnAction(e -> {DeleteAnchorPane.setVisible(false); MenuAnchorPane.setVisible(true);});
        ShowAnchorPane.setVisible(false);
        AddAnchorPane.setVisible(false);
        DeleteAnchorPane.setVisible(false);
    }

    private void showAllBuns(){
        MenuAnchorPane.setVisible(false);
        ShowAnchorPane.setVisible(true);
        ShowLabel.setText(convertListToString(bunsControl.getBuns(), "В списке еще нет булочек"));
    }

    private void showAllBunsMake5MinAgo(){
        MenuAnchorPane.setVisible(false);
        ShowAnchorPane.setVisible(true);
        ShowLabel.setText(convertListToString(bunsControl.getBunsMake5MinutesAgo(LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute(), 0)), "В списке еще нет булочек которые были сделаны 5 минут назад"));
    }

    private void showAllBunsWithPoppy(){
        MenuAnchorPane.setVisible(false);
        ShowAnchorPane.setVisible(true);
        ShowLabel.setText(convertListToString(bunsControl.getBunsWithPepper(), "В списке еще нет булочек которые содержат перец"));
    }

    private void addBun(){
        int hours = Integer.parseInt(TimeInput.getText().split(":")[0]);
        int minutes = Integer.parseInt(TimeInput.getText().split(":")[1]);
        LocalTime lt = LocalTime.of(hours, minutes, 0);
        int price = Integer.parseInt(PriceInput.getText());
        var ingredients = new ArrayList<Ingredient>();

        if(IngredientInput.getText().contains(",")){
            String[] ingredientsString = IngredientInput.getText().split(",");
            for(var ingr : ingredientsString){
                ingredients.add(new Ingredient(ingr));
            }
        } else {
            ingredients.add(new Ingredient(IngredientInput.getText()));
        }


        if(String.valueOf(TypeComboBox.getValue()).equals("Булочка с маком")){
            bunsControl.addBun(new BunWithPoppySeeds(price, lt, ingredients));
        } else if (String.valueOf(TypeComboBox.getValue()).equals("Чизкейк")){
            bunsControl.addBun(new Cheesecake(price, lt, ingredients));
        } else {
            bunsControl.addBun(new Donut(price, lt, ingredients));
        }
    }


    public String convertListToString(ArrayList<Bun> buns, String elseRes){
        if(buns.size() != 0){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < buns.size(); i++) {
                sb.append((i + 1) + ") " + buns.get(i).toString() + "\n");
            }
            return sb.toString();
        }
        return elseRes;
    }
}