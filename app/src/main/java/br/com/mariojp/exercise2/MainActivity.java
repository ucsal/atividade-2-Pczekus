package br.com.mariojp.exercise2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String usuario = "";
    private TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);



        if (savedInstanceState != null){
            usuario = savedInstanceState.getString("KEYTELA", "");
            textView.setText("Oi, "+usuario+"!");
        }
    }

    public void mudarTela(View v){
        Intent mudar = new Intent(MainActivity.this, OutraActivity.class);
        mudar.putExtra("USUARIO", usuario);
        startActivityForResult(mudar, 150);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("KEYTELA", usuario);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data.hasExtra("USUARIO")){
            if(data.getStringExtra("USUARIO").trim().isEmpty()){
                usuario="";
                textView.setText("Oi, !");
            }else{
                usuario=data.getStringExtra("USUARIO");
                textView.setText("Oi, "+usuario+"!");
            }
        }
    }
}
