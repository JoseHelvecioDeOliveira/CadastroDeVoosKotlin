package br.com.alura.orgs.application

import android.app.Application
import androidx.core.app.CoreComponentFactory
import br.com.alura.orgs.model.Passageiro
import br.com.alura.orgs.model.Voo

open class BaseApplication : Application() {

    var vooList = mutableListOf<Voo>()
    override fun onCreate() {
        super.onCreate()
    }

}