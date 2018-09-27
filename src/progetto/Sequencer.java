/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import com.sun.glass.events.KeyEvent;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.scene.paint.Color;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Sequencer extends javax.swing.JFrame implements ActionListener{

//**********************VARIABILI GLOBALI*********************************************************

    //stringhe paths dei sample 
    private String sample_path_1;
    private String sample_path_2;
    private String sample_path_3;
    private String sample_path_4;
    
    //colori delle file (quando vengono premuti i bottoni)
    int r1 = 186; int g1 = 35; int b1 = 35; //RIGA 1 PREMUTO
    int r1P = 252; int g1P = 88; int b1P = 88; //RIGA 1 QUANDO PASSA IL COSO
    int r2 = 130; int g2 = 40; int b2 = 119;
    int r3 = 240; int g3 = 252; int b3 = 106;
    int r4 = 68; int g4 = 237; int b4 = 225;
    
    JPanel panel[];
    private Timer tempo;
    
    //insiemi di contatori per la gestione del sequencer
    private int cont_riga_1 = 0;
    private int cont_riga_2 = 16;
    private int cont_riga_3 = 32;
    private int cont_riga_4 = 48;    

//***************************************************************************************************
    
    public Sequencer() {
        this.getContentPane().setBackground(new java.awt.Color(39, 43, 45));
        initComponents();
        this.setTitle("Super Sequencer");
        
        stop_button.setEnabled(false);
        sample1_button.addActionListener(this);
        sample2_button.addActionListener(this);
        sample3_button.addActionListener(this);
        sample4_button.addActionListener(this);
        
        export_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                exportAudio();
            }
            
        });
        
        
        Step_Panel.setBackground(new java.awt.Color(39, 43, 45));
        Step_Panel.setLayout(new GridLayout(4, 16));
        
        //Costruzione della griglia di step (grid layout consiste in un JPanel padre con tanti JPanel più piccoli figli)
        int cols = 16;
        int rows = 4;
        panel = new JPanel[cols*rows];
        int cont = 0;
        
        for (int x = 0; x < rows; x++)
            for (int y = 0; y < cols; y++) {
                //int i = (x * cols + y );
                panel[cont] = new JPanel();
                Step_Panel.add(panel[cont]);
                
                panel[cont].setBorder(BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY));
                panel[cont].setBackground(java.awt.Color.GRAY);
                panel[cont].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    step_MouseClicked(evt);
                    }                   
                });
            //******Sezione inutile ai fini applicativi pratici(numeriamo i vari step creati)-Utile ai fini di test*******
                JLabel numero = new JLabel();
                numero.setText(""+cont);
                panel[cont].add(numero);
                numero.setVisible(false);
                cont++;    
            //*************************************************************************************************************
            } 
    }

