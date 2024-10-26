package com.dicoding.airlinepedia

//import android.app.Person
//import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.os.Build

import android.widget.TextView
import android.widget.ImageView
//import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.recyclerviewapp.aircraft
import com.dicoding.airlinepedia.databinding.ActivityDetailAirlineBinding
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat

class DetailAirlineActivity : AppCompatActivity() {

    companion object {
        const val key_airline = "key_airline"
    }

    private lateinit var binding: ActivityDetailAirlineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_detail_airline)

        binding = ActivityDetailAirlineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Panggil fungsi untuk mengatur toolbar
        setToolBar()

        val dataAirline = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<aircraft>(key_airline, aircraft::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<aircraft>(key_airline)

        }


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
//        val ivDetailLogo: ImageView = findViewById(R.id.iv_detail_logo)

        tvDetailName.text = dataAirline?.name
        tvDetailDescription.text = dataAirline?.description
        ivDetailPhoto.setImageResource(dataAirline?.photo ?: 0)
//        ivDetailLogo.setImageResource(dataAirline?.photo?:0)

    }

    //
    @Suppress("DEPRECATION")
    fun setToolBar() {
        // Call object actionBar
        setSupportActionBar(binding.tbMain)
        supportActionBar!!.title = getString(R.string.app_name)
        // Change font style text
        binding.tbMain.setTitleTextAppearance(this, R.style.Theme_AirlinePedia)
        // Set icon
        supportActionBar!!.setIcon(R.drawable.baseline_share_24)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding.tbMain.setNavigationOnClickListener {
            onBackPressed()
        }
        //
        ////        supportActionBar?.title = "Detail"
        //   }


    }
}
