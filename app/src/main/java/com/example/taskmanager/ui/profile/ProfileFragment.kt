package com.example.taskmanager.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.taskmanager.data.Pref
import com.example.taskmanager.databinding.FragmentProfileBinding
import com.example.taskmanager.utils.loadImage

class ProfileFragment : Fragment() {
    private lateinit var pref: Pref

    private lateinit var binding: FragmentProfileBinding
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK
            && result.data != null
        ) {
            val photoUri: Uri? = result.data?.data
            pref.saveImage(photoUri.toString())
            binding.imgProfile.loadImage(photoUri.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        binding.imgProfile.loadImage(pref.getImage())
        binding.etText.setText(pref.getName())
        binding.etTextAge.setText(pref.getAge())
        binding.etTextGender.setText(pref.getGen())
        binding.etText.addTextChangedListener {
            pref.saveName(binding.etText.text.toString())
        }
        binding.etTextAge.addTextChangedListener {
            pref.saveAge(binding.etTextAge.text.toString())
        }
        binding.etTextGender.addTextChangedListener {
            pref.saveGen(binding.etTextGender.text.toString())
        }

        binding.imgProfile.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)

        }
    }

}