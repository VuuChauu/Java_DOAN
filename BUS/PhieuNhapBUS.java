package quanlycuahang.BUS;


import quanlycuahang.DAO.ChiTietPhieuNhapDAO;
import quanlycuahang.DAO.PhieuNhapDAO;
import quanlycuahang.DTO.ChiTietPhieuDTO;
import quanlycuahang.DTO.ChiTietPhieuNhapDTO;
import quanlycuahang.DTO.PhieuNhapDTO;

import java.util.ArrayList;


public class PhieuNhapBUS {

    public final PhieuNhapDAO phieunhapDAO = new PhieuNhapDAO();
    public final ChiTietPhieuNhapDAO ctPhieuNhapDAO = new ChiTietPhieuNhapDAO();
//    NhanVienBUS nvBUS = new NhanVienBUS();


    ArrayList<PhieuNhapDTO> listPhieuNhap;

    public PhieuNhapBUS() {
        this.listPhieuNhap = phieunhapDAO.selectAll();
    }

    public ArrayList<PhieuNhapDTO> getAll() {
        return this.listPhieuNhap;
    }

    public ArrayList<PhieuNhapDTO> getAllList() {
        return this.listPhieuNhap;
    }

    public ArrayList<ChiTietPhieuNhapDTO> getChiTietPhieuNhap(int idPhieuNhap) {
        return ctPhieuNhapDAO.selectAll(Integer.toString(idPhieuNhap));
    }

    public ArrayList<ChiTietPhieuDTO> getChiTietPhieu_Type(int idPhieuNhap) {
        ArrayList<ChiTietPhieuNhapDTO> arr = ctPhieuNhapDAO.selectAll(Integer.toString(idPhieuNhap));
        ArrayList<ChiTietPhieuDTO> ketQua = new ArrayList<>();
        for (ChiTietPhieuDTO i : arr) {
            ketQua.add(i);
        }
        return ketQua;
    }

    public ChiTietPhieuNhapDTO findCT(ArrayList<ChiTietPhieuNhapDTO> ctphieunhap, int idSanPham) {
        ChiTietPhieuNhapDTO p = null;
        int i = 0;
        while (i < ctphieunhap.size() && p == null) {
            if (ctphieunhap.get(i).getIdSanPham() == idSanPham) {
                p = ctphieunhap.get(i);
            } else {
                i++;
            }
        }
        return p;
    }

    public long getTongTien(ArrayList<ChiTietPhieuNhapDTO> ctphieunhap) {
        long ketQua = 0;
        for (ChiTietPhieuNhapDTO item : ctphieunhap) {
            ketQua += item.getDonGia() * item.getSoLuong();
        }
        return ketQua;
    }
    public int getQuantity(ArrayList<ChiTietPhieuNhapDTO> ctphieunhap) {
        int quantity = 0;
        for (ChiTietPhieuNhapDTO item : ctphieunhap) {
            quantity += item.getSoLuong();
        }
        return quantity;
    }


}