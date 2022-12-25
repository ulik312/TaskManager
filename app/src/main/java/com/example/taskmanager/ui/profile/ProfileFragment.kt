package com.example.taskmanager.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.example.taskmanager.data.Pref
import com.example.taskmanager.databinding.FragmentProfileBinding
import com.example.taskmanager.utils.loadImage

class ProfileFragment : Fragment() {

    private lateinit var pref: Pref
    private lateinit var binding:FragmentProfileBinding

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK
            && result.data != null
        ) {
            val photoUri: Uri? = result.data?.data
            //use photoUri here
            pref.saveImage(photoUri.toString())
            binding.profileImage.loadImage(photoUri.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())

        binding.profileImage.loadImage(pref.getImage())

        binding.etName.setText(pref.getName())

        binding.etAge.setText(pref.getAge())

        binding.etFloor.setText(pref.getFloor())

        binding.etName.addTextChangedListener {
            pref.saveName(binding.etName.text.toString())
        }

        binding.etAge.addTextChangedListener {
            pref.saveAge(binding.etAge.text.toString())
        }

        binding.etFloor.addTextChangedListener {
            pref.saveFloor(binding.etFloor.text.toString())
        }

        binding.profileImage.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)

        }

    }

}