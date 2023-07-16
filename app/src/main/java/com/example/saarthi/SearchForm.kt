package com.example.saarthi

import android.content.Intent
import android.media.MediaParser.SeekPoint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible

class SearchForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_form)

        val stateArray = arrayOf("Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka",
            "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram",
            "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu",
            "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal")
        val cityUP = arrayOf("Lucknow", "Kanpur", "Varanasi", "Agra", "Prayagraj","Pratapgarh",
            "Ghaziabad", "Meerut", "Noida", "Bareilly", "Moradabad",
            "Aligarh", "Saharanpur", "Gorakhpur", "Faizabad", "Jhansi",
            "Muzaffarnagar", "Mathura", "Sultanpur", "Banda", "Amroha",
            "Ayodhya", "Mirzapur", "Etawah", "Firozabad", "Hapur",
            "Bulandshahr", "Bahraich", "Rampur", "Modinagar", "Unnao")
        val colleges = arrayOf("Institute of Management Technology (IMT)",
            "ABES Engineering College",
            "Ajay Kumar Garg Engineering College (AKGEC)",
            "Indraprastha Engineering College (IPEC)",
            "Institute of Technology and Science (ITS)",
            "ABES Institute of Technology (ABESIT)",
            "Institute of Engineering and Rural Technology (IERT)",
            "Raj Kumar Goel Institute of Technology (RKGIT)",
            "KIET Group of Institutions",
            "HR Institute of Technology (HRIT)",
            "Dewan V.S. Institute of Engineering and Technology (DEWAN VSIT)",
            "Krishna Institute of Engineering and Technology (KIET)",
            "IMS Engineering College",
            "Ghaziabad Institute of Management and Technology (GIMT)",
            "Jagran Institute of Management and Mass Communication (JIMMC)",
            "IMS Law College",
            "Kamla Nehru Institute of Physical and Social Sciences",
            "IMS College of Engineering",
            "Raj Kumar Goel Institute of Technology for Women (RKGITW)",
            "Ideal Institute of Technology (IIT)",
            "Babu Banarsi Das Institute of Technology (BBDIT)",
            "Vivekanand Institute of Technology and Science (VITS)",
            "HLM Business School",
            "Raj Kumar Goel Engineering College (RKGEC)",
            "Sunder Deep Group of Institutions",
            "Inderprastha Engineering College (IPEC)")
        val allPlaces = arrayOf("Railway Stations","Airports","Colleges","Bus Stations","Hospitals","Parks","Tourist Places")

        val states = findViewById<Spinner>(R.id.allStates)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            applicationContext,
            android.R.layout.simple_spinner_dropdown_item,
            stateArray
        )
        states.setAdapter(adapter)

//        val places = findViewById<Spinner>(R.id.allPlaces)
//        val adapter2 : ArrayAdapter<String> = ArrayAdapter<String>(
//            applicationContext,
//            android.R.layout.simple_spinner_dropdown_item,
//            allPlaces
//        )
//        places.setAdapter(adapter2)


        states.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapter: AdapterView<*>?, view: View, i: Int, l: Long) {
                val selected_states: String = states.getSelectedItem().toString()


                if (selected_states == "Uttar Pradesh") {
                    val city = findViewById<Spinner>(R.id.allCity)
                    val adapter1 = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        cityUP
                    )
                    city.setAdapter(adapter1)

                    city.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            adapter: AdapterView<*>?,
                            view: View,
                            i: Int,
                            l: Long
                        ) {
                            val selected_city: String = city.getSelectedItem().toString()

                            val places = findViewById<Spinner>(R.id.allPlaces)
                            val adapter2 : ArrayAdapter<String> = ArrayAdapter<String>(
                                applicationContext,
                                android.R.layout.simple_spinner_dropdown_item,
                                allPlaces
                            )
                            places.setAdapter(adapter2)

                            places.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    adapter: AdapterView<*>?,
                                    view: View,
                                    i: Int,
                                    l: Long
                                ) {
                                    val selected_place: String = places.getSelectedItem().toString()
                                    val cllg_card = findViewById<CardView>(R.id.cardView4)



                                    if (selected_city == "Ghaziabad" && selected_place == "Colleges")
                                    {
                                        cllg_card.isVisible = true
                                        val cllg = findViewById<Spinner>(R.id.allCollege)
                                        val adapter3 = ArrayAdapter(
                                            applicationContext,
                                            android.R.layout.simple_spinner_dropdown_item,
                                            colleges
                                        )
                                        cllg.setAdapter(adapter3)


                                        cllg.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                                            override fun onItemSelected(
                                                adapter: AdapterView<*>?,
                                                view: View,
                                                i: Int,
                                                l: Long
                                            ) {
                                                val selected_cllg: String =
                                                    cllg.getSelectedItem().toString()

                                                if (selected_cllg == "Institute of Technology and Science (ITS)")
                                                {
                                                    val proceed = findViewById<Button>(R.id.proceed)
                                                    proceed.setOnClickListener {
                                                        val intent = Intent(this@SearchForm , SearchWheelchair::class.java)
                                                        startActivity(intent)
                                                    }
                                                }
                                            }

                                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                                Toast.makeText(applicationContext,"Please select college", Toast.LENGTH_LONG)
                                            }
                                        })


                                    }

                                }

                                override fun onNothingSelected(p0: AdapterView<*>?) {
                                    Toast.makeText(applicationContext,"Please select any public place", Toast.LENGTH_LONG)
                                }
                            })


                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {}
                    })




                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        })



    }


}
