package com.sistemas51.horarioslavalle

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sistemas51.horarioslavalle.adapters.DashboardAdapter
import com.sistemas51.horarioslavalle.databinding.StepperMainBinding
import com.sistemas51.horarioslavalle.models.SavedTrips
import com.sistemas51.horarioslavalle.repository.CommonObject
import com.sistemas51.horarioslavalle.resource.Status
import com.sistemas51.horarioslavalle.viewModels.MainActivityViewModel
import org.json.JSONException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var special = false
    private lateinit var sharedPreferences: SharedPreferences
    private var drawerLayout: DrawerLayout? = null
    private var dashboardAdapter: DashboardAdapter? = null
    var savedTrips: List<SavedTrips>? = null

    val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        try {

        super.onCreate(savedInstanceState)
        val binding = StepperMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.requestHours()
        sharedPreferences = getSharedPreferences("preferences", MODE_PRIVATE)
        val view = window.decorView.findViewById<View>(android.R.id.content)

        special = sharedPreferences.getBoolean("special", false)

        val toolbar = binding.toolbarStep
        val recyclerView = binding.dashboardRv
        setSupportActionBar(binding.toolbarStep)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.elevation = 10f
        }
        toolbar.bringToFront()
        drawerLayout = binding.drawerLayout
        val navigationView = binding.navigationView
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        dashboardAdapter = null
        try {
            savedTrips = SavedTrips.getSavedTrips(sharedPreferences)
            dashboardAdapter = DashboardAdapter(savedTrips as MutableList<SavedTrips>, applicationContext){
                viewModel.requestHours()
            }
        } catch (e: JSONException) {
            Log.e(javaClass.simpleName, e.message!!)
        }
        dashboardAdapter?.notifyDataSetChanged()
        recyclerView.setAdapter(dashboardAdapter)


        viewModel.liveData.observe(this) {

            when (it.status) {
                Status.LOADING -> {
                    Snackbar.make(binding.root, "Descargando Horarios", Snackbar.LENGTH_SHORT)
                        .show()
                }

                Status.ERROR -> {
                    Snackbar.make(
                        binding.root,
                        "Hubo un error al Descargar Horarios, causa:".plus(it.messageError),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                Status.SUCCESS -> {
                    CommonObject.database = it.data
                    val editor = sharedPreferences.edit()
                    editor.putString("database", it.data)
                    editor.apply()
                    Snackbar.make(binding.root, "Horarios Actualizados", Snackbar.LENGTH_SHORT)
                        .show()

                }

                else -> {}
            }
        }
        }catch (e:Exception ){
            Log.e("TAG", "onCreateView", e);
            throw e
        }
    }

    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {
            drawerLayout?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout)
    }

    override fun onPause() {
        super.onPause()
        if (drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {
            drawerLayout?.closeDrawer(GravityCompat.START)
        }
    }

    override fun onResume() {
        super.onResume()
        try {
            savedTrips = SavedTrips.getSavedTrips(sharedPreferences)
            dashboardAdapter?.setModels(savedTrips as MutableList<SavedTrips>)
            dashboardAdapter?.notifyDataSetChanged()
        } catch (e: JSONException) {
            Log.e(javaClass.simpleName, e.message!!)
        }
    }
}