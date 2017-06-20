package karakayastudio.notdefteri;
/**
 * Created by Karakaya on 18.06.2017.
 */
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class girdi extends AppCompatActivity {
    EditText etName, etContent;
    Button btn_Save;
    Button btn_entry;
    String fileName, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.girdi);
        instalize_elements();
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName = etName.getText().toString();
                if(fileName.contentEquals(""))
                {
                    fileName = "isimsiz";
                }
                content = etContent.getText().toString();
                try {
                    FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                    fos.write(content.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(girdi.this, cikti.class);
                startActivity(i);
            }
        });
    }
    private void instalize_elements(){
        etName  = (EditText) findViewById(R.id.etName);
        etContent = (EditText) findViewById(R.id.etContent);
        btn_Save = (Button) findViewById(R.id.btn_Save);
        btn_entry = (Button) findViewById(R.id.btn_entry);
    }

}

