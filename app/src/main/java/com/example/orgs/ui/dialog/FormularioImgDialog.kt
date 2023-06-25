package com.example.orgs.ui.dialog

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.orgs.databinding.FormImagemBinding
import com.example.orgs.extensions.loadImgView

class FormularioImgDialog(private val context: Context) {

    fun show(whenImgLoad: (img: String) -> Unit) {
        val binding = FormImagemBinding.inflate(LayoutInflater.from(context))
        binding.buttonAddImagem.setOnClickListener {
            val url = binding.editTextUrl.text.toString()
            binding.imgForms.loadImgView(url)
        }
        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirm") { _, _ ->
                val url = binding.editTextUrl.text.toString()
                whenImgLoad(url)
            }
            .setNegativeButton("Cancel") { _, _ ->

            }
            .show()
    }
}
