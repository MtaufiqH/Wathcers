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
        loadFragment(MoviesFragment())
        bindNavigation()
    }

     private fun bindNavigation() {
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

                 } else -> loadFragment(MoviesFragment())
             }
         }
     }

     private fun loadFragment(fragment: Fragment): Boolean {
        return run {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, fragment)
            }
            true
        }

    }

}