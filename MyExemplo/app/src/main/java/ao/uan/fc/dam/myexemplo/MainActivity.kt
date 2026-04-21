package ao.uan.fc.dami.myexemplo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciar os botões do layout
        val btnRegistar: Button = findViewById(R.id.btnRegistar)
        val btnIniciarSessao: Button = findViewById(R.id.btnIniciarSessao)

        // Ação do botão Registar
        btnRegistar.setOnClickListener {
            Toast.makeText(this, "Clicou em Registar", Toast.LENGTH_SHORT).show()
        }

        // Ação do botão Iniciar Sessão
        btnIniciarSessao.setOnClickListener {
            Toast.makeText(this, "Clicou em Iniciar Sessão", Toast.LENGTH_SHORT).show()
        }
    }
}