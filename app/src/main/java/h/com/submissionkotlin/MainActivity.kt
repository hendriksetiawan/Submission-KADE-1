package h.com.submissionkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items:MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        rvClub.layoutManager = LinearLayoutManager(this)
        rvClub.adapter = RecyclerViewAdapter(this, items){

            startActivity<DetailActivity>("name" to "${it.name}", "image" to it.image, "desc" to "${it.desc}")

        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_description)
        items.clear()

        for (i in name.indices){
            items.add(Item(name[i],
                    image.getResourceId(i, 0), desc[i]))
        }
        image.recycle()
    }
}
