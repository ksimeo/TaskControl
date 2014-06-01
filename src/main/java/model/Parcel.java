package model;

import java.util.List;

/**
 * Created by user on 01.06.14.
 */
public class Parcel<T>
{
    private int count;
    private List<T> page;

    public Parcel(int count, List<T> page)
    {
        this.count = count;
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getPage() {
        return page;
    }

    public void setPage(List<T> page) {
        this.page = page;
    }
}
