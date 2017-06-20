package karakayastudio.notdefteri;
/**
 * Created by Karakaya on 18.06.2017.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cikti extends AppCompatActivity {
    Button btn_loadFile;
    Spinner Sfiles;
    TextView tvShowContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cikti);
        instalize_elements();
        getFileNames();

        btn_loadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedFile = String.valueOf(Sfiles.getSelectedItem());
                try {
                    String data = getData(selectedFile);
                    tvShowContent.setText(data);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            private String getData(String selectedFile) throws IOException {
                String value = "";
                FileInputStream fis = openFileInput(selectedFile);
                byte[] input = new byte[fis.available()];
                while(fis.read(input) != -1){
                    value += new String(input);
                }
                fis.close();
                return  value;
            }
            
        });

    }



    private void getFileNames() {
        String[] fileNames = getApplicationContext().fileList();
        List<String> list = new ArrayList<String>();
        for (int i =0; i<fileNames.length; i++){
            list.add(fileNames[i]);
        }
        try {
            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
            Sfiles.setAdapter(adapter);
        }catch (IllegalArgumentException e)
        {

        }
    }
    private void instalize_elements() {
        btn_loadFile = (Button) findViewById(R.id.btn_loadFile);
        Sfiles = (Spinner) findViewById(R.id.Sfiles);
        tvShowContent = (TextView) findViewById(R.id.tvShowContent);
    }
}