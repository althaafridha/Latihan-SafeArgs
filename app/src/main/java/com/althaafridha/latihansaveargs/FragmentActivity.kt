package com.althaafridha.latihansaveargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class FragmentActivity : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment

		val safeArgs: FragmentActivityArgs by navArgs()
		val flowStepNumber = safeArgs.flowStepNumber

		return when (flowStepNumber) {
			1 -> inflater.inflate(R.layout.fragment_first, container, false)
			else -> inflater.inflate(R.layout.fragment_second, container, false)
		}
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		view.findViewById<View>(R.id.btn_next).setOnClickListener {
			findNavController().navigate(R.id.next_action)
		}
	}
}