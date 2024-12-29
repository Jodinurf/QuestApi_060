package com.jodifrkh.serverdatabase

import android.app.Application
import com.jodifrkh.serverdatabase.dependenciesinjection.AppContainer
import com.jodifrkh.serverdatabase.dependenciesinjection.MahasiswaContainer

class MahasiswaApplication:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}