package HomeWork_3.model.writer;

import java.io.Serializable;

public interface Writable {

    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}