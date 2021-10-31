package com.pacoglez.arquitecturasandroid.view

import com.pacoglez.arquitecturasandroid.model.Coupon

interface CouponView {
    //view
    fun showCoupons(coupons: ArrayList<Coupon>?)

    //presenter
    fun getCoupons()
}