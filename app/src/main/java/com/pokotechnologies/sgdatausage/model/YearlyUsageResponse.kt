package com.pokotechnologies.sgdatausage.model

class YearDataUsage {

    var year: Int = 0

    var quarterUsage1
            : QuarterUsage? = null

    var quarterUsage2: QuarterUsage? = null

    var quarterUsage3: QuarterUsage? = null

    var quarterUsage4: QuarterUsage? = null


    fun setDataForQuarter(quarter: String, quarterUsage: QuarterUsage) {
        if (quarter == "Q1") {
            quarterUsage1 = quarterUsage
        } else if (quarter == "Q2") {
            quarterUsage2 = quarterUsage
        } else if (quarter == "Q3") {
            quarterUsage3 = quarterUsage
        } else if (quarter == "Q4") {
            quarterUsage4 = quarterUsage
        }
    }


}
