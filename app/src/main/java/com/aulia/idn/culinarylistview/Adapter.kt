package com.aulia.idn.culinarylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Adapter internal constructor(private val context: Context) : BaseAdapter(){
    internal  var culies = arrayListOf<Model>()
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_view,p2,false)
        }
        val viewHolder = ViewHolder(view as View)
        val culi = getItem(p0) as Model
        viewHolder.bind(culi)
        return view
    }

    override fun getItem(p0: Int): Any {
        return culies[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()    }

    override fun getCount(): Int = culies.size

    private inner class ViewHolder internal constructor(view: View) {
        private val tvType1 : TextView = view.findViewById(R.id.tv_type1)
        private val tvType2 : TextView = view.findViewById(R.id.tv_type2)
        private val tvTitle : TextView = view.findViewById(R.id.tv_title)
        private val tvDesc : TextView = view.findViewById(R.id.tv_desc)
        private val tvDate : TextView = view.findViewById(R.id.tv_date)
        //insialize ImgView
        private val imgCulinary : ImageView = view.findViewById(R.id.img_culinary)

        internal fun bind(modelActivity: Model){
            tvType1.setText(modelActivity.type1)
            tvType2.text = modelActivity.type2
            tvTitle.setText(modelActivity.title)
            tvDesc.text = modelActivity.desc
            tvDate.setText(modelActivity.date)
            Glide.with(context).load(modelActivity.image).circleCrop().override(500).into(imgCulinary)
        }
    }
}


