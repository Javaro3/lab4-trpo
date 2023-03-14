package com.example.binarysearch;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class Controller {
    @FXML
    private TextField ArrayInput;

    @FXML
    private Label SortArrayLabel;

    @FXML
    private TextField FindElemInput;

    @FXML
    private Button FindElemButton;

    @FXML
    private Label ResultLabel;

    @FXML
    void initialize(){
        FindElemButton.setOnAction(e -> binarySearch());
    }

    private int[] convertStringToArray(){
        String[] strings = ArrayInput.getText().split(",");
        int[] arr = new int[strings.length];
        for(int i = 0; i < strings.length; i++){
            arr[i] = Integer.parseInt(strings[i]);
        }
        return arr;
    }


    private void binarySearch(){
        BinarySearchClass bsc = new BinarySearchClass(convertStringToArray());
        SortArrayLabel.setText(Arrays.toString(bsc.getArr()));
        ResultLabel.setText("Элемент "+FindElemInput.getText()+" находится под индексом "+bsc.binarySearch(Integer.parseInt(FindElemInput.getText()), 0, bsc.getArr().length));
    }
}