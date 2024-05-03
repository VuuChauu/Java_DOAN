package quanlycuahang.DAO;

import quanlycuahang.DTO.PhieuNhapDTO;
import quanlycuahang.JBDCUtil.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapDAO implements DAOinterface<PhieuNhapDTO> {
    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }
    @Override
    public int insert(PhieuNhapDTO pnDTO) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO phieunhapkho(idPhieuNhap, thoiGian, tongTien, NHANVIEN_idNV) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, pnDTO.getIdPhieuNhap());
            pst.setDate(2, (Date) pnDTO.getThoiGian());
            pst.setDouble(3, pnDTO.getTongTien());
            pst.setInt(4, pnDTO.getIdNhanVien());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }
    @Override
    public int update(PhieuNhapDTO pnDTO) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE phieunhapkho SET idPhieuNhap = ?, thoiGian = ?, tongTien = ?, NHANVIEN_idNV = ? WHERE idPhieuNhap = ?";
            PreparedStatement pst =  con.prepareStatement(sql);
            pst.setInt(1, pnDTO.getIdPhieuNhap());
            pst.setDate(2, (Date) pnDTO.getThoiGian());
            pst.setDouble(3, pnDTO.getTongTien());
            pst.setInt(4, pnDTO.getIdNhanVien());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }
    @Override
    public int delete(int t) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM phieunhapkho WHERE idPhieuNhap = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t);
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }
    @Override
    public ArrayList<PhieuNhapDTO> selectAll() {
        ArrayList<PhieuNhapDTO> ketqua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM phieunhapkho ORDER BY idPhieuNhap DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs =  pst.executeQuery();
            while (rs.next()) {
                int idPhieuNhap = rs.getInt("idPhieuNhap");
                Date thoigiantao = rs.getDate("thoiGian");
                double tongtien = rs.getDouble("tongTien");
                int idNhanVien = rs.getInt("NHANVIEN_idNV");
                PhieuNhapDTO phieunhap = new PhieuNhapDTO(idPhieuNhap,thoigiantao, tongtien, idNhanVien);
                ketqua.add(phieunhap);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
        }
        return ketqua;
    }
    @Override
    public PhieuNhapDTO selectById(int chonIdPhieuNhap) {
        PhieuNhapDTO ketqua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM phieunhapkho WHERE idPhieuNhap = ?";
            PreparedStatement pst =  con.prepareStatement(sql);
            pst.setInt(1, chonIdPhieuNhap);
            ResultSet rs =  pst.executeQuery();
            while (rs.next()) {
                int idPhieuNhap = rs.getInt("idPhieuNhap");
                Date thoiGian = rs.getDate("thoiGian");
                double tongTien = rs.getDouble("tongTien");
                int idNhanVien = rs.getInt("NHANVIEN_idNV");
                ketqua = new PhieuNhapDTO(idPhieuNhap, thoiGian, tongTien, idNhanVien);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ketqua;
    }

    @Override
    public ArrayList<PhieuNhapDTO> selectByCondition(String condition) {
        ArrayList<PhieuNhapDTO> ketqua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM phieunhapkho WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idPhieuNhap = rs.getInt("idPhieuNhap");
                Date thoiGian = rs.getDate("thoiGian");
                double tongTien = rs.getDouble("tongTien");
                int idNhanVien = rs.getInt("NHANVIEN_idNV");
                PhieuNhapDTO phieunhap = new PhieuNhapDTO(idPhieuNhap, thoiGian, tongTien, idNhanVien);
                ketqua.add(phieunhap);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ketqua;
    }


}