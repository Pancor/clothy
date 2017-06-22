package pancor.pl.clothy.models;


import android.support.annotation.NonNull;

import java.util.List;

public class Cloth {

    private List<Integer> sizes;

    public Cloth(@NonNull List<Integer> sizes) {
        this.sizes = sizes;
    }

    public List<Integer> getSizes() {
        return sizes;
    }
}
