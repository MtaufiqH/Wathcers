package taufiq.apps.wathcers.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.databinding.ActivityMainBinding
import taufiq.apps.wathcers.utils.ViewPagerAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabsId,binding.viewPager) { tab , position->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        binding.tabsId.isTabIndicatorFullWidth = true
    }

    companion object {
        private val TAB_TITLES = arrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }
}