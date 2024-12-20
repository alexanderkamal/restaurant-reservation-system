/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import XmlRead.RestaurantXml;
import XmlWrite.Reservations;
import XmlWrite.TableXmlWrite;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import objects.Table;
import objects.TableWriting;

/**
 *
 * @author Amr Ashraf
 */
public class ClientGui1 extends javax.swing.JFrame {
    int language ;
    
//  Sort alltabels  
     String clientname=null;
     List<Table> alltables ;
     List<TableWriting> tablew = new ArrayList<>();
    // List<TableXmlWrite> ta=new ArrayList<>();
     boolean check =false;
    /**
     * Creates new form ClientGui1
     */
    public ClientGui1(List<Table> x,String y,int l) throws JAXBException {
        initComponents();
        
        alltables = x;
        clientname = y ;
        language = l;
        checklanguage();
        readXmlFile();
        sortList();
        
    }
    
    
    public void sortList()
    {
        Collections.sort( alltables ,new Comparator<Table>(){
        
        @Override
        public int compare(Table t1 ,Table t2 ){
            
            if(t1.getSeats()!=t2.getSeats())
             return t1.getSeats()-t2.getSeats();
            
            return t1.getNumber()-t2.getNumber();
       
        }
         
        });
    }
    public void checklanguage()
    {
        if (language == 1)
        {
            
            jButton2.setText("خروج");
            jLabel1.setText(" عدد المقاعد:                                                                           ");
            jLabel2.setText("نوع الطاولة:                                                                            ");
            jComboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"مدخن","غير مدخن"}));
            jButton1.setText("حجز");
            jButton3.setText("توصيل");
        }
        else
        {
            jButton2.setText("Logout");
            jLabel1.setText("number of seats :");
            jLabel2.setText("type of table :");
            jComboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Smoking Areas","non smoking areas"}));
            jButton1.setText("reserve");
        }
    }
    
    
    
    
    
    private ClientGui1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void readXmlFile() throws JAXBException
    {
       
     JAXBContext jax = JAXBContext.newInstance(Reservations.class);
      Unmarshaller unm= jax.createUnmarshaller();
       Reservations r = (Reservations) unm.unmarshal(new File ("Reservation.xml"));
       
       List<TableXmlWrite> tab = r.getTables().getTableList();
       
        for (TableXmlWrite x : tab) {
            TableWriting te = new TableWriting(x.getNumber(), x.getName(), x.getOrder(), x.getPaid());
            tablew.add(te);
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English\t", "العربية" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 150, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 131, 63));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose number of seats :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 500, 70));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/scooter (1).png"))); // NOI18N
        jButton3.setText("Delivery");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 180, 60));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/exit.png"))); // NOI18N
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("type of table:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 179, 500, 70));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smoking Areas", "non smoking areas" }));
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 180, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/save.png"))); // NOI18N
        jButton1.setText("reserve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/artworks-000157996156-y6kft4-t500x500.jpg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         int seatno = jComboBox1.getSelectedIndex() + 1;
        boolean smoke;
        if(jComboBox2.getSelectedIndex()==0)
            smoke = true;
        else 
            smoke = false;
        int i = 0;
        
        Table clienttable = null;
       // for (Table alltable : alltables) {
       
       if(tablew.size()==8)
       {
           if(language == 0)
            JOptionPane.showMessageDialog(rootPane, "sorry Mr "+clientname+" there is no table available today ");
           else
            JOptionPane.showMessageDialog(rootPane, "للأسف سيد "+clientname+" لا توجد طاولة متاحة اليوم ");   
       }
       else
       {
       for (i=0 ; i<alltables.size()  ; i++)
       {
            if(alltables.get(i).getSeats() >= seatno && smoke == alltables.get(i).isSmoke())
            {
              int  check=0;
                      if(tablew.size()>1)
                      {
                              for(int j = 0 ; j < tablew.size() ; j++ )
                              {
                                 if (alltables.get(i).getNumber()==tablew.get(j).getNumber())
                                            check++;                                       
                              }
                             if (check==0)
                              {
                                clienttable = alltables.get(i);
                                 break;
                              }
                       } 
                
                      else
                      {
                    clienttable = alltables.get(i);
                              break;
                      }   
            }
        }
       
        if(clienttable == null)
        {
            if(language == 0)
            JOptionPane.showMessageDialog(rootPane, "sorry there is no table available with this requirements");
            else
            JOptionPane.showMessageDialog(rootPane, "للأسف لا توجد طاولة متاحة بهذه المواصفات");  
        }
        else
        {
            if(language == 0)
            JOptionPane.showMessageDialog(rootPane, "table number "+alltables.get(i).getNumber()+" reserved succefully");
            else
            JOptionPane.showMessageDialog(rootPane, "تم حجز طاولة رقم   "+alltables.get(i).getNumber()+" بنجاح   "); 
           if(language == 0) 
           {
           ClientGui2  m = new ClientGui2(alltables,clientname, i);
                    m.setVisible(true);
                    dispose();
           }
           else
           {
            ClientGui2arabic  m = new ClientGui2arabic(alltables,clientname, i);
                    m.setVisible(true);
                    dispose();
           } 
                    
        }
     }       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Login l=null;
        try {
            l = new Login();
        } catch (JAXBException ex) {
            Logger.getLogger(ClientGui3.class.getName()).log(Level.SEVERE, null, ex);
        }
        l.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

        if (jComboBox3.getSelectedIndex() == 0 )
            language = 0;
        else
            language = 1;
        checklanguage();
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        delivery l = new delivery();
        l.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
