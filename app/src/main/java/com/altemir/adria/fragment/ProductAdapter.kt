package com.altemir.adria.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.customlayout.view.*

class ProductAdapter(
    private val context: Context?,
    private val products: ArrayList<Product>
) : BaseAdapter() {


    @SuppressLint("ViewHolder", "SetTextI18n", "ResourceType")
    override fun getView(position: Int, convertView: View?, viewGrup: ViewGroup?): View {

        val layoutInflater = LayoutInflater.from(context)
        val rowMain = layoutInflater.inflate(R.layout.customlayout, viewGrup, false)


        rowMain.Nombre.text = products[position].name
        rowMain.StockTV.text = products[position].stock.toString()
        rowMain.IamgeProduct.setImageResource(products[position].img)
        rowMain.ButtonDelete.setOnClickListener{
            //Toast.makeText(context, "sUCCESSFULLY LOGGED IN", Toast.LENGTH_LONG).show()
            products.removeAt(position)

        }
        return rowMain

    }

    override fun getItem(position: Int): Any {
        return products[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }

    override fun getCount(): Int {
        return products.size
    }
}

