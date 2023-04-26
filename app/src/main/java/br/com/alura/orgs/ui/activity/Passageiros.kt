/*
package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.widget.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog


public class Passageiros extends AppCompactActivity{

    EditText editText;
    Button btn;


    override fun void onCreate(Bundle saveInstanceState){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.Passageiros)
        editText = (editText) findViewById(R.id.editTextTextPersonName2)
        btn = (Button) findViewById(R.id.button)
        btn.setOnClickListener(new View.OnClickListener())
        {
            @Override
            public void onClick(View v){
                enviarMSG()
            }
        }
    }
}
 public void enviarMSG()
{
     AlertDialog.Builder msg = new AlertDialog.Builder (this)
 msg.setMessage("Olá"+ editText.getText().toString()+ "Seus dados foram salvos com sucesso")
    msg.show()
 }*/
