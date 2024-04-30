package kendrick.lopez.iniciodesesionyregistrofirebasekendrick

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandar a llamar a todos lod elementos de la pantalla
        val txtCorreo = findViewById<EditText>(R.id.TxtCorreo)
        val txtcontrasena = findViewById<EditText>(R.id.TxtContrasena)
        val registrarse = findViewById<Button>(R.id.btnRegistrarse)

        //2- Programar el boton
        registrarse.setOnClickListener {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(txtCorreo.text.toString(), txtcontrasena.text.toString())
            println("se dio clic")
        }
    }
}