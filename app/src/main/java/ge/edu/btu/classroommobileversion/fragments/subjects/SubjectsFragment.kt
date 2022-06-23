package ge.edu.btu.classroommobileversion.fragments.subjects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ge.edu.btu.classroommobileversion.R
import ge.edu.btu.classroommobileversion.databinding.FragmentLoginBinding
import ge.edu.btu.classroommobileversion.databinding.FragmentSubjectsBinding
import ge.edu.btu.classroommobileversion.viewModels.SubjectViewModel


class SubjectsFragment : Fragment() {
    private lateinit var subjectViewModel : SubjectViewModel
    private var _binding: FragmentSubjectsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentSubjectsBinding.inflate(inflater, container, false)
        val adapter = ListAdapter()
        val recyclerView = binding.recycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        subjectViewModel = ViewModelProvider(this).get(SubjectViewModel :: class.java)

        subjectViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            subjects -> adapter.setData(subjects)
        })

        return binding.root
    }


}