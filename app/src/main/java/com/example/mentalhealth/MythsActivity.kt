package com.example.mentalhealth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mentalhealth.databinding.FragmentMythsBinding
import com.example.mentalhealth.databinding.FragmentTitleBinding

class MythsActivity:Fragment() {
    private lateinit var binding: FragmentMythsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentMythsBinding>(inflater,
            R.layout.fragment_myths,container,false)
        binding.mythsButton.setOnClickListener{
            setMyths()
        }
        return binding.root
    }
    private fun setMyths(){
        val randomInt=(1..9).random()
        when(randomInt){
            1->{
                binding.mheader.setText(R.string.m2header)
                binding.mcontent.setText(R.string.m2content)
            }
            2->{
                binding.mheader.setText(R.string.m2header)
                binding.mcontent.setText(R.string.m2content)
            }
            3->{
                binding.mheader.setText(R.string.m3header)
                binding.mcontent.setText(R.string.m3content)
            }
            4->{
                binding.mheader.setText(R.string.m4header)
                binding.mcontent.setText(R.string.m4content)
            }
            5->{
                binding.mheader.setText(R.string.m5header)
                binding.mcontent.setText(R.string.m5content)
            }
            6->{
                binding.mheader.setText(R.string.m6header)
                binding.mcontent.setText(R.string.m6content)
            }
            7->{
                binding.mheader.setText(R.string.m7header)
                binding.mcontent.setText(R.string.m7content)
            }
            8->{
                binding.mheader.setText(R.string.m8header)
                binding.mcontent.setText(R.string.m8content)
            }
            9->{
                binding.mheader.setText(R.string.m9header)
                binding.mcontent.setText(R.string.m9content)
            }
            else->binding.mheader.setText("No more myths available!")
        }
    }
}