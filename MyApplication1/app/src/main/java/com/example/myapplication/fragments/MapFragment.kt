package com.example.myapplication.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MapFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchBtnAddress: Button = view.findViewById(R.id.searchBTNaddress)
        val mapAddressET: EditText = view.findViewById(R.id.mapAddressET)
        val mapSearchLatLonBtn: Button = view.findViewById(R.id.map_search_lationBTN)
        val mapLatET: EditText = view.findViewById(R.id.map_latET)
        val mapLonET: EditText = view.findViewById(R.id.map_lonET)

        searchBtnAddress.setOnClickListener {
            var address = mapAddressET.text.toString()
            if (address.isEmpty()) {
                address = "Jarosław, ul. Czarnieckiego 16"
            }
            val geoData = Uri.parse("geo:0,0?q=$address")
            val intent = Intent(Intent.ACTION_VIEW, geoData)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }

        mapSearchLatLonBtn.setOnClickListener {
            var lat = mapLatET.text.toString()
            var lon = mapLonET.text.toString()
            var address = "$lat, $lon"
            if (lon.isEmpty() || lat.isEmpty()) {
                address = "50.012,22.674"
            }
            val geoData = Uri.parse("geo:0,0?q=$address")
            val intent = Intent(Intent.ACTION_VIEW, geoData)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
            mapLatET.text.clear()
            mapLonET.text.clear()
        }
    }
}
