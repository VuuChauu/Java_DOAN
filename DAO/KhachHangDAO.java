package quanlycuahang.DAO;

import quanlycuahang.DTO.KhachHangDTO;
import quanlycuahang.JBDCUtil.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangDAO implements DAOinterface<KhachHangDTO> {
    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }
    @Override
    public int insert(KhachHangDTO t){
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO khachhang(idKH, tenKH, diaChi, sdt) VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getIdKhachHang());
            pst.setString(2, t.getTenKhachHang());
            pst.setString(3, t.getDiaChiKhachHang());
            pst.setInt(4, t.getSdtKhachHang());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ketqua;
    }
    @Override
    public int update(KhachHangDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE khachhang SET idKH = ?, tenKH = ?, diaChi = ?, sdt = ? WHERE idKH = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getIdKhachHang());
            pst.setString(2, t.getTenKhachHang());
            pst.setString(3, t.getDiaChiKhachHang());
            pst.setInt(4, t.getSdtKhachHang());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ketqua;
    }
    @Override
    public int delete(int idKhachHang) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM khachhang WHERE idKH = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idKhachHang);
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ketqua;
    }
    @Override
    public ArrayList<KhachHangDTO> selectAll() {
        ArrayList<KhachHangDTO> khachHangList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KhachHangDTO khachHang = new KhachHangDTO(
                        rs.getInt("idKH"),
                        rs.getString("tenKH"),
                        rs.getString("diaChi"),
                        rs.getInt("sdt")
                );
                khachHangList.add(khachHang);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return khachHangList;
    }
    public ArrayList<KhachHangDTO> selectByCondition(String dieuKien) {
        ArrayList<KhachHangDTO> khachHangList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachang WHERE " + dieuKien;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KhachHangDTO khachHang = new KhachHangDTO(
                        rs.getInt("idKH"),
                        rs.getString("tenKH"),
                        rs.getString("diaChi"),
                        rs.getInt("sdt")
                );
                khachHangList.add(khachHang);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return khachHangList;
    }

    @Override
    public KhachHangDTO selectById(int chonIdKhachHang) {
        KhachHangDTO khachHang = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE idKH = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, chonIdKhachHang);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                khachHang = new KhachHangDTO(
                        rs.getInt("idKH"),
                        rs.getString("tenKH"),
                        rs.getString("diaChi"),
                        rs.getInt("sdt")
                );
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return khachHang;
    }
}

