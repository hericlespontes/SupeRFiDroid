package br.com.bhl.superfidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Compras extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz",13.30,"Prato Fino","23/10/2017","L1011",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));

        recyclerView.setAdapter(new ComprasAdapter(produtos,this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

        }
    }
