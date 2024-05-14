package com.dangchph33497.fpoly.lab2_md18306

fun addThongTinSinhVien(listSV: MutableList<SinhVienModel>){
    var tenSv :String?
    var mssv : String?
    var diemTB : Float?
    var tuoi : Int?
    var daTotNghiep : Boolean? = null
    var choice :String?
    println("Thêm Thông Tin Sinh Viên")
    println("------------------------")
    println("Nhập Tên Sinh Viên")
    tenSv = readlnOrNull()
    println("Nhập Mã Sinh Viên")
    mssv = readlnOrNull()
    println("Nhập Điểm Trung Bình")
    diemTB = readLine()!!.toFloatOrNull()
    println("Nhập Tuổi")
    tuoi = readLine()!!.toIntOrNull()
    println("Nhập Đã Tốt Nghiệp(c/k)")
    choice = readLine()

    if (mssv != null && checkMssv(listSV, mssv)) {
        println("Mã Sinh Viên đã tồn tại. Vui lòng nhập mã khác.")
        return
    }
    if(choice.equals("c",true)){
        daTotNghiep = true
    }else if(choice.equals("k",true)){
        daTotNghiep = false
    }else {
        println("Nhập sai")
    }
    if(diemTB == null || tuoi == null){
        println("Nhập sai")
        return
    }
    val ThemSinhVien = SinhVienModel(tenSv!!,mssv!!,diemTB!!,daTotNghiep!!,tuoi!!)
    listSV.add(ThemSinhVien)
    getThongTinSinhVien(listSV)
}
fun checkMssv(listSV: MutableList<SinhVienModel>, mssv: String): Boolean {
    for (sv in listSV) {
        if (sv.mssv == mssv) {
            return true
        }
    }
    return false
}

fun getThongTinSinhVien(listSV: MutableList<SinhVienModel>){
    if (listSV.isEmpty()) {
        println("Danh sách sinh viên rỗng")
        return
    }
    for (i in listSV.indices){
        println("Thông Tin $i : ${listSV.get(i).getThongTin()} ")
    }
}
fun deleteThongTinSinhVien(listSV: MutableList<SinhVienModel>){
    var mssv : String?
    println("Xóa Thông Tin Sinh Viên")
    println("------------------------")
    println("Nhập Mã Sinh Viên Cần Xóa")
    mssv = readLine().toString()
    for (i in listSV.indices) {
        if (listSV[i].mssv == mssv) {
            listSV.removeAt(i)
            println("Xóa sinh viên với MSSV $mssv thành công")
            return
        }
    }
    println("Sinh viên với MSSV $mssv không tồn tại")
}

fun format(mssv: String?, tenSv: String?, diemTB: Float?, daTotNghiep: Boolean?, tuoi: Int?) = "MSSV: $mssv, Tên: $tenSv, Điểm TB: $diemTB, Đã tốt nghiệp: $daTotNghiep, Tuổi: $tuoi"

fun updateThongTinSinhVien(listSV: MutableList<SinhVienModel>){
    var mssv : String?
    println("Cập nhật Thông Tin Sinh Viên")
    println("------------------------")
    println("Nhập Mã Sinh Viên Cần Cập Nhật")
    mssv = readlnOrNull().toString()

    var timKiem = false
    for (i in listSV.indices) {
        if (listSV[i].mssv == mssv) {
            println("Tìm kiếm Thành Công\n")
            println(format(listSV[i].mssv, listSV[i].tenSV, listSV[i].diemTB, listSV[i].daTotNghiep, listSV[i].tuoi))

            var tenSv :String?
            var diemTB : Float?
            var tuoi : Int?
            var daTotNghiep : Boolean? = null
            var choice :String?

            println("Nhập Tên Sinh Viên Mới (nhấn enter để bỏ qua)")
            tenSv = readlnOrNull()
            if (!tenSv.isNullOrEmpty()) {
                listSV[i].tenSV = tenSv!!
            }

            println("Nhập Điểm Trung Bình Mới (nhấn enter để bỏ qua)")
            diemTB = readLine()?.toFloatOrNull()
            if (diemTB != null ) {
                listSV[i].diemTB = diemTB
            }

            println("Nhập Tuổi Mới (nhấn enter để bỏ qua)")
            tuoi = readLine()?.toIntOrNull()
            if (tuoi != null) {
                listSV[i].tuoi = tuoi
            }

            println("Nhập Đã Tốt Nghiệp Mới (c/k, nhấn enter để bỏ qua)")
            choice = readLine()
            if (!choice.isNullOrEmpty()) {
                if (choice.equals("c", true)) {
                    daTotNghiep = true
                } else if (choice.equals("k", true)) {
                    daTotNghiep = false
                }
                listSV[i].daTotNghiep = daTotNghiep
            }

            println("Thông tin sinh viên đã được cập nhật thành công.")
            timKiem = true
            break
        }
    }
    if (!timKiem) {
        println("Không tìm thấy sinh viên với Mã Sinh Viên $mssv")
    }
}


fun signInThongTinSinhVien(listSV: MutableList<SinhVienModel>){
    var mssv : String?
    var tenSv : String?
    println("Đăng Nhập Bằng Thông Tin Sinh Viên")
    println("------------------------")
    println("Nhập Họ Tên Sinh Viên")
    tenSv = readlnOrNull().toString()
    println("Nhập Mã Sinh Viên")
    mssv = readlnOrNull().toString()
    for (i in listSV.indices) {
        if (listSV[i].mssv == mssv && listSV[i].tenSV == tenSv) {
            println("Đăng nhập thành công")
            println(format(listSV[i].mssv , listSV[i].tenSV, listSV[i].diemTB, listSV[i].daTotNghiep, listSV[i].tuoi))
        }else{
            println("Đăng Nhập Thất Bại")
        }
    }

}
fun main() {
    val listSV = mutableListOf<SinhVienModel>()

    while (true) {
        println("Mời nhập lựa chọn của bạn")
        println("0. Thoát chương trình")
        println("1. In ra danh sách")
        println("2. Thêm thông tin Sinh Viên")
        println("3. Xóa thông tin Sinh Viên")
        println("4. Sửa thông tin Sinh Viên")
        println("5. Đăng nhập ")

        val choice = readlnOrNull()?.toIntOrNull()

        when (choice) {
            1 -> {
                println("Bạn chọn in ra danh sách")
                getThongTinSinhVien(listSV)
            }
            2 -> {
                println("Bạn chọn thêm thông tin Sinh Viên")
                addThongTinSinhVien(listSV)
            }
            3 -> {
                println("Bạn chọn xóa thông tin Sinh Viên")
                deleteThongTinSinhVien(listSV)
            }
            4 -> {
                println("Bạn chọn sửa thông tin Sinh Viên")
                updateThongTinSinhVien(listSV)
            }
            5 -> {
                println("Bạn chọn đăng nhập")
                signInThongTinSinhVien(listSV)
            }
            0 -> {
                println("Thoát chương trình")
                return
            }
            else -> println("Lựa chọn $choice không hợp lệ")
        }
    }
}

class Bai4 {}