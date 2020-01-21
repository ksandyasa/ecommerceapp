package com.sehatqtestengineer.features.adapters

import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sehatqtestengineer.util.extension.getParentActivity
import com.sehatqtestengineer.R

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {

    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:"" })
    }

}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: MutableLiveData<String>?) {

    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && url != null) {
        url.observe(parentActivity, Observer { value -> Glide.with(view.context).load(value?:"").into(view)})
    }
}

@BindingAdapter("mutableLoved")
fun setMutableLoved(view: ImageView, loved: MutableLiveData<Int>?) {

    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && loved != null) {
        loved.observe(parentActivity, Observer { value -> if(value?:0 == 1) view.setImageResource(R.drawable.icon_love_fill) else view.setImageResource(R.drawable.icon_love_empty) })
    }

}