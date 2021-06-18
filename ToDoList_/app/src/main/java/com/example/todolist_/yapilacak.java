package com.example.todolist_;

public class yapilacak {

    private int id;
    private String yapilacak;

    public yapilacak(int id, String yapilacak) {
        this.id = id;
        this.yapilacak = yapilacak;
    }
    public yapilacak(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYapilacak() {
        return yapilacak;
    }

    public void setYapilacak(String yapilacak) {
        this.yapilacak = yapilacak;
    }

    @Override
    public String toString() {
        return "yapilacak= " + yapilacak ;
    }
}
