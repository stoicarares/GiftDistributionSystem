package fileio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class InputReader {

    private String inputPath;

    public InputReader(String inputPath) {
        this.inputPath = inputPath;
    }

    public Input readInput() throws IOException {
        File file = new File(this.inputPath);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Input.class);
    }
}
