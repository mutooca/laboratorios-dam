package ao.uan.fc.dam.threadexample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private Handler handler = new Handler(Looper.getMainLooper(), this);
    private TextView statusText;
    private Thread workerThread;
    private boolean running = false;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);
        statusText = findViewById(R.id.statusText);
        ImageView imageView = findViewById(R.id.imageView);
        Button btnDownload = findViewById(R.id.btnDownload);

        btnStart.setOnClickListener(v -> startThread());
        btnStop.setOnClickListener(v -> stopThread());
        btnDownload.setOnClickListener(v -> {
            new DownloadTask(imageView, statusText)
                    .execute("https://picsum.photos/300");
        });
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        if (msg.obj != null) {
            statusText.setText(msg.obj.toString());
        }
        return true;
    }

    private void startThread() {
        if (running) return; // 🔥 evita múltiplas threads

        running = true;
        counter = 0;

        workerThread = new Thread(() -> {
            while (running) {
                try {
                    counter++;

                    Message message = handler.obtainMessage();
                    message.obj = "Contador: " + counter;
                    handler.sendMessage(message);

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    Log.d("THREAD", "Thread interrompida");
                    return;
                }
            }
        });

        workerThread.start();
    }
    private void stopThread() {
        running = false;

        if (workerThread != null) {
            workerThread.interrupt();
        }
    }

}