package com.example.studentportal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.ArrayList

const val PORTAL_ITEM = "PORTAL_ITEM"
const val PORTAL_LIST = "PORTAL_LIST"

class MainActivity : AppCompatActivity() {
    private lateinit var viewAdapter: SiteAdapter
    var sites: ArrayList<Site> = ArrayList()
    private val siteAdapter = SiteAdapter(sites)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            val createPortalIntent = Intent(this,
                CreateSiteActivity::class.java)
            createPortalIntent.putExtra(PORTAL_LIST, sites)
            startActivity(createPortalIntent)
        }

        initViews()



    }

    private fun initViews(){
        val sites = intent.getParcelableArrayListExtra<Site>(PORTAL_LIST)
        val site = intent.getParcelableExtra<Site>(PORTAL_ITEM)

        if (sites != null) {
            this.sites = sites
            if (site != null) {
                this.sites.add(site)
            }
        }

        viewAdapter = SiteAdapter(this.sites)
        rvSites.adapter = viewAdapter
        rvSites.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL) as RecyclerView.LayoutManager?
        siteAdapter.notifyDataSetChanged()

        
    }
}
