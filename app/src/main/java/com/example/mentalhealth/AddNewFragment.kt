package com.example.mentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.mentalhealth.database.Post
import com.example.mentalhealth.database.PostDatabase
import com.example.mentalhealth.databinding.FragmentAddNewBinding

private lateinit var binding: FragmentAddNewBinding
private lateinit var viewModel: DiscussionViewModel
private lateinit var viewModelFactory: DiscussionViewModelFactory
class AddNewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_new, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = PostDatabase.getInstance(application).postDatabaseDao
        viewModelFactory = DiscussionViewModelFactory( dataSource, application)
        viewModel =  ViewModelProviders.of(this, viewModelFactory).get(DiscussionViewModel::class.java)


        binding.doneButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){
            view: View->

            var title: String = binding.postTitle.text.toString()
            var content: String = binding.postContent.text.toString()
            if(title!=null && content!=null ){

               val newPost = Post( title, content)
                viewModel.addItem(newPost)
                viewModel.dataCanChanged()
                view?.findNavController()!!.navigate(R.id.action_addNewFragment_to_discussionFragment)

            }

        }

        return binding.root
    }


}