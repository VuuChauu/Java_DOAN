package quanlycuahang.BUS;

import quanlycuahang.DAO.ChiTietPhieuXuatDAO;
import quanlycuahang.DAO.PhieuXuatDAO;
import quanlycuahang.DTO.ChiTietPhieuXuatDTO;
import quanlycuahang.DTO.PhieuXuatDTO;

import java.util.ArrayList;

public class PhieuXuatBUS {

    private final PhieuXuatDAO phieuXuatDAO = PhieuXuatDAO.getInstance();
    private final ChiTietPhieuXuatDAO chiTietPhieuXuatDAO = ChiTietPhieuXuatDAO.getInstance();
    private ArrayList<PhieuXuatDTO> listPhieuXuat;
    public PhieuXuatBUS(){}
    public PhieuXuatBUS(ArrayList<PhieuXuatDTO> listPhieuXuat) {
        this.listPhieuXuat = listPhieuXuat;
    }

    public ArrayList<PhieuXuatDTO> getAll() {
        return this.listPhieuXuat;
    }

    public PhieuXuatDTO getSelect(int index) {
        return listPhieuXuat.get(index);
    }

    public void remove(int px) {
        listPhieuXuat.remove(px);
    }

    public void insert(PhieuXuatDTO px, ArrayList<ChiTietPhieuXuatDTO> ct) {
        phieuXuatDAO.insert(px);
        chiTietPhieuXuatDAO.insert(ct);
    }

    public ArrayList<ChiTietPhieuXuatDTO> selectCTPX(int idPhieuXuat) {
        return chiTietPhieuXuatDAO.selectAll(Integer.toString(idPhieuXuat));
    }
    public int getQuantity(ArrayList<ChiTietPhieuXuatDTO> ctphieunhap) {
        int quantity = 0;
        for (ChiTietPhieuXuatDTO item : ctphieunhap) {
            quantity += item.getSoLuong();
        }
        return quantity;
    }

}