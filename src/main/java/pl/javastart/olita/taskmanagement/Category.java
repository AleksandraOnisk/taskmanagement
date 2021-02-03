package pl.javastart.olita.taskmanagement;

public enum Category {

    HOME("dom"), WORK("praca"), PRIVATE("prywatne");

    private String displayName;

    Category(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
