package github.com.kawaratei.derde.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import github.com.kawaratei.derde.databinding.CellBookItemBinding
import github.com.kawaratei.derde.model.Book

private object DiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }

}

class BookListAdapter(
    private val viewLifecycleOwner: LifecycleOwner,
    private val viewModel: MainViewModel
) : ListAdapter<Book, BookListAdapter.BookViewHolder>(DiffCallback) {

//    init {
//        viewModel.initStubData()
//    }

    class BookViewHolder(private val binding: CellBookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Book, viewLifecycleOwner: LifecycleOwner, viewModel: MainViewModel) {
            binding.run {
                lifecycleOwner = viewLifecycleOwner
                book = item
                this.viewModel = viewModel

                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BookViewHolder(CellBookItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position), viewLifecycleOwner, viewModel)
    }

}