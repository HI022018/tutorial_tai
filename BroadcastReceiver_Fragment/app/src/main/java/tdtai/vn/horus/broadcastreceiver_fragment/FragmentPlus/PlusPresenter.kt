package tdtai.vn.horus.broadcastreceiver_fragment.FragmentPlus

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_plus_one.*
import kotlinx.android.synthetic.main.fragment_plus_one.view.*
import tdtai.vn.horus.broadcastreceiver_fragment.MainActivity
import tdtai.vn.horus.broadcastreceiver_fragment.R

class PlusPresenter : Fragment(), PlusView {
    private var num = 0
    private lateinit var broadcast:BroadcastReceiver
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_plus_one,container,false)//view
        view.textViewPlus.text = num.toString()
        return view
    }

    override fun onResume() {
        super.onResume()
        broadcast = PlusModel(this)
        val filter = IntentFilter(MainActivity.ACTION_PLUS)
        activity?.registerReceiver(broadcast,filter)
    }

    override fun onPause() {
        super.onPause()
        activity?.unregisterReceiver(broadcast)
    }

    override fun increaseByOne() {
        textViewPlus.text = (++num).toString()
    }
}// Required empty public constructor