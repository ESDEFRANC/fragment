package com.altemir.adria.fragment


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.Toast
import com.altemir.adria.fragment.R.layout.activity_main
import com.altemir.adria.fragment.R.layout.fragment_list
import kotlinx.android.synthetic.main.fragment_list.*


class ListProduct : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        onInit()
    }


    companion object {


        const  val PRODUCT_KEY = "products"
    }


    val product1 = Product("Manga",12, R.drawable.cherry, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product2 = Product("Gundam", 12, R.drawable.durazno, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product3 = Product("Anime", 12, R.drawable.durazno, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product4 = Product("CD", 12, R.drawable.platano, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product5 = Product("Comic", 12, R.mipmap.ic_launcher, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product6 = Product("Taza", 12, R.drawable.cherry, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product7 = Product("Guantes", 12, R.drawable.sandia, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product8 = Product("Zapatos", 12, R.drawable.manzana, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product9 = Product("Pañuelo", 12, R.drawable.platano, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")
    val product10 = Product("Gorras", 12, R.drawable.durazno, "fkbasknsalkasnvksdnajnkndsknvsadñkvn")


    val products = arrayListOf<Product>(this.product1,this.product2,this.product3,this.product4,this.product5,this.product6,this.product7,this.product8,this.product9,this.product10  )
    val adapter = ProductAdapter(this.context, products)

    interface  OnButtonPressedListener{
        fun onButtonPressed(product: Product)
    }
    fun onInit(){
        var adapter = ProductAdapter(this.context,products)
        listView?.adapter = adapter
        listView.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, position: Int, l: Long ->
            listener.onButtonPressed(products[position])
        }
    }


    lateinit var listener: OnButtonPressedListener


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

       var  view = inflater.inflate(R.layout.fragment_list, container, false)
        setHasOptionsMenu(true)
        adapter.notifyDataSetChanged()
        return view
    }



    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = activity as OnButtonPressedListener

    }
     override fun onCreateOptionsMenu(menu: Menu?, inflater:MenuInflater){
        inflater.inflate(R.menu.menu_main_activity, menu)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onInit()


        // Inflate the layout for this fragment


    }



}




