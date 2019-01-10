package tdtai.vn.horus.mvp_api

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView, View.OnClickListener {
    private lateinit var mainView: MainView
    private lateinit var mainPresenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainView = this// as MainView
        mainPresenter = MainPresenter(mainView)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button ->{
                mainPresenter.getApiResult()
            }
        }
    }

    override fun displayResultOnTextView(result: DataItem?) {
        textView.text = Html.fromHtml(result?.data)
    }
}