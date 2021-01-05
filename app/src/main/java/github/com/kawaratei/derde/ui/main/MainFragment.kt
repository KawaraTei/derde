package github.com.kawaratei.derde.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import github.com.kawaratei.derde.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var viewBinding: MainFragmentBinding
    private lateinit var mAdapter: BookListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewBinding = MainFragmentBinding.inflate(inflater, container, false)

        viewBinding.list.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            mAdapter = BookListAdapter(viewLifecycleOwner, this@MainFragment.viewModel)
            this.adapter = mAdapter
        }

        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.run {
            booksList.observe(viewLifecycleOwner, {
                mAdapter.submitList(it)
            })
        }

        // todo stub!
        Handler(Looper.getMainLooper()).postDelayed (
            {viewModel.initStubData()},
            3000
        )
    }

}