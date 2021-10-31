package com.pacoglez.arquitecturasandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pacoglez.arquitecturasandroid.R
import com.pacoglez.arquitecturasandroid.model.Coupon
import com.pacoglez.arquitecturasandroid.presenter.CouponPresenter
import com.pacoglez.arquitecturasandroid.presenter.CouponPresenterImpl

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponPresenter? = null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)

        //VIEW
        rvCoupons = findViewById(R.id.rvCoupons) //UI
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }
}