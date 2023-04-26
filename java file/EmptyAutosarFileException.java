import java.io.IOException;

public class EmptyAutosarFileException extends IOException {
    EmptyAutosarFileException(String message){
        System.out.println(message);
    }
}
