package taufiq.apps.wathcers.utils

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import taufiq.apps.wathcers.ui.favorite.FavMovies
import taufiq.apps.wathcers.ui.favorite.FavTvShows


class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FavMovies()
            1 -> FavTvShows()
            else -> Fragment()
        }
    }


}