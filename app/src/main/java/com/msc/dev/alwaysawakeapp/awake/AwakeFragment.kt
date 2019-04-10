package com.msc.dev.alwaysawakeapp.awake

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msc.dev.alwaysawakeapp.Constants
import com.msc.dev.alwaysawakeapp.R

import kotlinx.android.synthetic.main.fragment_awake.*

class AwakeFragment : Fragment(), AwakeContract.View {
    var presenter: AwakePresenter = AwakePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_awake, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.setView(this)
        presenter.setImageData(arguments?.getString(Constants.EXTRA_IMAGE_URI)!!)
    }

    override fun showImage(uriStr: String) {
        var uriImage = Uri.parse(uriStr)
        iv_image.setImageURI(uriImage)
    }

    override fun showImageError() {
        tv_img_no_found.visibility = View.VISIBLE
    }

}