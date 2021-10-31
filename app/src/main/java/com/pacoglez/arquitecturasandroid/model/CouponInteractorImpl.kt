package com.pacoglez.arquitecturasandroid.model

import com.pacoglez.arquitecturasandroid.presenter.CouponPresenter

class CouponInteractorImpl(var couponPresenter: CouponPresenter): CouponInteractor {

    private var couponRepository:CouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}