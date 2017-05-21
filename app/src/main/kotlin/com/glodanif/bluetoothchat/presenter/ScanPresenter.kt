package com.glodanif.bluetoothchat.presenter

import android.bluetooth.BluetoothAdapter
import com.glodanif.bluetoothchat.view.ScanView

class ScanPresenter(private val view: ScanView) {

    private val adapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    fun checkBluetoothAvailability() {

        if (adapter == null) {
            view.showBluetoothIsNotAvailableMessage()
        } else {
            view.showBluetoothFunctionality()
        }
    }

    fun checkBluetoothEnabling() {

        if (adapter == null) {
            return
        }

        if (adapter.isEnabled) {
            getPairedDevices()
        } else {
            view.showBluetoothEnablingRequest()
        }
    }

    fun turnOnBluetooth() {
        if (adapter != null && !adapter.isEnabled) {
            view.enableBluetooth()
        }
    }

    fun getPairedDevices() {

        if (adapter != null) {
            view.showPairedDevices(adapter.bondedDevices)
        }
    }
}
