package com.example.a24.a3_UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a24.a1_DataSource.mapper.UsersDataPostToModelMapper
import com.example.a24.a1_DataSource.repository.impl.UserPostDatasorceImpl
import com.example.a24.a1_DataSource.source.interner.exe.UsersPostFromJsonExe
import com.example.a24.a2_Domain.UserRepository
import com.example.a24.a2_Domain.mapper.UserPostDomainToUIMapper
import com.example.a24.a2_Domain.useCase.UserPostGetUseCase
import com.example.a24.a3_UI.modelUi.UsersPostUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    val reposUsersPostsLiveData = MutableLiveData<List<UsersPostUIModel>>()

    val userPostGetUseCasee: UserPostGetUseCase = UserPostGetUseCase(
        UserPostDatasorceImpl(
            UsersPostFromJsonExe(
                Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build(
                    )
            ), UsersDataPostToModelMapper()
        ), UserPostDomainToUIMapper(UserRepository())
    )

    fun getUsersPost(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = userPostGetUseCasee.execute()
            withContext(Dispatchers.Main) {
                result?.also { repos ->
                    reposUsersPostsLiveData.postValue(repos)
                }
            }
        }
    }
}