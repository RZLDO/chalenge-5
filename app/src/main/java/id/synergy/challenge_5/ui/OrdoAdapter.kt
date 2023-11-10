package id.synergy.challenge_5.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.textview.MaterialTextView
import id.synergy.challenge_5.R
import id.synergy.challenge_5.domain.model.ordo.OrdoModel


class OrdoAdapter(private val onItemClick: (OrdoModel) -> Unit) :
    RecyclerView.Adapter<OrdoAdapter.OrdoViewHolder>() {

    private val ordoList = mutableListOf<OrdoModel>()

    fun setOrdoList(ordoList: List<OrdoModel>) {
        this.ordoList.clear()
        this.ordoList.addAll(ordoList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return OrdoViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrdoViewHolder, position: Int) {
        holder.bind(ordoList[position])
    }

    override fun getItemCount(): Int = ordoList.size

    inner class OrdoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClick(ordoList[adapterPosition])
            }
        }

        fun bind(ordo: OrdoModel) {
            itemView.findViewById<MaterialTextView>(R.id.tv_title).text = ordo.latinName
            itemView.findViewById<MaterialTextView>(R.id.tv_description).text = ordo.description
            Glide.with(itemView.context)
                .load(ordo.image)
                .into(itemView.findViewById(R.id.iv_image))
        }
    }
}

