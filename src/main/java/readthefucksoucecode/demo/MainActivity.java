package readthefucksoucecode.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import readthefucksoucecode.demo.model.ProductDetailInfo;
import readthefucksoucecode.demo.model.ProductSubDetailInfo;

public class MainActivity extends AppCompatActivity implements CheckInchPopWindow.OnItemClickListener, CheckInchPopWindow.OnSelectedCompleteLinstener {
    ProductDetailInfo mInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(MainActivity.this));

        String data = "{\"item_id\":\"D002211762\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"goods_specs\":\"http://cdn.online-stage.com/D002211762_Detail_index.html?time=201605051135\",\"goods_pic_desc\":\"http://cdn.online-stage.com/D002211762_Image_index.html?time=201605051135\",\"sales_volume\":0,\"is_available\":1,\"item_images\":[\"http://cdn.online-stage.com/D002211762_720_4703635975364371706319.jpg\",\"http://cdn.online-stage.com/D002211762_720_4704635975364371706319.jpg\",\"http://cdn.online-stage.com/D002211762_720_4705635975364371706319.jpg\",\"http://cdn.online-stage.com/D002211762_720_4707635975364371706319.jpg\",\"http://cdn.online-stage.com/D002211762_720_470QQ截图20160426142836635975364371706319.jpg\"],\"item_labels\":[],\"itemList\":[{\"item_id\":\"D002211762\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"263\",\"color_name\":\"桔色\",\"size\":\"3\",\"size_name\":\"女装m/165\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"1\",\"stock\":2,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"1\"},{\"item_id\":\"D002211763\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"263\",\"color_name\":\"桔色\",\"size\":\"4\",\"size_name\":\"女装l/170\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":2,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211764\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"263\",\"color_name\":\"桔色\",\"size\":\"5\",\"size_name\":\"女装xl/175\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":1,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211765\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"263\",\"color_name\":\"桔色\",\"size\":\"551\",\"size_name\":\"女装XXL/180\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":0,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211766\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"5\",\"color_name\":\"蓝色\",\"size\":\"3\",\"size_name\":\"女装m/165\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":2,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211767\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"5\",\"color_name\":\"蓝色\",\"size\":\"4\",\"size_name\":\"女装l/170\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":2,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211768\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"5\",\"color_name\":\"蓝色\",\"size\":\"5\",\"size_name\":\"女装xl/175\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":1,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211769\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"5\",\"color_name\":\"蓝色\",\"size\":\"551\",\"size_name\":\"女装XXL/180\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":0,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211770\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"410\",\"color_name\":\"姜黄色\",\"size\":\"3\",\"size_name\":\"女装m/165\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":1,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211771\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"410\",\"color_name\":\"姜黄色\",\"size\":\"4\",\"size_name\":\"女装l/170\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":1,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211772\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"410\",\"color_name\":\"姜黄色\",\"size\":\"5\",\"size_name\":\"女装xl/175\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":1,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211773\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"410\",\"color_name\":\"姜黄色\",\"size\":\"551\",\"size_name\":\"女装XXL/180\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":0,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"},{\"item_id\":\"D002211774\",\"name\":\"QDA品牌女装时尚甜美纯色九分裤30609902\",\"short_name\":\"QDA品牌女装时尚甜美纯色九分裤\",\"cat_id\":\"160101\",\"cat_name\":\"女装\",\"brand_id\":\"711\",\"brand_name\":\"QDA\",\"unit\":\"件\",\"place\":\"01\",\"place_name\":\"国内\",\"color\":\"240\",\"color_name\":\"枣红色\",\"size\":\"5\",\"size_name\":\"女装xl/175\",\"tag_price\":358.00,\"real_price\":89.00,\"remark\":\"聚酯纤维86.7%，氨纶13.3%\",\"is_main_item\":\"0\",\"stock\":0,\"product_source\":\"0\",\"sales_volume\":0,\"item_pic_thumbnail\":\"\",\"item_pic\":\"http://cdn.online-stage.com/3635975364442841863.jpg\",\"purchase_quantity\":0,\"limit\":0,\"logistice_cost\":12,\"status\":\"0\"}],\"item_status\":\"1\",\"limit_sale_status\":\"0\",\"errCode\":\"\",\"status\":\"1\",\"errMsg\":\"\"}";

        mInfo = GsonUtils.json2Bean(data, ProductDetailInfo.class);
    }

    public void showBottomPop(View v) {

        CheckInchPopWindow popWindow = new CheckInchPopWindow(this, mInfo);
        popWindow.setOnItemClickListener(this);
        popWindow.setOnSelectedCompleteListener(this);

        popWindow.setData(2);
        popWindow.showAsDropDown(v);
    }


    @Override
    public void onClickAdd2Car(ProductSubDetailInfo info, Integer num) {

    }

    @Override
    public void onClickBuyNow(ProductSubDetailInfo info, int num) {

    }

    /**
     * 所有商品
     *
     * @param result
     */
    @Override
    public void onComplete(ProductSubDetailInfo result) {

    }
}
