package ao.uan.fc.dam.fileexplorer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExternalStorage extends Activity {

    // wrap some operations that are likely to be needed in more than one place in FileUtil

    private EditText input;
    private TextView output;
    private Button write;
    private Button read;

    @Override
    public void onCreate(final Bundle icicle) {
        super.onCreate(icicle);
        this.setContentView(R.layout.external_storage);

        this.input = (EditText) findViewById(R.id.external_storage_input);
        this.output = (TextView) findViewById(R.id.external_storage_output);

        this.write = (Button) findViewById(R.id.external_storage_write_button);
        this.write.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
                write();
            }
        });

        this.read = (Button) findViewById(R.id.external_storage_read_button);
        this.read.setOnClickListener(new OnClickListener() {
            public void onClick(final View v) {
                read();
            }
        });
    }

    private void write() {
        try {
            File dir = getExternalFilesDir(null);

            if (dir == null) {
                Toast.makeText(this, "External storage not available", Toast.LENGTH_SHORT).show();
                return;
            }

            File file = new File(dir, "test.txt");

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(input.getText().toString().getBytes());
            fos.close();

            Toast.makeText(this, "File written", Toast.LENGTH_SHORT).show();
            input.setText("");

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void read() {
        try {
            File dir = getExternalFilesDir(null);

            if (dir == null) {
                Toast.makeText(this, "External storage not available", Toast.LENGTH_SHORT).show();
                return;
            }

            File file = new File(dir, "test.txt");

            if (!file.exists()) {
                Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
                return;
            }

            FileInputStream fis = new FileInputStream(file);

            StringBuilder sb = new StringBuilder();
            int c;

            while ((c = fis.read()) != -1) {
                sb.append((char) c);
            }

            fis.close();

            output.setText(sb.toString());

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

