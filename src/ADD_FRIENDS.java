
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yash Purohit
 */
public class ADD_FRIENDS extends javax.swing.JFrame {

    /**
     * Creates new form ADD_FRIENDS
     */
    public ADD_FRIENDS() {
        initComponents();
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
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel4.setText("FRIEND PROFILE ID");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 170, 233, 28);

        jTextField4.setColumns(10);
        jTextField4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jTextField4.setToolTipText("");
        jPanel1.add(jTextField4);
        jTextField4.setBounds(480, 180, 186, 34);

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setText("Send Friend Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(303, 378, 200, 31);

        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(75, 427, 81, 31);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ALL PAGES.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 10, 970, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String a,b,c,d;
        LOGIN_SIGNUP x= new LOGIN_SIGNUP();
        a=x.a;
       // b=jTextField2.getText();
       // c=jTextField3.getText();
        d=jTextField4.getText();
        int flag =0;
        int flag1=0;
        if(a.isEmpty()||d.isEmpty())
           // b.isEmpty()||c.isEmpty()||
        {
        flag=1;
        }
        try {String sql;
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orkut","root","manager");
            Statement stmt=con.createStatement();
            
            
             String sql1="select * from log where PROFILE_ID= '"+a+"' AND PROFILE_ID1= '"+d+"' ";
             ResultSet rst=  stmt.executeQuery(sql1);
             if(rst.next())
             {
                 flag1=1;
             }
              String sql2="select * from friends where User_ID= '"+a+"' AND Profile_ID= '"+d+"' ";
             ResultSet rst1=  stmt.executeQuery(sql2);
             if(rst1.next())
             {
                 flag1=2;
             } 
              String sql3="select * from log where PROFILE_ID= '"+d+"' AND PROFILE_ID1=  '"+a+"'  ";
             ResultSet rst2=  stmt.executeQuery(sql3);
             if(rst2.next())
             {
                 flag1=3;
             }
            sql="insert into log values('"+a+"','"+d+"',NULL)";
           // ,'"+b+"','"+c+"'
            if((flag==0)&&(flag1==0))
            {
            stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Friend Request Sent");
            }
            else if(flag1==1)
            {
            
                JOptionPane.showMessageDialog(this, "Request Sent,Awaiting For Comformation");
            }
            else if(flag1==2)
            {
           
                JOptionPane.showMessageDialog(this, "Already Friends");
            }
            else if(flag1==3)
            {
           
                JOptionPane.showMessageDialog(this, "oops! request already exist on your friend requests");
            }
            else
            {
            JOptionPane.showMessageDialog(this, "Fields Are Empty!!");
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ORKUT_TIMELINE a= new ORKUT_TIMELINE();
        a.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ADD_FRIENDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADD_FRIENDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADD_FRIENDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADD_FRIENDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADD_FRIENDS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
