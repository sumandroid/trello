package constants;

public enum  Commands {
    SHOW("show"),
    CREATE("create"),
    DELETE("delete"),
    ADD_MEMBER("add_member"),
    REMOVE_MEMBER("remove_member"),
    ASSIGN("assign");

    private String value;

    public String getValue() {
        return value;
    }

    Commands(String value) {
        this.value = value;
    }

    public static Commands getCommand(String text){
        for(Commands c : Commands.values()){
            if(c.value.equalsIgnoreCase(text)){
                return c;
            }
        }
        throw new IllegalArgumentException("illegal enum value");
    }

}
