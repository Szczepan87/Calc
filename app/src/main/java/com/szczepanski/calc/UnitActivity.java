package com.szczepanski.calc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnitActivity extends AppCompatActivity {

    @BindView(R.id.measurementClassSpinner) Spinner measurementClassSpinner;
    @BindView(R.id.firstUnitSpinner) Spinner firstUnitSpinner;
    @BindView(R.id.secondUnitSpinner) Spinner secondUnitSpinner;
    @BindView(R.id.selectUnitTextView) TextView selectUnitTextView;
    @BindView(R.id.valueEditText) EditText valueEditText;
    @BindView(R.id.resultTextView) TextView resultTextView;

    private UnitDatabaseTemplate unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        ButterKnife.bind(this);
        initMeasurementClassSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.calc:
                Intent intent = new Intent(UnitActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.currencyConvert:
                Intent intent2 = new Intent(UnitActivity.this, CurrencyActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initMeasurementClassSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,R.array.units_for_measurements,android.R.layout.simple_spinner_dropdown_item);
        measurementClassSpinner.setAdapter(adapter);

        measurementClassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getSelectedItem().toString()){
                    case "Długość":
                        unit = new DistanceMeasurementUnits();
                        Toast.makeText(UnitActivity.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case "Waga":
                        unit = new WeightMeasurementUnits();
                        Toast.makeText(UnitActivity.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initfirstUnitSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,unit.getListOfMeasurementUnits(),android.R.layout.simple_spinner_dropdown_item);
        measurementClassSpinner.setAdapter(adapter);

        measurementClassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
