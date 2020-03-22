package com.example.studentportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_site.*

class CreateSiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_site)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a Portal"
        addBtn.setOnClickListener{addPortal()}
    }

    private fun addPortal() {
        val site = Site(nameIET.text.toString(), urlIET.text.toString())
        val sites = intent.getParcelableArrayListExtra<Site>(PORTAL_LIST)

        val addSiteActivityIntent = Intent(this,MainActivity::class.java)
        addSiteActivityIntent.putExtra(PORTAL_ITEM, site)
        addSiteActivityIntent.putExtra(PORTAL_LIST, sites)
        startActivity(addSiteActivityIntent)
    }
}
