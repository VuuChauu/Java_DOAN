package quanlycuahang.BUS;

import quanlycuahang.DAO.KhachHangDAO;
import quanlycuahang.DTO.KhachHangDTO;
import java.util.ArrayList;

public class KhachHangBUS {

    private final KhachHangDAO khDAO = new KhachHangDAO();
    public ArrayList<KhachHangDTO> listKhachHang = new ArrayList<>();

    public KhachHangBUS() {
        listKhachHang = khDAO.selectAll();
    }
    // trả về danh sách
    public ArrayList<KhachHangDTO> getAll() {
        return this.listKhachHang;
    }
    // lấy khách hàng chỉ mục
    public KhachHangDTO getByIndex(int index) {
        return this.listKhachHang.get(index);
    }
    //chỉ mục của một khách hàng dựa trên mã khách hàng
    public int getIndexByMaDV(int idKH) {
            for (int i = 0; i < this.listKhachHang.size(); i++) {
                if (listKhachHang.get(i).getIdKhachHang() == idKH) {
                    return i;
                }
            }
            return -1;
    }
    // thêm khách hàng
    public Boolean add(KhachHangDTO kh) {
        boolean check = khDAO.insert(kh) != 0;
        if (check) {
            this.listKhachHang.add(kh);
        }
        return check;
    }
    // xóa một khách hàng
    public boolean delete(KhachHangDTO kh) {
        int index = getIndexByMaDV(kh.getIdKhachHang());
        if (index != -1) {
            boolean check = khDAO.delete(kh.getIdKhachHang()) != 0;
            if (check) {
                this.listKhachHang.remove(index);
            }
            return check;
        }
        return false;
    }
    // cập nhâp lại
    public boolean update(KhachHangDTO kh) {
        int index = getIndexByMaDV(kh.getIdKhachHang());
        if (index != -1) {
            boolean check = khDAO.update(kh) != 0;
            if (check) {
                this.listKhachHang.set(index, kh);
            }
            return check;
        }
        return false;
    }
    //tìm kiếm khách hàng dựa trên một từ khóa và loại tìm kiếm được chỉ định
    public ArrayList<KhachHangDTO> search(String text, String type) {
        ArrayList<KhachHangDTO> ketQua = new ArrayList<>();
        text = text.toLowerCase();
        switch (type) {
            case "Tất cả" -> {
                for (KhachHangDTO i : this.listKhachHang) {
                    if (Integer.toString(i.getIdKhachHang()).toLowerCase().contains(text) ||
                            i.getTenKhachHang().toLowerCase().contains(text) ||
                            i.getDiaChiKhachHang().toLowerCase().contains(text) ||
                            (Integer.toString(i.getSdtKhachHang())).toLowerCase().contains(text)) {
                        ketQua.add(i);
                    }
                }
            }

            case "Mã khách hàng" -> {
                for (KhachHangDTO i : this.listKhachHang) {
                    if (Integer.toString(i.getIdKhachHang()).toLowerCase().contains(text)) {
                        ketQua.add(i);
                    }
                }
            }
            case "Tên khách hàng" -> {
                for (KhachHangDTO i : this.listKhachHang) {
                    if (i.getTenKhachHang().toLowerCase().contains(text)) {
                        ketQua.add(i);
                    }
                }
            }
            case "Địa chỉ" -> {
                for (KhachHangDTO i : this.listKhachHang) {
                    if (i.getDiaChiKhachHang().toLowerCase().contains(text)) {
                        ketQua.add(i);
                    }
                }
            }
            case "Số điện thoại" -> {
                for (KhachHangDTO i : this.listKhachHang) {
                    if (Integer.toString(i.getSdtKhachHang()).toLowerCase().contains(text)) {
                        ketQua.add(i);
                    }
                }
            }
        }
        return ketQua;
    }

    public String getTenKhachHang(int idKH) {
        String name = "";
        for (KhachHangDTO khachHangDTO : listKhachHang) {
            if (khachHangDTO.getIdKhachHang() == idKH) {
                name = khachHangDTO.getTenKhachHang();
            }
        }
        return name;
    }

    public KhachHangDTO selectKh(int idKH) {
        return khDAO.selectById(Integer.parseInt(idKH+ ""));
    }


}
