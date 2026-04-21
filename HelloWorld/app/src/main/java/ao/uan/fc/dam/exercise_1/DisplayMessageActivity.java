package ao.uan.fc.dam.exercise_1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Recebe a mensagem enviada
        String message = getIntent().getStringExtra("EXTRA_MESSAGE");

        // Exibe no TextView
        TextView textViewMessage = findViewById(R.id.textViewMessage);
        textViewMessage.setText(message);
    }
}