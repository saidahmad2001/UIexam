package uz.pdp.uiexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SearchFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var featured:Featured
    private lateinit var features:ArrayList<Features>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        init(view)



        return view
    }
    private fun init(view: View){
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        features = addFeature()
        refreshAdapter()

    }
    private fun refreshAdapter() {
        featured = Featured(features)
        recyclerView.adapter = featured
        featured.clickAll = {


        }
    }

    private fun addFeature(): ArrayList<Features> {
        return  ArrayList<Features>().apply {
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran recitation",1))
            this.add(Features(R.drawable.sleep,"Quran for sleep",2))
            this.add(Features(R.drawable.sleep,"Quran surah",3))
            this.add(Features(R.drawable.sleep,"Quran Ruqia",4))
            this.add(Features(R.drawable.sleep,"Quran Most Popular",5))
        }
    }


}