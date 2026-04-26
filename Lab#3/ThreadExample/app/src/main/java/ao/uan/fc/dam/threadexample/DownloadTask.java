package ao.uan.fc.dam.threadexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;
    private TextView statusText;

    public DownloadTask(ImageView imageView, TextView statusText) {
        this.imageView = imageView;
        this.statusText = statusText;
    }

    @Override
    protected void onPreExecute() {
        statusText.setText("Iniciando download...");
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            imageView.setImageBitmap(result);
            statusText.setText("Download completo!");
        } else {
            statusText.setText("Erro no download");
        }
    }
}