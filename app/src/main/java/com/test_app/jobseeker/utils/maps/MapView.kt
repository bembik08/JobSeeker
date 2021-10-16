package com.test_app.jobseeker.utils.maps

import com.yandex.mapkit.mapview.MapView

interface MapView {
    fun showMap(latitude: Double, longitude : Double, mapView: MapView)
    fun onStart(mapView : MapView)
}