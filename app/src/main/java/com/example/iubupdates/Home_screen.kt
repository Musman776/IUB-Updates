package com.example.iubupdates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class Home_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.opt_menu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    //click on item








    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.rate->{



            }
            R.id.more->{



            }
            R.id.notify->{



            }
            R.id.share->{



            }
        }
        return super.onOptionsItemSelected(item)
    }
}