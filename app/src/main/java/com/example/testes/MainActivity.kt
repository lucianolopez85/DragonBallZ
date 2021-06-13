package com.example.testes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<data>
    lateinit var listImageId: Array<Int>
    lateinit var listTitle: Array<String>
    lateinit var listData: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listImageId = arrayOf(
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
        listTitle = arrayOf(
            "Freeza",
            "Mestre Kame",
            "Bulma",
            "Cell",
            "Gohn",
            "Goku",
            "Goten",
            "Kuririn",
            "Trunks",
            "Vegeta"

        )
        listData = arrayOf(
            getString(R.string.position_0),
            getString(R.string.position_1),
            getString(R.string.position_2),
            getString(R.string.position_3),
            getString(R.string.position_4),
            getString(R.string.position_5),
            getString(R.string.position_6),
            getString(R.string.position_7),
            getString(R.string.position_8),
            getString(R.string.position_9)

            )

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        arrayList = arrayListOf()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in listImageId.indices) {
            val fulList = data(listImageId[i], listTitle[i])
            arrayList.add(fulList)
        }

        val adapter = MyAdapter(arrayList)

        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@MainActivity,"testando ${position}", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity,DetailActivity::class.java )
                intent.putExtra("listTitle", arrayList[position].title)
                intent.putExtra("listImageId",arrayList[position].image )
                intent.putExtra("listData", listData[position])
                startActivity(intent)
            }

        })
    }
}