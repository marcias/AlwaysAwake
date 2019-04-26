package com.msc.dev.alwaysawakeapp.history

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.msc.dev.alwaysawakeapp.R
import android.view.Menu
import android.content.Intent
import android.view.MenuItem
import com.msc.dev.alwaysawakeapp.howtouse.HowToUseActivity

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(com.msc.dev.alwaysawakeapp.R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this, HowToUseActivity::class.java))
        return true
    }

    //show message of no history
    //show button start using always awake

}