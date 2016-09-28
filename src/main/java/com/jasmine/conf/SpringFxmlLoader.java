package com.jasmine.conf;

import org.springframework.context.ApplicationContext;

public class SpringFxmlLoader {

	private ApplicationContext context;
	
	public SpringFxmlLoader(ApplicationContext context){
		this.context = context;
	}
	
//	public Parent loadLogin(String url, Stage stage) throws IOException{
//		
//		InputStream fxmlStream = null;
//		
//		try{
//			fxmlStream = LoginController.class.getResourceAsStream(url);
//			LoginController instance = (LoginController)context.getBean(LoginController.class);
//			instance.setPrimaryStage(stage);
//			FXMLLoader loader = new FXMLLoader();
//			//loader.getNamespace().put("controller", instance);
//			loader.setControllerFactory(new Callback<Class<?>, Object>() {
//				public Object call(Class<?> clazz) {
//					return context.getBean(clazz);
//				}
//			});
//			return loader.load(fxmlStream);
//		}finally {
//			if (fxmlStream != null){
//				fxmlStream.close();
//			}
//		}
//		
//	}
	
	
}
