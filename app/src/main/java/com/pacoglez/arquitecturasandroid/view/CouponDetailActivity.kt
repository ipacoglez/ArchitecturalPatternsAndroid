package com.pacoglez.arquitecturasandroid.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.pacoglez.arquitecturasandroid.R
import com.pacoglez.arquitecturasandroid.model.Coupon
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponDetailActivity : AppCompatActivity() {
    private var couponSelected: Coupon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon_detail)

        couponSelected = intent.getSerializableExtra("COUPON") as Coupon

        val tvTitleDetail: TextView = findViewById(R.id.tvTitleDetail)
        val tvDescriptionShortDetail: TextView = findViewById(R.id.tvDescriptionShortDetail)
        val tvCategoryDetail: TextView = findViewById(R.id.tvCategoryDetail)
        val tvDateDetail: TextView = findViewById(R.id.tvDateDetail)
        val tvDescriptionDetailData: TextView = findViewById(R.id.tvDescriptionDetailData)
        val tvOfferDetailData: TextView = findViewById(R.id.tvOfferDetailData)
        val tvWebsiteDetailData: TextView = findViewById(R.id.tvWebsiteDetailData)
        val tvDateEndData: TextView = findViewById(R.id.tvDateEndData)
        val imgHeaderDetail: ImageView = findViewById(R.id.imgHeaderDetail)
        val imgCouponDetail: CircleImageView = findViewById(R.id.imgCouponDetail)
        val btnOpenOffer: Button = findViewById(R.id.btnOpenOffer)

        tvTitleDetail.text = couponSelected?.title
        tvDescriptionShortDetail.text = couponSelected?.descriptionShort
        tvCategoryDetail.text = couponSelected?.category
        tvDateDetail.text = couponSelected?.endDate
        tvDescriptionDetailData.text = couponSelected?.description
        tvOfferDetailData.text = couponSelected?.offer
        tvWebsiteDetailData.text = couponSelected?.website
        tvDateEndData.text = couponSelected?.endDate

        if (couponSelected?.imageUrl?.isNotEmpty() == true) {
            Picasso.get().load(couponSelected?.imageUrl).resize(520, 520).centerCrop().into(imgHeaderDetail)
            Picasso.get().load(couponSelected?.imageUrl).resize(520, 520).centerCrop().into(imgCouponDetail)
        }

        btnOpenOffer.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)

            if (couponSelected?.url?.isNotEmpty() == true) {
                openURL.data = Uri.parse(couponSelected?.url)
                startActivity(openURL)
            }
        }

    }
}