package br.com.bhl.superfidapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    private String usrName;
    private SharedPreferences preferenciaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        preferenciaLogin = getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        usrName = preferenciaLogin.getString("user", null);

        if(usrName != null) {
            getSupportActionBar().setTitle("Bem-Vindo " + usrName);
        }

        btnParear = (Button) findViewById(R.id.btnParear);
        btnMinhasCompras = (Button) findViewById(R.id.btnMinhasCompras);

        btnParear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intent = new IntentIntegrator(PrincipalActivity.this);
                intent.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                intent.setPrompt("Aproxime do QRCode do Carrinho");
                intent.setCameraId(0);
                intent.setBeepEnabled(true);
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
                finish();
                Intent it = new Intent(this, MainBluetoothActivity.class);
                it.putExtra("qrResult",resultado.getContents());
                startActivity(it);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }


}// fim da classe