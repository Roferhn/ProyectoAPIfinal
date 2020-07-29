package com.example.proyectoapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.media.midi.MidiDeviceService;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String URL = "https://api.rawg.io/api/games";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Juegos> Ljuegos = new ArrayList<>();
    private RecyclerView recyclerView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        jsonrequest();


    }

    private void jsonrequest() {


        request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;


                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Juegos juego = new Juegos();
                        juego.setNombre(jsonObject.getString("name"));
                        juego.setRating(jsonObject.getString("rating"));
                        juego.setImagen(jsonObject.getString("background_image"));
                        Ljuegos.add(juego);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                Toast.makeText(MainActivity.this,"Size of List" + String.valueOf(Ljuegos.size()),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, Ljuegos.get(1).toString(),Toast.LENGTH_SHORT).show();
                setRvadapter(Ljuegos);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void setRvadapter(List<Juegos> Ljuegos) {

        adapter mAdapter = new adapter(this, Ljuegos);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapter);


    }


}