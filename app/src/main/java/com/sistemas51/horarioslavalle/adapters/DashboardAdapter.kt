package com.sistemas51.horarioslavalle.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sistemas51.horarioslavalle.R
import com.sistemas51.horarioslavalle.activity.Help
import com.sistemas51.horarioslavalle.activity.ResultActivity
import com.sistemas51.horarioslavalle.models.SavedTrips
import com.squareup.picasso.Picasso
import java.io.Serializable
import java.util.*

class DashboardAdapter(private var models: List<SavedTrips>,
                       var context: Context,
                       private val listener: () -> Unit)
    : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(models[position].drawable).into(holder.imageView)
        holder.description.text = models[position].name
        holder.linearLayout.setOnClickListener {
            if (position == 0) {
               listener.invoke()
            } else if (position == 1) {
                val intent = Intent(context, Help::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(intent)
            } else {
                val args: MutableMap<String, String> = HashMap()
                args[context.resources.getString(R.string.from)] = models[position].from
                args[context.resources.getString(R.string.to)] = models[position].to
                args[context.resources.getString(R.string.route)] = models[position].route
                val intent = Intent(context, ResultActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("args", args as Serializable)
                context.startActivity(intent)
            }
        }
    }

    fun setModels(models: List<SavedTrips>) {
        this.models = models
    }

    override fun getItemCount(): Int {
        return models.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var description: TextView
        var linearLayout: LinearLayout

        init {
            imageView = itemView.findViewById(R.id.item_menu_image)
            description = itemView.findViewById(R.id.item_menu_description)
            linearLayout = itemView.findViewById(R.id.item_menu_linearLayout)
        }
    }
}