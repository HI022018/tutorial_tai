package tdtai.vn.horus.broadcastreceiver_fragment.FragmentMinus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MinusModel(val minusView: MinusView):BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        minusView.decreaseByOne()
    }
}