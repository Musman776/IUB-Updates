package com.example.iubupdates

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_point.*

class PointActivity : AppCompatActivity() {
    var download:Long = 0
    lateinit var manager:DownloadManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point)
        supportActionBar?.hide()




        down.setOnClickListener {

            manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val url:Uri = Uri.parse("https://drive.google.com/file/d/1ZxzXTIxCjp8BNYpZwb3A_J6jfVwiSelR/view?usp=sharing")
            val request = DownloadManager.Request(url)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
           request.setAllowedOverMetered(true)
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)

            request.setTitle("Download ")
            request.setDescription("This file is downloading")

            request.allowScanningByMediaScanner()
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${System.currentTimeMillis()}")
            download =  manager.enqueue(request)
        }
        val br= object :BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                val id =p1!!.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if (id==download){
                    Toast.makeText(applicationContext, "Download Completed", Toast.LENGTH_SHORT).show()


                }


            }



        }
        registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))


    }
}