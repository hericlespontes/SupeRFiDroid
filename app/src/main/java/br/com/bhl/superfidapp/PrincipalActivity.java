package br.com.bhl.superfidapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class PrincipalActivity extends AppCompatActivity {

    private Button btnParear;
    private Button btnMinhasCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        getSupportActionBar().setTitle("Bem-Vindo Fulano");

        btnParear = (Button) findViewById(R.id.btnParear);
        btnMinhasCompras = (Button) findViewById(R.id.btnMinhasCompras);

        btnParear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intent = new IntentIntegrator(PrincipalActivity.this);
                intent.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                intent.setPrompt("Scan");
                intent.setCameraId(0);
                intent.setBeepEnabled(false);
                intent.setBarcodeImageEnabled(false);
                intent.initiateScan();
            }
        });

        btnMinhasCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PrincipalActivity.this, MinhasComprasActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuLogin = getMenuInflater();
        menuLogin.inflate(R.menu.menu_login, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_sair:
                SharedPreferences.Editor preferenciaEditor = getSharedPreferences("preferencia", Context.MODE_PRIVATE).edit();
                preferenciaEditor.remove("user");
                preferenciaEditor.remove("senha");
                preferenciaEditor.commit();


                finish();
                Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult resultado = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (resultado != null) {
            if (resultado.getContents() == null) {
                Toast.makeText(this, "Cancelou o scanner", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, resultado.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}// fim da classe