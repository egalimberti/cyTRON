package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import java.awt.Color;

import javax.swing.JOptionPane;

public class RenameTypeFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -336609300131178908L;

	private final DatasetController datasetController;
    private final int typeIndex;
    private final int datasetIndex;

    public RenameTypeFrame(DatasetController datasetController, int typeIndex, int datasetIndex) {
        // get the variables
        this.datasetController = datasetController;
        this.typeIndex = typeIndex;
        this.datasetIndex = datasetIndex;
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        renameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        newNameLabel = new javax.swing.JLabel();
        newNameTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        renameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rename Type");
        setMinimumSize(new java.awt.Dimension(640, 360));
        setSize(new java.awt.Dimension(640, 360));

        renameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        renameLabel.setText("Rename Type");

        nameLabel.setText("Name:");

        newNameLabel.setText("New name:");

        nameTextField.setEditable(false);
        nameTextField.setText(((it.unimib.disco.bimib.cyTRON.model.Type) datasetController.getTypesListModel().get(typeIndex)).toString());

        renameButton.setText("Rename");
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(renameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newNameLabel)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newNameTextField)
                            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(renameButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(renameLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newNameLabel)
                    .addComponent(newNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(renameButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        // get the new name
        String newName = newNameTextField.getText();

        // check the parameters
        if (newName.length() == 0) {
            newNameTextField.setBackground(Color.RED);
            return;
        } else {
        	newNameTextField.setBackground(Color.WHITE);
        }	
        
        // rename the gene
        datasetController.renameType(typeIndex, datasetIndex, newName);

    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // close the frame
            dispose();
        } else {
        	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_renameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel newNameLabel;
    private javax.swing.JTextField newNameTextField;
    private javax.swing.JButton renameButton;
    private javax.swing.JLabel renameLabel;
    // End of variables declaration//GEN-END:variables
}
