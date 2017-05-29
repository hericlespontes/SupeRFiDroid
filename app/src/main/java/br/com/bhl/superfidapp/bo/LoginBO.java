package br.com.bhl.superfidapp.bo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import br.com.bhl.superfidapp.util.Util;
import br.com.bhl.superfidapp.validation.LoginValidation;

/**
 * Created by LEONARDOLN on 24/05/2017.
 */

public class LoginBO {

    public boolean validarLogin(LoginValidation loginValidation) {
        boolean validacao = true;

        if (loginValidation.getUser() == null || loginValidation.getUser().equals("")) {
            loginValidation.getEdtUser().setError("Campo obrigatório");
            validacao = false;
        }

        if (loginValidation.getSenha() == null || loginValidation.getSenha().equals("")) {
            loginValidation.getEdtSenha().setError("Campo obrigatório");
            validacao = false;
        }

        if (validacao) {
            if(!loginValidation.getUser().equals("user") || !loginValidation.getSenha().equals("123")) {
                Util.showMensagens(loginValidation.getActitity(), "Login/Senha inválidos");
                validacao = false;
            } else {
                SharedPreferences.Editor preferenciaLogin = loginValidation.getActitity().getSharedPreferences("preferencia", Context.MODE_PRIVATE).edit();
                preferenciaLogin.putString("user", loginValidation.getUser());
                preferenciaLogin.putString("senha", loginValidation.getSenha());
                preferenciaLogin.commit();
            }
        }

        return validacao;
    }

    public void deslogar() {

    }

}// fim da classe
