package com.heller.memento;

public class GameRole {
    private int vit;
    private int def;

    public GameRole(int vit, int def) {
        this.vit = vit;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public Memento createMem() {
        return new Memento(vit, def);
    }

    public void recover(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }
}
