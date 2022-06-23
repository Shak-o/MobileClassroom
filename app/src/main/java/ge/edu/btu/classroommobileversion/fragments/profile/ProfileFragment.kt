package ge.edu.btu.classroommobileversion.fragments.profile

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ge.edu.btu.classroommobileversion.databinding.FragmentLoginBinding
import ge.edu.btu.classroommobileversion.databinding.FragmentProfileBinding
import ge.edu.btu.classroommobileversion.databinding.FragmentSubjectsBinding
import ge.edu.btu.classroommobileversion.fragments.subjects.ListAdapter
import ge.edu.btu.classroommobileversion.persistence.data.User
import ge.edu.btu.classroommobileversion.viewModels.SubjectViewModel
import ge.edu.btu.classroommobileversion.viewModels.UserViewModel
import java.util.*

class ProfileFragment : Fragment() {
    private lateinit var subjectViewModel : SubjectViewModel
    private lateinit var userViewModel: UserViewModel

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentProfileBinding.inflate(inflater, container, false)



//        val adapter = ListAdapter()
//        val recyclerView = binding.recycler
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        subjectViewModel = ViewModelProvider(this).get(SubjectViewModel :: class.java)
//
//        subjectViewModel.readAllData.observe(viewLifecycleOwner, Observer {
//                subjects -> adapter.setData(subjects)
//        })


        getData()


        return binding.root
    }

    private fun getData() {

        // TODO: GET DATA FROM USER
        // TODO: ASSIGN USER DATA TO PROFILE FRAGMENT TEXTVIEWS


        // val user: User

        val profileTex = binding.profileText

        profileTex.setTextColor(Color.parseColor("#FF0000"))
//        profileTex.text = user.name.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}