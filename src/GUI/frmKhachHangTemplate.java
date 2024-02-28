/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.KhachHang;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class frmKhachHangTemplate extends javax.swing.JPanel {

    /**
     * Creates new form frmKhachHangTemplate
     */
    private DefaultTableModel defaultTableModel;
    KhachHang kh = new KhachHang();
    ArrayList<KhachHang> listKH = new ArrayList<>();
    public frmKhachHangTemplate() {
        initComponents();
    }
        public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listKH = new ArrayList<>(); //lưu ý
            fr = new FileReader("khachhang.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    KhachHang kh = new KhachHang();
                    kh.setMaKhachHang(arr[0]);
                    kh.setHoTen(arr[1]);
                    kh.setDiaChi(arr[2]);
                    kh.setSoDienThoai(arr[3]);
                    kh.setEmail(arr[4]);
                    kh.setGioiTinh(arr[5]);
                    kh.setTrangThai(Integer.parseInt(arr[6]));
                    listKH.add(kh);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmKhachHangTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmKhachHangTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }

    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listKH.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listKH.get(i).getMaKhachHang()+ "\t";
                row = row + listKH.get(i).getHoTen() + "\t";
                row = row + listKH.get(i).getDiaChi()+ "\t";
                row = row + listKH.get(i).getSoDienThoai()+ "\t";
                row = row + listKH.get(i).getEmail()+ "\t";
                row = row + listKH.get(i).getGioiTinh() + "\t";
                row = row + listKH.get(i).getTrangThai() + "\n";
                data += row;
            }
            fw = new FileWriter("khachhang.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmKhachHangTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    private void getData(ArrayList<KhachHang> listKH) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã KH");
        defaultTableModel.addColumn("Họ tên KH");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số Điện Thoại");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Trạng Thái");

        for (KhachHang obj : listKH) {
            Vector vector = new Vector();
            vector.add(obj.getMaKhachHang());
            vector.add(obj.getHoTen());
            vector.add(obj.getDiaChi());
            vector.add(obj.getSoDienThoai());
            vector.add(obj.getEmail());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
            defaultTableModel.addRow(vector);
        }
        tbl_khachhang.setModel(defaultTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khachhang = new javax.swing.JTable();

        tbl_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_khachhang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_khachhang;
    // End of variables declaration//GEN-END:variables
}
