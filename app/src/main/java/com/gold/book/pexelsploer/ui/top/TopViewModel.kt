package com.gold.book.pexelsploer.ui.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class TopViewModel : ViewModel() {

    val searchTextLiveData = MutableLiveData("")

    val isLoadingLiveData = MutableLiveData(false)

    fun onClickSearch() {
        Timber.tag("test").d(searchTextLiveData.value)
    }
}
