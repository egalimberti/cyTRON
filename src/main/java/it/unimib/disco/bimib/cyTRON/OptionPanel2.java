/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unimib.disco.bimib.cyTRON;

import java.awt.event.ItemEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskObserver;

/**
 *
 * @author Dalia
 */
public class OptionPanel2 extends javax.swing.JPanel {

    public enum FieldTitle {
        MODEL("model"), GRAPHML("graphml"), PDF("pdf"), HG("hg"), TP("tp"),
        PR("pr"), SCALE_NODES("scale.nodes"), HEIGHT("height"), WIDTH("width"),
        DISCONNECTED_NODES("disconnected"), PMIN("pmin"), EDGE_CEX("edge.cex"),
        LABEL_EDGE_SIZE("label.edge.size"), EDGE_COLOR("edge.color"),
        EDGE_LWD("edge.lwd");
        private String title;

        private FieldTitle(String title) {
            this.title = title;
        }

    };
    private File modelFile;
    private CommandExecutor commandExecutor;
    private JFrame frame;
    private Map<FieldTitle, String> parameters = new HashMap<>();

    /**
     * Creates new form OptionPanel2
     */
    public OptionPanel2(CommandExecutor commandExecutor, JFrame frame) {
        this.commandExecutor = commandExecutor;
        this.frame = frame;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        modelButton = new javax.swing.JButton();
        outputCB = new javax.swing.JCheckBox();
        outputFileText = new javax.swing.JTextField();
        exportPdfCB = new javax.swing.JCheckBox();
        outputPdf = new javax.swing.JTextField();
        loadButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tpCB = new javax.swing.JCheckBox();
        hgCB = new javax.swing.JCheckBox();
        prCB = new javax.swing.JCheckBox();
        scaleNodesCB = new javax.swing.JCheckBox();
        scaleNodesTB = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        heightTB = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        widthTB = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        pminTB = new javax.swing.JFormattedTextField();
        edgeCexTB = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        disconnectedNodesCB = new javax.swing.JCheckBox();
        labelEdgeSizeCB = new javax.swing.JCheckBox();
        lesTB = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        edgeColorTB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lwdTB = new javax.swing.JFormattedTextField();
        helpButton = new javax.swing.JButton();

        modelButton.setText("Choose Model");
        modelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelButtonActionPerformed(evt);
            }
        });

        outputCB.setText("Choose graphml output file");
        outputCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                outputCBItemStateChanged(evt);
            }
        });

        outputFileText.setText(System.getProperty("user.home") + "/test.graphml");
        outputFileText.setEnabled(false);

        exportPdfCB.setText("Export PDF");
        outputPdf.setEnabled(false);
        exportPdfCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                exportPdfCBItemStateChanged(evt);
            }
        });

        outputPdf.setText(System.getProperty("user.home") + "/output.pdf");

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(exportPdfCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(outputCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputFileText, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(outputPdf))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(modelButton)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modelButton)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputCB)
                    .addComponent(outputFileText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportPdfCB)
                    .addComponent(outputPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(loadButton)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("input/output file options", jPanel1);

        jLabel1.setText("Confidence");

        tpCB.setText("tp");

        hgCB.setText("hg");

        prCB.setText("pr");

        scaleNodesCB.setText("scale.nodes");
        scaleNodesCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                scaleNodesCBItemStateChanged(evt);
            }
        });
        scaleNodesCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleNodesCBActionPerformed(evt);
            }
        });

        scaleNodesTB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        scaleNodesTB.setEnabled(false);

        jLabel2.setText("height");

        heightTB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        heightTB.setText("2.0");

        jLabel3.setText("width");

        widthTB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        widthTB.setText("3.0");

        jLabel4.setText("pmin");

        pminTB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        pminTB.setText("0.05");

        edgeCexTB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edgeCexTB.setText("1.0");

        jLabel5.setText("edge.cex");

        disconnectedNodesCB.setText("Show disconnected nodes");
        disconnectedNodesCB.setToolTipText("");

        labelEdgeSizeCB.setText("labels.edge.size");
        labelEdgeSizeCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                labelEdgeSizeCBItemStateChanged(evt);
            }
        });
        labelEdgeSizeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelEdgeSizeCBActionPerformed(evt);
            }
        });

        lesTB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        lesTB.setEnabled(false);

        jLabel6.setText("edge.color");

        edgeColorTB.setText("black");
        edgeColorTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edgeColorTBActionPerformed(evt);
            }
        });

        jLabel7.setText("edge.lwd");

        lwdTB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        lwdTB.setText("3");

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                .addGap(107, 107, 107))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(scaleNodesCB, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scaleNodesTB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(heightTB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(245, 245, 245))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disconnectedNodesCB)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pminTB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(widthTB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edgeCexTB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prCB)
                            .addComponent(hgCB)
                            .addComponent(tpCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEdgeSizeCB)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edgeColorTB)
                            .addComponent(lesTB)
                            .addComponent(lwdTB, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(helpButton))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEdgeSizeCB)
                            .addComponent(lesTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(edgeColorTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lwdTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(hgCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tpCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prCB)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scaleNodesCB)
                            .addComponent(scaleNodesTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(heightTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(widthTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(disconnectedNodesCB)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pminTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edgeCexTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap(60, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helpButton))
        );

        jTabbedPane1.addTab("export.graphml parameters", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edgeColorTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edgeColorTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edgeColorTBActionPerformed

    private void labelEdgeSizeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelEdgeSizeCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelEdgeSizeCBActionPerformed

    private void scaleNodesCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleNodesCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scaleNodesCBActionPerformed

    private void modelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelButtonActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(loadButton);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            modelFile = fc.getSelectedFile();

        }

    }//GEN-LAST:event_modelButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
   	
        parameters.put(FieldTitle.MODEL, modelFile.getAbsolutePath());
        
        if (outputCB.isEnabled()) {
            parameters.put(FieldTitle.GRAPHML, outputFileText.getText());
        }
        if (exportPdfCB.isEnabled()) {
            parameters.put(FieldTitle.PDF, outputPdf.getText());
        }
        if (hgCB.isEnabled()) {
            parameters.put(FieldTitle.HG, "'hg'");
        }
        if (tpCB.isEnabled()) {
            parameters.put(FieldTitle.TP, "'tp'");
        }
        if (prCB.isEnabled()) {
            parameters.put(FieldTitle.PR, "'pr'");
        }
        if (scaleNodesCB.isEnabled()) {
            parameters.put(FieldTitle.SCALE_NODES, scaleNodesTB.getText());
        }
        parameters.put(FieldTitle.HEIGHT, heightTB.getText());
        parameters.put(FieldTitle.WIDTH, widthTB.getText());

        parameters.put(FieldTitle.DISCONNECTED_NODES,
                disconnectedNodesCB.isEnabled() ? "TRUE" : "FALSE");
        parameters.put(FieldTitle.PMIN, pminTB.getText());
        parameters.put(FieldTitle.EDGE_CEX, edgeCexTB.getText());

        if (labelEdgeSizeCB.isEnabled()) {
            parameters.put(FieldTitle.LABEL_EDGE_SIZE, lesTB.getText());
        }

        parameters.put(FieldTitle.EDGE_COLOR, "'" + edgeColorTB.getText() + "'");

        parameters.put(FieldTitle.EDGE_LWD, lwdTB.getText());

        TaskObserver observer = new TaskObserver() {
            @Override
            public void taskFinished(ObservableTask arg0) {
                System.out.println("TaskFinished");
            }

            @Override
            public void allFinished(FinishStatus arg0) {
                System.out.println("TaskAllFinished");

            }
        };

        HashMap<String, Object> mappa = new HashMap<String, Object>();
        //mappa.put("inputFile", scriptFile.getAbsolutePath());
        commandExecutor.executeCommand("cytron", "import", mappa, observer);
        frame.dispose();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void exportPdfCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_exportPdfCBItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            outputPdf.setEnabled(true);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            outputPdf.setEnabled(false);
        }

        validate();
        repaint();
    }//GEN-LAST:event_exportPdfCBItemStateChanged

    private void outputCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_outputCBItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            outputFileText.setEnabled(true);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            outputFileText.setEnabled(false);
        }

        validate();
        repaint();
    }//GEN-LAST:event_outputCBItemStateChanged

    private void scaleNodesCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_scaleNodesCBItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            scaleNodesTB.setEnabled(true);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            scaleNodesTB.setEnabled(false);
        }

        validate();
        repaint();
    }//GEN-LAST:event_scaleNodesCBItemStateChanged

    private void labelEdgeSizeCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_labelEdgeSizeCBItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            lesTB.setEnabled(true);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            lesTB.setEnabled(false);
        }

        validate();
        repaint();
    }//GEN-LAST:event_labelEdgeSizeCBItemStateChanged

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        StringBuilder parameters = new StringBuilder();
        parameters.append("model: a reconstructed model\n");
        parameters.append("models: a vector containing the name of the algorithms used\n");
        parameters.append("fontsize: for node names\n");
        parameters.append("height: for node height\n");
        parameters.append("width: for node width\n");
        parameters.append("height.logic: for logical nodes\n");
        parameters.append("pf: should I print Prima Facie?\n");
        parameters.append("disconnected: should I print disconnected nodes?\n");
        parameters.append("scale.nodes: node scaling coefficient\n");
        parameters.append("title: title of the plot\n");
        parameters.append("confidence: should I add confidence information?\n");
        parameters.append("pmin: p-value cutoff\n");
        parameters.append("label.edge.size: size of edge labels\n");
        parameters.append("expand: should I expand hypotheses?\n");
        parameters.append("genes: visualise only genes in this list\n");
        parameters.append("edge.color: edge color\n");
        parameters.append("file: string containing file name for PDF output\n");
        parameters.append("pathways: a vetor containing pathways information\n");
        parameters.append("lwd: edge base lwd\n");
        parameters.append("samples.annotation\n");
        JOptionPane.showMessageDialog(null, parameters.toString(), "Parametri disponibili", JOptionPane.QUESTION_MESSAGE);

    }//GEN-LAST:event_helpButtonActionPerformed

    
    public Map<FieldTitle, String> getParameters() {
    	return parameters;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox disconnectedNodesCB;
    private javax.swing.JFormattedTextField edgeCexTB;
    private javax.swing.JTextField edgeColorTB;
    private javax.swing.JCheckBox exportPdfCB;
    private javax.swing.JFormattedTextField heightTB;
    private javax.swing.JButton helpButton;
    private javax.swing.JCheckBox hgCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox labelEdgeSizeCB;
    private javax.swing.JFormattedTextField lesTB;
    private javax.swing.JButton loadButton;
    private javax.swing.JFormattedTextField lwdTB;
    private javax.swing.JButton modelButton;
    private javax.swing.JCheckBox outputCB;
    private javax.swing.JTextField outputFileText;
    private javax.swing.JTextField outputPdf;
    private javax.swing.JFormattedTextField pminTB;
    private javax.swing.JCheckBox prCB;
    private javax.swing.JCheckBox scaleNodesCB;
    private javax.swing.JFormattedTextField scaleNodesTB;
    private javax.swing.JCheckBox tpCB;
    private javax.swing.JFormattedTextField widthTB;
    // End of variables declaration//GEN-END:variables
}
