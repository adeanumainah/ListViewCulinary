package com.aulia.idn.culinarylistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var culiAdapter : Adapter
    private var culies = arrayListOf<Model>()
    private lateinit var type1 : Array<String>
    private lateinit var type2 : Array<String>
    private lateinit var title : Array<String>
    private lateinit var desc : Array<String>
    private lateinit var date : Array<String>
    private lateinit var image : TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        culiAdapter = Adapter(this)

        lv_main.adapter = culiAdapter
        attachData()
        loadData()
    }

    private fun loadData() {
        for (p0 in title.indices){
            val culi = Model(
                type1[p0],
                type2[p0],
                title[p0],
                desc[p0],
                date[p0],
                image.getResourceId(p0,-1)
            )
            culies.add(culi)
        }
        culiAdapter.culies = culies
    }

    private fun attachData() {
        type1 = resources.getStringArray(R.array.type1)
        type2 = resources.getStringArray(R.array.type2)
        title = resources.getStringArray(R.array.title)
        desc = resources.getStringArray(R.array.desc)
        date = resources.getStringArray(R.array.date)
        image = resources.obtainTypedArray(R.array.image)
    }
}
