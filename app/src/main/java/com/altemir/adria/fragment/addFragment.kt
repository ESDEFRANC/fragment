package com.altemir.adria.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_add_fragment.*
import kotlinx.android.synthetic.main.fragment_list.*

class addFragment : Fragment() {

    interface  OnAddButtonPressedListener{
        fun onAddButtonPressed(product: Product)
    }
    lateinit var listener: OnAddButtonPressedListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_add_fragment, container, false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        AddProduct.setOnClickListener(){

           var nom = NameET.text.toString()
            var cantiat = StockET.text.toString()
            var intcantitat = cantiat.toInt()
            var descripcio = DescriptionET.text.toString()

            val product1 = Product(nom,intcantitat, R.drawable.cherry, descripcio)

            listener.onAddButtonPressed(product1)

            //Toast.makeText(context, "cantitat" + product1.stock, Toast.LENGTH_LONG).show()


        }


        // Inflate the layout for this fragment


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        listener = activity as OnAddButtonPressedListener
    }



}
