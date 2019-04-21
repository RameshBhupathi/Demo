package io.ramesh.timesapidemo.view.fragments.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import io.ramesh.timesapidemo.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LoadingDialog.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LoadingDialog.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LoadingDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.loading_dialog, container)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(activity!!)

        dialog.setContentView(R.layout.loading_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)
        val width = resources.getDimensionPixelSize(R.dimen.loading_dialog_width)
        val height = resources.getDimensionPixelSize(R.dimen.loading_dialog_height)
        dialog.window!!.setLayout(width, height)

        return dialog

    }

    companion object {
        @JvmStatic
        fun newInstance(): LoadingDialog {
            val loadingDialog = LoadingDialog()
            val args = Bundle()
            loadingDialog.arguments = args

            return loadingDialog
        }
    }
}
