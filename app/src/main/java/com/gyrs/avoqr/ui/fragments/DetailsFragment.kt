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
        about_detail_text_view.text = getString(R.string.dummy_text)

          imageList.transitionName = "image ${args.dataAvocadoPassed.title}"
          title.transitionName = args.dataAvocadoPassed.title
    }
}