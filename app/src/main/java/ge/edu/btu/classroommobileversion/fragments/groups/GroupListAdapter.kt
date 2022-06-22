package ge.edu.btu.classroommobileversion.fragments.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.edu.btu.classroommobileversion.R
import ge.edu.btu.classroommobileversion.persistence.data.Group
import ge.edu.btu.classroommobileversion.persistence.data.Subject

class GroupListAdapter : RecyclerView.Adapter<GroupListAdapter.GroupViewHolder>() {
    private var groups = emptyList<Group>()

    class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            itemView.setOnClickListener(this)
        }
        private lateinit var group : Group

        fun onBind(group : Group) {
            val groupNumber : TextView = itemView.findViewById(R.id.groupNumber)
            val roomNumber : TextView = itemView.findViewById(R.id.roomNumber)

            groupNumber.text = group.groupId.toString()
            roomNumber.text = group.roomNumber.toString()

            this.group = group
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.group_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val current = groups[position]
        holder.onBind(current)
    }

    override fun getItemCount(): Int {
        return groups.size
    }
    fun setData(gotGroups: List<Group>) {
        this.groups = gotGroups
        notifyDataSetChanged()
    }
}