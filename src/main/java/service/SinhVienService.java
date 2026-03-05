package service;

import entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    public List<SinhVien> sinhVienList = new ArrayList<>();

    public List<SinhVien> getAll(){
        return sinhVienList;
    }

    public String addSV(SinhVien sv){
        if(sv.getMaSV() == null){
            return "không được để trống";
        }
        sinhVienList.add(sv);
        return "thêm thành công";
    }

    public void delete (String maSV){
        sinhVienList.removeIf(sv -> sv.getMaSV().equals(maSV));
    }

    public void update (SinhVien svm , String maSV){
        for(SinhVien sv : sinhVienList){
            if(sv.getMaSV().equals(maSV)){
                sv.setTen(svm.getTen());
                sv.setTuoi(svm.getTuoi());
                sv.setDiemTrungBinh(svm.getDiemTrungBinh());
                sv.setKyHoc(svm.getKyHoc());
                sv.setChuyenNganh(svm.getChuyenNganh());
            }
        }
    }

    public SinhVien findBymaSV(String maSV){
        for(SinhVien sv : sinhVienList){
            if(sv.getMaSV().equals(maSV)){
                return sv;
            }
        }
        return null;
    }
}

