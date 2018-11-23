package com.ey.piit.core.paginator.domain;

import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  分页查询对象
 *  @author Yingjie.Wu
 *  int page = 1; //页号
	int pageSize = 20; //每页数据条数
	String sortString = "age.asc,gender.desc";//如果你想排序的话逗号分隔可以排序多列
	PageBounds pageBounds = new PageBounds(page, pageSize , Order.formString(sortString));
	List list = findByCity("BeiJing",pageBounds);
	//获得结果集条总数
	PageList pageList = (PageList)list;
	System.out.println("totalCount: " + pageList.getPaginator().getTotalCount());
	PageList类是继承于ArrayList的，这样Dao中就不用为了专门分页再多写一个方法。
	使用PageBounds这个对象来控制结果的输出，常用的使用方式一般都可以通过构造函数来配置。
	new PageBounds();//默认构造函数不提供分页，返回ArrayList
	new PageBounds(int limit);//取TOPN操作，返回ArrayList
	new PageBounds(Order... order);//只排序不分页，返回ArrayList
	 
	new PageBounds(int page, int limit);//默认分页，返回PageList
	new PageBounds(int page, int limit, Order... order);//分页加排序，返回PageList
	new PageBounds(int page, int limit, List<Order> orders, boolean containsTotalCount);//使用containsTotalCount来决定查不查询totalCount，即返回ArrayList还是PageList

 */
public class PageBounds extends RowBounds implements Serializable {
    private static final long serialVersionUID = -6414350656252331011L;
    public final static int NO_PAGE = 1;
    /** 页号 */
    protected int page = NO_PAGE;
    /** 分页大小 */
    protected int limit = NO_ROW_LIMIT;
    /** 分页排序信息 */
    protected List<Order> orders = new ArrayList<Order>();
    /** 结果集是否包含TotalCount */
    protected boolean containsTotalCount;

    protected Boolean asyncTotalCount;

    public PageBounds(){
        containsTotalCount = false;
    }

    public PageBounds(RowBounds rowBounds) {
        if(rowBounds instanceof PageBounds){
            PageBounds pageBounds = (PageBounds)rowBounds;
            this.page = pageBounds.page;
            this.limit = pageBounds.limit;
            this.orders = pageBounds.orders;
            this.containsTotalCount = pageBounds.containsTotalCount;
            this.asyncTotalCount = pageBounds.asyncTotalCount;
        }else{
            this.page = (rowBounds.getOffset()/rowBounds.getLimit())+1;
            this.limit = rowBounds.getLimit();
        }

    }

    /**
     * Query TOP N, default containsTotalCount = false
     * @param limit
     */
    public PageBounds(int limit) {
        this.limit = limit;
        this.containsTotalCount = false;
    }

    public PageBounds(int page, int limit) {
        this(page, limit, new ArrayList<Order>(), true);
    }

    public PageBounds(int page, int limit, boolean containsTotalCount) {
        this(page, limit, new ArrayList<Order>(), containsTotalCount);
    }

    /**
     * Just sorting, default containsTotalCount = false
     * @param orders
     */
    public PageBounds(List<Order> orders) {
        this(NO_PAGE, NO_ROW_LIMIT,orders ,false);
    }

    /**
     * Just sorting, default containsTotalCount = false
     * @param order
     */
    public PageBounds(Order... order) {
        this(NO_PAGE, NO_ROW_LIMIT,order);
        this.containsTotalCount = false;
    }

    public PageBounds(int page, int limit, Order... order) {
        this(page, limit, Arrays.asList(order), true);
    }

    public PageBounds(int page, int limit, List<Order> orders) {
        this(page, limit, orders, true);
    }

    public PageBounds(int page, int limit, List<Order> orders, boolean containsTotalCount) {
        this.page = page;
        this.limit = limit;
        this.orders = orders;
        this.containsTotalCount = containsTotalCount;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isContainsTotalCount() {
        return containsTotalCount;
    }

    public void setContainsTotalCount(boolean containsTotalCount) {
        this.containsTotalCount = containsTotalCount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Boolean getAsyncTotalCount() {
        return asyncTotalCount;
    }

    public void setAsyncTotalCount(Boolean asyncTotalCount) {
        this.asyncTotalCount = asyncTotalCount;
    }

    @Override
    public int getOffset() {
        if(page >= 1){
            return (page-1) * limit;
        }
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageBounds{");
        sb.append("page=").append(page);
        sb.append(", limit=").append(limit);
        sb.append(", orders=").append(orders);
        sb.append(", containsTotalCount=").append(containsTotalCount);
        sb.append(", asyncTotalCount=").append(asyncTotalCount);
        sb.append('}');
        return sb.toString();
    }
}