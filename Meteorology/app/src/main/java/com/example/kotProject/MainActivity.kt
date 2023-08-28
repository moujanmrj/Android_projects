package com.example.kotProject

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    var data: JSONObject? = null
    var spinnerO: Spinner? = null
    var spinnerC: Spinner? = null
    var ostans = arrayOf<String?>("ا-ش", "آ-غ", "ایلام", "اردبیل", "اصفهان")
    var cities1 = arrayOf<String?>("تبریز", "مرند", "هریس", "بستان آباد", "جلفا")
    var cities2 = arrayOf<String?>("ارومیه", "مهاباد", "بوکان", "بیرانشهر ", "خوی")
    var cities4 = arrayOf<String?>("اردبیل", "بارس آإد", "خلخال", " نمین", "عنبران")
    var cities3 = arrayOf<String?>("ایلام", "ایوان", "دهلران", " آبدانان", "چوار")
    var cities5 = arrayOf<String?>("اصفهان", "کاشان", "نجف اباد", "شاهین شهر ", "داران")
    var textView: TextView? = null
    var textView1: TextView? = null
    var textView2: TextView? = null
    var textView3: TextView? = null
    var textView4: TextView? = null
    var textView5: TextView? = null
    var imageView1: ImageView? = null
    var imageView2: ImageView? = null
    var imageView3: ImageView? = null
    var imageView4: ImageView? = null
    var imageView5: ImageView? = null
    var st = "null"
    var button: Button? = null
    var button1: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinnerO = findViewById(R.id.spinner)
        spinnerC = findViewById(R.id.spinner1)
        textView = findViewById(R.id.textView)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        imageView1 = findViewById(R.id.imageView)
        imageView2 = findViewById(R.id.imageView1)
        imageView3 = findViewById(R.id.imageView2)
        imageView4 = findViewById(R.id.imageView3)
        imageView5 = findViewById(R.id.imageView4)
        button = findViewById<View>(R.id.button) as Button
        button1 = findViewById<View>(R.id.button1) as Button
        button!!.setOnClickListener {
            val locationTrack = LocationTrack(this@MainActivity)
            if (locationTrack.canGetLocation()) {
                val longitude: Double = locationTrack.getLongitudee()
                lan = longitude
                val latitude: Double = locationTrack.getLatitudee()
                lot = latitude
                method = "gps"
                getJSON("gps")
                Toast.makeText(applicationContext, "Longitude:" + java.lang.Double.toString(longitude) + "\nLatitude:" + java.lang.Double.toString(latitude), Toast.LENGTH_SHORT).show()
            } else {
                locationTrack.showSettingsAlert()
            }
        }
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, ostans)
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) { // do something upon option selection
// On selecting a spinner item
                val item = parent.getItemAtPosition(position).toString()
                //textView.setText(item);
                if (position == 0) {
                    val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this@MainActivity, android.R.layout.simple_spinner_item, cities1)
                    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    ad.notifyDataSetChanged()
                    st = "0"
                } else if (position == 1) {
                    val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this@MainActivity, android.R.layout.simple_spinner_item, cities2)
                    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    ad.notifyDataSetChanged()
                    st = "1"
                } else if (position == 2) {
                    val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this@MainActivity, android.R.layout.simple_spinner_item, cities3)
                    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    ad.notifyDataSetChanged()
                    st = "2"
                }
                if (position == 3) {
                    val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this@MainActivity, android.R.layout.simple_spinner_item, cities4)
                    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    ad.notifyDataSetChanged()
                    st = "3"
                }
                if (position == 4) {
                    val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this@MainActivity, android.R.layout.simple_spinner_item, cities5)
                    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    ad.notifyDataSetChanged()
                    st = "4"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) { // can leave this empty
            }
        }
        button1!!.setOnClickListener {
            val position = st
            method = ""
            if (st == "0") {
                if (position == "0") {
                    getJSON("Tabriz")
                } else if (position == "1") {
                    getJSON("Marand")
                } else if (position == "2") {
                    getJSON("Heris")
                } else if (position == "3") {
                    getJSON("BostanAbad")
                } else if (position == "4") {
                    getJSON("BostanAbad")
                } else if (position == "5") {
                    getJSON("Jolfa")
                }
            } else if (st == "1") {
                if (position == "0") {
                    getJSON("Urmia")
                } else if (position == "1") {
                    getJSON("Mahabad")
                } else if (position == "2") {
                    getJSON("Bukan")
                } else if (position == "3") {
                    getJSON("Piranshahr")
                } else if (position == "4") {
                    getJSON("Khoy")
                }
            } else if (st == "2") {
                if (position == "0") {
                    getJSON("Ilam")
                } else if (position == "1") {
                    getJSON("Eyvan")
                } else if (position == "2") {
                    getJSON("Dehloran")
                } else if (position == "3") {
                    getJSON("Abdanan")
                } else if (position == "4") {
                    getJSON("Chovar")
                }
            } else if (st == "3") {
                if (position == "0") {
                    getJSON("Ardebil")
                } else if (position == "1") {
                    getJSON("ParsAbad")
                } else if (position == "2") {
                    getJSON("Khalkhal")
                } else if (position == "3") {
                    getJSON("Namin")
                } else if (position == "4") {
                    getJSON("Anbaran")
                }
            } else if (st == "4") {
                if (position == "0") {
                    getJSON("Isfahan")
                } else if (position == "1") {
                    getJSON("Kashan")
                } else if (position == "2") {
                    getJSON("NjafAbad")
                } else if (position == "3") {
                    getJSON("ShahinShahr")
                } else if (position == "4") {
                    getJSON("Daran")
                }
            }
        }
    }

    fun getJSON(city: String) {
        object : AsyncTask<Void?, Void?, Void?>() {
            override fun onPreExecute() {
                super.onPreExecute()
            }

            protected override fun doInBackground(vararg p0: Void?): Void? {
                try {
                    var url: URL? = null

                    url = if (method == "gps") {
                        URL("https://api.openweathermap.org/data/2.5/forecast?lat=$lot&lon=$lan&appid=12626f85fc9f4d9ec5fe0917de517e88")
                    } else {
                        URL("https://api.openweathermap.org/data/2.5/forecast?q=$city&appid=12626f85fc9f4d9ec5fe0917de517e88")
                    }
                    val connection = url.openConnection() as HttpURLConnection
                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
                    val json = StringBuffer(1024)
                    var tmp: String? = ""
                    reader.close()
                    data = JSONObject(json.toString())
                    //st=data.toString();
                    if (data!!.getInt("cod") != 200) {
                        return null
                    }
                } catch (e: Exception) {
                    textView!!.text = "امکان دریافت اطلاعات نیست"
                    return null
                }
                return null
            }

            override fun onPostExecute(Void: Void?) {
                if (data != null) {
                    try {
                        val jsonArray = data!!.getJSONArray("list")
                        val jsonObject = jsonArray[0] as JSONObject
                        val jsonArray1 = jsonObject.getJSONArray("weather")
                        val jsonObject11 = jsonArray1[0] as JSONObject
                        val date = jsonObject["dt_txt"] as String
                        textView!!.text = jsonObject11["main"].toString() + "\n" + date
                        if (jsonObject11["main"].toString() == "Clouds") imageView1!!.setImageResource(R.drawable.rawcloudy) else if (jsonObject11["main"].toString() == "Clear") imageView1!!.setImageResource(R.drawable.clear) else if (jsonObject11["main"].toString() == "Rain") imageView1!!.setImageResource(R.drawable.rainyy) else if (jsonObject11["main"].toString() == "Snow") imageView1!!.setImageResource(R.drawable.snowy2)
                        val jsonObject1 = jsonArray[8] as JSONObject
                        val jsonArray2 = jsonObject1.getJSONArray("weather")
                        val jsonObject21 = jsonArray2[0] as JSONObject
                        val date1 = jsonObject1["dt_txt"] as String
                        textView1!!.text = jsonObject21["main"].toString() + "\n" + date1
                        if (jsonObject21["main"].toString() == "Clouds") imageView2!!.setImageResource(R.drawable.rawcloudy) else if (jsonObject21["main"].toString() == "Clear") imageView2!!.setImageResource(R.drawable.clear) else if (jsonObject21["main"].toString() == "Rain") imageView2!!.setImageResource(R.drawable.rainyy) else if (jsonObject21["main"].toString() == "Snow") imageView2!!.setImageResource(R.drawable.snowy2)
                        val jsonObjec2 = jsonArray[16] as JSONObject
                        val jsonArray3 = jsonObjec2.getJSONArray("weather")
                        val jsonObject31 = jsonArray3[0] as JSONObject
                        val date2 = jsonObjec2["dt_txt"] as String
                        textView2!!.text = jsonObject31["main"].toString() + "\n" + date2
                        if (jsonObject31["main"].toString() == "Clouds") imageView3!!.setImageResource(R.drawable.rawcloudy) else if (jsonObject31["main"].toString() == "Clear") imageView3!!.setImageResource(R.drawable.clear) else if (jsonObject31["main"].toString() == "Rain") imageView3!!.setImageResource(R.drawable.rainyy) else if (jsonObject31["main"].toString() == "Snow") imageView3!!.setImageResource(R.drawable.snowy2)
                        val jsonObject3 = jsonArray[24] as JSONObject
                        val jsonArray14 = jsonObject3.getJSONArray("weather")
                        val jsonObject41 = jsonArray14[0] as JSONObject
                        val date3 = jsonObject3["dt_txt"] as String
                        textView3!!.text = jsonObject41["main"].toString() + "\n" + date3
                        if (jsonObject41["main"].toString() == "Clouds") imageView4!!.setImageResource(R.drawable.rawcloudy) else if (jsonObject41["main"].toString() == "Clear") imageView4!!.setImageResource(R.drawable.clear) else if (jsonObject41["main"].toString() == "Rain") imageView4!!.setImageResource(R.drawable.rainyy) else if (jsonObject41["main"].toString() == "Snow") imageView4!!.setImageResource(R.drawable.snowy2)
                        val jsonObject4 = jsonArray[32] as JSONObject
                        val jsonArray5 = jsonObject4.getJSONArray("weather")
                        val jsonObject51 = jsonArray5[0] as JSONObject
                        val date4 = jsonObject4["dt_txt"] as String
                        textView4!!.text = jsonObject51["main"].toString() + "\n" + date4
                        if (jsonObject51["main"].toString() == "Clouds") imageView5!!.setImageResource(R.drawable.rawcloudy) else if (jsonObject51["main"].toString() == "Clear") imageView5!!.setImageResource(R.drawable.clear) else if (jsonObject51["main"].toString() == "Rain") imageView5!!.setImageResource(R.drawable.rainyy) else if (jsonObject51["main"].toString() == "Snow") imageView5!!.setImageResource(R.drawable.snowy2)
                        //  }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    //Log.d("my weather received",data.toString());
                }
            }
        }.execute()
    }

    companion object {
        const val RequestPermissionCode = 1
        var method = ""
        var lan = 0.0
        var lot = 0.0
    }
}