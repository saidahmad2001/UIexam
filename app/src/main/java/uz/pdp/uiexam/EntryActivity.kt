package uz.pdp.uiexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.uiexam.controller.SharedPref

import com.example.uiexam.model.EntryPage
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class EntryActivity : AppCompatActivity() {

    private lateinit var vpEntry: ViewPager2
    private lateinit var adapter: EntryAdapter
    private lateinit var tvSkip: TextView
    private lateinit var tvNext: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        initViews()
    }

    private fun initViews() {
        vpEntry = findViewById(R.id.vpEntry)
        tvSkip = findViewById(R.id.tvSkip)
        tvNext = findViewById(R.id.tvNext)

        val tabIndicator = findViewById<TabLayout>(R.id.tabIndicator)

        refreshAdapter(getAllPages())

        TabLayoutMediator(tabIndicator, vpEntry) { _, _ ->
        }.attach()

        controlPager()
    }

    private fun controlPager() {
        vpEntry.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

                controlChangeTextView(position)

                if (position != 3) {
                    tvNext.setOnClickListener {
                        vpEntry.currentItem = vpEntry.currentItem + 1
                    }
                }

                tvSkip.setOnClickListener {
                    vpEntry.currentItem = 3
                }
            }
        })
    }

    private fun controlChangeTextView(position: Int) {
        if (position == 3) {
            tvSkip.visibility = View.GONE
            tvNext.text = "Done"

            tvNext.setOnClickListener {
                Intent(this@EntryActivity, MainActivity::class.java).also {
                    SharedPref(this).isSaved = true
                    startActivity(it)
                    finish()
                }
            }

        } else {
            tvSkip.visibility = View.VISIBLE
            tvNext.text = "Next"
        }
    }

    private fun refreshAdapter(allPages: java.util.ArrayList<EntryPage>) {
        adapter = EntryAdapter(allPages)
        vpEntry.adapter = adapter
    }

    private fun getAllPages(): ArrayList<EntryPage> {
        return ArrayList<EntryPage>().apply {
            this.add(
                EntryPage(
                    R.drawable.ic_loved,
                    "Saved Listings",
                    "Save your favourite listings to come back to them later"
                )
            )

            this.add(
                EntryPage(
                    R.drawable.ic_chat,
                    "Add new Listings",
                    "Add new listings directly from the app, including photo gallery and filters"
                )
            )

            this.add(
                EntryPage(
                    R.drawable.ic_chat,
                    "Chat",
                    "Communicate with your customers and vendors in real-time"
                )
            )

            this.add(
                EntryPage(
                    R.drawable.ic_notification,
                    "Get Notified",
                    "Stay on the top of your game with real-time push notifications"
                )
            )
        }
    }
}