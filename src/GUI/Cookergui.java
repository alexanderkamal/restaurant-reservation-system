/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import XmlWrite.Reservations;
import XmlWrite.TableXmlWrite;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import objects.Table;
import objects.TableWriting;

/**
 *
 * @author kamal alexander
 */
public class Cookergui extends javax.swing.JFrame {

    List<Table> alltables;
    List<TableWriting> tablew = new ArrayList<>();
    /**
     * Creates new form Cookergui
     */
    public Cookergui(List<Table> alltables) throws JAXBException {
        initComponents();
        this.alltables = alltables;
        readXmlFile();
        display();
        
        //loadtables();
    }

    private Cookergui() {
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
    public void display()
      {
           
           DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
           DefaultTableModel n = (DefaultTableModel) jTable2.getModel();
           if(tablew.size()>1){
           for (int i=1 ; i<tablew.size() ; i++) {
              
               m.addRow(new Object[]{tablew.get(i).getNumber()});
               n.addRow(new Object[]{tablew.get(i).getOrder()});
              
          }
       }  
           else{
               m.addRow(new Object[]{"no reservation yet"});
               n.addRow(new Object[]{"no orders till now"});
               // JOptionPane.showMessageDialog(rootPane,"There is no reservations uptill now");
           }   
      }
    void loadtables() //hena el mafrod fe if condition lel table reserved walla law kol table osadha el dishes
    {
        DefaultTableModel t = (DefaultTableModel) jTable1.getModel();
        for (Table table : alltables) {
            t.addRow(new Object[]{table.getNumber(),"dishes"});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable1.setBackground(new java.awt.Color(181, 110, 8));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Table number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 140));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Table Order"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 490, 140));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons8-back-64.png"))); // NOI18N
        jButton2.setText("Leave");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 140, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/ratatouille4.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 600, 320));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Login l=null;
        try {
            l = new Login();
        } catch (JAXBException ex) {
            Logger.getLogger(ClientGui3.class.getName()).log(Level.SEVERE, null, ex);
        }
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
