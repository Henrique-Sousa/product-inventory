TARGET_FOLDER = ~/programs/tomcat/webapps/productinventory
TARGET_CLASSES = $(TARGET_FOLDER)/WEB-INF/classes
SRC_FOLDER = ./src/br/com/henriquesousa/productinventory
SERVLET_API = ~/programs/tomcat/lib/servlet-api.jar
ROOT_PACKAGE = ./src

JSP = error.jsp product_list.jsp product_view.jsp product_create.jsp product_delete.jsp
MODELS = DAO.java ProductDAO.java Product.java
CONTROLLERS = ProductListController.java ProductViewController.java ProductCreateController.java ProductDeleteController.java
UTILS = Utils.java

build: cleansite $(UTILS) $(MODELS) $(CONTROLLERS) $(JSP)

cleansite: cleanclasses cleanjsp

cleanclasses:
	rm -rf $(TARGET_CLASSES)/br
	@echo "\e[1;33mall classes deleted \e[0m"

cleanjsp:
	if [ $(TARGET_FOLDER)/"*.jsp" ]; then rm -f $(TARGET_FOLDER)/*.jsp; fi
	@echo "\e[1;33mall jsp deleted \e[0m"

localclean:
	find . -name "*.class" -exec rm {} \;
	
$(MODELS): %.java:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/model/$*.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mmodel/$*.java built successfully \e[0m"

$(CONTROLLERS): %.java:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/controller/$*.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mcontroller/$*.java built successfully \e[0m"

$(UTILS): %.java:
	javac -cp $(SERVLET_API):$(ROOT_PACKAGE) $(SRC_FOLDER)/util/$*.java -d $(TARGET_CLASSES)
	@echo "\e[1;32mutil/$*.java built successfully \e[0m"

$(JSP): %.jsp:
	cp src/webapp/$*.jsp $(TARGET_FOLDER)
	@echo "\e[1;32m$*.jsp built successfully \e[0m"

