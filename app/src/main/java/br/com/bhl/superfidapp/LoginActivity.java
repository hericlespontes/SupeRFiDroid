package br.com.bhl.superfidapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.bhl.superfidapp.bo.LoginBO;
import br.com.bhl.superfidapp.validation.LoginValidation;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private Button btnCadastrar;
    private EditText edtUser;
    private EditText edtSenha;
    private int testeCommit;

    private SharedPreferences preferenciaLogin;

    private LoginBO loginBO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBO = new LoginBO();

        preferenciaLogin = getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        String user = preferenciaLogin.getString("user", null);
        String senha = preferenciaLogin.getString("senha", null);

        if (user != null && senha != null) {
            Intent it = new Intent(LoginActivity.this, PrincipalActivity.class);
            startActivity(it);
            finish();
        }

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        edtUser = (EditText) findViewById(R.id.edtUser);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String senha = edtSenha.getText().toString();

                LoginValidation loginValidation = new LoginValidation(user, senha, edtUser, edtSenha, LoginActivity.this);

                if (!loginBO.validarLogin(loginValidation)) {
                    edtUser.setText("");
                    edtSenha.setText("");
                } else {
                    Intent it = new Intent(LoginActivity.this, PrincipalActivity.class);
                    startActivity(it);
                    finish();
                }
            }
        });
    }

}// fim da classe