package FileManager;

public enum UserActions {
    
    LIST_FILES("1"),
    CREATE_FOLDER("2"),
    DELETE_FOLDER("3"),
    CREATE_FILE("4"),
    DELETE_FILE("5"),
    GO_IN_FOLDER("6"),
    BACK_FOLDER("7"),
    EXIT("8");

    private String value;

    UserActions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean containsAction(String value) {
        for (UserActions action : UserActions.values()) {
            if (action.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }
}