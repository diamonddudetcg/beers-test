package com.santirivera.frogtekbeertest.fragment.base

import android.app.Dialog
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.santirivera.frogtekbeertest.R

abstract class FrogtekBeerBaseFragment : Fragment(), Loadable {

    private var loading = false

    private lateinit var dialog: Dialog

    override fun startLoad() {
        if (!loading) {
            dialog = createDialog()
            dialog.show()
            loading = true
        }
    }

    override fun endLoad() {
        if (loading) {
            dialog.hide()
            loading = false
        }
    }

    override fun noInternet() {
        dialog.findViewById<TextView>(R.id.dialogTextViewErrorInternet).visibility = View.VISIBLE
        dialog.setCancelable(true)
        dialog.setOnCancelListener { activity?.finish() }
    }

    private fun createDialog(): Dialog {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.progress_dialog)
        return dialog
    }

}