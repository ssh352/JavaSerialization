package tcw.serialzation.plain.consepts.inheritance;


public class ObjectC {

    private String nameC;
    private String common;

    public ObjectC(){}

    public ObjectC(String nameC, String common) {
        this.nameC = nameC;
        this.common = common;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getCommon() {
        return "From C: " + common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    @Override
    public String toString() {
        return "ObjectC{" +
                "nameC='" + nameC + '\'' +
                ", common='" + common + '\'' +
                '}';
    }
}
