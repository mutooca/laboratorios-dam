package ao.uan.fc.dam.simpleactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloVida";

   // @Override
  //  protected void onCreate(Bundle savedInstanceState) {
     //   super.onCreate(savedInstanceState);
      //  EdgeToEdge.enable(this);
       // setContentView(R.layout.activity_main);
       // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
          //  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
          //  return insets;
       // });

   // }
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       EdgeToEdge.enable(this);
       setContentView(R.layout.activity_main);
       Log.i(TAG, "Chamada do metodo  onCreate");

       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
           Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
           v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
           return insets;
       });
   }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Chamada do metodo  onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Chamada do metodo onResume ");

       Toast.makeText(this, "Estou em açcão", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Chamada do metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Chamada do metodo onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Chamada do metodo onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Chamada do metodo onRestart");
    }
    public void finishButtonPressed(View view) {
        Log.i(TAG, "Encerrado.");
        finish();
    }
}