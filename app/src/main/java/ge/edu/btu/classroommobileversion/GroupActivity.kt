package ge.edu.btu.classroommobileversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ge.edu.btu.classroommobileversion.databinding.ActivityGroupBinding
import ge.edu.btu.classroommobileversion.databinding.ActivityMainBinding
import ge.edu.btu.classroommobileversion.databinding.FragmentLoginBinding
import ge.edu.btu.classroommobileversion.fragments.groups.GroupListAdapter
import ge.edu.btu.classroommobileversion.fragments.subjects.ListAdapter
import ge.edu.btu.classroommobileversion.viewModels.GroupViewModel
import ge.edu.btu.classroommobileversion.viewModels.SubjectViewModel

class GroupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupBinding
    private lateinit var groupViewModel: GroupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.groupRecycler
        val adapter = GroupListAdapter()

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(baseContext)

        groupViewModel = ViewModelProvider(this).get(GroupViewModel :: class.java)
        val subjectId = intent.extras?.getInt(ListAdapter.SUBJECT_ID, -1)

        if (subjectId != -1 && subjectId != null) {
            val result = groupViewModel.getGroupsBySubject(subjectId)
            result.observe(this, Observer {
                groups ->
                run {
                    for (data in groups) {
                        if (data.subject.subjectId == subjectId)
                            adapter.setData(data.groups)
                    }
                }
            } )
        }

    }
}