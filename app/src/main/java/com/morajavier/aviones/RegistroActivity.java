package com.morajavier.aviones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class RegistroActivity extends AppCompatActivity {
    Button jbtnSelectImagen, jbtnRegistrarPiloto;
    EditText jtextFecha, jtextHora, jtextNombrePiloto;
    /*
    mongodb+srv://<username>:<password>@cluster0-2srol.mongodb.net/test?retryWrites=true&w=majority

    MongoClientURI uri = new MongoClientURI(
        "mongodb+srv://<username>:<password>@cluster0-2srol.mongodb.net/test?retryWrites=true&w=majority");

    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("test");

    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        jbtnSelectImagen = findViewById(R.id.xbtnImagen);
        jbtnRegistrarPiloto = findViewById(R.id.xbtnRegistroPiloto);

        jtextFecha = findViewById(R.id.textFecha);
        jtextHora = findViewById(R.id.textHora);
        jtextNombrePiloto = findViewById(R.id.textNombrePiloto);
        jbtnRegistrarPiloto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkData(jtextFecha) && checkData(jtextHora) && checkData(jtextNombrePiloto)){
                    try {
                        MongoClientURI uri = new MongoClientURI("mongodb+srv://kuz:holapendejo@cluster0-2srol.mongodb.net/aviones");
                        MongoClient mongoClient = new MongoClient(uri);
                        MongoDatabase database = mongoClient.getDatabase("aviones");
                        MongoCollection mongoCollection =  database.getCollection("pilotos");
                        //mongoCollection.insertOne(());

                        DBObject dbObject = (DBObject) JSON.parse(
                                "{'nombre':"+jtextNombrePiloto.getText().toString()
                                +", 'fecha':"+jtextFecha.getText().toString()+",'hora':"+jtextHora.getText().toString()+"}");
                        mongoCollection.insertOne(dbObject);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Toast.makeText(RegistroActivity.this, "Guardado", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(RegistroActivity.this, "No guardado, complete los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private boolean checkData(EditText field){
        if(field.getText().toString()!="" && field != null){
            return true;
        }
        return false;
    }
}
