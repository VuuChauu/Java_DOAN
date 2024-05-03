package quanlycuahang.DTO;

import java.util.Objects;

public class KhachHangDTO {
    private int idKhachHang;
    private String tenKhachHang;
    private String diaChiKhachHang;
    private int sdtKhachHang;
    public KhachHangDTO(){}
    public KhachHangDTO(int idKhachHang, String tenKhachHang, String diaChiKhachHang, int sdtKhachHang){
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diaChiKhachHang = diaChiKhachHang;
        this.sdtKhachHang = sdtKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setDiaChiKhachHang(String diaChiKhachHang) {
        this.diaChiKhachHang = diaChiKhachHang;
    }

    public String getDiaChiKhachHang() {
        return diaChiKhachHang;
    }

    public void setSdtKhachHang(int sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }

    public int getSdtKhachHang() {
        return sdtKhachHang;
    }


    @Override
    public String toString() {
        return "KhachHangDTO{" +
                "idKhachHang=" + idKhachHang +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", diaChiKhachHang='" + diaChiKhachHang + '\'' +
                ", sdtKhachHang=" + sdtKhachHang +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KhachHangDTO that)) return false;
        return idKhachHang == that.idKhachHang && sdtKhachHang == that.sdtKhachHang && Objects.equals(tenKhachHang, that.tenKhachHang) && Objects.equals(diaChiKhachHang, that.diaChiKhachHang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKhachHang, tenKhachHang,diaChiKhachHang, sdtKhachHang);
    }
}
