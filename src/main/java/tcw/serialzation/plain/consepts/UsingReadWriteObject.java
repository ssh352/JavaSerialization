package tcw.serialzation.plain.consepts;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UsingReadWriteObject implements Serializable {

    private static final long serialVersionUID = 0L;

    private String name;
    private transient String note;

    public UsingReadWriteObject(String name, String note) {
        this.name = name;
        this.note = note;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(this.note);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.note = (String) in.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "UsingReadWriteObject{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
