package library;

public enum UserActionsBook {
	
	ADD_BOOK("1"),
	DELETE_BOOK("2"),
	LIST_BOOKS("3"),
	BORROW_BOOK("4"),
	RETURN_BOOK("5"),
	CHECK_BORROWED_BOOKS("6"),
    EXIT("10");

    private String value;

    UserActionsBook(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean containsAction(String value) {
        UserActionsBook[] actions = UserActionsBook.values();

        for (UserActionsBook action : actions) {
            if (action.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }

}
