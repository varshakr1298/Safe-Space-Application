package com.example.mentalhealth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.mentalhealth.database.Post
import com.example.mentalhealth.database.PostDatabase
import com.example.mentalhealth.database.PostDatabaseDao
import com.example.mentalhealth.databinding.FragmentAwarenessBinding
import com.example.mentalhealth.databinding.FragmentDiscussionBinding


private lateinit var binding: FragmentDiscussionBinding
private lateinit var viewModel: DiscussionViewModel
private lateinit var viewModelFactory: DiscussionViewModelFactory
class DiscussionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_discussion, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = PostDatabase.getInstance(application).postDatabaseDao
        viewModelFactory = DiscussionViewModelFactory( dataSource, application)
        viewModel =  ViewModelProviders.of(this, viewModelFactory).get(DiscussionViewModel::class.java)


        val newPost = Post( "Loren Ipsum Title", "Dummy text for this this post")
        viewModel.addItem(newPost)

        viewModel.dataChanged.observe(viewLifecycleOwner, Observer {dataChanged->
            if(dataChanged)
           { val adapter = PostAdapter()
            val allPosts = dataSource.getAllPosts()
            Log.i("Database", "GOT Items")
            binding.postLists.adapter = adapter
            adapter.data= allPosts
               viewModel.dataCannotChanged()
           }

        })


        binding.addNewPostButton.setOnClickListener{
            view?.findNavController()!!.navigate(R.id.action_discussionFragment_to_addNewFragment)

        }
        return binding.root
    }



}