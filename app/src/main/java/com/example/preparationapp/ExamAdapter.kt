package com.example.preparationapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

//Nomthandazo Ndlovu st10432979

//// Data class to represent the student information
data class Student(val date: String,val morning: String, val afternoon: String, val notes:String)

//// Data class to represent the student information
class ExamAdapter (private val students:List<Student>) : RecyclerView.Adapter<ExamAdapter.ViewHolder>()
{
    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    // Declare the TextViews for each piece of data we want to display
    {
        val date : TextView=view.findViewById(R.id.tvDate)
        val morning: TextView=view.findViewById(R.id.tvMorning)
        val afternoon: TextView=view.findViewById(R.id.tvAfternoon)
        val notes:TextView=view.findViewById(R.id.tvNotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { // This method is called when a new ViewHolder is created
        val view= LayoutInflater.from(parent.context).inflate(R.layout.exam_data, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =students.size // Return the size of the student spending

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // This method binds data to each ViewHolder at a specific position in the list
       val student=students[position]

        //Set the data for each TextView in the ViewHolder
        holder.date.text=student.date
        holder.morning.text=student.morning
        holder.afternoon.text=student.afternoon
        holder.notes.text=student.notes
    }
}