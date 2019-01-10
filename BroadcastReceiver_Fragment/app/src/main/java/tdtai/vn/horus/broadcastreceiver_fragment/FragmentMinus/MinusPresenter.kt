package tdtai.vn.horus.broadcastreceiver_fragment.FragmentMinus

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_minus_one.*
import kotlinx.android.synthetic.main.fragment_minus_one.view.*
import tdtai.vn.horus.broadcastreceiver_fragment.MainActivity
import tdtai.vn.horus.broadcastreceiver_fragment.R

class MinusPresenter:Fragment(), MinusView {
    private lateinit var broadcast:BroadcastReceiver
    private var num = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_minus_one,container,false)
        view.textViewMinus.text = num.toString()
        return view
    }

    override fun onResume() {
        super.onResume()
        broadcast = MinusModel(this)
        val filter = IntentFilter(MainActivity.ACTION_MINUS)
        activity?.registerReceiver(broadcast,filter)
    }

    override fun onPause() {
        super.onPause()
        activity?.unregisterReceiver(broadcast)
    }

    override fun decreaseByOne() {
        textViewMinus.text = (--num).toString()
    }
}