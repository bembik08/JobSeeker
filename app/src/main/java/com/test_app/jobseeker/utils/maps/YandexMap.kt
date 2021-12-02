package com.test_app.jobseeker.utils.maps

import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import javax.inject.Inject


class YandexMap @Inject constructor() : MapView {
    override fun showMap(
        latitude: Double,
        longitude: Double,
        mapView: com.yandex.mapkit.mapview.MapView
    ) {
        mapView.map.move(
            CameraPosition(
                Point(latitude, latitude),
                11.0f,
                0.0f,
                0.0f
            ),
            Animation(Animation.Type.SMOOTH, 0f),
            null
        )
    }

    override fun onStart(mapView: com.yandex.mapkit.mapview.MapView) {
        mapView.onStart()
    }


}