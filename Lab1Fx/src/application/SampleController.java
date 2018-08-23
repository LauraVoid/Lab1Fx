package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SampleController {

    @FXML
    private TextField txtOrder;

    @FXML
    private RadioButton toggleInsertion;

    @FXML
    private RadioButton toggleQuick;

    @FXML
    private RadioButton toggleHeap;

    @FXML
    private Button buttonOrden;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtMaxMin;

    @FXML
    private RadioButton toggleInteger;

    @FXML
    private RadioButton toggleD;

    @FXML
    private Button butRandom;

    @FXML
    private Button butOrdenedRandom;

    @FXML
    private Button butOrderedRandomPercent;

    @FXML
    private RadioButton toggleRepeated;

    @FXML
    private RadioButton toggleNoRepeat;

    @FXML
    private TextField txtRandom;

    @FXML
    private TextField txtOrderedRandom;

    @FXML
    private TextField txtRandomPercent;

    @FXML
    private Button buttonValidate;

    @FXML
    private TextField txtResult;

    @FXML
    private RadioButton toggleInsertionRandom;

    @FXML
    private RadioButton toggleQuickRandom;

    @FXML
    private RadioButton toggleHeapRandom;

    @FXML
    private Button butOrdenRandom;

    @FXML
    private Slider sliderPercent;
    
    private Main main;
    
    public void initialize() {
    	main= new Main();
    	clusterToggleButtons();
    	clusterToggleButtons1();
    	clusterToggleButtons2();
    	clusterToggleButtons3();
//    	btPista.setDisable(true);
//    	btVerMinas.setDisable(true);
    	
    	
    }
    
    private void clusterToggleButtons() {
    	ToggleGroup tg=new ToggleGroup();
    	toggleInsertion.setToggleGroup(tg);
    	toggleQuick.setToggleGroup(tg);
    	toggleHeap.setToggleGroup(tg);
	}
    
    private void clusterToggleButtons1() {
    	ToggleGroup tg=new ToggleGroup();
    	toggleRepeated.setToggleGroup(tg);
    	toggleNoRepeat.setToggleGroup(tg);
	}
    
    private void clusterToggleButtons2() {
    	ToggleGroup tg=new ToggleGroup();
    	toggleInteger.setToggleGroup(tg);
    	toggleD.setToggleGroup(tg);
	}
    
    private void clusterToggleButtons3() {
    	ToggleGroup tg=new ToggleGroup();
    	toggleInsertionRandom.setToggleGroup(tg);
    	toggleQuickRandom.setToggleGroup(tg);
    	toggleHeapRandom.setToggleGroup(tg);
   
	}
    
    @FXML
    void butOrdenedRandom(ActionEvent event) {
    	

    }

    @FXML
    void butRandom(ActionEvent event) {

    }

    @FXML
    void heapValores(ActionEvent event) {

    }

    @FXML
    void insertionValues(ActionEvent event) {

    }

    @FXML
    void orderValues(ActionEvent event) {

    }

    @FXML
    void quickValues(ActionEvent event) {

    }

    @FXML
    void toggleD(ActionEvent event) {

    }

    @FXML
    void toggleInsertionRandom(ActionEvent event) {

    }

    @FXML
    void toggleInteger(ActionEvent event) {

    }

    @FXML
    void toggleNoRepeat(ActionEvent event) {

    }

    @FXML
    void toggleRepeated(ActionEvent event) {

    }

    @FXML
    void txtAmount(ActionEvent event) {

    }

    @FXML
    void txtMaxMin(ActionEvent event) {

    }

    @FXML
    void txtOrder(ActionEvent event) {
    	

    }

    @FXML
    void txtOrderedRandom(ActionEvent event) {

    }

    @FXML
    void txtResult(ActionEvent event) {

    }

    @FXML
    void validate(ActionEvent event) {
    	
    String numbers=txtOrder.getText();
    	
//    	main.getPrincipal().

    }
    
    
    
    
    
}
