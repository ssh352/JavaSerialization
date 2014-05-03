package tcw.serialzation.plain.consepts.inheritance;

import java.io.Serializable;

public class ObjectB extends ObjectC implements Serializable{

    private static final long serialVersionUID = 0L;

    private String nameB;
    private String common;

    public ObjectB(){}

    public ObjectB(String nameC, String nameB, String common) {
        super(nameC,common);
        this.nameB = nameB;
        this.common = common;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    @Override
    public String getCommon() {
        return "From B: " + common;
    }

    @Override
    public void setCommon(String common) {
        this.common = common;
    }

    @Override
    public String toString() {
        return "ObjectB{" +
                "nameB='" + nameB + '\'' +
                ", common='" + common + '\'' +
                '}';
    }
}
