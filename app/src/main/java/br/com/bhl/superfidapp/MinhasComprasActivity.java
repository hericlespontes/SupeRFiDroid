package br.com.bhl.superfidapp;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

public class MinhasComprasActivity extends AppCompatActivity {

    private EditText edtDataInicial;
    private EditText edtDataFinal;
    private DatePickerDialog.OnDateSetListener dataInicialListener;
    private DatePickerDialog.OnDateSetListener dataFinalListener;
    private EditText edtNomeProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_compras);

        getSupportActionBar().setTitle("Minhas Compras!");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtDataInicial = (EditText)findViewById(R.id.edtDataInicial);
        edtDataFinal = (EditText)findViewById(R.id.edtDataFinal);
        edtNomeProduto = (EditText)findViewById(R.id.edtNomeProduto);

        edtDataInicial.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar data = Calendar.getInstance();

                int ano = data.get(Calendar.YEAR);
                int mes = data.get(Calendar.MONTH);
                int dia = data.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(
                        MinhasComprasActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dataInicialListener,
                        ano, mes, dia);
                datePicker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePicker.show();

            }
        });

        edtDataFinal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar data = Calendar.getInstance();

                int ano = data.get(Calendar.YEAR);
                int mes = data.get(Calendar.MONTH);
                int dia = data.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(
                        MinhasComprasActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dataFinalListener,
                        ano, mes, dia);
                datePicker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePicker.show();
            }
        });

        dataInicialListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                mes += 1;

                String dataTxt = dia + "/" + mes +"/" + ano;
                edtDataInicial.setText(dataTxt);
            }
        };

        dataFinalListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                mes = mes + 1;

                String dataTxt = dia + "/" + mes +"/" + ano;
                edtDataFinal.setText(dataTxt);
            }
        };
        edtDataInicial.setEnabled(false);
        edtDataFinal.setEnabled(false);
        edtNomeProduto.setEnabled(false);

        edtDataInicial.setFocusable(false);
        edtDataFinal.setFocusable(false);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rdiProdutos:
                if (checked)
                    edtDataInicial.setEnabled(false);
                    edtDataFinal.setEnabled(false);
                    edtNomeProduto.setEnabled(true);

                    edtDataInicial.setText("");
                    edtDataFinal.setText("");
                    break;
            case R.id.rdiCompras:
                if (checked)
                    edtDataInicial.setEnabled(true);
                    edtDataFinal.setEnabled(true);
                    edtNomeProduto.setEnabled(false);

                    edtNomeProduto.setText("");
                    break;
        }
    }

}// fim da classe