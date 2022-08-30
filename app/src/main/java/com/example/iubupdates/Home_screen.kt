package com.example.iubupdates

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import hotchemi.android.rate.AppRate
import kotlinx.android.synthetic.main.backdialog.*
import kotlinx.android.synthetic.main.home_screen.*

class Home_screen : AppCompatActivity() {
    var cc = false
    lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)



        AppRate.with(this)
            .setInstallDays(2)
            .setLaunchTimes(2)
            .setRemindInterval(2)
            .monitor()
        AppRate.showRateDialogIfMeetsConditions(this)
        AppRate.with(this).clearAgreeShowDialog()
        AppRate.with(this).shouldShowRateDialog()
        sp = this.getSharedPreferences("filename",Context.MODE_PRIVATE)
        val editer = sp.edit()
        editer.putBoolean("Noghtmode",cc)
        editer.commit()

        point_btn.setOnClickListener {

            startActivity(Intent(this,Point_Schedule::class.java))
        }

        timetable_btn.setOnClickListener {

            startActivity(Intent(this,ComingSoonActivity::class.java))
        }
        updates_btn.setOnClickListener {
            startActivity(Intent(this,UpdatesActivity::class.java))
        }
        point_btn.setOnClickListener {
            startActivity(Intent(this,PointActivity::class.java))
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.opt_menu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    //click on item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.rate->{


                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )



            }
            R.id.more->{

                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=Muhammad%20usman4973")
                )



            }
            R.id.notify->{



            }
            R.id.share->{

                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "https://play.google.com/store/apps/details?id=$packageName"
                    )
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)



            }


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {


        val dialgo= Dialog(this)
        dialgo.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialgo.setCancelable(false)
        dialgo.setContentView(R.layout.backdialog)
        dialgo.btn_no.setOnClickListener {
            dialgo.dismiss()


        }

        dialgo.btn_yes.setOnClickListener {

            dialgo.dismiss()

            finishAffinity()
            System.exit(0)
        }
        dialgo.show()








    }






}