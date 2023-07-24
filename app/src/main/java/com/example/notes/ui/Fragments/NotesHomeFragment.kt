package com.example.notes.ui.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notes.R
import com.example.notes.ViewModel.NotesViewModel
import com.example.notes.databinding.FragmentNotesHomeBinding
import com.example.notes.ui.Adapter.NotesAdapter

class NotesHomeFragment : Fragment() {

    lateinit var binding: FragmentNotesHomeBinding

    val viewmodel :NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotesHomeBinding.inflate(inflater, container,false)
        // Inflate the layout for this fragment




        viewmodel.getAllNotes().observe(viewLifecycleOwner,{notelist->
            binding.notesrecycler.layoutManager= GridLayoutManager(requireContext(),2)
            binding.notesrecycler.adapter=NotesAdapter(requireContext(),notelist,viewmodel)

        })



        binding.addbutton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_notesHomeFragment_to_createNoteFragment)
            Log.i("Addbutton pressed","Addbutton pressed")
        }



        return binding.root
    }



}