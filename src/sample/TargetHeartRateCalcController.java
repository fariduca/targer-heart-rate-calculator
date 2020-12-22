package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TargetHeartRateCalcController {

    @FXML
    private TextField textFieldAge;

    @FXML
    private TextField textFieldMaxHR;

    @FXML
    private TextField textFieldTargetHRR;

    @FXML
    private Label labelNote;

    @FXML
    void calculateButtonClicked(ActionEvent event) {
        int age = 0;
        try {
            age = Integer.parseInt(textFieldAge.getText());
            if (age < 1 || age > 150)
                throw new NumberFormatException();

            int maxHR = 220 - age;
            int targetHRLower = maxHR / 2;
            int targetHRUpper = maxHR * 85 / 100;
            textFieldMaxHR.setText(String.valueOf(maxHR));
            textFieldTargetHRR
                    .setText(String.valueOf(targetHRLower)
                    .concat(" - ")
                    .concat(String.valueOf(targetHRUpper)));
        } catch (NumberFormatException e) {
            textFieldAge.setText("Please enter valid age");
            textFieldAge.selectAll();
            textFieldAge.requestFocus();
            textFieldMaxHR.clear();
            textFieldTargetHRR.clear();
        }
    }

    public void initialize() {
        labelNote.setText("Note: \nThese formulas are estimates\n" +
                "provided by the AHA. Maximum and target\n" +
                "heart rates may vary based on the health,\n" +
                "fitness and gender of the individual. Always\n" +
                "consult a physician or qualified health care\n" +
                "professional before beginning or modifying an\n" +
                "exercise program.");
    }

}