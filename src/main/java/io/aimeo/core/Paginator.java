package io.aimeo.core;

import io.aimeo.db.CarDAO;

public class Paginator {

    private CarDAO carDao;

    private int pageID;

    private int total = 0;

    private long offset = 0;

    public Paginator() {
        pageID = 1;
        total = 1;
        offset = total * (pageID - 1);
    }

    public CarDAO getCarDao() {
        return carDao;
    }

    public void setCarDao(CarDAO carDao) {
        this.carDao = carDao;
    }

    public int getPageID() {
        return pageID;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

}
