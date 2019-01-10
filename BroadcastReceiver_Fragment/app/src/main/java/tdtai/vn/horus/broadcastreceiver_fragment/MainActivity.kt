package tdtai.vn.horus.broadcastreceiver_fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import tdtai.vn.horus.broadcastreceiver_fragment.FragmentMinus.MinusPresenter
import tdtai.vn.horus.broadcastreceiver_fragment.FragmentPlus.PlusPresenter

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var fm:FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)

        fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.frame_layout_1, PlusPresenter())
        ft.add(R.id.frame_layout_2, MinusPresenter())
        ft.commit()
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        when(v?.id){
            R.id.buttonPlus->intent.action = ACTION_PLUS
            R.id.buttonMinus->intent.action = ACTION_MINUS
        }
        sendBroadcast(intent)
    }
    companion object {
        const val ACTION_PLUS = "Main.Plus"
        const val ACTION_MINUS = "Main.Minus"
    }
}