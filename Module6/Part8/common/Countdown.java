package Module6.Part8.common;


import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

/**
 * Simple countdown timer demo of java.util.Timer facility.
 */

public class Countdown {
    private int time;
    private String message;
    private Runnable expireCallback = null;
    private Consumer<Integer> tickCallback = null;
    final private Timer timer;
    private static MyLogger logger = MyLogger.getLogger(Countdown.class.getName());

    public Countdown(String message, int duration, Runnable callback) {
        this(message, duration);
        this.expireCallback = callback;
    }
    public Countdown(String message, int duration) {
        timer = new Timer();
        this.message = message;
        time = duration;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                time--;
                logger.info("Time: " + time);
                if(tickCallback != null){
                    tickCallback.accept(time);
                }
                if (time <= 0) {
                    timer.cancel();
                    time = 0;
                    if (expireCallback != null) {
                        expireCallback.run();
                    }
                }
            }
        }, 1000, 1000);
    }
    public void setTickCallback(Consumer<Integer> callback){
        tickCallback = callback;
    }
    public void setExpireCallback(Runnable callback){
        expireCallback = callback;
    }
    public void cancel() {
        expireCallback = null;
        timer.cancel();
    }

    public String getTimeMessage() {
        if (message == null) {
            return "";
        }
        if (time == 0) {
            return String.format("%s: %s", message, "expired");
        }
        return String.format("%s: %s", message, time);
    }
}