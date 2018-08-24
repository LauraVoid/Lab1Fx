package application;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelo.Principal;

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

	@FXML
	private Label valuePercent;
	
	
	  @FXML
	    private RadioButton acsend;

	    @FXML
	    private RadioButton descend;

	private Main main;

	public void initialize() {
		
		
		main = new Main();
		main.setPrincipal(new Principal());
		clusterToggleButtons();
		clusterToggleButtons1();
		clusterToggleButtons2();
		clusterToggleButtons3();
		clusterToggleButtons4();
//    	btPista.setDisable(true);
//    	btVerMinas.setDisable(true);
		sliderPercent.setValue(0);
		valuePercent.textProperty().bindBidirectional(sliderPercent.valueProperty(),NumberFormat.getInstance());

	}

	private void clusterToggleButtons() {
		ToggleGroup tg = new ToggleGroup();
		toggleInsertion.setToggleGroup(tg);
		toggleQuick.setToggleGroup(tg);
		toggleHeap.setToggleGroup(tg);
	}

	private void clusterToggleButtons1() {
		ToggleGroup tg = new ToggleGroup();
		toggleRepeated.setToggleGroup(tg);
		toggleNoRepeat.setToggleGroup(tg);
	}

	private void clusterToggleButtons2() {
		ToggleGroup tg = new ToggleGroup();
		toggleInteger.setToggleGroup(tg);
		toggleD.setToggleGroup(tg);
	}

	private void clusterToggleButtons3() {
		ToggleGroup tg = new ToggleGroup();
		toggleInsertionRandom.setToggleGroup(tg);
		toggleQuickRandom.setToggleGroup(tg);
		toggleHeapRandom.setToggleGroup(tg);

	}
	
	private void clusterToggleButtons4() {
		ToggleGroup tg = new ToggleGroup();
		descend.setToggleGroup(tg);
		acsend.setToggleGroup(tg);
		

	}

	@FXML
	void butOrdenedRandom(ActionEvent event) {
		
		int amount = Integer.parseInt(txtAmount.getText());
		String num0=valuePercent.getText();
		double pp= Double.parseDouble(num0);
		int percent=(int)pp;
		String[] interval = txtMaxMin.getText().split(",");
		int max = Integer.parseInt(interval[0]);
		int min = Integer.parseInt(interval[1]);
		String val="";
		
		ArrayList<Integer> r= main.getPrincipal().randomInt(amount, true, min, max);
		
		int numW= main.getPrincipal().calculatePercent(r.size(), percent);
		
		ArrayList<Integer> n=main.getPrincipal().changeNumbersInt(r, r.size(), numW);
		
		for (int i = 0; i < n.size(); i++) {
			val+=n.get(i)+"";
			
		}
		txtRandomPercent.setText(val);
		
		
	
		

	}
	

	@FXML
	void butRandom(ActionEvent event) {

		int amount = Integer.parseInt(txtAmount.getText());
		String[] interval = txtMaxMin.getText().split(",");
		int max = Integer.parseInt(interval[0]);
		int min = Integer.parseInt(interval[1]);

		if (toggleInteger.isSelected()) {
			

			if (toggleRepeated.isSelected()) {
				ArrayList<Integer> arr = main.getPrincipal().randomInt(amount, true, min, max);
				if(acsend.isSelected()) {
					String yy=" ";
					ArrayList<Integer> ne=main.getPrincipal().InsertionUp(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					txtRandom.setText(yy);
					
					
					
				}
				if(descend.isSelected()) {
					String yy=" ";
					ArrayList<Integer> ne=main.getPrincipal().InsertionDown(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					txtRandom.setText(yy);
					
					
				}
				

			} else if (toggleNoRepeat.isSelected()) {
				txtRandom.setText(" ");
				ArrayList<Integer> arr = main.getPrincipal().randomInt(amount, false, min, max);
				if(acsend.isSelected()) {
					String yy=" ";
					ArrayList<Integer> ne=main.getPrincipal().InsertionUp(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					txtRandom.setText(yy);
					
					
					
				}
				if(descend.isSelected()) {
					String yy=" ";
					ArrayList<Integer> ne=main.getPrincipal().InsertionDown(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					txtRandom.setText(yy);
					
					
				}
				

			}
		}
		
		else if (toggleD.isSelected()) {
		
			txtRandom.setText(" ");

			if (toggleRepeated.isSelected()) {
				ArrayList<Double> arr = main.getPrincipal().randomDouble(amount, true, min, max);
				if(acsend.isSelected()) {
					if(toggleQuickRandom.isSelected()) {
					String yy=" ";
					ArrayList<Double> ne=main.getPrincipal().quickSort(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					
					txtRandom.setText(yy);
					}
					
					
					
				}
				if(descend.isSelected()) {
					String yy=" ";
					txtRandom.setText(yy);
					
					
					
				}
				

			}
		}
if (toggleInteger.isSelected()) {
			

			if (toggleRepeated.isSelected()) {
				ArrayList<Integer> arr = main.getPrincipal().randomInt(amount, true, min, max);
				if(acsend.isSelected()) {
					String yy=" ";
					ArrayList<Integer> ne=main.getPrincipal().InsertionUp(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					txtRandom.setText(yy);
					
					
					
				}
				if(descend.isSelected()) {
					String yy=" ";
					ArrayList<Integer> ne=main.getPrincipal().InsertionDown(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					txtRandom.setText(yy);
					
					
				}
				

			} else if (toggleNoRepeat.isSelected()) {
				txtRandom.setText(" ");
				ArrayList<Integer> arr = main.getPrincipal().randomInt(amount, false, min, max);
				if(acsend.isSelected()) {
					String yy=" ";
					ArrayList<Integer> ne=main.getPrincipal().InsertionUp(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					txtRandom.setText(yy);
					
					
					
				}
				if(descend.isSelected()) {
					String yy=" ";
					ArrayList<Integer> ne=main.getPrincipal().InsertionDown(arr);
					for (int i = 0; i < ne.size(); i++) {
						yy+=ne.get(i)+", ";
						
					}
					txtRandom.setText(yy);
					
					
				}
				

			}
}

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

		String numbers = txtOrder.getText();

		if (main.getPrincipal().verificateIntegerDouble(numbers)) {
			ArrayList<Double> nn = new ArrayList<Double>();
			ArrayList<Double> first = main.getPrincipal().setNumbers(numbers, nn);

			if (toggleQuick.isSelected()) {
				ArrayList<Double> mm = main.getPrincipal().quickSort(first);
				String num = " ";
				for (int i = 0; i < mm.size(); i++) {

					num += mm.get(i) + ",";

				}
				txtResult.setText(num);

			} else if (toggleHeap.isSelected()) {
				ArrayList<Double> mm = main.getPrincipal().heapSort(first);
				String num = " ";
				for (int i = 0; i < mm.size(); i++) {

					num += mm.get(i) + ",";

				}
				txtResult.setText(num);

			}

		} else if (main.getPrincipal().verificateIntegerDouble(numbers) == false) {
			ArrayList<Integer> n = new ArrayList<Integer>();
			ArrayList<Integer> firs = main.getPrincipal().setNumbersInteger(numbers, n);

			if (toggleInsertion.isSelected()) {
				ArrayList<Integer> mm = main.getPrincipal().InsertionUp(firs);
				String num = " ";
				for (int i = 0; i < mm.size(); i++) {

					num += mm.get(i) + ",";

				}
				txtResult.setText(num);

			}

		}
	}

//    ArrayList<Integer> n=main.getPrincipal().verificateIntegerDouble(numbers);
//    System.out.println(result);

}
