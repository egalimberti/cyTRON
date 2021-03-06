package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class JoinTypesFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -6368847769338410691L;

	private final MainFrame mainFrame;
    private final DatasetController datasetController;
    private final int typeIndex1;
    private final int datasetIndex;
    
    private final DefaultComboBoxModel<String> defaultComboBoxModel;
    
    public JoinTypesFrame(MainFrame mainFrame, DatasetController datasetController, int typeIndex1, int datasetIndex) {
        // get the variables
        this.mainFrame = mainFrame;
        this.datasetController = datasetController;
        this.typeIndex1 = typeIndex1;
        this.datasetIndex = datasetIndex;
        
        // create the default combo box model from the list of types
        defaultComboBoxModel = new DefaultComboBoxModel<>();
        for (Object type : this.datasetController.getTypesListModel().toArray()) {
            defaultComboBoxModel.addElement(type.toString());
        }
        defaultComboBoxModel.removeElementAt(this.typeIndex1);
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        joinLabel = new javax.swing.JLabel();
        typeLabel1 = new javax.swing.JLabel();
        newNameLabel = new javax.swing.JLabel();
        newNameTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        joinButton = new javax.swing.JButton();
        typeLabel2 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Join Types");
        setMinimumSize(new java.awt.Dimension(640, 360));
        setSize(new java.awt.Dimension(640, 360));

        joinLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        joinLabel.setText("Join Types");

        typeLabel1.setText("Type:");

        newNameLabel.setText("New name:");

        typeTextField.setEditable(false);
        typeTextField.setText(((it.unimib.disco.bimib.cyTRON.model.Type) datasetController.getTypesListModel().get(typeIndex1)).toString());

        joinButton.setText("Join");
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });

        typeLabel2.setText("Type:");

        typeComboBox.setModel(defaultComboBoxModel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(joinButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(newNameTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeLabel1)
                            .addComponent(joinLabel)
                            .addComponent(typeLabel2))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                            .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(joinLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel2)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newNameLabel)
                    .addComponent(newNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(joinButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        // get the new name and the index of the second type
        String newName = newNameTextField.getText();
        int typeIndex2 = typeComboBox.getSelectedIndex();
        if (typeIndex2 >= typeIndex1) {
            typeIndex2++;
        }
        
        // check the parameters
        if (newName.length() == 0) {
            newNameTextField.setBackground(Color.RED);
            return;
        } else {
        	newNameTextField.setBackground(Color.WHITE);
        }	

        // rename the gene
        datasetController.joinTypes(typeIndex1, typeIndex2, datasetIndex, newName);

    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // update the main frame
            mainFrame.updateNumberLabels();
            
            // close the frame
            dispose();
        } else {
        	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_joinButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton joinButton;
    private javax.swing.JLabel joinLabel;
    private javax.swing.JLabel newNameLabel;
    private javax.swing.JTextField newNameTextField;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel1;
    private javax.swing.JLabel typeLabel2;
    private javax.swing.JTextField typeTextField;
    // End of variables declaration//GEN-END:variables
}
