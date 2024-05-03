package quanlycuahang.DAO;

import quanlycuahang.DTO.ChiTietPhieuXuatDTO;
import quanlycuahang.JBDCUtil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietPhieuXuatDAO implements ChiTietInterface<ChiTietPhieuXuatDTO> {
    public static ChiTietPhieuXuatDAO getInstance() {
        return new ChiTietPhieuXuatDAO();
    }
    @Override
    public int insert(ArrayList<ChiTietPhieuXuatDTO> t) {
        int ketQua= 0;
        for (int i = 0; i < t.size(); i++) {
            try {
                Connection con =  JDBCUtil.getConnection();
                String sql = "INSERT INTO ctphieuxuatkho (soLuong, PHIEUXUATKHO_idPhieuXuat, SANPHAM_idSP) VALUES (?,?,?)";
                PreparedStatement pst =  con.prepareStatement(sql);
                pst.setInt(1, t.get(i).getSoLuong());
                pst.setInt(2, t.get(i).getIdPhieuXuat());
                pst.setInt(3, t.get(i).getIdSanPham());
                ketQua = pst.executeUpdate();
                JDBCUtil.closeConnection(con);
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ketQua;
    }
    public int delete(String idPhieuXuat) {
        int ketQua = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "DELETE FROM ctphieuxuatkho WHERE PHIEUXUATKHO_idPhieuXuat = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, idPhieuXuat);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int update(ArrayList<ChiTietPhieuXuatDTO> t, String pk) {
        int ketQua = this.delete(pk);
        if (ketQua != 0) {
            ketQua = this.insert(t);
        }
        return ketQua;
    }

    @Override
    public ArrayList<ChiTietPhieuXuatDTO> selectAll(String t) {
        ArrayList<ChiTietPhieuXuatDTO> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ctphieuxuatkho WHERE PHIEUXUATKHO_idPhieuXuat = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int soLuong = rs.getInt("soLuong");
                int idPhieuXuat = rs.getInt("PHIEUXUATKHO_idPhieuXuat");
                int idSanPham = rs.getInt("SANPHAM_idSP");
                ChiTietPhieuXuatDTO ctphieu = new ChiTietPhieuXuatDTO(idPhieuXuat, soLuong, idSanPham);
                ketQua.add(ctphieu);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ketQua;
    }
    @Override
    public ChiTietPhieuXuatDTO selectById(int idPhieuXuat) {
        ChiTietPhieuXuatDTO ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ctphieuxuatkho WHERE PHIEUXUATKHO_idPhieuXuat = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idPhieuXuat);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int soLuong = rs.getInt("soLuong");
                int idSanPham = rs.getInt("SANPHAM_idSP");
                ketQua = new ChiTietPhieuXuatDTO(idPhieuXuat, soLuong, idSanPham);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
}
