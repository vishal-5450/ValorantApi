package com.daggerhilt.valorantapi.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daggerhilt.valorantapi.R
import com.daggerhilt.valorantapi.domain.model.Agent

class AgentAdapter : RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {

    private val agents = mutableListOf<Agent>()

    fun setAgents(newAgents: List<Agent>) {
        agents.clear()
        agents.addAll(newAgents)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_agent, parent, false)
        return AgentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        holder.bind(agents[position])
    }

    override fun getItemCount(): Int = agents.size

    class AgentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.agentName)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.agentDescription)
        private val roleTextView: TextView = itemView.findViewById(R.id.agentRole)
        private val abilitiesTextView: TextView = itemView.findViewById(R.id.agentAbilities)
        private val iconImageView: ImageView = itemView.findViewById(R.id.agentIcon)

        fun bind(agent: Agent) {
            nameTextView.text = agent.displayName
            descriptionTextView.text = agent.description
            roleTextView.text = agent.role.displayName
            abilitiesTextView.text = agent.abilities.joinToString("\n") { it.displayName }
            Glide.with(itemView.context).load(agent.displayIcon).into(iconImageView)
        }
    }
}
