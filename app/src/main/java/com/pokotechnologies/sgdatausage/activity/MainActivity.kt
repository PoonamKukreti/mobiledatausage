package com.pokotechnologies.sgdatausage.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pokotechnologies.sgdatausage.R
import com.pokotechnologies.sgdatausage.model.YearDataUsage
import com.pokotechnologies.sgdatausage.util.Constants
import com.pokotechnologies.sgdatausage.viewmodel.DataUsageViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity() {
    var mAdapter: MobileUsageAdapter? = null
    var mDataUsageList: List<YearDataUsage>? = null

    val vm: DataUsageViewModel by lazy {
        ViewModelProviders.of(this).get(DataUsageViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.sendResourceId(Constants.RESOURCE_ID)

        vm.allDataUsage.observe(this, Observer {
            if (it != null) {
                mDataUsageList = it.data
            }
        })

        dataUsageRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = mDataUsageList?.let { it1 -> MobileUsageAdapter(it1, this) }

    }
}

