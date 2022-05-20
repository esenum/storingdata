package com.umutesen.storingdata

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.umutesen.storingdata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences:SharedPreferences
    var ageFromPreferences:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPreferences Initialize
         sharedPreferences = this.getSharedPreferences("com.umutesen.storingdata", Context.MODE_PRIVATE)

        ageFromPreferences=sharedPreferences.getInt("age",-1)

        if(ageFromPreferences==-1){
            binding.textView2.text="Your Age: "
        } else{
            binding.textView2.text="Your Age: $ageFromPreferences"
        }

    }
    fun save(view: View){

        val myAge= binding.editText.text.toString().toIntOrNull()

        if(myAge !=null){
         binding.textView2.text="Your Age: " + myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
    }
    fun delete(view:View){
        ageFromPreferences=sharedPreferences.getInt("age",-1)
        if(ageFromPreferences!=-1){
            sharedPreferences.edit().remove("age")
            binding.textView2.text="Your Age: "
        }
    }

}