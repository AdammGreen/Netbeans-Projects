/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datavalidationtask;

import java.time.LocalDate;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.Z;
import static jdk.nashorn.internal.objects.NativeFunction.function;

public class DataValidationTaskController {

    @FXML
    private TextField InputBox1;

    @FXML
    private TextField InputBox2;

    @FXML
    private CheckBox MaleCheck;

    @FXML
    private CheckBox FemaleCheck;

    @FXML
    private DatePicker DateBox;

    @FXML
    private Button ValidateBTN;

    @FXML
    private TextArea TextArea;

    public String DateInfo;
    public String FirstnameInfo;
    public String HeightInfo;
    public String GenderInfo;
    public String HeightInfo2;
    public String FirstnameInfo2;
    public String HieghtInfo3;

    @FXML
    void DateChosen(ActionEvent event) {

    }

    @FXML
    void DoubleEntered(ActionEvent event) {

    }

    @FXML
    void FemaleClicked(ActionEvent event) {

    }

    @FXML
    void MaleClicked(ActionEvent event) {

    }

    @FXML
    void StringEntered(ActionEvent event) {

    }

    public String DateValidation() {
        LocalDate date = DateBox.getValue();
        int year = date.getYear();
        if (year > 1900 && year < 2020) {
            DateInfo = " Date is valid. ";
            System.out.println("Date is valid");
        } else {
            DateInfo = " Date is invalid. ";
            System.out.println("Date is invalid");
        }
        return DateInfo;
    }

    public String Height() {
        String string = InputBox1.getText();
        boolean numeric = true;
        Double dub = Double.parseDouble(string);

        try {
            double num = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if (numeric) {
            HeightInfo = string + " is a number. ";
            System.out.println(string + "is a number");
        } else {
            HeightInfo = string + " is not a number. ";
            System.out.println(string + "is not a number");
        }

        if (InputBox1.getText().length() != 0 && InputBox1.getText().length() <= 4 && InputBox1.getText().contains("") && InputBox1.getText().contains(".")) {
            HeightInfo2 = " Height is present, correct length, is within range and is in the correct format. ";
            System.out.println("Height is present, correct length, is within range and is in the correct format");
        } else {
            HeightInfo2 = " Height is either not present, not correct length, isn't within range and isn't in the correct format. ";
        }

        if (dub > 1.0 && dub < 2.75) {
            HieghtInfo3 = " Is a double variable. ";
            System.out.println("Is a double variable");
        } else {
            HieghtInfo3 = " Is not a double variable. ";
            System.out.println("Is not a double variable");
        }
        return HeightInfo + "/n" + HeightInfo2 + "/n" + HieghtInfo3;
    }

    public String GenderCheck() {

        if (FemaleCheck.isSelected() == true && MaleCheck.isSelected() == false) {
            GenderInfo = " Gender has been selected. ";
            System.out.println("Gender has been selected");
        }
        if (FemaleCheck.isSelected() == true && MaleCheck.isSelected() == true) {
            GenderInfo = " select one gender. ";
            System.out.println("select one gender");
        }
        if (FemaleCheck.isSelected() == false && MaleCheck.isSelected() == false) {
            GenderInfo = " No gender selected, select a gender. ";
            System.out.println("No gender selected, select a gender");
        }
        if (FemaleCheck.isSelected() == false && MaleCheck.isSelected() == true) {
            GenderInfo = " Gender has been selected. ";
            System.out.println("Gender has been selected");
        }
        return GenderInfo;
    }

    public String Firstname() {
        boolean isUpperCase = Character.isUpperCase(InputBox2.getText().charAt(0));

        for (int i = 0; i < InputBox2.getText().length(); i++) {
            if (Character.isLetter(InputBox2.getText().charAt(i)) == true) {
                FirstnameInfo = " Firstname is alphabetical. ";
                //this.setFirstnameInfo("Firstname is alphabetical and has no numbers/symbols");
                System.out.println(" Firstname is alphabetical and has no numbers/symbols");
            } else {
                FirstnameInfo = " Firstname is not alphabetical. ";
                System.out.println("Firstname is not alphabetical");
            }
        }

        if (InputBox2.getText().length() != 0 && isUpperCase == true && InputBox2.getText().length() <= 12 && InputBox2.getText().contains("")) {

            FirstnameInfo2 = " Firstname starts with a Capital letter, is present and isn't too long. ";
            System.out.println("Firstname starts with a Capital letter, is present and isn't too long.");

        } else {
            FirstnameInfo2 = " Firstname doesn't start with a Capital letter or isn't present or is too long. ";
            System.out.println("Firstname doesn't start with a Capital letter or isn't present or is too long");
        }
        return FirstnameInfo + "/n" + FirstnameInfo2;
    }

    @FXML
    void Validate(ActionEvent event) {
        DateValidation();
        Height();
        GenderCheck();
        Firstname();

        TextArea.setText(HeightInfo + HeightInfo2 + HieghtInfo3 + FirstnameInfo + FirstnameInfo2 + GenderInfo + DateInfo);

    }
}
