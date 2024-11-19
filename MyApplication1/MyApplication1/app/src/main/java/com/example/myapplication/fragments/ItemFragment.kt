package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.data.Contact
import com.example.myapplication.fragments.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private var columnCount = 1
    private var ContactList = listOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                ContactList = createContactList()
                adapter = MyItemRecyclerViewAdapter(ContactList)
            }
        }
        return view
    }

    private val myImage = listOf(
        R.drawable.ob1,
        R.drawable.ob4,
        R.drawable.ob4
    )
    private fun createContactList(): List<Contact> = buildList<Contact> {
        for (i in 1 ..10){
        val name ="Użytkownik${i}"
        val number = "+"+ "${randomNumber(2)} " + "${randomNumber(3)} " +"${randomNumber(3)} " + "${randomNumber(3)} "
        val image = myImage[(myImage.indices.random())]
        val contact = Contact(name,number,image)
        add(contact)
        }

    }
    private fun  addContact(contact:Contact){
        var mutableContactList = ContactList.toMutableList()
        mutableContactList.add(contact)
        ContactList = mutableContactList
    }
    private fun randomNumber(n: Int):String

    {
        var number = ""
        for (i in (1 .. n)){
            number += "${(0 .. 3).random()}"

        }
        return number
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}