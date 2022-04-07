package br.com.fernandosousa.lmsapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // acessar parametros da intnet
        // intent é um atributo herdado de Activity
        val args = intent.extras
        // recuperar o parâmetro do tipo String
        val nome = args?.getString("nome")

        // recuperar parâmetro simplificado
        val numero = intent.getIntExtra("nome",0)

        Toast.makeText(context, "Parâmetro: $nome", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "Numero: $numero", Toast.LENGTH_LONG).show()

        mensagemInicial.text = "Bem vindo $nome"

        botaoSair.setOnClickListener {cliqueSair()}

        supportActionBar?.title = "Disciplinas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
        if (id  == R.id.action_buscar){
            Toast.makeText(this,
                    "Buscar",
                    Toast.LENGTH_SHORT)
                    .show()
        }else if (id  == R.id.action_atualizar){
            Toast.makeText(this,
                    "Atualizar",
                    Toast.LENGTH_SHORT)
                    .show()
        }else if (id  == R.id.action_config){
            Toast.makeText(this,
                    "Configurações",
                    Toast.LENGTH_SHORT)
                    .show()

            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
        }else if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun cliqueSair() {
        val returnIntent = Intent();
        returnIntent.putExtra("result","Saída do LMSApp");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

}
