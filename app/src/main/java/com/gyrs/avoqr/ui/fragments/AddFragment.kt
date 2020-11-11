package com.gyrs.avoqr.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.gyrs.avoqr.R
import kotlinx.android.synthetic.main.add_fragment.*


class AddFragment : Fragment(R.layout.add_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSave.setOnClickListener {
            generateQR()
        }
    }

    private fun generateQR(){
       val builder = MaterialAlertDialogBuilder(requireContext())
            .setTitle("QR code")
           .setOnCancelListener {
               findNavController().popBackStack()
           }

        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_qr, null)

        builder.setView(dialogLayout)
        builder.show()
    }
}