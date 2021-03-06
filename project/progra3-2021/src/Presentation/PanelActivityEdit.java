/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Activity;
import Business.ActivityType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class PanelActivityEdit extends javax.swing.JPanel {

    private ArrayList<Integer> listActivites = new ArrayList<>();

    private ArrayList<ActivityType> activityTypes;
    private ArrayList<Integer> activityTypesIds;

    /**
     * Creates new form PanelActivityEdit
     */
    public PanelActivityEdit() {
        try {
            initComponents();
            txtDescrition.setEnabled(false);
            txtName.setEnabled(false);
            txtPoints.setEnabled(false);
            LoadActivities();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PanelActivityEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LoadActivities() throws SQLException, ClassNotFoundException {
        Activity activity = new Activity();
        ArrayList<Activity> allActivities = activity.List();

        listActivites.add(0);

        DefaultListModel listModel = new DefaultListModel();

        listModel.addElement("--Seleccione--");

        for (int i = 0; i < allActivities.size(); i++) {
            listModel.addElement(allActivities.get(i).getName());
            listActivites.add(allActivities.get(i).getIdActivityType());
        }

        lstActivities.setModel(listModel);
    }

    private void LoadSelectedActivity() {
        Activity u = new Activity();
        int selectedId = listActivites.get(lstActivities.getSelectedIndex());
        u.setIdActivity(selectedId);
        u.Find();
        txtName.setText(u.getName());
        txtPoints.setText(String.valueOf(u.getPoints()));
        txtDescrition.setText(u.getDescription());
        txtDescrition.setEnabled(true);
        txtName.setEnabled(true);
        txtPoints.setEnabled(true);

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
        lstActivities = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescrition = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPoints = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstActivities.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstActivities.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstActivitiesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstActivities);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 275, 436));

        jLabel2.setText("Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 66, -1, 16));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 64, 303, -1));

        txtDescrition.setColumns(20);
        txtDescrition.setRows(5);
        txtDescrition.setText("Long description of the activity");
        jScrollPane2.setViewportView(txtDescrition);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 305, -1));

        jLabel5.setText("Description:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jLabel6.setText("Points:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));
        add(txtPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 300, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        jLabel10.setText("Find Activity");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int selectedId = listActivites.get(lstActivities.getSelectedIndex());
            Activity u = new Activity();
            u.setIdActivity(selectedId);
            u.setName(txtName.getText());
            u.setDescription(txtDescrition.getText());
            u.setPoints(Integer.parseInt(txtPoints.getText()));
            u.Edit();
            JOptionPane.showMessageDialog(null, "Activity updated");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PanelActivityTypeAdd.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lstActivitiesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstActivitiesValueChanged
        LoadSelectedActivity();

    }//GEN-LAST:event_lstActivitiesValueChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            LoadActivities();
        } catch (SQLException ex) {
            Logger.getLogger(PanelActivityEdit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelActivityEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstActivities;
    private javax.swing.JTextArea txtDescrition;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPoints;
    // End of variables declaration//GEN-END:variables
}
