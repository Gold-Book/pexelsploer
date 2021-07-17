package com.gold.book.pexelsploer.ui.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gold.book.pexelsploer.data.entities.PhotoEntity
import com.gold.book.pexelsploer.data.repository.PicturesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopViewModel : ViewModel() {

    val photosLiveData = MutableLiveData<List<PhotoEntity>>(listOf())

    val searchTextLiveData = MutableLiveData("")

    val isLoadingLiveData = MutableLiveData(false)

    fun getPhoto(position: Int) = photosLiveData.value?.get(position)

    fun onClickSearch() {
        if (isLoadingLiveData.value == true) return

        viewModelScope.launch(Dispatchers.IO) {
            isLoadingLiveData.postValue(true)

            val searchText = searchTextLiveData.value
            if (searchText.isNullOrEmpty()) return@launch

            runCatching {
                val response = PicturesRepository().search(searchText)
                photosLiveData.postValue(response.photos)
            }

            isLoadingLiveData.postValue(false)
        }
    }
}
