package com.ajdevmobile.preferenciasusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText edit_nome, edit_email;
    private Button button_salvar;

    private TextView text_nome, text_email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        recuperarValores();


    }

    private void iniciarComponentes(){

        edit_nome = findViewById(R.id.edit_nome);
        edit_email = findViewById(R.id.edit_email);

        button_salvar = findViewById(R.id.button_salvar);

        text_nome = findViewById(R.id.text_nome);
        text_email = findViewById(R.id.text_email);

        button_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();

                if(!nome.isEmpty() && !email.isEmpty()){

                    SharedPreferences preferences = getSharedPreferences("arquivoDados", 0);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("nome", nome);
                    editor.putString("email", email);
                    editor.commit();

                    text_nome.setText(nome);
                    text_email.setText(email);

                }else{

                    Toast.makeText(getApplicationContext(), "Existem campos vázios", Toast.LENGTH_SHORT).show();

                }




            }
        });

    }


    private void recuperarValores(){

        SharedPreferences preferences = getSharedPreferences("arquivoDados", 0);

        String nome = preferences.getString("nome", "Dados inválidos");
        String email = preferences.getString("email", "Dados inválidos"); ;

        text_nome.setText(nome);
        text_email.setText(email);

    }


}