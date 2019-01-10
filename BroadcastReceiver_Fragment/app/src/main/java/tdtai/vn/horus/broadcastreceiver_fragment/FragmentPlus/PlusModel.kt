package tdtai.vn.horus.broadcastreceiver_fragment.FragmentPlus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class PlusModel(val plusView: PlusView) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        plusView.increaseByOne()
    }
}