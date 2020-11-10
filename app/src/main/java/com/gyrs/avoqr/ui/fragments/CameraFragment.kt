package com.gyrs.avoqr.ui.fragments

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import com.gyrs.avoqr.R
import kotlinx.android.synthetic.main.camera_fragment.*

class CameraFragment : Fragment(R.layout.camera_fragment) {

    private lateinit var surfaceCamera: SurfaceView
    private var detector: BarcodeDetector? = null
    private var cameraSource: CameraSource? = null
    private var _width: Int = 1024
    private var _height: Int = 768
    private val _CAMERA_CODE = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        surfaceCamera = surface_camera
        detector = BarcodeDetector.Builder(requireContext()).setBarcodeFormats(Barcode.QR_CODE).build()

        getCameraDimens()
        setDetector()
        setCameraBuilder(CameraSource.CAMERA_FACING_BACK)
        setSurfaceHolder()

    }

    fun getCameraDimens() {
        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        _width = displayMetrics.widthPixels  // set the dimensions of the camera
        _height = displayMetrics.heightPixels
    }

    fun setDetector() {
        // instantiates the QR detector and what to do when one is detected
        detector?.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {

            }

            // runs on background thread
            override fun receiveDetections(detections: Detector.Detections<Barcode>?) {
                val barCodes = detections?.detectedItems
                barCodes.let {
                    if (barCodes!!.size() > 0) {
                        //presenter.getUserSelection(_extras,barCodes.valueAt(0).displayValue)
                        Toast.makeText(activity, "detected", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })
    }

    fun setCameraBuilder(facing: Int) {
        cameraSource = CameraSource.Builder(requireContext(), detector)
            .setRequestedPreviewSize(_width, _height)
            .setRequestedFps(30f) // builds the camera
            .setAutoFocusEnabled(true)
            .setFacing(facing)
            .build()
    }

    fun setSurfaceHolder() {
        // manages where the camera lives and if it has permission to be displayed
        surfaceCamera.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {

            }

            override fun surfaceDestroyed(p0: SurfaceHolder?) {
                cameraSource?.stop()
            }

            override fun surfaceCreated(holder: SurfaceHolder?) {

                if (ContextCompat.checkSelfPermission(
                        requireContext(),
                        android.Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    cameraSource?.start(holder)
                } else {
                    ActivityCompat.requestPermissions(
                        requireActivity(), arrayOf(
                            android.Manifest.permission.CAMERA
                        ), _CAMERA_CODE
                    )
                }
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        detector?.release()
        cameraSource?.stop()
        cameraSource?.release()
    }



}