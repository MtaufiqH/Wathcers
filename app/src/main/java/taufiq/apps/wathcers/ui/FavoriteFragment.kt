package taufiq.apps.wathcers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.databinding.FragmentFavoriteBinding
import taufiq.apps.wathcers.utils.BaseFragment
import taufiq.apps.wathcers.utils.ViewPagerAdapter

/**
 * Created By Taufiq on 5/5/2021.
 *
 */
class FavoriteFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoriteBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        val sectionsPagerAdapter = ViewPagerAdapter(this)
        binding.pagerFavorite.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabLayout,binding.pagerFavorite) { tab , position->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        binding.tabLayout.isTabIndicatorFullWidth = true
    }

    override fun observableInit() {
        // later
    }

    companion object {
        private val TAB_TITLES = arrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }
}