/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lms;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author Indra
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookId1.getText());  
        try {
           Connection  con = DBConnection.getConnection();
           PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
           pst.setInt(1, bookId);
           ResultSet rs = pst.executeQuery();
           
           if(rs.next()){
               lbl_bookId.setText(rs.getString("book_id"));
               lbl_bookName.setText(rs.getString("book_name"));
               lbl_author.setText(rs.getString("author"));
               lbl_quantity.setText(rs.getString("quantity"));
               
           }else{
               lbl_book_error.setText("Invalid Book ID");
           }
           
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getStudentDetails(){
        int studentId = Integer.parseInt(txt_studentId.getText());  
        try {
           Connection  con = DBConnection.getConnection();
           PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
           pst.setInt(1, studentId);
           ResultSet rs = pst.executeQuery();
           
           if(rs.next()){
               tbl_studentid.setText(rs.getString("student_id"));
               tbl_studentname.setText(rs.getString("name"));
               tbl_course.setText(rs.getString("course"));
               tbl_branch.setText(rs.getString("branch"));
               
           }else{
               lbl_StudentError.setText("Invalid Student ID");
           }
           
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean issueBook(){
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_bookId1.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = tbl_studentname.getText();
        Date uIssueDate = date_issue.getDatoFecha();
        Date uDueDate = date_Due.getDatoFecha();
        
        Long issueDate = uIssueDate.getTime();
        long dueDate = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(issueDate);
        java.sql.Date sDueDate = new java.sql.Date(dueDate);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,"
                    + "issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "Pending");
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }
    
    public void UpdateBookCount(){
        int bookId = Integer.parseInt(txt_bookId1.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
            
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book count updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
                
            }else{
                JOptionPane.showMessageDialog(this, "can't update book count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isAlreadyIssued(){
        boolean isAlready = false;
        int bookId = Integer.parseInt(txt_bookId1.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con =DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAlready = true;
            }else{
                isAlready = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlready;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_book_error = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tbl_branch = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tbl_studentid = new javax.swing.JLabel();
        tbl_studentname = new javax.swing.JLabel();
        tbl_course = new javax.swing.JLabel();
        lbl_StudentError = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        date_issue = new rojeru_san.componentes.RSDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        date_Due = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_bookId1 = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("Book Details");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 390, 10));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel2.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 250, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Book Name:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Author:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Book ID:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        lbl_bookId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(0, 0, 51));
        jPanel2.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 230, 30));

        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel2.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 230, 30));

        lbl_author.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel2.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 250, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setText("Quantity:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        lbl_book_error.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_book_error.setForeground(new java.awt.Color(255, 255, 0));
        jPanel2.add(lbl_book_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 360, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jPanel5.setBackground(new java.awt.Color(0, 0, 102));
        jPanel5.setForeground(new java.awt.Color(0, 0, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel12.setText("Student Details");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jPanel7.setBackground(new java.awt.Color(204, 51, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 390, 10));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Branch:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        tbl_branch.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(tbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 250, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Name:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Course:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Student ID:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        tbl_studentid.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tbl_studentid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(tbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 230, 30));

        tbl_studentname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(tbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 190, 30));

        tbl_course.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(tbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 250, 30));

        lbl_StudentError.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_StudentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel5.add(lbl_StudentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 360, 100));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 420, 810));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel4.setText("Issue Books");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 130, -1, -1));

        jPanel9.setBackground(new java.awt.Color(204, 51, 0));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(204, 51, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 390, 10));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 390, 10));

        jPanel6.setBackground(new java.awt.Color(51, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 190, 280, 10));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Book ID:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Issue Date:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 470, -1, -1));

        date_issue.setPlaceholder("Select Issue Date");
        jPanel1.add(date_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 460, 310, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Student ID:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Due Date:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 550, -1, -1));

        date_Due.setPlaceholder("Due Date");
        jPanel1.add(date_Due, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 540, 310, -1));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(204, 51, 0));
        rSMaterialButtonRectangle3.setText(" Issue Boook");
        rSMaterialButtonRectangle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle3MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 650, 270, 60));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 51, 0)));
        txt_studentId.setPlaceholder("Enter Srudent ID");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 370, 310, -1));

        txt_bookId1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 51, 0)));
        txt_bookId1.setPlaceholder("Enter Book ID");
        txt_bookId1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookId1FocusLost(evt);
            }
        });
        jPanel1.add(txt_bookId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 300, 310, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1411, 803));

        setSize(new java.awt.Dimension(1427, 811));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonRectangle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3MouseClicked

    }//GEN-LAST:event_rSMaterialButtonRectangle3MouseClicked

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed

            if (isAlreadyIssued() == false) {
                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(this, "Book Issued Successfully");
                    UpdateBookCount();
                }else{
                    JOptionPane.showMessageDialog(this, "Can't Issude The Book");
                }
            }else{
                JOptionPane.showMessageDialog(this, "This student already has the book");
                }
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if (!txt_studentId.getText().equals("")) {
            getStudentDetails();
            
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_bookId1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookId1FocusLost
        if (!txt_bookId1.getText().equals("")) {
            getBookDetails();
            
        }

    }//GEN-LAST:event_txt_bookId1FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_Due;
    private rojeru_san.componentes.RSDateChooser date_issue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_StudentError;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_book_error;
    private javax.swing.JLabel lbl_quantity;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private javax.swing.JLabel tbl_branch;
    private javax.swing.JLabel tbl_course;
    private javax.swing.JLabel tbl_studentid;
    private javax.swing.JLabel tbl_studentname;
    private app.bolivia.swing.JCTextField txt_bookId1;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
