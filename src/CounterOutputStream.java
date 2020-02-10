import java.io.IOException;
import java.io.OutputStream;

public class CounterOutputStream extends OutputStream {

    private OutputStream outputStream;

    public CounterOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    private int count;

    @Override
    public void write(int b) throws IOException {
        count++;
        System.out.println("Количество обращений при записи: " + count);
        outputStream.write(b);
    }
}