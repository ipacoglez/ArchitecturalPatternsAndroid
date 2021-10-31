package com.pacoglez.arquitecturasandroid.presenter

import com.pacoglez.arquitecturasandroid.model.Coupon

interface CouponPresenter {

    //view
    fun showCoupons(coupons: ArrayList<Coupon>?)

    //Interactor
    fun getCoupons()

}