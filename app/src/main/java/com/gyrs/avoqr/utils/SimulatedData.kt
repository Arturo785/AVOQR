package com.gyrs.avoqr.utils

import com.gyrs.avoqr.R
import com.gyrs.avoqr.data.AvocadoData

class SimulatedData {

    companion object{

        fun generateData() : MutableList<AvocadoData>{
            val listToSend = mutableListOf<AvocadoData>()

            val num1 = AvocadoData(R.drawable.avocado_1,"Lote 1",
                "Los arrollo,Arrollo,fsdsjd425f,CD Guzman,31423554,Lote 1,Jazz,30kg,cajas:1")
            listToSend.add(num1)
            val num2 = AvocadoData(R.drawable.avocado_2,"Lote 2",
                "Avomex,Jose,45sd4f1adf,CD Guzman,3124211254,Lote 2,Jazz,80kg,cajas:3")
            listToSend.add(num2)
            val num3 = AvocadoData(R.drawable.avocado_3,"Lote 3",
                "AvoSup,Juan,fsd5g2s1ff,CD Guzman,3144223554,Lote 3,Criollo,500kg,cajas:15")
            listToSend.add(num3)
            val num4 = AvocadoData(R.drawable.avocado_1,"Lote 4",
                "Los arrollo,Arrollo,fsdsjd425f,CD Guzman,31423554,Lote 4,Criollo,100kg,cajas:5")
            listToSend.add(num4)
            val num5 = AvocadoData(R.drawable.avocado_2,"Lote 5",
                "Los arrollo,Arrollo,fsdsjd425f,CD Guzman,31423554,Lote 5,Jazz,150kg,cajas:8")
            listToSend.add(num5)
            val num6 = AvocadoData(R.drawable.avocado_1,"Lote 6",
                "AvoSup,Juan,fsd5g2s1ff,CD Guzman,3144223554,Lote 6,Criollo,200kg,cajas:10")
            listToSend.add(num6)
            val num7 = AvocadoData(R.drawable.avocado_3,"Lote 7",
                "Avomex,Jose,45sd4f1adf,CD Guzman,3124211254,Lote 7,Jazz,80kg,cajas:3")
            listToSend.add(num7)
            val num8 = AvocadoData(R.drawable.avocado_2,"Lote 8",
                "Los arrollo,Arrollo,fsdsjd425f,CD Guzman,31423554,Lote 8,Criollo,150kg,cajas:7")
            listToSend.add(num8)
            val num9 = AvocadoData(R.drawable.avocado_1,"Lote 9",
                "Los arrollo,Arrollo,fsdsjd425f,CD Guzman,31423554,Lote 9,Criollo,120kg,cajas:8")
            listToSend.add(num9)
            val num10 = AvocadoData(R.drawable.avocado_3,"Lote 10",
                "AvoSup,Juan,fsd5g2s1ff,CD Guzman,3144223554,Lote 10,Criollo,240kg,cajas:10")
            listToSend.add(num10)

            return listToSend
        }
    }
}