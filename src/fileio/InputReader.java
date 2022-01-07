package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public final class InputReader {

    private final String inputPath;

    public InputReader(final String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * Method for getting the data from the input files
     * @return An instance of Input class containg the data read
     * @throws IOException
     */
    public Input readInput() throws IOException {
        File file = new File(this.inputPath);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Input.class);
    }
}
