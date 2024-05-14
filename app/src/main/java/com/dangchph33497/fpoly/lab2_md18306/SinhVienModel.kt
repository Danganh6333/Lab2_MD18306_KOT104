package com.dangchph33497.fpoly.lab2_md18306

class SinhVienModel (var tenSV : String,var mssv:String,var diemTB: Float,
                     ){
    var daTotNghiep : Boolean? = null
    var tuoi : Int? = null

    constructor(tenSV : String,mssv:String,diemTB: Float, datotnghiep: Boolean, tuoi: Int) : this(tenSV,mssv,diemTB){
        this.daTotNghiep = datotnghiep
        this.tuoi = tuoi

    }
    fun getThongTin() : String{
        val s: String
        if(daTotNghiep != null && tuoi != null){
            s = "Tên : $tenSV, MSSV : $mssv, Điểm TB : $diemTB,Đạt : $daTotNghiep, Tuổi : $tuoi"
        }else {
            s = "Tên : $tenSV, MSSV : $mssv, Điểm TB : $diemTB"
        }
        return s
    }

    override fun toString(): String {
        return "SinhVienModel(tenSV='$tenSV', mssv='$mssv', diemTB=$diemTB, daTotNghiep=$daTotNghiep, tuoi=$tuoi)"
    }

}