package br.com.bhl.superfidapp.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by LEONARDOLN on 02/05/2017.
 */

public class Util {

    public static void showMensagens(Activity activity, String mensagem) {

        Toast toast = Toast.makeText(activity, mensagem, Toast.LENGTH_LONG);
        toast.show();
    }

    public static void showAlertMensagemOk(final Activity activity, String titulo, String mensagem) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.create();

        alertDialog.setTitle(titulo);
        alertDialog.setMessage(mensagem);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Util.showMensagens(activity, "SupeRFiD App v.1.0");
            }
        });// fim do setup do botão Ok do AlertDialog
        alertDialog.show();
    }

} // fim da classe