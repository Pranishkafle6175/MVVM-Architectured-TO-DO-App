package com.example.notes.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notes.Entity.NotesEntity
import com.example.notes.R
import com.example.notes.ViewModel.NotesViewModel
import com.example.notes.databinding.FragmentCreateNoteBinding
import com.example.notes.databinding.FragmentEditNoteBinding
import java.util.*

class EditNoteFragment : Fragment() {

    lateinit var binding: FragmentEditNoteBinding

    val viewmodel:NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEditNoteBinding.inflate(inflater,container,false)

        val args =this.arguments
        val title = args?.get("title").toString()
        val subtitle= args?.get("subtitle").toString()
        val description= args?.get("description").toString()
        val date= args?.get("date").toString()
        var priority = args?.get("priority").toString()
        var id:Int = args?.get("id") as Int
        Log.i("title",priority.toString())

        binding.titleedittext.setText(title)
        binding.descriptionedittext.setText(description)
        binding.subtitleedittext.setText(subtitle)
        when(priority){
            "1"->{
                binding.reddot.setBackgroundResource(R.drawable.ic_tick)
            }
            "2"->{
                binding.greendot.setBackgroundResource(R.drawable.ic_tick)
            }
            "3"->{
                binding.bluedot.setImageResource(R.drawable.ic_tick)
            }
        }

        binding.reddot.setOnClickListener {
            binding.reddot.setImageResource(R.drawable.ic_tick)
            binding.greendot.setImageResource(0)
            binding.bluedot.setImageResource(0)
            priority="1"
        }

        binding.greendot.setOnClickListener {
            binding.greendot.setImageResource(R.drawable.ic_tick)
            binding.reddot.setImageResource(0)
            binding.bluedot.setImageResource(0)
            priority="2"
        }

        binding.bluedot.setOnClickListener {
            binding.bluedot.setImageResource(R.drawable.ic_tick)
            binding.greendot.setImageResource(0)
            binding.reddot.setImageResource(0)
            priority="3"
        }

        binding.floatingbbutton.setOnClickListener {

            var titletext = binding.titleedittext.text.toString()
            var subtitletext = binding.subtitleedittext.text.toString()
            var descriptiontext = binding.descriptionedittext.text.toString()
            val d = Date()
            val datetext: CharSequence = DateFormat.format("MMMM d, yyyy ", d.getTime())

            val notes =NotesEntity(id= id, title = titletext, subtitle = subtitletext, notes = descriptiontext, date = datetext.toString(), priority = priority)
            viewmodel.updateNotes(notes = notes)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

}