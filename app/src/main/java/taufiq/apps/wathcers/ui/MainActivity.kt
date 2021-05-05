package taufiq.apps.wathcers.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val sectionsPagerAdapter = ViewPagerAdapter(this)
//        binding.viewPager.adapter = sectionsPagerAdapter
//        TabLayoutMediator(binding.tabsId, binding.viewPager) { tab, position ->
//            tab.text = resources.getString(TAB_TITLES[position])
//        }.attach()
//
//        binding.tabsId.isTabIndicatorFullWidth = true

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_movies -> {
                    loadFragment(MoviesFragment())
                    true
                }

                R.id.menu_tv -> {
                    loadFragment(TvFragment())
                    true
                }

                R.id.menu_favorite -> {
                    loadFragment(FavoriteFragment())
                    true
                }


                else -> false
            }
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId) {
//            R.id.menu_favorite ->{
//                Toast.makeText(this, "Show favorite", Toast.LENGTH_SHORT).show()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }

    private fun loadFragment(fragment: Fragment): Boolean {
        return run {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, fragment)
            }
            true
        }

    }


//    companion object {
//        private val TAB_TITLES = arrayOf(
//            R.string.tab_text_1,
//            R.string.tab_text_2
//        )
//
//    }
}