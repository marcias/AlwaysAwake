package com.msc.dev.alwaysawakeapp.history

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msc.dev.alwaysawakeapp.R
import com.msc.dev.alwaysawakeapp.howtouse.HowToUseActivity
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.view_empty_history.*

class HistoryFragment : Fragment(), HistoryContract.View {
    var mPresenter = HistoryPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.setView(this)
        mPresenter.getGalleryContent()

        btn_learn_how_to_use.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity, HowToUseActivity::class.java))
        })
    }

    override fun updateGallery() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressBar() {
        progress.visibility = View.VISIBLE
    }

    override fun hidePogressBar() {
        progress.visibility = View.GONE
    }

    override fun showEmptyGalleryMessage() {
        view_empty_history.visibility = View.VISIBLE
    }

    override fun hideEmptyGalleryMessage() {
        view_empty_history.visibility = View.GONE
    }
}