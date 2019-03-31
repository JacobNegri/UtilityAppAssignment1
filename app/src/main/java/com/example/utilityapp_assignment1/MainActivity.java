package com.example.utilityapp_assignment1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    Spinner convertFromUnitTypeSpinner;
    Spinner convertToUnitTypeSpinner;

    // this array is for the unit type selections

    String[] unitTypes = {"Kilometres","Metres","Centimetres","Millimetres"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set spinner variables to the corresponding spinner components
        convertFromUnitTypeSpinner = (Spinner)findViewById(R.id.convertFromUnitTypeSpinner);
        convertToUnitTypeSpinner = (Spinner)findViewById(R.id.convertToUnitTypeSpinner);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, unitTypes);

        convertFromUnitTypeSpinner.setAdapter(spinnerAdapter);
        convertToUnitTypeSpinner.setAdapter(spinnerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickConvertButtonEvent(View view){

        //declare variables
        double beginning_qty;
        double ending_qty;
        String beg_unit_type;
        String end_unit_type;

        //declare components
        EditText qtyEditText = (EditText)findViewById(R.id.inputdata);
        TextView resultOutputTextView = (TextView)findViewById(R.id.output);

        //create object for length conversion
        conversion_length lengthConverter = new conversion_length();

        //check the quantity field has been entered
        if(!qtyEditText.getText().toString().equals("")) {

            // get input user data from the fields
            beginning_qty = Double.parseDouble(qtyEditText.getText().toString());
            beg_unit_type = convertFromUnitTypeSpinner.getSelectedItem().toString();
            end_unit_type = convertToUnitTypeSpinner.getSelectedItem().toString();

            //input data into object
            lengthConverter.setStartingValue(beginning_qty);
            lengthConverter.setStartUnitType(beg_unit_type);
            lengthConverter.setEndUnitType(end_unit_type);

            //calculate conversion results
            ending_qty = lengthConverter.calculatingEndQnty();
            lengthConverter.setEndingValue(ending_qty);

            //output the conversion onto the console
            resultOutputTextView.setText(lengthConverter.toString());

        } else {

            //create a mesage to enter quantity
            Context context = getApplicationContext();
            CharSequence text = "Enter Quantity";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }




    }
}
