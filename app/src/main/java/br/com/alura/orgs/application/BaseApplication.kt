package br.com.alura.orgs.application

import android.app.Application
import br.com.alura.orgs.dao.FormularioDao
import br.com.alura.orgs.dao.PassageirosDao
import br.com.alura.orgs.dao.TripulanteDao
import br.com.alura.orgs.dao.VooDao

open class BaseApplication : Application() {

    var vooDao = VooDao
    var tripulanteDao = TripulanteDao
    var passageiroDao = PassageirosDao
    var formularioDao = FormularioDao

    override fun onCreate() {
        super.onCreate()
    }
}