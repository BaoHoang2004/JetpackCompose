package com.example.asm.services

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class ViewModelApp : ViewModel(){
    private val _register = mutableStateOf<RegisterRes?>(null)
    val register: State<RegisterRes?> = _register

    fun registerViewModel(registerReq: RegisterReq) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.register(registerReq)
                Log.d("API Response", response.toString())
                _register.value = response
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    private val _login = mutableStateOf<LoginRes?>(null)
    val login: State<LoginRes?> = _login

    fun loginViewModel(loginReq: LoginReq) {
        viewModelScope.launch {
            try {
                _login.value = RetrofitInstance.api.login(loginReq)
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    private val _listCate = mutableStateOf<List<CategoryRes>>(emptyList())
    val listCate: State<List<CategoryRes>> = _listCate

    fun getCategoryViewModel() {
        viewModelScope.launch {
            try {
                _listCate.value = RetrofitInstance.api.getCategory()
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    private val _listProduct = mutableStateOf<List<ProductRes>>(emptyList())
    val listProduct: State<List<ProductRes>> = _listProduct

    fun getProductByCateIDViewModel(cateID : String?) {
        viewModelScope.launch {
            try {
                _listProduct.value = RetrofitInstance.api.getProductByCateID(cateID)
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    private val _detailProduct = mutableStateOf<ProductRes?>(null)
    val detailProduct: State<ProductRes?> = _detailProduct

    fun getProductByIDViewModel(productID : String?) {
        viewModelScope.launch {
            try {
                _detailProduct.value = RetrofitInstance.api.getProductByID(productID)
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }
}
