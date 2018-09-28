package at.htl.roomwithnavigation.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import at.htl.roomwithnavigation.R
import at.htl.roomwithnavigation.R.id.createFragment
import at.htl.roomwithnavigation.entities.Word
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        var adapter = WordListAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this.context)

        viewModel.getAllWords().observe(this, Observer<List<Word>> {
            adapter.list = it!!
            adapter.notifyDataSetChanged()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionCreateButton.setOnClickListener {
            Navigation.findNavController(it).navigate(createFragment)
        }

//        view.findViewById<FloatingActionButton>(R.id.floatingActionCreateButton).setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.createFragment)
//        }
    }

}
