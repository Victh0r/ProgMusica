/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.scene.paint.Color;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class Sequencer extends javax.swing.JFrame implements ActionListener{

    private String sample_path_1;
    private String sample_path_2;
    private String sample_path_3;
    private String sample_path_4;
    private ArrayList<JPanel> step_array;
    
    //colori delle file (quando vengono premuti i bottoni)
    int r1 = 186; int g1 = 35; int b1 = 35;
    int r2 = 130; int g2 = 40; int b2 = 119;
    int r3 = 240; int g3 = 252; int b3 = 106;
    int r4 = 68; int g4 = 237; int b4 = 225;
    
    
    
    
    public Sequencer() {
        this.getContentPane().setBackground(new java.awt.Color(39, 43, 45));
        initComponents();
              
        
        
        //****** sezione degli add ActionListener **********
        sample1_button.addActionListener(this);
        sample2_button.addActionListener(this);
        sample3_button.addActionListener(this);
        sample4_button.addActionListener(this);
        
        
        //****** end sezione add action Listener ************
        
        Step_Panel.setBackground(new java.awt.Color(39, 43, 45));
        Step_Panel.setLayout(new GridLayout(4, 16));
        //prova aggiunta con grid layout
        int cols = 16;
        int rows = 4;
        JPanel[] panel = new JPanel[cols*rows];
        int boh = 0;
        
        for (int x = 0; x < rows; x++)
            for (int y = 0; y < cols; y++) {
                //int i = (x * cols + y );
                panel[boh] = new JPanel();
                Step_Panel.add(panel[boh]);
                
                panel[boh].setBorder(BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY));
                panel[boh].setBackground(java.awt.Color.GRAY);
                panel[boh].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    step_MouseClicked(evt);
                    }

                   
                });
                //utile per test
                JLabel numero = new JLabel();
                numero.setText(""+boh);
                panel[boh].add(numero);
                numero.setVisible(false);
                boh++;           
            } 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        play_button = new javax.swing.JButton();
        stop_button = new javax.swing.JButton();
        bpm_field = new javax.swing.JTextField();
        bpm_label = new javax.swing.JLabel();
        export_button = new javax.swing.JButton();
        save_button = new javax.swing.JButton();
        import_button = new javax.swing.JButton();
        reset_button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        sample1_button = new javax.swing.JButton();
        sample2_button = new javax.swing.JButton();
        sample3_button = new javax.swing.JButton();
        sample4_button = new javax.swing.JButton();
        Step_Panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        play_button.setText("PLAY");
        play_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_buttonActionPerformed(evt);
            }
        });

        stop_button.setText("STOP");

        bpm_field.setText("120");

        bpm_label.setText("BPM");

        export_button.setText("Export mp3");
        export_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_buttonActionPerformed(evt);
            }
        });

        save_button.setText("save pattern");

        import_button.setText("import pattern");
        import_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_buttonActionPerformed(evt);
            }
        });

        reset_button.setText("reset pattern");

        sample1_button.setText("Sample 1");

        sample2_button.setText("Sample 2");

        sample3_button.setText("Sample 3");

        sample4_button.setText("Sample 4");

        javax.swing.GroupLayout Step_PanelLayout = new javax.swing.GroupLayout(Step_Panel);
        Step_Panel.setLayout(Step_PanelLayout);
        Step_PanelLayout.setHorizontalGroup(
            Step_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        Step_PanelLayout.setVerticalGroup(
            Step_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(play_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stop_button)
                        .addGap(18, 18, 18)
                        .addComponent(bpm_label)
                        .addGap(8, 8, 8)
                        .addComponent(bpm_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(reset_button)
                        .addGap(12, 12, 12)
                        .addComponent(import_button)
                        .addGap(18, 18, 18)
                        .addComponent(save_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(export_button)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sample4_button)
                            .addComponent(sample1_button)
                            .addComponent(sample2_button)
                            .addComponent(sample3_button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Step_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(play_button)
                    .addComponent(stop_button)
                    .addComponent(bpm_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bpm_label)
                    .addComponent(export_button)
                    .addComponent(save_button)
                    .addComponent(import_button)
                    .addComponent(reset_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sample1_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sample2_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sample3_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sample4_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Step_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void export_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_buttonActionPerformed
        // TODO add your handling code here:
        //System.out.println("EXPORT");
    }//GEN-LAST:event_export_buttonActionPerformed

    private void import_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_import_buttonActionPerformed

    private void play_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_buttonActionPerformed
        //RIPRODUZIONE musicale
        
        
    }//GEN-LAST:event_play_buttonActionPerformed

    private void step_MouseClicked(MouseEvent evt) {
        if(evt.getSource() instanceof JPanel){
            JPanel step = (JPanel)evt.getSource();
            
            //ulteriore controllo per evitare BUG && PER VEDERE SE NON è STATO GIA SCHIACCIATO
            if(step.getBackground() == java.awt.Color.GRAY){
                //Utile per capire quale step si sta schiacciando
                /*
                JLabel numero = (JLabel)step.getComponent(0);
                System.out.println("SONO LO STEP NUMERO: " + numero.getText());
                */
                JLabel numero = (JLabel)step.getComponent(0);
                
                //coloriamo gli step && SUONARE I SAMPLE QUANDO CLICCA(?)
                int scelta = 0;
                scelta = Integer.parseInt(numero.getText());
                
                if(scelta < 16){
                    //PRIMA RIGA
                    step.setBackground(new java.awt.Color(r1,g1,b1));
                    //SUONA IL SAMPLE 1
                    if(sample_path_1 != null && !sample_path_1.isEmpty()){
                        try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sample_path_1).getAbsoluteFile());
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();
                        } catch(Exception ex) {
                            System.out.println("Error with playing sound.");
                            ex.printStackTrace();
                        }
                    }
                    
                    
                }
                if(scelta < 32 && scelta > 15){
                    //SECONDA RIGA
                    step.setBackground(new java.awt.Color(r2,g2,b2));
                    //SUONA IL SAMPLE 2
                    if(sample_path_2 != null && !sample_path_2.isEmpty()){
                        try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sample_path_2).getAbsoluteFile());
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();
                        } catch(Exception ex) {
                            System.out.println("Error with playing sound.");
                            ex.printStackTrace();
                        }
                    }
                }
                if(scelta < 48 && scelta > 31){
                    //TERZA RIGA
                    step.setBackground(new java.awt.Color(r3,g3,b3));
                    //SUONA IL SAMPLE 3
                    if(sample_path_3 != null && !sample_path_3.isEmpty()){
                        try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sample_path_3).getAbsoluteFile());
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();
                        } catch(Exception ex) {
                            System.out.println("Error with playing sound.");
                            ex.printStackTrace();
                        }
                    }
                }
                if(scelta < 64 && scelta > 47){
                    //QUARTA RIGA
                    step.setBackground(new java.awt.Color(r4,g4,b4));
                    //SUONA IL SAMPLE 1
                    if(sample_path_4 != null && !sample_path_4.isEmpty()){
                        try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sample_path_4).getAbsoluteFile());
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();
                        } catch(Exception ex) {
                            System.out.println("Error with playing sound.");
                            ex.printStackTrace();
                        }
                    }
                }
                
            }else{
                //LO STEP è GIA COLORATO
                //per ora: non controllo i colori ma metto sempre a colore predefinito: GRAY
                step.setBackground(java.awt.Color.GRAY);
            
            }
                
        }   
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //carica i Samples
        if(ae.getSource() == sample1_button || ae.getSource() == sample2_button || ae.getSource() == sample3_button || ae.getSource() == sample4_button) {
            JFileChooser carica = new JFileChooser();
            int caricato = carica.showOpenDialog(null);
            
            if(caricato == JFileChooser.APPROVE_OPTION){
                //controllo per vedere se ha scelto un file
                File f = carica.getSelectedFile();
                String filename = f.getName();
                String path = f.getAbsolutePath();
                String parts[] = filename.split(Pattern.quote("."));
                JButton butt = (JButton) ae.getSource();
                if(parts[0].length() < 8 ){
                    butt.setText(parts[0]);
                }else{
                    butt.setText(parts[0].substring(0, 8));
                }
                
                
                 if(ae.getSource() == sample1_button){
                sample_path_1 = path;
                }    
                if(ae.getSource() == sample2_button){
                    sample_path_2 = path;
                }
                if(ae.getSource() == sample3_button){
                    sample_path_3 = path;
                }
                if(ae.getSource() == sample4_button){
                    sample_path_4 = path;
                }      
            }  
        }
    }
        
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
            java.util.logging.Logger.getLogger(Sequencer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sequencer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sequencer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sequencer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sequencer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Step_Panel;
    private javax.swing.JTextField bpm_field;
    private javax.swing.JLabel bpm_label;
    private javax.swing.JButton export_button;
    private javax.swing.JButton import_button;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton play_button;
    private javax.swing.JButton reset_button;
    private javax.swing.JButton sample1_button;
    private javax.swing.JButton sample2_button;
    private javax.swing.JButton sample3_button;
    private javax.swing.JButton sample4_button;
    private javax.swing.JButton save_button;
    private javax.swing.JButton stop_button;
    // End of variables declaration//GEN-END:variables

    
}
