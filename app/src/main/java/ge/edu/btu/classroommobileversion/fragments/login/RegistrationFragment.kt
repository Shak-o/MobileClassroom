package ge.edu.btu.classroommobileversion.fragments.login

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ge.edu.btu.classroommobileversion.R
import ge.edu.btu.classroommobileversion.databinding.FragmentLoginBinding
import ge.edu.btu.classroommobileversion.databinding.FragmentRegistrationBinding
import ge.edu.btu.classroommobileversion.enums.UserType
import ge.edu.btu.classroommobileversion.persistence.data.User
import ge.edu.btu.classroommobileversion.viewModels.UserViewModel


class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentRegistrationBinding.inflate(inflater, container, false)
        userViewModel = ViewModelProvider(this).get(UserViewModel :: class.java)

        binding.submit.setOnClickListener() {
            insertData()
        }

        return binding.root
    }

    private fun insertData() {
        val firstName = binding.regInputName.text.toString()
        val lastName = binding.regInputLastName.text.toString()
        val userName = binding.regInputUserName.text.toString()
        val password = binding.regInputPassword.text.toString()
        val personalId = binding.regInputPersonalId.text.toString()

        if (inputCheck(firstName, lastName, userName, password, personalId)) {
            val user = User(0, firstName, lastName, userName, 22,personalId, UserType.Student.name, "date", password)
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "User added successfully!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
        else{
            Toast.makeText(requireContext(), "All parameters are required", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(firstName: String, lastName : String, userName : String, password: String, personalId : String) : Boolean {

            return !(TextUtils.isEmpty(firstName) &&
                    TextUtils.isEmpty(lastName) &&
                    TextUtils.isEmpty(userName) &&
                    TextUtils.isEmpty(password) &&
                    TextUtils.isEmpty(personalId)
                    )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}