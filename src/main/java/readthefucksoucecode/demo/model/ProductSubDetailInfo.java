package readthefucksoucecode.demo.model;

import java.io.Serializable;

public class ProductSubDetailInfo implements Serializable {

		private static final long serialVersionUID = -701026565379945765L;
	private Integer is_main_item; // 是否为主商品
		private String item_id;// 货品ID
		private Integer stock;// 库存
		private String unit;  // 计量单位
		private String place; // 产地代码
		private String place_name;// 产地
		private String color;  // 颜色代码
		private String color_name;   // 颜色
		private String size;   // 尺寸代码
		private String size_name;  // 尺寸
		private float tag_price; // 吊牌价
		private float real_price;// 舞台价
		private String remark; // 产品介绍
		private String item_pic; // 商品图
		private String item_pic_thumbnail;// 商品缩略图
		private int purchase_quantity;  // 限购数量 0则不限购
		private int limit; // 可购买数量
		private float logistice_cost;//运费

		public Integer getIs_main_item() {
			return is_main_item;
		}

		public void setIs_main_item(Integer is_main_item) {
			this.is_main_item = is_main_item;
		}

		public String getItem_id() {
			return item_id;
		}

		public void setItem_id(String item_id) {
			this.item_id = item_id;
		}

		public Integer getStock() {
			return stock;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getPlace() {
			return place;
		}

		public void setPlace(String place) {
			this.place = place;
		}

		public String getPlace_name() {
			return place_name;
		}

		public void setPlace_name(String place_name) {
			this.place_name = place_name;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getColor_name() {
			return color_name;
		}

		public void setColor_name(String color_name) {
			this.color_name = color_name;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getSize_name() {
			return size_name;
		}

		public void setSize_name(String size_name) {
			this.size_name = size_name;
		}

		public float getTag_price() {
			return tag_price;
		}

		public void setTag_price(float tag_price) {
			this.tag_price = tag_price;
		}

		public float getReal_price() {
			return real_price;
		}

		public void setReal_price(float real_price) {
			this.real_price = real_price;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getItem_pic() {
			return item_pic;
		}

		public void setItem_pic(String item_pic) {
			this.item_pic = item_pic;
		}

		public String getItem_pic_thumbnail() {
			return item_pic_thumbnail;
		}

		public void setItem_pic_thumbnail(String item_pic_thumbnail) {
			this.item_pic_thumbnail = item_pic_thumbnail;
		}

		public int getPurchase_quantity() {
			return purchase_quantity;
		}

		public void setPurchase_quantity(int purchase_quantity) {
			this.purchase_quantity = purchase_quantity;
		}

		public int getLimit() {
			return limit;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}

		public float getLogistice_cost() {
			return logistice_cost;
		}

		public void setLogistice_cost(float logistice_cost) {
			this.logistice_cost = logistice_cost;
		}

	}