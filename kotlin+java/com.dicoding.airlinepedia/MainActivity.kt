package com.dicoding.airlinepedia

//import android.view.View
//import android.view.Menu
//import androidx.activity.enableEdgeToEdge
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
//import android.R.attr.action
import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.recyclerviewapp.aircraft


//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var rvAirline: RecyclerView
    private val list = ArrayList<aircraft>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // change background or text color on toolbar
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)



        rvAirline = findViewById(R.id.rv_Airline)
        rvAirline.setHasFixedSize(true)

        list.addAll(getListAirline())
        showRecyclerList()



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_about -> {
                //mengklik AccountActivity
                val intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }



    @SuppressLint("Recycle")
    private fun getListAirline(): ArrayList<aircraft> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listAirlines = ArrayList<aircraft>()


        val size = minOf(dataName.size, dataDescription.size, dataPhoto.length())
        for (i in 0 until size) {
            val airlines = aircraft(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listAirlines.add(airlines)
        }
//        for(i in dataName.indices){
//            val aircraft = aircraft(dataName[i],dataDescription[i],dataPhoto.getResourceId(i, -1))
//            listAircraft.add(aircraft)
//        }

        return listAirlines
    }


    private fun showRecyclerList() {
        rvAirline.layoutManager = LinearLayoutManager(this)
        val listAircraftAdapter = ListAircraftAdapter(list)
        rvAirline.adapter = listAircraftAdapter


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_about,menu)
//        return super.onCreateOptionsMenu(menu)


//    }

//        supportActionBar?.hide()



//        supportActionBar?.title = "My Toolbar Title"
    }

    //share to...


        }

