package com.example.listadofutbol

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recView: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView= findViewById(R.id.rec_equipo)
        recView.layoutManager= LinearLayoutManager(this)
        val dataSet = getListadoEquipos()
        adapter=Adapter(applicationContext)
        recView.adapter=adapter
        adapter.submitList(dataSet)
    }

    private fun getListadoEquipos(): MutableList<Equipo>? {
        return mutableListOf(
            Equipo(1,"Boca Juniors","Boca","bombonera",Paises.ARGENTINA,"https://w7.pngwing.com/pngs/1008/873/png-transparent-boca-juniors-superliga-argentina-de-futbol-football-club-atletico-huracan-football-sport-heart-logo-thumbnail.png"),
            Equipo(2,"River Plate","Millo","Monumental",Paises.ARGENTINA,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwx2ji0hv-RHdGaZiyxF864NAP3KG8Fta0-jTC_RFLUA&s"),
            Equipo(3,"Racing","La academia","Cilindro",Paises.ARGENTINA,"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Escudo_de_Racing_Club.svg/1200px-Escudo_de_Racing_Club.svg.png"),
            Equipo(4,"Corinthians","Corinthians","Neo Química Arena",Paises.BRAZIL,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWCaRuA7g4ACrLTBjN8ctK97iILE7R0s90k0aPnpuCyg&s"),
            Equipo(5,"Cruzeiro","Cruzeiro","Estadio Mineirão",Paises.BRAZIL,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuxzBP-l_K-_w3XXwQ-w6iCr5Ogf_1-4t5TbpFUSV8_A&s"),
            Equipo(6,"Atlético Nacional","Atlético Nacional","Atanasio Girardot",Paises.COLOMBIA,"https://upload.wikimedia.org/wikipedia/commons/2/29/Atletico-nacional-vector-logo_11186.jpg"),
            Equipo(7,"Deportivo Cali","Deportivo Cali","Estadio Deportivo Cali",Paises.COLOMBIA,"https://upload.wikimedia.org/wikipedia/commons/4/4a/Escudo_Deportivo_Cali.png"),
            Equipo(8,"Liverpool FC","Liverpool FC","Estadio liverpool FC",Paises.URUGUAY,"https://upload.wikimedia.org/wikipedia/commons/0/0d/Escudo_Liverpool_FC_Montevideo.webp"),
            Equipo(9,"Montevideo Wanderers FC","Montevideo Wanderers FC","Estadio Montevideo",Paises.URUGUAY,"https://upload.wikimedia.org/wikipedia/commons/d/d4/Escudo_del_Montevideo_Wanderers_Futbol_Club.png"),
            Equipo(10,"Universidad Católica","Universidad Católica","estadio Universidad Católica",Paises.CHILE,"https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Escudo_Club_Deportivo_Universidad_Cat%C3%B3lica.svg/800px-Escudo_Club_Deportivo_Universidad_Cat%C3%B3lica.svg.png")
        )
    }
}