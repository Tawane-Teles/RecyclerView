package com.tawane.listadepaises

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tawane.listadepaises.adapter.ListaAdapter

class MainActivity : AppCompatActivity() {

    var nameList = ArrayList<String>()
    var listaAdapter: ListaAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    var list:RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        getCats()

    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView() {
        list = findViewById(R.id.id_recyclerview)
        listaAdapter = ListaAdapter(nameList, this)
        linearLayoutManager = LinearLayoutManager(this)
        list?.layoutManager = linearLayoutManager
        list?.adapter = listaAdapter
    }

    // setando no adapter os gatos
    private fun getCats() {
        nameList.add(getString(R.string.pais_um))
        nameList.add(getString(R.string.pais_dois))
        nameList.add(getString(R.string.pais_tres))
        nameList.add(getString(R.string.pais_quatro))
    }

    //Buscando os gastos que inseriou na tela Name
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val nome: String = data!!.getStringExtra("nome").toString()
            nameList.add(nome)
        }
    }
}