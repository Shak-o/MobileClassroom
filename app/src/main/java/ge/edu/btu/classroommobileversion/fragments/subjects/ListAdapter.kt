package ge.edu.btu.classroommobileversion.fragments.subjects

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.edu.btu.classroommobileversion.GroupActivity
import ge.edu.btu.classroommobileversion.R
import ge.edu.btu.classroommobileversion.persistence.data.Subject

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    companion object {
        const val SUBJECT_ID = "SUBJECT_ID"
    }
    private var subjects = emptyList<Subject>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        private lateinit var subject : Subject

        fun onBind(subject : Subject) {
            val name : TextView = itemView.findViewById(R.id.name)
            val description : TextView = itemView.findViewById(R.id.description)
            val max : TextView = itemView.findViewById(R.id.max)
            val homeworks : TextView = itemView.findViewById(R.id.homeworks)

            name.text = subject.name
            description.text = subject.description
            max.text = subject.barrier.toString()
            homeworks.text = subject.homeworkAmount.toString()
            this.subject = subject
        }
        override fun onClick(v: View?) {
            val context = itemView.context
            val intent = Intent(context, GroupActivity :: class.java)
            intent.putExtra(SUBJECT_ID, subject.subjectId)
            context.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = subjects[position]
        holder.onBind(current)
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    fun setData(gotSubjects: List<Subject>) {
        this.subjects = gotSubjects
        notifyDataSetChanged()
    }
}