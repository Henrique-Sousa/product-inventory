TARGET_FOLDER=~/programs/tomcat/webapps/productinventory
TARGET_CLASSES=$(TARGET_FOLDER)/WEB-INF/classes
SRC_FOLDER=./src/br/com/henriquesousa/productinventory
SERVLET_API=~/programs/tomcat/lib/servlet-api.jar
ROOT_PACKAGE=./src

build: cleansite util models controllers jsp

cleansite: cleanclasses cleanjsp

cleanclasses:
	rm -rf $(TARGET_CLASSES)/br
	@echo all classes deleted

cleanjsp:
	rm ~/programs/tomcat/webapps/productinventory/*.jsp
	@echo all jsp deleted

localclean:
	find . -name "*.class" -exec rm {} \;
	

models: dao productdao product

controllers: productlist productview

util:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/controller/ProductListController.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mmodel/ProductListController.java built successfully \e[0m"

productlist:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/controller/ProductListController.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mmodel/ProductListController.java built successfully \e[0m"

productview:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/controller/ProductViewController.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mmodel/ProductViewController.java built successfully \e[0m"

dao:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/model/DAO.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mmodel/DAO.java built successfully \e[0m"

productdao:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/model/ProductDAO.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mmodel/ProductDAO.java built successfully \e[0m"

product:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/model/Product.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mmodel/Product.java built successfully \e[0m"
	
jsp: error product_list product_view

product_view:
	cp src/webapp/product_view.jsp $(TARGET_FOLDER)

product_list:
	cp src/webapp/product_list.jsp $(TARGET_FOLDER) 

error:
	cp src/webapp/error.jsp $(TARGET_FOLDER)

