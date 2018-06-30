
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    boolean state1;
    boolean state2;
    String customerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        if(quantity>=100){
            return;
        }else {

            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(this,"Cannot order less than 1 cup",Toast.LENGTH_LONG).show();
            return;
        } else{
            quantity = quantity - 1;
        displayQuantity(quantity);
    }

    }
    public void submitOrder(View view) {
        CheckBox checkBoxInfo = findViewById(R.id.checkbox_info);
        state1 = checkBoxInfo.isChecked();
        CheckBox checkBoxChoc = findViewById(R.id.checkbox_choc);
        state2 = checkBoxChoc.isChecked();
        EditText nameOfCustomer = findViewById(R.id.customer_name_view);
        customerName = nameOfCustomer.getText().toString();

        int price = calculatePrice(quantity);
        displayMessage(createOrderSummary(price));

    }

    private int calculatePrice(int quantity){
        int test = 5;
        if(state1 && !state2) {
            test = test +1;
        }else if(state2 && !state1) {
            test = test +2;
        }else if(state1 && state2){
            test = test +3;
        }else{
        }
     return quantity*test;

    }

    private String createOrderSummary(int price){
        String priceMessage = "Name = "+ customerName;
        priceMessage +="\nAdd whipped cream : " + state1;
        priceMessage +="\nAdd Chocolate : " + state2;
        priceMessage += "\nQuantity = "+ quantity;
        priceMessage += "\nTotal = $"+ price;
        priceMessage += "\nThank You!!";
        return priceMessage;

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }






}