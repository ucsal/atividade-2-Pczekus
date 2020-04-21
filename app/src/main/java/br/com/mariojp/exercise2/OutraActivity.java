package br.com.mariojp.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);
        editText = findViewById(R.id.editText);

        if (getIntent().hasExtra("USUARIO")){
            editText.setText(getIntent().getStringExtra("USUARIO"));
        }

    }

    public void botaoConfirmar(View v){
        getIntent().putExtra("USUARIO", editText.getText().toString());
        setResult(150,getIntent());
        finish();
    }
    public void botaoCancelar(View v){
        setResult(200, null);
        finish();
    }
}
