package h.com.submissionkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity: AppCompatActivity(){
    lateinit var imageGambar: ImageView
    lateinit var tvTeamDesc: TextView
    lateinit var tvTeam: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)

            val intent = intent
            val name: String = intent.getStringExtra("name")
            val image: Int = intent.getIntExtra("image", 0)
            val desc: String = intent.getStringExtra("desc")

            imageGambar = imageView(R.drawable.img_acm).lparams(width = matchParent, height = dip(50)){
                padding = dip(20)
                margin = dip(15)
            }
            tvTeam = textView()
            tvTeam.text = name
            tvTeamDesc = textView()
            tvTeamDesc.text = desc

            Glide.with(this).load(image).into(imageGambar)
        }
    }
}