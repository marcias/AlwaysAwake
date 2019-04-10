package com.msc.dev.alwaysawakeapp.awake

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.msc.dev.alwaysawakeapp.Constants
import com.msc.dev.alwaysawakeapp.R


class AwakeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_awake)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        verifyIntentType()
    }

    fun initFragment() {
        var fragment = AwakeFragment()
        val args = Bundle()
        args.putString(Constants.EXTRA_IMAGE_URI, getUriFromIntent())
        fragment.arguments = args
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    fun verifyIntentType() {
        when {
            intent?.action == Intent.ACTION_SEND -> {
                if (intent.type.startsWith("image")) {
                    initFragment()
                }
            }
        }
    }

    fun getUriFromIntent(): String {
        var uri = intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM)
        (uri as? Uri?).let {
            return uri.toString()
        }
    }

}