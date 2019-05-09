package com.msc.dev.alwaysawakeapp.noimage

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msc.dev.alwaysawakeapp.R
import com.msc.dev.alwaysawakeapp.howtouse.HowToUseActivity
import kotlinx.android.synthetic.main.fragment_no_image.*

class NoImageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_no_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_learn_how_to_use.setOnClickListener {
            startActivity(Intent(activity, HowToUseActivity::class.java))
        }
    }
}