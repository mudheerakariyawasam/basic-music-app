import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import java.io.File
import kotlin.concurrent.thread

class MusicPlayer {
    private val audioClip: Clip
    init {
        val audioFile = File(javaClass.getResource("AdarePawasala.wav").toURI())
        val audioInputStream = AudioSystem.getAudioInputStream(audioFile)
        audioClip = AudioSystem.getClip()
        audioClip.open(audioInputStream)
    }
    fun startPlayback() {
        if (!audioClip.isRunning) {
            audioClip.start()
        }
    }
    fun pausePlayback() {
        if (audioClip.isRunning) {
            audioClip.stop()
        }
    }
    fun stopPlayback() {
        audioClip.stop()
        audioClip.close()
    }
}

fun main() {
    val musicPlayer = MusicPlayer()

    // Start playback
    musicPlayer.startPlayback()

    // Simulate pause and stop after a while
    thread {
        Thread.sleep(5000)
        musicPlayer.pausePlayback()
        Thread.sleep(2000)
        musicPlayer.startPlayback()
        Thread.sleep(3000)
        musicPlayer.stopPlayback()
    }
}
