package ge.edu.btu.classroommobileversion.fragments.subjects

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.edu.btu.classroommobileversion.R
import ge.edu.btu.classroommobileversion.persistence.data.Subject

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var subjects = emptyList<Subject>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = subjects[position]
        val name : TextView = holder.itemView.findViewById(R.id.name)
        val description : TextView = holder.itemView.findViewById(R.id.description)
        val max : TextView = holder.itemView.findViewById(R.id.max)
        val homeworks : TextView = holder.itemView.findViewById(R.id.homeworks)

        name.text = current.name
        description.text = current.description
        max.text = current.barrier.toString()
        homeworks.text = current.homeworkAmount.toString()
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    fun setData(gotSubjects: List<Subject>) {
        this.subjects = gotSubjects
        notifyDataSetChanged()
    }
}