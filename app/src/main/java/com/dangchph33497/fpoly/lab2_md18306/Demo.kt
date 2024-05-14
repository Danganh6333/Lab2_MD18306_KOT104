package com.dangchph33497.fpoly.lab2_md18306


fun main (){
//    val tenSV : String? = "Nguyen Van Long"
//    if(tenSV != null){
//        val mssv = getThongTinSV(tenSV!!)
//        println("MSSV của $tenSV là: $mssv")
//    }
    val sv1 : SinhVienModel = SinhVienModel("Nguyen Van Long", "PH11331",9.6f)
    val sv2 : SinhVienModel = SinhVienModel("Le Tuan Anh", "PH14731",8.5f)
    sv2.daTotNghiep = false
    sv2.tuoi = 21

    println(sv1.getThongTin())

    val sv3 : SinhVienModel = SinhVienModel("Le Tuan Anh", "PH144831",5.5f,false,20)
    println(sv2.getThongTin())
    println(sv3.getThongTin())

    //Tạo và xử lý danh sách Sv
    val listSV = mutableListOf<SinhVienModel>()
    listSV.add(sv1)
    listSV.add(sv2)
    listSV.add(sv3)

    //Xóa phần tử cuối
    listSV.removeAt(listSV.size - 1)

    //Cách 1 :Duyệt Nhanh
    println("Duyệt Nhanh")
    println("-------------------------")
    for (sv in listSV){
        println(sv.getThongTin())
    }

    //Cách 2 :Duyệt có index
    println("Duyệt Có Index")
    println("-------------------------")
    for (i in listSV.indices){
        println("Thông Tin $i : ${listSV.get(i).getThongTin()} ")
    }
}
fun getThongTinSV(tenSV: String) : String? {
    when(tenSV){
        "Nguyen Van Long" -> {
            return "PH11331"
        }
        "Le Tuan Anh" -> return  "PH11412"
        else -> return null
    }
    return null
}


class Demo {
}