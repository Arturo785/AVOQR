package com.gyrs.avoqr.ui.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.gyrs.avoqr.R
import com.gyrs.avoqr.data.AvocadoData
import com.gyrs.avoqr.utils.AvocadoListAdapter
import com.gyrs.avoqr.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.home_fragment.*
import kotlin.random.Random

class HomeFragment : Fragment(), AvocadoListAdapter.Interaction {

    private lateinit var listAdapter : AvocadoListAdapter
    private lateinit var recycler : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = recycler_main

        val list = mockData()
        initAdapter(list)

        postponeEnterTransition()

        recycler.doOnPreDraw {
            startPostponedEnterTransition()
        }

    }

    private fun initAdapter(listPassed : MutableList<AvocadoData>){
        listAdapter = AvocadoListAdapter(this)
        listAdapter.differ.submitList(listPassed)

        recycler_main.apply {
            layoutManager =LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = listAdapter
           // addItemDecoration(TopSpacingItemDecoration(0))
        }

    }

    private fun mockData() : MutableList<AvocadoData> {

        val avocadoData = mutableListOf<AvocadoData>()

        for (i in 0..30){
            val message = "This is a dummy message number ${i}"
            val myRandom = Random.nextInt(1,4)
            val resourceName = "avocado_${myRandom}"
            val image = resources.getIdentifier(resourceName, "drawable",activity?.packageName)

            val avocado = AvocadoData(image,"Title$i",  message)
            avocadoData.add(avocado)
        }

        return avocadoData
    }

    override fun onItemSelected(
        position: Int,
        item: AvocadoData,
        image: AppCompatImageView,
        title: TextView
    ) {
       // Snackbar.make(requireView(), "CLICKED ${position}", Snackbar.LENGTH_LONG).show()
        val direction : NavDirections = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item)

        val extras = FragmentNavigatorExtras(
            image to "image ${item.title}",
            title to item.title
        )

        findNavController().navigate(direction, extras)

    }

}