
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sony
 */
public class Encryption extends javax.swing.JFrame {

    /**
     * Creates new form Encryption
     */
    public Encryption() {
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

        file_path = new javax.swing.JTextField();
        but_browse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        key = new javax.swing.JPasswordField();
        but_encrypt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        but_saveAs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ENCRYPTION");

        file_path.setFocusable(false);

        but_browse.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        but_browse.setText("Browse");
        but_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_browseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("  ENTER KEY :");

        but_encrypt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        but_encrypt.setText("ENCRYPT");
        but_encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_encryptActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("      IMAGE LOCATION :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("               SAVE AS  :");

        but_saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_saveAsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(but_encrypt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(61, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(key)
                    .addComponent(file_path)
                    .addComponent(but_saveAs, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_browse)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(but_saveAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(but_encrypt)
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_browseActionPerformed
FileFilter filter=new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png");      
        JFileChooser chooser = new JFileChooser("D:\\FProject\\Images");
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();// 
        String filename=f.getAbsolutePath();
        file_path.setText(filename);        // TODO add your handling code here:
    }//GEN-LAST:event_but_browseActionPerformed

    private void but_encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_encryptActionPerformed
try{
          Connection conn=null;
	PreparedStatement stmt=null;
        
        String save = but_saveAs.getText();
        String skey= key.getText();
        
        if(skey.length()==16){
        
        Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirusa","root","root");
    
           stmt = conn.prepareStatement(" insert into list " + " values(?,?) ");
           
             stmt.setString(1,save);
             stmt.setString(2,skey);
    
              stmt.executeUpdate();
			
	      stmt.close();
	      conn.close();
    
    
    
    
                 
            FileInputStream file = new FileInputStream(file_path.getText());
            FileOutputStream outStream=new FileOutputStream("D:\\FProject\\Encrypted Images\\" + save + ".jpg");
            byte k[]=key.getText().getBytes();
            SecretKeySpec key = new SecretKeySpec(k,"AES");
            Cipher enc=Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE,key);
            CipherOutputStream cos=new CipherOutputStream(outStream,enc );
            
            byte[] buf = new byte[1024];
            int read;
            while((read=file.read(buf))!=-1)
            {
               cos.write(buf, 0 , read);
            }
            file.close();
            outStream.flush(); 
            cos.close();
            JOptionPane.showMessageDialog(null,"File is encrypted");
            dispose();
               }
        else{
            JOptionPane.showMessageDialog(null, "invalid key length");
            key.setText("");
        }
                 
           }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_but_encryptActionPerformed

    private void but_saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_saveAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_but_saveAsActionPerformed

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
            java.util.logging.Logger.getLogger(Encryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Encryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Encryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Encryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Encryption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_browse;
    private javax.swing.JButton but_encrypt;
    private javax.swing.JTextField but_saveAs;
    private javax.swing.JTextField file_path;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField key;
    // End of variables declaration//GEN-END:variables
}