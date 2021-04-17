package taufiq.apps.wathcers.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import taufiq.apps.wathcers.databinding.ActivityMainBinding
import taufiq.apps.wathcers.utils.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

    }
}