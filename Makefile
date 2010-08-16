# e.g. make run ARGS='arguments'
ARGS = 

DELETE = rm -f

JAVA = java
JAVAC = javac

all:
	$(JAVAC) -encoding "ISO-8859-1" -d classes src/*.java

run:
	$(JAVA) -classpath classes:. org.jwam.JWAM $(ARGS) 

clean:
	find -name \*~ | xargs $(DELETE) 
	find -name \*.class | xargs $(DELETE)
