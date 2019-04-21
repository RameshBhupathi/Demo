package io.ramesh.timesapidemo.view.base

import android.os.Bundle
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import io.ramesh.timesapidemo.view.fragments.dialog.LoadingDialog


abstract class BaseActivity : DaggerAppCompatActivity() {

    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingDialog = LoadingDialog.newInstance()
    }

    fun showLoadingDialog() {
        if (loadingDialog != null)
            loadingDialog.show(supportFragmentManager, javaClass.name)
    }

    fun hideDialog() {
        when (loadingDialog.dialog?.isShowing) {

            true -> loadingDialog.dismiss()
        }
    }

    fun showToastMessage(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}
