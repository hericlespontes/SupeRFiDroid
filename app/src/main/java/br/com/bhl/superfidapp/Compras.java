package br.com.bhl.superfidapp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.bhl.superfidapp.util.Util;

public class Compras extends AppCompatActivity {

    static List<Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerView.addItemDecoration(new DividerItemDecoration(this));


        /*produtos.add(new Produto("Arroz",13.30,"Prato Fino","23/10/2017","L1011",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
        produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));*/

        recyclerView.setAdapter(new ComprasAdapter(produtos,this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


        }

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("data");
            String dataString= new String(data);
            if(!dataString.equals("")){
                produtos.add(new Produto("Feijão",4.70,"Camil","23/10/2018","L4052",1.0));
            }
        }
    };
    }
