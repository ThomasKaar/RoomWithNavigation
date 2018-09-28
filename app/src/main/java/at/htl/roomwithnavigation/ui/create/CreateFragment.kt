package at.htl.roomwithnavigation.ui.create

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
import kotlinx.android.synthetic.main.create_fragment.*


class CreateFragment : Fragment() {

    companion object {
        fun newInstance() = CreateFragment()
    }

    private lateinit var viewModel: CreateViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.create_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button.setOnClickListener{
            viewModel.insert(Word(0, editText.text.toString()))
            Navigation.findNavController(it).popBackStack()
        }
//        view.findViewById<Button>(R.id.button)?.setOnClickListener {
//            viewModel.insert(Word(0, editText.text.toString()))
//            Navigation.findNavController(it).popBackStack()
//        }
    }

}
