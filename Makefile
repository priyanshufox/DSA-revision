BIN = bin

compile:
	mkdir -p $(BIN)
	find . -name "*.java" | xargs javac -d $(BIN)

run:
	@classfile=$$(find $(BIN) -name "$(CLASS).class" | head -1); \
	classname=$${classfile#$(BIN)/}; \
	classname=$${classname%.class}; \
	classname=$$(echo $$classname | tr '/' '.'); \
	java -cp $(BIN) $$classname

clean:
	rm -rf $(BIN)
