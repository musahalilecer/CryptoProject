package com.musahalilecer.cryptoproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.musahalilecer.cryptoproject.adapter.CryptoAdapter
import com.musahalilecer.cryptoproject.adapter.RecyclerViewAdapter
import com.musahalilecer.cryptoproject.databinding.ActivityMainBinding
import com.musahalilecer.cryptoproject.model.CryptoModel
import com.musahalilecer.cryptoproject.service.CryptoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
//import kotlinx.android.synthetic.main.activity_main.recyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.Listener {
    private lateinit var binding: ActivityMainBinding
    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var cryptoModels: ArrayList<CryptoModel>? = null
    private var cryptoAdapter: RecyclerViewAdapter? = null
    private var compositeDisposable: CompositeDisposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerViewRow.layoutManager = layoutManager

        loadData()

    }
    private fun loadData(){


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(CryptoAPI::class.java)

        compositeDisposable?.add(retrofit.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))

    //    val service = retrofit.create(CryptoAPI::class.java)

    //    val call = service.getData()



    /*    compositeDisposable = CompositeDisposable()

        val disposable = service.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    // Handle successful response here
                    response?.let {
                        cryptoModels = ArrayList(it)
                        for (cryptoModel: CryptoModel in cryptoModels!!) {
                            println(cryptoModel.currency)
                            println(cryptoModel.price)
                        }
                    }
                },
                { t ->
                    // Handle error here
                    t.printStackTrace()
                }
            )

        compositeDisposable?.add(disposable)

     */

        }

    private fun handleResponse(cryptoList : List<CryptoModel>){
        cryptoModels = ArrayList(cryptoList)

        cryptoModels?.let {
            cryptoAdapter = RecyclerViewAdapter(it,this@MainActivity)
            binding.recyclerViewRow.adapter = cryptoAdapter
        }
    }

    override fun onItemClick(cryptoModel: CryptoModel) {
        Toast.makeText(this,"Clicked : ${cryptoModel.currency}",Toast.LENGTH_LONG ).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable?.clear()
    }
}


