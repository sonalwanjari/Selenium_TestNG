package SeleniumDemos.ScreenshotAndRecording;

import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class RecordingUtilityClass { //Java Class Name

    static ScreenRecorder recorder;

    public static void recordingDemo() throws Exception {
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        Rectangle recordSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        File recording = new File("C:\\STAD Solutions\\Selenium\\Screenrecording\\TrialRecording1");
        recording.mkdir();

        recorder = new ScreenRecorder(gc, recordSize,
                new org.monte.media.Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new org.monte.media.Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new org.monte.media.Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null, recording);

        recorder.start();
        System.out.println("Recording started...");
    }

    // Stop Recording
    public static void stopRecording() throws Exception {
        if (recorder != null) {
            recorder.stop();
            System.out.println("Recording stopped.");
        }
    }

    // Example usage
    public static void main(String[] args) throws Exception {
        // No need to create object, call static method directly
        RecordingUtilityClass.recordingDemo();

        WebDriver browser = new ChromeDriver();
        browser.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(5000);

        RecordingUtilityClass.stopRecording();
        browser.quit();
    }
}
