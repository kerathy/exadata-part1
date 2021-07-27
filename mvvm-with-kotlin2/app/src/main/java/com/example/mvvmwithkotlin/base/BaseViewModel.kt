package com.example.mvvmwithkotlin.base

import androidx.lifecycle.ViewModel
import com.example.mvvmwithkotlin.injection.component.DaggerViewModelInjector
import com.example.mvvmwithkotlin.injection.component.ViewModelInjector
import com.example.mvvmwithkotlin.injection.module.NetworkModule
import com.example.mvvmwithkotlin.ui.post.PostListViewModel


abstract class BaseViewModel: ViewModel(){
    //...

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}