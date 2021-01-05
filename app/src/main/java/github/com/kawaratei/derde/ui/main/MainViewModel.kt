package github.com.kawaratei.derde.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import github.com.kawaratei.derde.model.Book
import java.time.Instant

class MainViewModel : ViewModel() {

    private val booksListRaw = mutableListOf<Book>()
    val booksList = MutableLiveData<List<Book>>(emptyList())

    fun initStubData() {
        booksListRaw.add(
            Book(
            title = "hoge1",
                author = "huga1",
                imageUrl = null,
                publishDate = Instant.ofEpochSecond(1609686000)))
        booksListRaw.add(
            Book(
                title = "hoge2",
                author = "huga2",
                imageUrl = null,
                publishDate = Instant.ofEpochSecond(1609686000)))
        booksListRaw.add(
            Book(
                title = "hoge3",
                author = "huga3",
                imageUrl = null,
                publishDate = Instant.ofEpochSecond(1609686000)))

        booksList.value = booksListRaw
    }

    fun onClickItem(item: Book) {
        Log.d("MainViewModel", "onClickItem: $item")
    }

}