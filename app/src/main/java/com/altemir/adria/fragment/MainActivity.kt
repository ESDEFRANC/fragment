package com.altemir.adria.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_list.*
import kotlin.math.sin

class MainActivity : AppCompatActivity(), ListProduct.OnButtonPressedListener, addFragment.OnAddButtonPressedListener{



    override fun onButtonPressed(product: Product) {
        val singleElementFragment = ProductFragment.newInstance(product)
        val fragmentTransaction: android.support.v4.app.FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainContainer, singleElementFragment).addToBackStack(null)
        fragmentTransaction.commit()

    }

    override fun onAddButtonPressed(product: Product) {
        val fl = ListProduct()
        val listFragment = supportFragmentManager
        if(listFragment.backStackEntryCount > 0){
            fl.products.add(product)
            fl.adapter.notifyDataSetChanged()
            Toast.makeText(this, "Product size = ${fl.products.size}", Toast.LENGTH_LONG).show()
            listFragment.popBackStack()


        }else{
            Toast.makeText(this, "cantitat" + product.description, Toast.LENGTH_LONG).show()
            super.onBackPressed()
        }



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ListProduct()
        supportFragmentManager.beginTransaction().
            add(R.id.mainContainer,list).
            commit()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.add -> {
                val addFragment = addFragment()
                val fragmentTransaction: android.support.v4.app.FragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.mainContainer, addFragment).addToBackStack(null)
                fragmentTransaction.commit()
                return true

            }else ->{return super.onOptionsItemSelected(item)}
        }

    }



}
