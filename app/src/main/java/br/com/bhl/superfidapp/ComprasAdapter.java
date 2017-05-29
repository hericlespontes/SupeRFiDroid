package br.com.bhl.superfidapp;

import android.support.v7.widget.RecyclerView;
import java.util.List;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;

/**
 * Created by hericles on 28/05/17.
 */

public class ComprasAdapter extends RecyclerView.Adapter {

    private List<Produto> produtos;
    private Context context;

    public ComprasAdapter(List<Produto> produtos, Context context){
        this.produtos = produtos;
        this.context = context;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.viewholder, parent, false);

        ComprasViewHolder holder = new ComprasViewHolder(view);

        return holder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {
        ComprasViewHolder holder = (ComprasViewHolder) viewHolder;

        Produto produto  = produtos.get(position) ;

        holder.descricao.setText(produto.getDescricao());
        holder.lote.setText(produto.getLote());
        holder.marca.setText(produto.getMarca());
        holder.precoUnitario.setText(""+ produto.getPrecoUnitario());
        holder.unidades.setText(""+ produto.getUnidades());
        holder.validade.setText(""+ produto.getValidade());

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
