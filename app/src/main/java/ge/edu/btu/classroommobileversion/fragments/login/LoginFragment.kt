package ge.edu.btu.classroommobileversion.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ge.edu.btu.classroommobileversion.R
import ge.edu.btu.classroommobileversion.databinding.FragmentLoginBinding
import ge.edu.btu.classroommobileversion.persistence.data.User
import ge.edu.btu.classroommobileversion.viewModels.UserViewModel

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentLoginBinding.inflate(inflater, container, false)
        userViewModel = ViewModelProvider(this).get(UserViewModel :: class.java)

        binding.register.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
        binding.login.setOnClickListener() {
            checkUser()
        }
        return binding.root
    }

    private fun checkUser() {
        val inputUser = binding.editTextTextPersonName.text.toString()
        //პაროლი წესით უნდა იჰეშებოდეს და ა.შ. მაგრამ მაგდენი დრო არ გვაქვს.
        val inputPassword = binding.editTextTextPassword.text.toString()

        var user : User? = null

        userViewModel.getUserByPassAndName(inputUser, inputPassword)?.observe(viewLifecycleOwner, Observer {
                x -> Toast.makeText(requireContext(), x.name, Toast.LENGTH_LONG).show()
            })

        if (user == null)
        {
            Toast.makeText(requireContext(), "Authentication failed", Toast.LENGTH_LONG).show()
        }
        else {
            findNavController().navigate(R.id.action_loginFragment_to_subjectsFragment)
        }
        findNavController().navigate(R.id.action_loginFragment_to_subjectsFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}