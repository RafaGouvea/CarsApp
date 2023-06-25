package com.example.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.orgs.databinding.FormImagemBinding
import com.example.orgs.extensions.loadImgView

class FormularioImgDialog(private val context: Context) {

    fun show(
        urlSend: String? = null,
        whenImgLoad: (img: String) -> Unit
    ) {
        FormImagemBinding.inflate(LayoutInflater.from(context)).apply {
            urlSend?.let {
                imgForms.loadImgView(it)
                editTextUrl.setText(it)
            }
            buttonAddImagem.setOnClickListener {
                val url = editTextUrl.text.toString()
                imgForms.loadImgView(url)
            }
            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("Confirm") { _, _ ->
                    val url = editTextUrl.text.toString()
                    whenImgLoad(url)
                }
                .setNegativeButton("Cancel") { _, _ ->

                }
                .show()
        }
    }
}
