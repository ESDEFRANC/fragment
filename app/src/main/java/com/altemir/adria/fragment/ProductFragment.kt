package com.altemir.adria.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_product.*

class ProductFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onStart() {
        super.onStart()

        if (arguments != null) {
            val data = arguments!!.getParcelable<Product>("data_product")

            ImageProduct.setImageResource(data.img)
            ProductName.text = data.name
            ProductCantity.text = data.stock.toString()
            Description.text = data.description
        }
    }

    companion object {
        fun newInstance(product: Product): ProductFragment {
            val singleElementFragment = ProductFragment()
            val args = Bundle()
            args.putParcelable("data_product", product)
            singleElementFragment.arguments = args

            return singleElementFragment
        }
    }
}
