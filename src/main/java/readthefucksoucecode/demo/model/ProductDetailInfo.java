package readthefucksoucecode.demo.model;

import java.util.ArrayList;

public class ProductDetailInfo extends BaseBean {

	private static final long serialVersionUID = -2414230867256780629L;

	private String item_id; // 主货品id
	private String name;    // 货品名称
	private String short_name;  // 货品简称
	private String cat_id;  // 货品分类代码
	private String cat_name;   // 货品分类名
	private String brand_id;    // 货品品牌代码
	private String brand_name;   // 货品品牌名
	private String goods_specs;  // 商品规格地址
	private String goods_pic_desc;  // 商品图文地址
	private Integer sales_volume;  // 销量
	private Integer is_available;  // 商品是否有效
	private String item_status;  // 状态 0:未上架 1:上架 2:下架
	private String limit_sale_status;  // 限时抢购状态 0:限时抢购中 1:限时抢购未开始 2:限时抢购已结束

	private ArrayList<String> item_images;  // 商品展示图片
	private ArrayList<ProductSubItemLabel> item_labels;
	private ArrayList<ProductSubDetailInfo> itemList;


	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getGoods_specs() {
		return goods_specs;
	}

	public void setGoods_specs(String goods_specs) {
		this.goods_specs = goods_specs;
	}

	public String getGoods_pic_desc() {
		return goods_pic_desc;
	}

	public void setGoods_pic_desc(String goods_pic_desc) {
		this.goods_pic_desc = goods_pic_desc;
	}

	public Integer getSales_volume() {
		return sales_volume;
	}

	public void setSales_volume(Integer sales_volume) {
		this.sales_volume = sales_volume;
	}

	public Integer getIs_available() {
		return is_available;
	}

	public void setIs_available(Integer is_available) {
		this.is_available = is_available;
	}


	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public String getLimit_sale_status() {
		return limit_sale_status;
	}

	public void setLimit_sale_status(String limit_sale_status) {
		this.limit_sale_status = limit_sale_status;
	}

	public ArrayList<String> getItem_images() {
		return item_images;
	}

	public void setItem_images(ArrayList<String> item_images) {
		this.item_images = item_images;
	}

	public ArrayList<ProductSubItemLabel> getItem_labels() {
		return item_labels;
	}

	public void setItem_labels(ArrayList<ProductSubItemLabel> item_labels) {
		this.item_labels = item_labels;
	}

	public ArrayList<ProductSubDetailInfo> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ProductSubDetailInfo> itemList) {
		this.itemList = itemList;
	}
}
