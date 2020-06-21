package com.example.mentalhealth

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mentalhealth.databinding.FragmentLinksBinding
import kotlinx.android.synthetic.main.fragment_links.*

private lateinit var binding: FragmentLinksBinding
class LinksFragment : Fragment(), ListAdapter.onContactClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_links, container, false)
        binding.mentalHealthButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){
            view: View->
            view.setBackgroundColor(Color.GREEN)
            binding.sexualHealthButton.setBackgroundColor(Color.WHITE)
            val adapter = ListAdapter(contactMentalHealth, this)
            binding.linksList.adapter = adapter

        }

        binding.sexualHealthButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){
                view: View->
            view.setBackgroundColor(Color.GREEN)
            binding.mentalHealthButton.setBackgroundColor(Color.WHITE)
            val adapter = ListAdapter(contactSexualHealth, this)
            binding.linksList.adapter = adapter

        }

        return binding.root
    }

    data class ContactPerson(
        val nameOfAssociation : String,
        val imageOfAssociation: Int,
        val contactOfAssociation: String,
        val websiteofAssociation: String)


    val contactMentalHealth: List<ContactPerson> = listOf(
        ContactPerson(nameOfAssociation = "Live Laugh Foundation",
        imageOfAssociation = R.drawable.drinks,
        contactOfAssociation = "9876543215",
        websiteofAssociation = "https://thelivelovelaughfoundation.org/"),
        ContactPerson(nameOfAssociation = "The Mind Research Foundation",
            imageOfAssociation = R.drawable.drinks,
            contactOfAssociation = "The Mind Research Foundation provides therapy and support groups for a wide range of emotional and behavioural issues. These can range from therapy for depression, grief counselling, parenting support, etc., to couples counselling and much more.",
            websiteofAssociation = "http://www.themindresearchfoundation.org/"),
        ContactPerson(nameOfAssociation = "AASRA",
            imageOfAssociation = R.drawable.drinks,
            contactOfAssociation = "AASRA focuses on suicide prevention and provides a 24/7 suicide prevention helpline. But for those who are just looking for support, they do organise support groups for people suffering from bipolar, schizophrenic disorders, and families affected by suicide",
            websiteofAssociation = "http://www.aasra.info/"),
        ContactPerson(nameOfAssociation = "Hope Trust India",
            imageOfAssociation = R.drawable.drinks,
            contactOfAssociation = "Hope Trust India focuses mainly on recovery from addiction. But they do provide cognitive behavioural therapy for anxiety and depression for outpatients.",
            websiteofAssociation = "https://hopetrustindia.com/"),
        ContactPerson(nameOfAssociation = "Seraniti",
            imageOfAssociation = R.drawable.drinks,
            contactOfAssociation = "With the mission of making mental health care more accessible, convenient and confidential, Seraniti provides online therapy and counselling sessions by trained therapists who work under the supervision of clinical psychiatrists. The sessions can take place over Skype",
            websiteofAssociation = "http://www.seraniti.com/")

    )

    val contactSexualHealth: List<ContactPerson> = listOf(
        ContactPerson(nameOfAssociation = "Laugh Foundation",
            imageOfAssociation = R.drawable.drinks,
            contactOfAssociation = "9876543215",
            websiteofAssociation = ""),
        ContactPerson(nameOfAssociation = "Foundation",
            imageOfAssociation = R.drawable.drinks,
            contactOfAssociation = "9876543215",
            websiteofAssociation = ""),
        ContactPerson(nameOfAssociation = "Hope Foundation",
            imageOfAssociation = R.drawable.drinks,
            contactOfAssociation = "9876543215",
            websiteofAssociation = "")

    )

    override fun onItemClick(item: ContactPerson,holder: ListAdapter.ViewHolder) {

        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(item.websiteofAssociation)
        startActivity(openURL)
    }



}