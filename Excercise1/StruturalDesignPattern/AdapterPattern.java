package Excercise1.StruturalDesignPattern;

interface MediaPlayer {
    void play(String audioType, String filename);
}

class Mp3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String filename) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing mp3 file: " + filename);
        } else {
            System.out.println("Invalid media: " + audioType);
        }
    }
}

class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        } else if ("avi".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new AviPlayer();
        }
    }

    @Override
    public void play(String audioType, String filename) {
        if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playMp4(filename);
        } else if ("avi".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playAvi(filename);
        }
    }
}

interface AdvancedMediaPlayer {
    void playMp4(String filename);
    void playAvi(String filename);
}

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String filename) {
        System.out.println("Playing mp4 file: " + filename);
    }

    @Override
    public void playAvi(String filename) {
        // Do nothing
    }
}

class AviPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String filename) {
        // Do nothing
    }

    @Override
    public void playAvi(String filename) {
        System.out.println("Playing avi file: " + filename);
    }
}

class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String filename) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            new Mp3Player().play(audioType, filename);
        } else if ("mp4".equalsIgnoreCase(audioType) || "avi".equalsIgnoreCase(audioType)) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, filename);
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
        player.play("avi", "movie.avi");
        player.play("wav", "sound.wav");
    }
}
