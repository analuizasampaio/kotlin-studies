package br.com.fernandosousa.lmsapp

import android.app.ActionBar
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity(),
    NavigationView.OnNavigationItemSelectedListener {

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
        val numero = intent.getIntExtra("nome", 0)

        Toast.makeText(context, "Parâmetro: $nome", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "Numero: $numero", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar)

        mensagemInicial.text = "Bem vindo $nome"

        botaoSair.setOnClickListener { cliqueSair() }

        supportActionBar?.title = "Disciplinas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerDisciplinas?.layoutManager = LinearLayoutManager(this)
        recyclerDisciplinas?.itemAnimator = DefaultItemAnimator()
        recyclerDisciplinas?.setHasFixedSize(true)
    }

    private var disciplinas = listOf<Disciplina>()
    override fun onResume() {
        super.onResume()
        disciplinas = DisciplinaService.getDisciplinas()
        recyclerDisciplinas?.adapter = DisciplinaAdapter(disciplinas){  onClickDisciplina(it)}
    }

    fun onClickDisciplina(disciplina: Disciplina){
        Toast.makeText(this, "Clicou na ${disciplina.nome}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
        if (id == R.id.action_buscar) {
            Toast.makeText(this,
                    "Buscar",
                    Toast.LENGTH_SHORT)
                    .show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this,
                    "Atualizar",
                    Toast.LENGTH_SHORT)
                    .show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this,
                    "Configurações",
                    Toast.LENGTH_SHORT)
                    .show()

            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun cliqueSair() {
        val returnIntent = Intent();
        returnIntent.putExtra("result", "Saída do LMSApp");
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_disciplinas -> {
                Toast.makeText(this, "Disciplinas",
                        Toast.LENGTH_SHORT).show()
            }
            R.id.nav_forum -> {
                Toast.makeText(this, "Forúm",
                        Toast.LENGTH_SHORT).show()
            }
            R.id.nav_localizacao -> {
                Toast.makeText(this, "Localização",
                        Toast.LENGTH_SHORT).show()

            }
        }
            return true
    }
    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
                this,
                layoutMenuLateral,
                toolbar,
                R.string.open,
                R.string.close
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener (this)
    }

 }