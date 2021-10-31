package com.pacoglez.arquitecturasandroid.presenter

import com.pacoglez.arquitecturasandroid.model.Coupon
import com.pacoglez.arquitecturasandroid.model.CouponInteractor
import com.pacoglez.arquitecturasandroid.model.CouponInteractorImpl
import com.pacoglez.arquitecturasandroid.view.CouponView

class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

    private var couponInteractor: CouponInteractor = CouponInteractorImpl(this)

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }
}