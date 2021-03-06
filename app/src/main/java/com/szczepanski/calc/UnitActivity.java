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

import com.szczepanski.calc.UnitsOfMeasurement.AreaMeasurementUnit;
import com.szczepanski.calc.UnitsOfMeasurement.DistanceMeasurementUnit;
import com.szczepanski.calc.UnitsOfMeasurement.MemoryMeasurementUnit;
import com.szczepanski.calc.UnitsOfMeasurement.PowerMeasurementUnit;
import com.szczepanski.calc.UnitsOfMeasurement.PressureMeasurementUnit;
import com.szczepanski.calc.UnitsOfMeasurement.SpeedMeasurementUnit;
import com.szczepanski.calc.UnitsOfMeasurement.UnitDatabaseTemplate;
import com.szczepanski.calc.UnitsOfMeasurement.UnitOfMeasurement;
import com.szczepanski.calc.UnitsOfMeasurement.VolumeMeasurementUnit;
import com.szczepanski.calc.UnitsOfMeasurement.WeightMeasurementUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
    private DecimalFormat decimalFormat = new DecimalFormat("#.##########");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        ButterKnife.bind(this);
        initMeasurementClassSpinner();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.scale_white);
        getSupportActionBar().setTitle(R.string.unit_convert);
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
                if (adapterView.getSelectedItem().toString().equals(getString(R.string.Length))){
                    unit = new DistanceMeasurementUnit();
                } else if(adapterView.getSelectedItem().toString().equals(getString(R.string.Weight))){
                    unit = new WeightMeasurementUnit();
                } else if (adapterView.getSelectedItem().toString().equals(getString(R.string.Volume))){
                    unit = new VolumeMeasurementUnit();
                } else if (adapterView.getSelectedItem().toString().equals(getString(R.string.Area))){
                    unit = new AreaMeasurementUnit();
                } else if (adapterView.getSelectedItem().toString().equals(getString(R.string.Memory))){
                    unit = new MemoryMeasurementUnit();
                }else if (adapterView.getSelectedItem().toString().equals(getString(R.string.Power))){
                    unit = new PowerMeasurementUnit();
                }else if (adapterView.getSelectedItem().toString().equals(getString(R.string.Speed))){
                    unit = new SpeedMeasurementUnit();
                }else if (adapterView.getSelectedItem().toString().equals(getString(R.string.Pressure))){
                    unit = new PressureMeasurementUnit();
                }
                initFirstUnitSpinner();
                initSecondUnitSpinner();
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
            BigDecimal result = BigDecimal.valueOf(Double.parseDouble(String.valueOf(valueEditText.getText())));
            result = firstUnit.getUnitValue().multiply(result).stripTrailingZeros();
            if (result.equals(BigDecimal.valueOf(0))) {
                result = BigDecimal.ZERO;
            }
            result = result.divide(resultUnit.getUnitValue(),10,RoundingMode.HALF_UP).stripTrailingZeros();
            resultTextView.setText(decimalFormat.format(result));
            return true;
        } else return super.onKeyUp(keyCode,event);
    }
}
