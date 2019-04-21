package io.ramesh.timesapidemo.view.base

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import io.ramesh.timesapidemo.MyApplication
import io.ramesh.timesapidemo.view.fragments.dialog.LoadingDialog
import javax.inject.Inject


abstract class BaseFragment : DaggerFragment() {
    /**
     * Created by Ramesh Bhupathi on 2019-04-21.
     */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var application: MyApplication
    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingDialog = LoadingDialog.newInstance()
    }

    fun showLoadingDialog() {
        if (loadingDialog != null)
            loadingDialog.show(fragmentManager!!, javaClass.name)
        else {
            loadingDialog = LoadingDialog.newInstance()
            loadingDialog.show(fragmentManager!!, javaClass.name)
        }
    }

    fun hideDialog() {
        when (loadingDialog.dialog?.isShowing) {

            true -> loadingDialog.dismiss()
        }
    }

    fun showToastMessage(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }
}