package com.pokotechnologies.sgdatausage.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pokotechnologies.sgdatausage.R
import com.pokotechnologies.sgdatausage.model.YearDataUsage
import java.text.DecimalFormat
import android.widget.Toast
import butterknife.ButterKnife
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import butterknife.BindView


class MobileUsageAdapter(
    private val mDataUsageList: List<YearDataUsage>,
    private val mContext: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_year_data_usage, viewGroup, false)
        return DataUsageVH(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val vh = viewHolder as DataUsageVH
        val yearDataUsage = mDataUsageList[position]

        var totalUsage: Double? = 0.0

        var hasDecreased = false

        if (yearDataUsage.quarterUsage1!= null) {
            vh.mQuarter1!!.text =
                "Q1\n" + DecimalFormat("00.00").format(yearDataUsage.quarterUsage1!!.usage)
            totalUsage = totalUsage!! + yearDataUsage.quarterUsage1!!.usage!!

            if (position > 0 && mDataUsageList[position - 1] != null) {
                val prevYear = mDataUsageList[position - 1]
                if (prevYear.quarterUsage4 != null) {
                    if (prevYear.quarterUsage4!!.usage!! > yearDataUsage.quarterUsage4!!.usage!!) {
                        vh.mQuarter1!!.setBackgroundColor(
                            ContextCompat.getColor(
                                mContext,
                                R.color.data_usage_low
                            )
                        )
                        hasDecreased = true
                    } else {
                        vh.mQuarter1!!.setBackgroundColor(
                            ContextCompat.getColor(
                                mContext,
                                R.color.data_usage_high
                            )
                        )
                    }

                } else {
                    vh.mQuarter1!!.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            android.R.color.transparent
                        )
                    )
                }

            } else {
                vh.mQuarter1!!.setBackgroundColor(
                    ContextCompat.getColor(
                        mContext,
                        android.R.color.transparent
                    )
                )
            }
        } else {
            vh.mQuarter1!!.text = "Q1\n-"
            vh.mQuarter1!!.setBackgroundColor(
                ContextCompat.getColor(
                    mContext,
                    android.R.color.transparent
                )
            )

        }

        if (yearDataUsage.quarterUsage2 != null) {
            vh.mQuarter2!!.text =
                "Q2\n" + DecimalFormat("00.00").format(yearDataUsage.quarterUsage2!!.usage!!)
            totalUsage = totalUsage!! + yearDataUsage.quarterUsage2!!.usage!!

            if (yearDataUsage.quarterUsage1 != null) {
                if (yearDataUsage.quarterUsage1!!.usage!! > yearDataUsage.quarterUsage2!!.usage!!) {
                    vh.mQuarter2!!.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.data_usage_low
                        )
                    )
                    hasDecreased = true
                } else {
                    vh.mQuarter2!!.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.data_usage_high
                        )
                    )
                }

            } else {
                vh.mQuarter2!!.setBackgroundColor(
                    ContextCompat.getColor(
                        mContext,
                        android.R.color.transparent
                    )
                )
            }
        } else {
            vh.mQuarter2!!.text = "Q2\n-"
            vh.mQuarter2!!.setBackgroundColor(
                ContextCompat.getColor(
                    mContext,
                    android.R.color.transparent
                )
            )
        }

        if (yearDataUsage.quarterUsage3 != null) {
            vh.mQuarter3!!.text =
                "Q3\n" + DecimalFormat("00.00").format(yearDataUsage.quarterUsage3!!.usage)
            totalUsage = totalUsage!! + yearDataUsage.quarterUsage3!!.usage!!
            if (yearDataUsage.quarterUsage3!= null) {
                if (yearDataUsage.quarterUsage2!!.usage!! > yearDataUsage.quarterUsage3!!.usage!!)
                {
                    vh.mQuarter3!!.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.data_usage_low
                        )
                    )
                    hasDecreased = true
                } else {
                    vh.mQuarter3!!.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.data_usage_high
                        )
                    )
                }

            } else {
                vh.mQuarter3!!.setBackgroundColor(
                    ContextCompat.getColor(
                        mContext,
                        android.R.color.transparent
                    )
                )
            }
        } else {
            vh.mQuarter3!!.text = "Q3\n-"
            vh.mQuarter3!!.setBackgroundColor(
                ContextCompat.getColor(
                    mContext,
                    android.R.color.transparent
                )
            )

        }

        if (yearDataUsage.quarterUsage4!= null) {
            vh.mQuarter4!!.text =
                "Q4\n" + DecimalFormat("00.00").format(yearDataUsage.quarterUsage4!!.usage)
            totalUsage = totalUsage!! + yearDataUsage.quarterUsage4!!.usage!!

            if (yearDataUsage.quarterUsage3 != null) {
                if (yearDataUsage.quarterUsage3!!.usage!! > yearDataUsage.quarterUsage4!!.usage!!) {
                    vh.mQuarter4!!.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.data_usage_low
                        )
                    )
                    hasDecreased = true
                } else {
                    vh.mQuarter4!!.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.data_usage_high
                        )
                    )
                }
            } else {
                vh.mQuarter4!!.setBackgroundColor(
                    ContextCompat.getColor(
                        mContext,
                        android.R.color.transparent
                    )
                )
            }

        } else {
            vh.mQuarter4!!.text = "Q4\n-"
            vh.mQuarter4!!.setBackgroundColor(
                ContextCompat.getColor(
                    mContext,
                    android.R.color.transparent
                )
            )
        }

        vh.usageYear!!.text = "Year " + yearDataUsage.year.toString()
        vh.mTotalUsage!!.text = DecimalFormat("0.00").format(totalUsage) + " (unit) pb"

        if (hasDecreased) {
            vh.mLowUsageImageView!!.visibility = View.VISIBLE
        } else {
            vh.mLowUsageImageView!!.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
        return mDataUsageList.size
    }


    inner class DataUsageVH(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        @BindView(R.id.quarterOne)
        internal var mQuarter1: AppCompatTextView? = null

        @BindView(R.id.quarterTwo)
        internal var mQuarter2: AppCompatTextView? = null

        @BindView(R.id.quarterThree)
        internal var mQuarter3: AppCompatTextView? = null

        @BindView(R.id.quarterFour)
        internal var mQuarter4: AppCompatTextView? = null

        @BindView(R.id.total_usage)
        internal var mTotalUsage: AppCompatTextView? = null

        @BindView(R.id.usage_year)
        internal var usageYear: AppCompatTextView? = null

        @BindView(R.id.low_usage)
        internal var mLowUsageImageView: AppCompatImageView? = null

        init {
            ButterKnife.bind(this, itemView)
            mLowUsageImageView!!.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Toast.makeText(
                mContext,
                "This Year has decrease in volume data (quarter)",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

}