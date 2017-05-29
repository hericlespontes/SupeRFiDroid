package br.com.bhl.superfidapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hericles on 28/05/17.
 */

public class ComprasViewHolder extends RecyclerView.ViewHolder {
    final TextView descricao;
    final TextView precoUnitario;
    final TextView marca;
    final TextView validade;
    final TextView lote;
    final TextView unidades;

    public ComprasViewHolder(View view){
        super(view);
        descricao = (TextView) view.findViewById(R.id.item_produto_descricao);
        precoUnitario = (TextView) view.findViewById(R.id.item_produto_precoUnitario);
        marca = (TextView) view.findViewById(R.id.item_produto_marca);
        validade = (TextView) view.findViewById(R.id.item_produto_validade);
        lote = (TextView) view.findViewById(R.id.item_produto_lote);
        unidades = (TextView) view.findViewById(R.id.item_produto_unidades);
    }
}
