/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

import com.jsyn.*;
import com.jsyn.data.FloatSample;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.MixerStereo;
import com.jsyn.unitgen.MixerStereoRamped;
import com.jsyn.unitgen.VariableRateMonoReader;
import com.jsyn.util.SampleLoader;
import com.jsyn.util.WaveRecorder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;

public class Progetto{


    public static void main(String[] args) throws IOException, InterruptedException {
        
        
       
        String snare_sample = "C:\\Users\\Victor\\Desktop\\Boss DR-55\\DR-55Snare.wav"; 
        String kick_sample = "C:\\Users\\Victor\\Desktop\\Boss DR-55\\DR-55Kick.wav";
        String pop_sample = "C:\\Users\\Victor\\Desktop\\Boss DR-55\\DR-55Pop.wav";
        File snare = new File(snare_sample);
        File kick = new File(kick_sample);
        File pop = new File(pop_sample);
        File output = new File("C:\\Users\\Victor\\Desktop\\provaScritturaAudio\\finale.wav");
 
        
        
        // Create a context for the synthesizer.
        Synthesizer synth;
        LineOut line;
        
        synth = JSyn.createSynthesizer();
        synth.add(line = new LineOut());
        synth.start();
        line.start();
        
        
        
        
            //qua dovrei collegare quello che riproduco al lineOut
            FloatSample sample = SampleLoader.loadFloatSample(kick);
            FloatSample sample2 = SampleLoader.loadFloatSample(pop);
            VariableRateMonoReader samplePlayer;
            VariableRateMonoReader samplePlayer2;
            //primo modulo che suona un sample
            synth.add(samplePlayer = new VariableRateMonoReader());
            //secondo modulo che suona un sample
            synth.add(samplePlayer2 = new VariableRateMonoReader());
            
            
            WaveRecorder record = new WaveRecorder(synth,output);
            
            MixerStereo mixer = new MixerStereo(2); 
            synth.add(mixer); 
            record.start();
            
            //per il primo sample
            samplePlayer.rate.set(sample.getFrameRate());
            samplePlayer.output.connect(0, mixer.input, 0);
            samplePlayer.output.connect(0, mixer.input, 1);
            //samplePlayer.dataQueue.queue(sample);
            
            
            //per il seconodo sample
            samplePlayer2.rate.set(sample2.getFrameRate());
            samplePlayer2.output.connect(0, mixer.input, 0);
            samplePlayer2.output.connect(0, mixer.input, 1);
            samplePlayer2.dataQueue.queue(sample2);
            
            
            //questo prende l'output di tutto e lo registra nel file finale
            mixer.output.connect(0, record.getInput(), 0);
            mixer.output.connect(1, record.getInput(), 1);
            
            
            //questo lo suona mentre esegue il programma
            mixer.output.connect(0, line.input, 0);
            mixer.output.connect(1, line.input, 1);
            
        do {
            synth.sleepFor(1.0);
        } while (samplePlayer.dataQueue.hasMore());
        record.stop();
        record.close();
        synth.stop();
        
    }
    
}
