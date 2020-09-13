package com.tta.china_myandictionary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_word.view.*
import kotlin.collections.ArrayList

class WordAdapter(var clicklistener: Clicklistener)
    :RecyclerView.Adapter<WordAdapter.WordVH>(),Filterable {
    var itemsModellist = ArrayList<WordList>();
    var itemsModellistFilter = ArrayList<WordList>();
     fun setWord(itemsModellist: ArrayList<WordList>){
         this.itemsModellist=itemsModellist
         this.itemsModellistFilter= itemsModellist;
         notifyDataSetChanged()
     }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordVH {
        return WordVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return itemsModellist.size
    }

        override fun onBindViewHolder(holder: WordVH, position: Int) {
            val itemModel = itemsModellist[position];
            holder.word.text = itemModel.word
            holder.pinyin.text = itemModel.pinyin
            holder.meaning.text = itemModel.meaning

            holder.itemView.setOnClickListener {
                clicklistener.ClickedItem(itemModel)

            }
        }


    class WordVH(itemview: View) : RecyclerView.ViewHolder(itemview) {
          val word = itemview.list1
          val pinyin = itemview.list2
          val meaning = itemview.list3
    }
    interface Clicklistener{
        fun ClickedItem(wordList: WordList)
    }

    override fun getFilter(): Filter {
        return object :Filter(){
            override fun performFiltering(charsequense: CharSequence?): FilterResults {

                val filterResults = FilterResults();
                if (charsequense == null ||	charsequense.length < 0){
                    filterResults.count = itemsModellistFilter.size
                    filterResults.values = itemsModellistFilter
                }else{

                   var searchChr = charsequense.toString().toLowerCase()
                    val wordList = ArrayList<WordList>()
                    for (item in itemsModellistFilter){
                        if (item.meaning.contains(searchChr) || item.pinyin.contains(searchChr)
                            || item.word.contains(searchChr)){
                            wordList.add(item)
                        }
                    }
                    filterResults.count = wordList.size
                    filterResults.values=wordList
                }
                         return filterResults;
            }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
                itemsModellist = filterResults!!.values as ArrayList<WordList>
                notifyDataSetChanged()
            }

        }
    }
}
