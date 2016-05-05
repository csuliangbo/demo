package readthefucksoucecode.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {
	/**
	 * 将服务端返回的json字符转换为javabean
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T json2Bean(String json,Class<T> clazz){
		Gson gson=new Gson();
		T t=gson.fromJson(json,clazz);
		return t;
	}

	public static<T> String Bean2Json(Class<T> clazz){
		GsonBuilder builder = new GsonBuilder();
		// 不转换没有 @Expose 注解的字段
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		return gson.toJson(clazz);
	}

}