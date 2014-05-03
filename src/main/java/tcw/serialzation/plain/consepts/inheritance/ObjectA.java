package tcw.serialzation.plain.consepts.inheritance;


public class ObjectA extends ObjectB{

    private static final long serialVersionUID = 0L;

    private String nameA;
    private String common;

    public ObjectA(){}

    public ObjectA(String nameC, String nameB, String common, String nameA) {
        super(nameC, nameB, common);
        this.common = common;
        this.nameA = nameA;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    @Override
    public String getCommon() {
        return "From A: " + common;
    }

    @Override
    public void setCommon(String common) {
        this.common = common;
    }

    @Override
    public String toString() {
        return "'" +nameA + " '" + getNameB() + "' '" + getNameC() + "' '" + getCommon()+ "'";
    }
}
