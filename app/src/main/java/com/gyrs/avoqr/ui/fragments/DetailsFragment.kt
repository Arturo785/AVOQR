package com.gyrs.avoqr.ui.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.gyrs.avoqr.R
import kotlinx.android.synthetic.main.details_fragment.*
import java.util.concurrent.TimeUnit

class DetailsFragment : Fragment() {

    //Photo by <a href="/photographer/cwsillero-48168">Carlos Sillero</a> from <a href="https://freeimages.com/">FreeImages</a>
    //Photo by <a href="/photographer/FrenchByte-32662">pat herman</a> from <a href="https://freeimages.com/">FreeImages</a>
    //Photo by <a href="/photographer/FrenchByte-32662">pat herman</a> from <a href="https://freeimages.com/">FreeImages</a>
    //Foto de ready made en Pexels

    val args :DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.details_fragment, container, false)

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        postponeEnterTransition(250, TimeUnit.MILLISECONDS)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = imageViewDetail
        val title = title_detail_text_view

        Glide.with(this).load(args.dataAvocadoPassed.imageResource).into(imageList)
        title.text = args.dataAvocadoPassed.title


        imageList.transitionName = "image ${args.dataAvocadoPassed.title}"
        title.transitionName = args.dataAvocadoPassed.title

        fillData()

    }

    private fun fillData(){
        val dataPassed = args.dataAvocadoPassed.content.split(",")
        //"Los arrollo,Arrollo,fsdsjd425f,CD Guzman,31423554,Lote 1,Jazz,30kg,cajas:1"

        about_detail_text_view1.text = "Company:    ${dataPassed[0]}"
        about_detail_text_view2.text = "Name of productor:    ${dataPassed[1]}"
        about_detail_text_view3.text = "RFC:    ${dataPassed[2]}"
        about_detail_text_view4.text = "Address:    ${dataPassed[3]}"
        about_detail_text_view5.text = "Contact info:    ${dataPassed[4]}"
        about_detail_text_view6.text = "Batch:    ${dataPassed[5]}"
        about_detail_text_view7.text = "Variety:    ${dataPassed[6]}"
        about_detail_text_view8.text = "Weight:    ${dataPassed[7]}"
        about_detail_text_view9.text = "Quantity:    ${dataPassed[8]}"
    }
}