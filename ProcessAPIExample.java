import java.time.Duration;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class ProcessAPIExample {

    public static void main(String[] args) {

        //detailListProcesses();
        detailListProcessUsers();

    }

    public static void detailListProcesses() {
        ProcessHandle.allProcesses().forEach(h -> System.out.println(formattedProcess(h)));
    }

    public static String formattedProcess(ProcessHandle handle) {
        long pid = handle.pid();
        boolean alive = handle.isAlive();
        Optional<Duration> cpuDuration = handle.info().totalCpuDuration();
        Optional<String> handleName = handle.info().command();
        return pid + " " + alive + " " + handleName + ":" + cpuDuration;
    }

    public static void detailListProcessUsers() {
        ProcessHandle.allProcesses().forEach(h -> System.out.println(listOsUser(h)));
    }

    public static String listOsUser(ProcessHandle handle) {
        ProcessHandle.Info procInfo = handle.info();
        return handle.pid() + ": " + procInfo.user();
    }

}