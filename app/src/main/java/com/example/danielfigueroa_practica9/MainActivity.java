package com.example.danielfigueroa_practica9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMessageListener{

    UDPConnection udp;
    private Orden orden;
    private ImageView sandwich;
    private ImageView yogur;
    private ImageView bebida;
    private ImageView hotdog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sandwich = findViewById(R.id.sandwich);
        yogur = findViewById(R.id.yogur);
        bebida = findViewById(R.id.bebida);
        hotdog = findViewById(R.id.hotdog);
        orden = new Orden("","","");

        udp = new UDPConnection();
        udp.setObserver(this); //this en este caso es main activity
        udp.start();


        sandwich.setOnClickListener(
                (v)->{

                    Gson gson = new Gson();

                    ArrayList<Orden> grupo = new ArrayList<>();

                    String json = gson.toJson(grupo);
                    Log.e("hello", ""+json);

                    udp.sendMessage(json);

                }
        );
        yogur.setOnClickListener(
                (v)->{


                }
        );
        bebida.setOnClickListener(
                (v)->{

                }
        );
        hotdog.setOnClickListener(
                (v)->{

                }
        );
    }


    @Override
    public void recibirConfirmacion(String orden) { //se conecta con el UDP, metodo se hace desde un hilo y si quiero imagenes necesito
    runOnUiThread(
            ()->{ //aqui van las confirmaciones de ordenes

            }
    );
    }
}