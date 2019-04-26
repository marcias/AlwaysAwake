package com.msc.dev.alwaysawakeapp.howtouse

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msc.dev.alwaysawakeapp.R
import kotlinx.android.synthetic.main.fragment_how_to_use.*

class HowToUseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_how_to_use,  container, false)
    }

}