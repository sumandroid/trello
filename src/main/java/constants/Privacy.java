package constants;

public enum Privacy {
    PUBLIC("public"), PRIVATE("private");

    private String value;


    Privacy(String s) {
        this.value = s;
    }

    public static Privacy getEnum(String value){
        for(Privacy p : Privacy.values()){
            if(p.value.equalsIgnoreCase(value)){
                return p;
            }
        }
        throw new IllegalArgumentException("illegal enum value");
    }
}
