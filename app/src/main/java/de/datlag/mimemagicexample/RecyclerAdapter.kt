package de.datlag.mimemagicexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val items: List<RecyclerData>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_mime_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val header = holder.itemView.findViewById<TextView>(R.id.textHeader)
        val mime = holder.itemView.findViewById<TextView>(R.id.textMime)
        val archive = holder.itemView.findViewById<CheckBox>(R.id.textArchive)
        val audio = holder.itemView.findViewById<CheckBox>(R.id.textAudio)
        val document = holder.itemView.findViewById<CheckBox>(R.id.textDocument)
        val font = holder.itemView.findViewById<CheckBox>(R.id.textFont)
        val image = holder.itemView.findViewById<CheckBox>(R.id.textImage)
        val text = holder.itemView.findViewById<CheckBox>(R.id.textText)
        val video = holder.itemView.findViewById<CheckBox>(R.id.textVideo)
        val item = items[position]

        header.text = item.header
        mime.text = item.mimeData.mimeType ?: "not detected"
        archive.isChecked = item.mimeData.isArchive
        audio.isChecked = item.mimeData.isAudio
        document.isChecked = item.mimeData.isDocument
        font.isChecked = item.mimeData.isFont
        image.isChecked = item.mimeData.isImage
        text.isChecked = item.mimeData.isText
        video.isChecked = item.mimeData.isVideo
    }

    override fun getItemCount(): Int = items.size

}