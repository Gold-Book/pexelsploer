package com.gold.book.pexelsploer.ui.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopViewModel : ViewModel() {

    val searchTextLiveData = MutableLiveData("")

    val isLoadingLiveData = MutableLiveData(false)

    fun onClickSearch() {

    }
}
