package ao.uan.fc.dam.threadexample;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class ConsumerThread extends Thread {

    public Handler handler;

    @Override
    public void run() {
        Looper.prepare();

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                String data = (String) msg.obj;

                Log.d("LOOPER", "Recebido: " + data);

                return true;
            }
        });

        Looper.loop();
    }
}