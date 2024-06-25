import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.*;
import javax.speech.Central;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String p = sc.nextLine();
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            Synthesizer sy = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            sy.allocate();
            sy.resume();
            sy.speakPlainText(p, null);
            sy.waitEngineState(Synthesizer.QUEUE_EMPTY);
            sy.deallocate();
        }
        catch (Exception e){

        }
    }
}
