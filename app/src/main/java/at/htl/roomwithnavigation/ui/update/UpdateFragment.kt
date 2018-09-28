package at.htl.roomwithnavigation.ui.update

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import at.htl.roomwithnavigation.R
import at.htl.roomwithnavigation.entities.Word
import kotlinx.android.synthetic.main.update_fragment.*


class UpdateFragment : Fragment() {

    companion object {
        fun newInstance() = UpdateFragment()
    }

    private lateinit var viewModel: UpdateViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.update_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UpdateViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getLong("Id")!!
        editText.setText(arguments?.getString("Word").toString())

        button_update.setOnClickListener {
            viewModel.update(Word(id, editText.text.toString()))
            Navigation.findNavController(it).popBackStack()
        }

        button_delete.setOnClickListener {
            viewModel.delete(Word(id, editText.text.toString()))
            Navigation.findNavController(it).popBackStack()
        }

//        view.findViewById<Button>(R.id.button_update)?.setOnClickListener {
//            viewModel.update(Word(id, editText.text.toString()))
//            Navigation.findNavController(it).popBackStack()
//        }
//
//        view.findViewById<Button>(R.id.button_delete)?.setOnClickListener {
//            viewModel.delete(Word(id, editText.text.toString()))
//            Navigation.findNavController(it).popBackStack()
//        }

    }

}
