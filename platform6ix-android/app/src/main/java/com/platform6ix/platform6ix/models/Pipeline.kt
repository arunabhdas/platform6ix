package com.platform6ix.platform6ix.models

/**
 * Created by Das on 2021-08-24.
 */
data class Pipeline(val pk: String,
                    val name: String,
                    val start_date: String,
                    val end_date: String,
                    val budget_per_km2: Float,
                    val max_cost: Float,
                    val cloud_cover_percentage: Double,
                    val min_aoi_coverage_percentage: Double,
                    val resolution_low: Double,
                    val resolution_high: Double
                ) {

   override fun toString(): String {
       return ""
   }
}