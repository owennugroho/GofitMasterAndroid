package com.example.gofit.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit.R

/**
 * A simple [Fragment] subclass.
 * Use the [IjinFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IjinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ijin, container, false)
    }


}