//****************************CODICE GENERATO******************************************************************************
    
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

        play_button.setBackground(new java.awt.Color(53, 55, 58));
        play_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progetto/Img/play.png"))); // NOI18N
        play_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_buttonActionPerformed(evt);
            }
        });

        stop_button.setBackground(new java.awt.Color(53, 55, 58));
        stop_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progetto/Img/stop.png"))); // NOI18N
        stop_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_buttonActionPerformed(evt);
            }
        });

        bpm_field.setText("120");
        bpm_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bpm_fieldKeyTyped(evt);
            }
        });

        bpm_label.setText("<html><font color='white'>BPM</font></html>");

        export_button.setBackground(new java.awt.Color(53, 55, 58));
        export_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progetto/Img/Music-icon.png"))); // NOI18N
        export_button.setText("<html><font color='white'>Audio Export</font></html>");

        save_button.setBackground(new java.awt.Color(53, 55, 58));
        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progetto/Img/upload-icon.png"))); // NOI18N
        save_button.setText("<html><font color='white'>Save Pattern</font></html>");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        import_button.setBackground(new java.awt.Color(53, 55, 58));
        import_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progetto/Img/download-icon.png"))); // NOI18N
        import_button.setText("<html><font color='white'>Import Pattern</font></html>");
        import_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_buttonActionPerformed(evt);
            }
        });

        reset_button.setBackground(new java.awt.Color(53, 55, 58));
        reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progetto/Img/cross-3-icon.png"))); // NOI18N
        reset_button.setText("<html><font color='white'>Reset Pattern</font></html>");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        sample1_button.setBackground(new java.awt.Color(53, 55, 58));
        sample1_button.setText("<html><font color='red'>Sample 1</font></html>");

        sample2_button.setBackground(new java.awt.Color(53, 55, 58));
        sample2_button.setText("<html><font color='red'>Sample 2</font></html>");

        sample3_button.setBackground(new java.awt.Color(53, 55, 58));
        sample3_button.setText("<html><font color='red'>Sample 3</font></html>");

        sample4_button.setBackground(new java.awt.Color(53, 55, 58));
        sample4_button.setText("<html><font color='red'>Sample 4</font></html>");

        javax.swing.GroupLayout Step_PanelLayout = new javax.swing.GroupLayout(Step_Panel);
        Step_Panel.setLayout(Step_PanelLayout);
        Step_PanelLayout.setHorizontalGroup(
            Step_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Step_PanelLayout.setVerticalGroup(
            Step_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                        .addComponent(play_button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stop_button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(bpm_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bpm_field, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(reset_button, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(import_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(export_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sample4_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sample1_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sample2_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sample3_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Step_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(play_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(export_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(import_button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bpm_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bpm_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(sample1_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sample2_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sample3_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sample4_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Step_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    private void import_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_buttonActionPerformed
        JFileChooser imp = new JFileChooser(); //utilizzo il file chooser per gestire l'importazione dei file
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); // uso un filtro poichè i file importabili
                                                                                                   // possono essere solo txt
        imp.setFileFilter(filter);
        
        int importato = imp.showOpenDialog(null);
          
        if(importato == JFileChooser.APPROVE_OPTION){
            reset(); // una volta scelto il file faccio il reset di quello che eventualmente posso aver scrito sul sequencer
            File f = imp.getSelectedFile();
            
            try {
                BufferedReader in = new BufferedReader(new FileReader(f));
                String line = in.readLine(); // leggo il file e salvo il contenuto in una stringa
                String[] arrline = line.split("-"); // splitto il file per il carattere - e salvo il risultato in un array di stringhe
                int step;
                for(int i=0; i<arrline.length; i++){ //scorro  tutto l'array di stringhe ed ogni stringa la converto in int che corrisponde 
                                                     // all'indice del panel che deve essere illuminato
                    step =Integer.parseInt(arrline[i]);
                    // Faccio i controlli per capire di che colore deve essere illuminato il panel[step]
                    if(step < 16){
                        panel[step].setBackground(new java.awt.Color(r1,g1,b1));
                    }
                    
                    if(step > 15 && step < 32){
                        panel[step].setBackground(new java.awt.Color(r2,g2,b2));
                    }
                    
                    if(step > 31 && step < 48){
                        panel[step].setBackground(new java.awt.Color(r3,g3,b3));
                    }
                    
                    if(step > 47 && step < 64){
                        panel[step].setBackground(new java.awt.Color(r4,g4,b4));
                    }
                    
                }
                
            } catch (FileNotFoundException ex) {
                System.out.println("File not found.");
                ex.printStackTrace();
            } catch (IOException ex) {
               System.out.println("Error in file import.");
               ex.printStackTrace();
            }  
        }
    }//GEN-LAST:event_import_buttonActionPerformed

    private void play_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_buttonActionPerformed
        //RIPRODUZIONE musicale
        reset_button.setEnabled(false);
        play_button.setEnabled(false);
        stop_button.setEnabled(true);
        
        //disattiva operazioni sui file
        import_button.setEnabled(false);
        save_button.setEnabled(false);
        
        //istanzio Timer convertendo il campo BPM da BPM a millisecondi.utile per la sincronizzazione dell'esecuzione
        double bpm_d = Integer.parseInt(bpm_field.getText());
        bpm_d = 60000/bpm_d;
        int bpm_i = (int) Math.round(bpm_d);
        
        tempo = new Timer(bpm_i, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                playSequencer();
            }
        
        });
        
        tempo.start();         
    }//GEN-LAST:event_play_buttonActionPerformed

    private void stop_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_buttonActionPerformed
        tempo.stop();
        play_button.setEnabled(true);
        stop_button.setEnabled(false);
        
        //riattiva le operazioni sui file
        import_button.setEnabled(true);
        save_button.setEnabled(true);
        
        
        //non posso resettare il pattern durante l'esecuzione 
        reset_button.setEnabled(true);
        
        //Ripristino i contatori originali per far ripartire l'esecuzione da capo dopo il play dall'inizio
        cont_riga_1 = 0;
        cont_riga_2 = 16;
        cont_riga_3 = 32;
        cont_riga_4 = 48;
        
        for(int i=0; i<16; i++){
            java.awt.Color c = panel[i].getBackground();
            //System.out.println("colore: "+i+"");
            if(c.equals(java.awt.Color.GRAY.brighter()) || c.equals(new java.awt.Color(r1, g1, b1).brighter()) || c.equals(new java.awt.Color(r2, g2, b2).brighter()) || c.equals(new java.awt.Color(r3, g3, b3).brighter()) || c.equals(new java.awt.Color(r4, g4, b4).brighter())){
                mydarker(i);
                mydarker(i+16);
                mydarker(i+32);
                mydarker(i+48);
            }
        }
    }//GEN-LAST:event_stop_buttonActionPerformed

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
        //Scorro tutti gli step e li imposto a grigio
        reset();
    }//GEN-LAST:event_reset_buttonActionPerformed
        
    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
        JFileChooser save = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
        save.setFileFilter(filter);
        
        save.showSaveDialog(this);
        File f = new File (save.getSelectedFile()+".txt"); // in fase di salvataggio viene automaticamente aggiunta l'estensione del file 
                                                           // da salvare
        try { 
            FileWriter fw =new FileWriter(f); 
            BufferedWriter buf = new BufferedWriter(fw);
            
            for(int i=0; i<panel.length; i++){ //scorro tutti gli step e se lo step ha un colore che è diverso da grigio mi salvo il suo indice 
                                               //su un file txt
                if(!(panel[i].getBackground().equals(java.awt.Color.GRAY))){
                   buf.write(i+"-");
                }
            }
            buf.flush();
            buf.close();
        } catch (IOException ex) {
            System.out.println("Error with saving file.");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_save_buttonActionPerformed

    //esporta il pattern in un file audio
    public void exportAudio(){
        
    }
    
//******************************FINE ACTION PERFORMED BOTTONI***************************************************************

//******************************SEZIONE KEY TYPED***************************************************************************
    
    private void bpm_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bpm_fieldKeyTyped
        //in questo modo blocco ogni inserimento che non siano numeri nel campo BPM 
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_bpm_fieldKeyTyped

//******************************FINE KEY TYPED******************************************************************************

//******************************SEZIONE METODI AGGIUNTIVI*******************************************************************
    
    private void playSequencer(){
        //QUA DENTRO VA FATTO TUTTO:
            // 1) aggiornare i colori degli step
            // 2) play dei sample SE lo step è colorato
            
        if(cont_riga_1 == 16 && cont_riga_2 == 32 && cont_riga_3 ==48 && cont_riga_4 ==64){
            mydarker(cont_riga_1-1);
            cont_riga_1 = 0;
            mydarker(cont_riga_2-1);
            cont_riga_2 = 16;
            mydarker(cont_riga_3-1);
            cont_riga_3 = 32;
            mydarker(cont_riga_4-1);
            cont_riga_4 = 48;
        }
        
        if((cont_riga_1>0 && cont_riga_1 < 16) && (cont_riga_2 > 15 && cont_riga_2 < 32) && (cont_riga_3 > 31 && cont_riga_3 <48) && (cont_riga_4 > 47 && cont_riga_4 < 64)){
            mydarker(cont_riga_1-1);
            mydarker(cont_riga_2-1);
            mydarker(cont_riga_3-1);
            mydarker(cont_riga_4-1);
        }

        panel[cont_riga_1].setBackground(panel[cont_riga_1].getBackground().brighter());
        panel[cont_riga_2].setBackground(panel[cont_riga_2].getBackground().brighter());
        panel[cont_riga_3].setBackground(panel[cont_riga_3].getBackground().brighter());
        panel[cont_riga_4].setBackground(panel[cont_riga_4].getBackground().brighter());
        
        java.awt.Color c = panel[cont_riga_1].getBackground();
        java.awt.Color c2 = panel[cont_riga_2].getBackground();
        java.awt.Color c3 = panel[cont_riga_3].getBackground();
        java.awt.Color c4 = panel[cont_riga_4].getBackground();
        
        if(c.equals(new java.awt.Color(r1,g1,b1).brighter())){
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
        
        if(c2.equals(new java.awt.Color(r2,g2,b2).brighter())){
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
        
        if(c3.equals(new java.awt.Color(r3,g3,b3).brighter())){
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
        
        if(c4.equals(new java.awt.Color(r4,g4,b4).brighter())){
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
        cont_riga_1++;
        cont_riga_2++;
        cont_riga_3++;
        cont_riga_4++;
    }
    
    //Metodo mydarker reimopsta i colori originali 
    private void mydarker(int i){
        if(i < 16){
            if(panel[i].getBackground().equals(java.awt.Color.GRAY.brighter())){
                panel[i].setBackground(java.awt.Color.GRAY);
            }else{
                panel[i].setBackground(new java.awt.Color(r1,g1,b1));
            }
        }
        if(i < 32 && i > 15){
            if(panel[i].getBackground().equals(java.awt.Color.GRAY.brighter())){
                panel[i].setBackground(java.awt.Color.GRAY);
            }else{
                panel[i].setBackground(new java.awt.Color(r2,g2,b2));
            }
        }
        if(i < 48 && i > 31){
            if(panel[i].getBackground().equals(java.awt.Color.GRAY.brighter())){
                panel[i].setBackground(java.awt.Color.GRAY);
            }else{
                panel[i].setBackground(new java.awt.Color(r3,g3,b3));
            }
        }       
        if(i < 64 && i > 47){
            if(panel[i].getBackground().equals(java.awt.Color.GRAY.brighter())){
                panel[i].setBackground(java.awt.Color.GRAY);
            }else{
                panel[i].setBackground(new java.awt.Color(r4,g4,b4));
            }
        }
    }
    
    //Funzione Reset la faccio così perchè in questo modo posso richiamarla sia quando schiaccio reset_button sia quando faccio l'import
    public void reset(){
        for(int i=0; i<panel.length; i++){
            panel[i].setBackground(java.awt.Color.GRAY);
        }
    }
 
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
    
    
    //codice per i sampleLoader
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
                    butt.setForeground(java.awt.Color.GREEN);
                }else{
                    butt.setText(parts[0].substring(0, 8));
                    butt.setForeground(java.awt.Color.GREEN);
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

//*****************************FINE SEZIONE METODI AGGIUNTIVI***************************************************************
         
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