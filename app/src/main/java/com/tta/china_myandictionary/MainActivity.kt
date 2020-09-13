package com.tta.china_myandictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),WordAdapter.Clicklistener {

    val wordname = arrayOf(
        WordList("爱", "ài", "ချစ်သည်။ ကြိုက်သည် ။အချစ်"),
        WordList("八", "bā", "နံပါတ်ရှစ်။"),
        WordList("爸爸", "bàba", "အဖေ။"),
        WordList("杯子", "bēizi", "ခွက်။"),
        WordList("北京", "běijīng", "ပေကျင်းမြို့"),
        WordList("本", "běn", "အရင်းအမြစ်။စာအုပ် စသည်တို့ကိုရေတွက်သောယူနစ်။"),
        WordList("不客气", "bú kèqi", "အားမနာပါနဲ့။ ရပါတယ်။"),
        WordList("不", "bù", "မ....ဘူ:။"),
        WordList("菜", "cài", "ဟင်း"),
        WordList("茶", "chá", "လက်ဖက်ရည်"),
        WordList("吃", "chī", "စားသည်။"),
        WordList("出租车", "chūzūchē", "တက္ကစီ။"),
        WordList("打电话", "dǎ diànhuà", "ဖုန်းခေါ်သည်။"),
        WordList("大", "dà", "ကြီးသော။"),
        WordList("的", "de", "ပိုင်ဆိုင်မူကိုပြသောစကားလုံး။"),
        WordList("点", "diǎn", "အစက်။သေးသေးလေး။အချိန်နာရီကိုပြသောစကားလုံး။"),
        WordList("电脑", "diànnǎo", "ကွန်ပြူတာ။"),
        WordList("电视", "diànshì", "တီဗီ။"),
        WordList("电影", "diànyǐng", "ရုပ်ရှင်။"),
        WordList("东西", "dōngxi", "ပစ္စည်း။" ),
        WordList("都", "dōu", "အားလုံး။"),
        WordList("读", "dú", "(စာ)ဖတ်သည်။"),
        WordList("对不起", "duìbuqǐ", "စော်ရီး။စိတ်မကောင်းပါဘူး။"),
        WordList("多", "duō", "များသော။"),
        WordList("多少", "duōshao", "ဘယ်လောက်လဲ ။"),
        WordList("儿子", "érzi", "သား။"),
        WordList("二", "èr", "နံပါတ်နှစ်။"),
        WordList("饭店", "fàndiàn", "စားသောက်ဆိုင်။"),
        WordList("飞机", "fēijī", "လေယာဥ်ပျံ။"),
        WordList("分钟", "fēnzhōng", "မိနစ်။" ),
        WordList("高兴", "gāoxìng", "ပျော်ရွင်သည်။"),
        WordList("个", "ge", "လူ ပစ္စည်း စသည်ကိုရေတွက်သည့်ယူနစ်။"),
        WordList("工作", "gōngzuò", "အလုပ်။"),
        WordList("狗", "gǒu", "ခွေး။"),
        WordList("汉语", "hànyǔ", "တရုတ်ဘာသာစကား။"),
        WordList("好", "hǎo", "ကောင်းသော။"),
        WordList("号", "hào", "နံပါတ်။"),
        WordList("喝", "hē", "သောက်သည်။"),
        WordList("和", "hé", "နှင့်။ အတူ။"),
        WordList("很", "hěn", "အလွန်။" ),
        WordList("后面", "hòumian", "အနောက်ဖက်။"),
        WordList("回", "huí", "ဘယ်နှစ်ခေါက် စသည်ရေတွက်သောယူနစ်။"),
        WordList("会", "huì", "တွေ့ဆုံသည်။သိသည်။ တတ်သည်။အဖွဲ့အစည်း။"),
        WordList("几", "jǐ", "မတိကျသော အရေအတွက် တချိူ့ပို ရည်ညွှန်းသည်။ ဘယ်နှစွခုရှိလဲဟုမေးသောမေးခွန်းတွင်သုံးသည်။"),
        WordList("家", "jiā", "အိမ်။ မိသားစု။"),
        WordList("叫", "jiào", "ခေါ်သည်။ အော်ခေါ်သည်။ မှာသည်။"),
        WordList("今天", "jīntiān", "ယနေ့။"),
        WordList("九", "jiǔ", "နံပါတ်ကိုး။"),
        WordList("开", "kāi", "ဖွင့်သည်။စသည်။"),
        WordList("看", "kàn", "ကြည့်သည်။" ),

        WordList("看见", "kànjiàn", "မြင်သည်။"),
        WordList("块", "kuài", "အတုံး။ ပိုက်ဆံအရေအတွက်တွင်အနိမ့်ဆုံးအရေအတွက်။"),
        WordList("来", "lái", "လာသည်။ ရောက်သည်။ နောက်တခု။"),
        WordList("老师", "lǎoshī", "ဆရာ။"),
        WordList("了", "le", " ပြီးဆုံးကြောင်းပြသောစကားလုံး။"),
        WordList("冷", "lěng", "အေးသော။"),
        WordList("里", "lǐ", "အထဲမှာ။ တရုတ် （မိုင်）။"),
        WordList("六", "liù", "နံပါတ်ခြောက်။"),
        WordList("妈妈", "māma", "အမေ ။"),
        WordList("吗", "ma", "မေးခွန်းပြပုဒ်။" )




    )
    val itemModellist = ArrayList<WordList>()
    var wordAdapter: WordAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (items in wordname) {
            itemModellist.add(items)
        }
        wordAdapter = WordAdapter(this);
        wordAdapter!!.setWord(itemModellist);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = wordAdapter

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val menuItem = menu!!.findItem(R.id.searchview)

        val searchview = menuItem.actionView as SearchView
        searchview.maxWidth = Int.MAX_VALUE
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                wordAdapter!!.filter.filter(filterString)
                return true
            }

            override fun onQueryTextChange(filterString: String?): Boolean {
                wordAdapter!!.filter.filter(filterString)
                return true
            }

        })
        return true

    }


    override fun ClickedItem(wordList: WordList) {
        Log.e("Tag" ,wordList.word)
        when (wordList.word) {
            "爱" ->
                startActivity(Intent(this@MainActivity, DetailActivity::class.java))
            "八" ->
                startActivity(Intent(this@MainActivity, Detail1Activity::class.java))
            "爸爸" ->
                startActivity(Intent(this@MainActivity, Detail2Activity::class.java))
            "杯子" ->
                startActivity(Intent(this@MainActivity, Detail3Activity::class.java))
            "北京" ->
                startActivity(Intent(this@MainActivity, Detail4Activity::class.java))
            "本" ->
                startActivity(Intent(this@MainActivity, Detail5Activity::class.java))
            "不客气" ->
                startActivity(Intent(this@MainActivity, Detail6Activity::class.java))
            "不" ->
                startActivity(Intent(this@MainActivity, Detail7Activity::class.java))
            "菜" ->
                startActivity(Intent(this@MainActivity, Detail8Activity::class.java))
            "茶" ->
                startActivity(Intent(this@MainActivity, Detail9Activity::class.java))
            "吃" ->
                startActivity(Intent(this@MainActivity, Detail10Activity::class.java))
            "出租车" ->
                startActivity(Intent(this@MainActivity, Detail11Activity::class.java))
            "打电话" ->
                startActivity(Intent(this@MainActivity, Detail12Activity::class.java))
            "大" ->
                startActivity(Intent(this@MainActivity, Detail13Activity::class.java))
            "的" ->
                startActivity(Intent(this@MainActivity, Detail14Activity::class.java))
            "点" ->
                startActivity(Intent(this@MainActivity, Detail15Activity::class.java))
            "电脑" ->
            startActivity(Intent(this@MainActivity, Detail16Activity::class.java))
            "电视" ->
                startActivity(Intent(this@MainActivity, Detail17Activity::class.java))
            "电影" ->
                startActivity(Intent(this@MainActivity, Detail18Activity::class.java))
            "东西" ->
                startActivity(Intent(this@MainActivity, Detail19Activity::class.java))
            "都" ->
                startActivity(Intent(this@MainActivity, Detail20Activity::class.java))
            "读" ->
                startActivity(Intent(this@MainActivity, Detail21Activity::class.java))
            "对不起" ->
                startActivity(Intent(this@MainActivity, Detail22Activity::class.java))
            "多" ->
                startActivity(Intent(this@MainActivity, Detail23Activity::class.java))
            "多少" ->
                startActivity(Intent(this@MainActivity, Detail24Activity::class.java))
            "儿子" ->
                startActivity(Intent(this@MainActivity, Detail25Activity::class.java))
            "二" ->
                startActivity(Intent(this@MainActivity, Detail26Activity::class.java))
            "饭店" ->
                startActivity(Intent(this@MainActivity, Detail27Activity::class.java))
            "飞机" ->
                startActivity(Intent(this@MainActivity, Detail28Activity::class.java))
            "分钟" ->
                startActivity(Intent(this@MainActivity, Detail29Activity::class.java))
            "高兴" ->
                startActivity(Intent(this@MainActivity, Detail30Activity::class.java))
            "个" ->
                startActivity(Intent(this@MainActivity, Detail31Activity::class.java))
            "工作" ->
                startActivity(Intent(this@MainActivity, Detail32Activity::class.java))
            "狗" ->
                startActivity(Intent(this@MainActivity, Detail33Activity::class.java))
            "汉语" ->
                startActivity(Intent(this@MainActivity, Detail34Activity::class.java))
            "好" ->
                startActivity(Intent(this@MainActivity, Detail35Activity::class.java))
            "号" ->
                startActivity(Intent(this@MainActivity, Detail36Activity::class.java))
            "喝" ->
                startActivity(Intent(this@MainActivity, Detail37Activity::class.java))
            "和" ->
                startActivity(Intent(this@MainActivity, Detail38Activity::class.java))
            "很" ->
                startActivity(Intent(this@MainActivity, Detail39Activity::class.java))
            "后面" ->
                startActivity(Intent(this@MainActivity, Detail40Activity::class.java))
            "回" ->
                startActivity(Intent(this@MainActivity, Detail41Activity::class.java))
            "会" ->
                startActivity(Intent(this@MainActivity, Detail42Activity::class.java))
            "几" ->
                startActivity(Intent(this@MainActivity, Detail43Activity::class.java))
            "家" ->
                startActivity(Intent(this@MainActivity, Detail44Activity::class.java))
            "叫" ->
                startActivity(Intent(this@MainActivity, Detail45Activity::class.java))
            "今天" ->
                startActivity(Intent(this@MainActivity, Detail46Activity::class.java))
            "九" ->
                startActivity(Intent(this@MainActivity, Detail47Activity::class.java))
            "开" ->
                startActivity(Intent(this@MainActivity, Detail48Activity::class.java))
            "看" ->
                startActivity(Intent(this@MainActivity, Detail49Activity::class.java))

            "看见" ->
                startActivity(Intent(this@MainActivity, Detail50Activity::class.java))
            "块" ->
                startActivity(Intent(this@MainActivity, Detail51Activity::class.java))
            "来" ->
                startActivity(Intent(this@MainActivity, Detail52Activity::class.java))
            "老师" ->
                startActivity(Intent(this@MainActivity, Detail53Activity::class.java))
            "了" ->
                startActivity(Intent(this@MainActivity, Detail54Activity::class.java))
            "冷" ->
                startActivity(Intent(this@MainActivity, Detail55Activity::class.java))
            "里" ->
                startActivity(Intent(this@MainActivity, Detail56Activity::class.java))
            "六" ->
                startActivity(Intent(this@MainActivity, Detail57Activity::class.java))
            "妈妈" ->
                startActivity(Intent(this@MainActivity, Detail58Activity::class.java))
            "吗" ->
                startActivity(Intent(this@MainActivity, Detail59Activity::class.java))
             else->{
                 Toast.makeText(this,"No action",Toast.LENGTH_LONG).show()
             }
        }
    }
}

