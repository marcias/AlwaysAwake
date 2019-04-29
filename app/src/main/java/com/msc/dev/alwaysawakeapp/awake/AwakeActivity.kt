package com.msc.dev.alwaysawakeapp.awake

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.WindowManager
import com.msc.dev.alwaysawakeapp.R


class AwakeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_awake)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        verifyIntentType(intent)
    }

    fun initFragment(fragment: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        verifyIntentType(intent)
    }

    fun verifyIntentType(intent: Intent?) {
        when {
            intent?.action == Intent.ACTION_SEND -> {
                if (intent.type.startsWith("image")) {
                    initFragment(AwakeFragment.newInstance(intent))
                } else if ("text/plain" == intent.type) {
                    initFragment(AwakeWebviewFragment.newInstance(intent))
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyDown(keyCode, event)
    }
}