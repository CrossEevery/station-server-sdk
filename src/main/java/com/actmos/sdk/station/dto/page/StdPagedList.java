package com.actmos.sdk.station.dto.page;

import java.util.List;

public class StdPagedList<E> implements IPagedList<E> {

    public StdPagedList(){

    }

    public StdPagedList(List<E> data, int total) {
        this.data = data;
        this.total = total;
    }

    private List<E> data;

    private int total;

    public List<E> getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }
}
