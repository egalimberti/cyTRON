package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ImportDatasetFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -3735699826971726858L;
	
	private final DatasetController datasetController;

    public ImportDatasetFrame(DatasetController datasetController) {
        // get the controller
        this.datasetController = datasetController;
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeButtonGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        importLabel = new javax.swing.JLabel();
        pathLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        pathTextField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        genotypesRadioButton = new javax.swing.JRadioButton();
        mafRadioButton = new javax.swing.JRadioButton();
        gisticRadioButton = new javax.swing.JRadioButton();
        importButton = new javax.swing.JButton();
        loadRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Import Dataset");
        setMinimumSize(new java.awt.Dimension(640, 360));

        importLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        importLabel.setText("Import Dataset from File");

        pathLabel.setText("File");

        nameLabel.setText("Dataset name:");

        pathTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathTextFieldMouseClicked(evt);
            }
        });

        typeLabel.setText("Type:");

        typeButtonGroup.add(genotypesRadioButton);
        genotypesRadioButton.setSelected(true);
        genotypesRadioButton.setText("genotypes");

        typeButtonGroup.add(mafRadioButton);
        mafRadioButton.setText("MAF");

        typeButtonGroup.add(gisticRadioButton);
        gisticRadioButton.setText("GISTIC");

        importButton.setText("Import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        typeButtonGroup.add(loadRadioButton);
        loadRadioButton.setText("load");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(importLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(pathLabel)
                            .addComponent(typeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(genotypesRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(mafRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(gisticRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(loadRadioButton)
                                .addGap(0, 166, Short.MAX_VALUE))
                            .addComponent(nameTextField)
                            .addComponent(pathTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(importButton)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(importLabel)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(genotypesRadioButton)
                    .addComponent(mafRadioButton)
                    .addComponent(gisticRadioButton)
                    .addComponent(loadRadioButton))
                .addGap(13, 13, 13)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathLabel)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(importButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	// get the parameters
    	String name = nameTextField.getText();
        String path = pathTextField.getText();
        
        // check the parameters
        if (name.length() == 0) {
        	nameTextField.setBackground(Color.RED);
		} else {
			nameTextField.setBackground(Color.WHITE);
        }
        if (path.length() == 0) {
        	pathTextField.setBackground(Color.RED);
		} else {
			pathTextField.setBackground(Color.WHITE);
        }
        
        try {
        	if (name.length() > 0 && path.length() > 0) {
        		// import the dataset
    			if (genotypesRadioButton.isSelected()) {
    			    datasetController.importDataset(name, path, DatasetController.GENOTYPES);
    			} else if (gisticRadioButton.isSelected()) {
    			    datasetController.importDataset(name, path, DatasetController.GISTIC);
    			} else if (mafRadioButton.isSelected()) {
    			    datasetController.importDataset(name, path, DatasetController.MAF);
    			} else if (loadRadioButton.isSelected()) {
                            datasetController.importDataset(name, path, DatasetController.LOAD);
                }
    			
    			// if the last console message is regular
    			if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        			// close the frame
        	        dispose();
    			} else {
    				JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
    			}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showConfirmDialog(this, "The specified file does not exist.", RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
		}
    }                                            

    private void pathTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathTextFieldMouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                pathTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }//GEN-LAST:event_pathTextFieldMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton genotypesRadioButton;
    private javax.swing.JRadioButton gisticRadioButton;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel importLabel;
    private javax.swing.JRadioButton loadRadioButton;
    private javax.swing.JRadioButton mafRadioButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField pathTextField;
    private javax.swing.ButtonGroup typeButtonGroup;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
