package quanlycuahang.DTO;

import java.util.Objects;

public class ChiTietPhieuXuatDTO extends ChiTietPhieuDTO{
    private int idPhieuXuat;
    public ChiTietPhieuXuatDTO(){}
    public ChiTietPhieuXuatDTO(int idPhieuXuat, int soLuong, int idSanPham) {
        super(soLuong, idSanPham);
        this.idPhieuXuat = idPhieuXuat;
    }

    public void setIdPhieuXuat(int idPhieuXuat) {
        this.idPhieuXuat = idPhieuXuat;
    }

    public int getIdPhieuXuat() {
        return idPhieuXuat;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuXuatDTO{" +
                "idPhieuXuat=" + idPhieuXuat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietPhieuXuatDTO that)) return false;
        if (!super.equals(o)) return false;
        return idPhieuXuat == that.idPhieuXuat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idPhieuXuat);
    }
}
