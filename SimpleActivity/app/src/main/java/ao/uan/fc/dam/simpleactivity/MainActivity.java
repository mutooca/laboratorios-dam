package ao.uan.fc.dam.simpleactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate chamado");
    }

    public void finishButtonPressed(View view) {
        Log.i(TAG, "Encerrar");
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart chamado");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop chamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy chamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart chamado");
    }
}