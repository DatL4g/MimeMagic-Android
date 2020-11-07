package de.datlag.mimemagicexample

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.obsez.android.lib.filechooser.ChooserDialog
import de.datlag.mimemagic.MimeData
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun chooseFile(view: View?) {
        ChooserDialog(this)
            .withFilter(false, true)
            .withChosenListener { _, file ->
                supportActionBar?.title = file.name
                setRecyclerData(createItems(file))
            }
            .build()
            .show()
    }

    private fun createItems(file: File): List<RecyclerData> {
        if (file.isDirectory) {
            return listOf()
        }

        val items = mutableListOf<RecyclerData>()
        items.add(
            RecyclerData(
                "File - Extension Fallback",
                MimeData.fromFile(file)
            )
        )
        items.add(
            RecyclerData(
                "File - Uri Fallback",
                MimeData.fromFile(file, this)
            )
        )
        items.add(
            RecyclerData(
                "InputStream",
                MimeData.fromInputStream(file.inputStream())
            )
        )
        items.add(
            RecyclerData(
                "Uri",
                MimeData.fromUri(Uri.fromFile(file), this)
            )
        )
        items.add(
            RecyclerData(
                "Name",
                MimeData.fromName(file.name)
            )
        )
        return items
    }

    private fun setRecyclerData(items: List<RecyclerData>) {
        val recycler = findViewById<RecyclerView>(R.id.mimeRecycler)
        recycler.adapter = null
        recycler.adapter = RecyclerAdapter(items)
        recycler.layoutManager = LinearLayoutManager(this)
    }
}