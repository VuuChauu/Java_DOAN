package quanlycuahang.DAO;

import quanlycuahang.DTO.PhieuXuatDTO;
import quanlycuahang.JBDCUtil.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

public class PhieuXuatDAO implements DAOinterface<PhieuXuatDTO>{
    public static PhieuXuatDAO getInstance(){
        return new PhieuXuatDAO();
    }
    @Override
    public int insert(PhieuXuatDTO pxDTO) {
        int ketQua = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "INSERT INTO phieuxuatkho (idPhieuXuat, thoiGian, tongTien, NHANVIEN_idNV) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, pxDTO.getIdPhieuXuat());
            pst.setDate(2, (Date) pxDTO.getThoiGian());
            pst.setDouble(3, pxDTO.getTongTien());
            pst.setInt(4, pxDTO.getIdNhanVien());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int update(PhieuXuatDTO pxDTO) {
        int ketQua = 0 ;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "UPDATE phieuxuatkho SET idPhieuXuat = ?, thoiGian = ?, tongTien = ?, NHANVIEN_idNV = ? WHERE idPhieuXuat = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, pxDTO.getIdPhieuXuat());
            pst.setDate(2, (Date) pxDTO.getThoiGian());
            pst.setDouble(3, pxDTO.getTongTien());
            pst.setInt(4, pxDTO.getIdNhanVien());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int delete(int t) {
        int ketQua = 0 ;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "DELETE FROM phieuxuatkho WHERE idPhieuXuat = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public ArrayList<PhieuXuatDTO> selectAll() {
            ArrayList<PhieuXuatDTO> result = new ArrayList<>();
            try {
                Connection con = (Connection) JDBCUtil.getConnection();
                String sql = "SELECT * FROM phieuxuatkho ORDER BY idPhieuXuat DESC";
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = (ResultSet) pst.executeQuery();
                while(rs.next()){
                    int idPhieuXuat = rs.getInt("idPhieuXuat");
                    Timestamp thoiGian = rs.getTimestamp("thoiGian");
                    long tongTien = rs.getLong("tongTien");
                    int idNhanVien = rs.getInt("NHANVIEN_idNV");
                    PhieuXuatDTO phieuxuat = new PhieuXuatDTO(idPhieuXuat, thoiGian, tongTien, idNhanVien);
                    result.add(phieuxuat);
                }
                JDBCUtil.closeConnection(con);
            } catch (SQLException e) {
                System.out.println(e);
            }
            return result;
    }

    @Override
    public PhieuXuatDTO selectById(int t) {
            PhieuXuatDTO result = null;
            try {
                Connection con = (Connection) JDBCUtil.getConnection();
                String sql = "SELECT * FROM phieuxuatkho WHERE idPhieuXuat = ?";
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                pst.setInt(1, t);
                ResultSet rs = (ResultSet) pst.executeQuery();
                while(rs.next()){
                    int idPhieuXuat = rs.getInt("idPhieuXuat");
                    Timestamp thoiGian = rs.getTimestamp("thoiGian");
                    long tongTien = rs.getLong("tongTien");
                    int idNhanVien = rs.getInt("NHANVIEN_idNV");
                    result = new PhieuXuatDTO(idPhieuXuat, thoiGian, tongTien, idNhanVien);
                }
                JDBCUtil.closeConnection(con);
            } catch (Exception e) {
            }
            return result;
        }

    @Override
    public ArrayList<PhieuXuatDTO> selectByCondition(String condition) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM phieuxuatkho WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idPhieuXuat = rs.getInt("idPhieuXuat");
                Timestamp thoiGian = rs.getTimestamp("thoiGian");
                double tongTien = rs.getDouble("tongTien");
                int idNhanVien = rs.getInt("NHANVIEN_idNV");
                PhieuXuatDTO phieuxuat = new PhieuXuatDTO(idPhieuXuat, thoiGian, tongTien, idNhanVien);
                result.add(phieuxuat);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }


    public int deletePhieu(int t) {
        int result = 0 ;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "DELETE FROM phieuxuatkho WHERE idPhieuXuat = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }


}
