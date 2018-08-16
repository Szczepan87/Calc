package com.szczepanski.calc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
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

import java.math.BigDecimal;
import java.math.RoundingMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnitActivity extends AppCompatActivity {

    @BindView(R.id.measurementClassSpinner)
    Spinner measurementClassSpinner;
    @BindView(R.id.firstUnitSpinner)
    Spinner firstUnitSpinner;
    @BindView(R.id.secondUnitSpinner)
    Spinner secondUnitSpinner;
    @BindView(R.id.selectUnitTextView)
    TextView selectUnitTextView;
    @BindView(R.id.valueEditText)
    EditText valueEditText;
    @BindView(R.id.resultTextView)
    TextView resultTextView;

    private UnitDatabaseTemplate unit;
    private UnitOfMeasurement firstUnit;
    private UnitOfMeasurement resultUnit;
    private BigDecimal result = new BigDecimal(0);

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
        menuInflater.inflate(R.menu.app_bar_menu, menu);
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

    private void initMeasurementClassSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.units_for_measurements, android.R.layout.simple_spinner_dropdown_item);
        measurementClassSpinner.setAdapter(adapter);

        measurementClassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getSelectedItem().toString()) {
                    case "Długość":
                        unit = new DistanceMeasurementUnits();
                        Toast.makeText(UnitActivity.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        initFirstUnitSpinner();
                        initSecondUnitSpinner();
                        break;
                    case "Waga":
                        unit = new WeightMeasurementUnits();
                        Toast.makeText(UnitActivity.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        initFirstUnitSpinner();
                        initSecondUnitSpinner();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(UnitActivity.this, R.string.please_select_value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFirstUnitSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item, unit.getAvailableUnitNames());
        firstUnitSpinner.setAdapter(adapter);

        firstUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                firstUnit = unit.getUnit(unit.getAvailableUnitNames()
                        .get(unit.getAvailableUnitNames().indexOf(adapterView.getSelectedItem().toString())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(UnitActivity.this, R.string.please_select_value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initSecondUnitSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item, unit.getAvailableUnitNames());
        secondUnitSpinner.setAdapter(adapter);

        secondUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultUnit = unit.getUnit(unit.getAvailableUnitNames()
                        .get(unit.getAvailableUnitNames().indexOf(adapterView.getSelectedItem().toString())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(UnitActivity.this, R.string.please_select_value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            result = BigDecimal.valueOf(Double.parseDouble(String.valueOf(valueEditText.getText())));
            result = firstUnit.getUnitValue().multiply(result);
            if (result.equals(BigDecimal.valueOf(0))) {
                result = BigDecimal.valueOf(0);
            }
            result = result.divide(resultUnit.getUnitValue().setScale(10, RoundingMode.HALF_UP));
            resultTextView.setText(String.valueOf(result));
            return true;
        } else return false;
    }
}
