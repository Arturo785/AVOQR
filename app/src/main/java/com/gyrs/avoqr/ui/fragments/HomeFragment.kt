package com.gyrs.avoqr.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.gyrs.avoqr.R
import com.gyrs.avoqr.data.AvocadoData
import com.gyrs.avoqr.utils.AvocadoListAdapter
import com.gyrs.avoqr.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(R.layout.home_fragment), AvocadoListAdapter.Interaction {

    private lateinit var listAdapter : AvocadoListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mockData()
        initAdapter(list)

    }

    private fun initAdapter(listPassed : MutableList<AvocadoData>){
        listAdapter = AvocadoListAdapter(this)
        listAdapter.differ.submitList(listPassed)

        recycler_main.apply {
            layoutManager =LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = listAdapter
            addItemDecoration(TopSpacingItemDecoration(8))
        }

    }

    private fun mockData() : MutableList<AvocadoData> {

        val avocadoData = mutableListOf<AvocadoData>()

        for (i in 0..30){
            val message = "This is a dummy message number ${i}"
            val avocado = AvocadoData(null,"Title ${i}",  message)
            avocadoData.add(avocado)
        }

        return avocadoData
    }

    override fun onItemSelected(
        position: Int,
        item: AvocadoData,
        image: ImageView,
        title: TextView
    ) {
        Snackbar.make(requireView(), "CLICKED ${position}", Snackbar.LENGTH_LONG).show()
    }

}