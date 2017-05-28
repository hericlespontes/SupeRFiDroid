package br.com.bhl.superfidapp.validation;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import br.com.bhl.superfidapp.bo.LoginBO;
import br.com.bhl.superfidapp.util.Util;

/**
 * Created by LEONARDOLN on 24/05/2017.
 */

public class LoginValidation {

    private String user;
    private String senha;

    private EditText edtUser;
    private EditText edtSenha;

    private Activity actitity;

    public LoginValidation() {
    }

    public LoginValidation(String user, String senha, EditText edtUser, EditText edtSenha, Activity actitity) {
        this.user = user;
        this.senha = senha;
        this.edtUser = edtUser;
        this.edtSenha = edtSenha;
        this.actitity = actitity;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EditText getEdtUser() {
        return edtUser;
    }

    public void setEdtUser(EditText edtUser) {
        this.edtUser = edtUser;
    }

    public EditText getEdtSenha() {
        return edtSenha;
    }

    public void setEdtSenha(EditText edtSenha) {
        this.edtSenha = edtSenha;
    }

    public Activity getActitity() {
        return actitity;
    }

    public void setActitity(Activity actitity) {
        this.actitity = actitity;
    }

}// fim da classe
