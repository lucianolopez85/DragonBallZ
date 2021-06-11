package com.example.testes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<data>
    lateinit var imageId :Array<Int>
    lateinit var titulo: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.freeza,
            R.drawable.mestre_kame,
            R.drawable.bulma,
            R.drawable.cell,
            R.drawable.gohan,
            R.drawable.goku,
            R.drawable.goten,
            R.drawable.kuririn,
            R.drawable.trunks,
            R.drawable.vegeta,
        )
        titulo = arrayOf(
            "Freeza",
            "MestreKame",
            "Bulma",
            "Cell",
            "Gohn",
            "Goku",
            "Goten",
            "Kuririn",
            "Trunks",
            "Vegeta"

        )
        recyclerView=findViewById(R.id.recycler_view)
        arrayList= arrayListOf()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices){
            val fulList = data(imageId[i], titulo[i])
            arrayList.add(fulList)
        }
        recyclerView.adapter=MyAdapter(arrayList)
    }
}