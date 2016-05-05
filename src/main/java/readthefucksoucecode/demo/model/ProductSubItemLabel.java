package readthefucksoucecode.demo.model;

import java.io.Serializable;

public  class ProductSubItemLabel implements Serializable {

	/**
		 * 
		 */
		private static final long serialVersionUID = -3979678727482224312L;
		private Integer label_id;
		private String label_type;
		private String label_value;
		public Integer getLabel_id() {
			return label_id;
		}
		public void setLabel_id(Integer label_id) {
			this.label_id = label_id;
		}
		public String getLabel_type() {
			return label_type;
		}
		public void setLabel_type(String label_type) {
			this.label_type = label_type;
		}
		public String getLabel_value() {
			return label_value;
		}
		public void setLabel_value(String label_value) {
			this.label_value = label_value;
		}
		
	}