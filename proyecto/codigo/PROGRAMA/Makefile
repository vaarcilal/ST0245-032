SRC=src
INCLUDE=src/include
BIN=bin
OBJ=$(BIN)/obj
CXXFLAGS=-Ofast -finline-functions
CXX=g++

all: $(BIN)/BeeTree $(BIN)/spatialhashing

$(BIN)/BeeTree: $(OBJ)/main.o $(OBJ)/octree.o $(OBJ)/balltree.o #$(OBJ)/spatialhashing.o
	$(CXX) $(CXXFLAGS) -o $@ $^

$(BIN)/spatialhashing: $(SRC)/spatialhashing.cpp
	$(CXX) $(CXXFLAGS) -o $@ $^

$(OBJ)/main.o: $(SRC)/main.cpp
	mkdir -p $(OBJ)
	$(CXX) $(CXXFLAGS) -I$(INCLUDE) -o $@ -c $<

$(OBJ)/balltree.o: $(SRC)/balltree.cpp $(INCLUDE)/balltree.h
	mkdir -p $(OBJ)
	$(CXX) $(CXXFLAGS) -I$(INCLUDE) -o $@ -c $<

$(OBJ)/octree.o: $(SRC)/octree.cpp $(INCLUDE)/octree.h
	mkdir -p $(OBJ)
	$(CXX) $(CXXFLAGS) -I$(INCLUDE) -o $@ -c $<

$(OBJ)/spatialhashing.o: $(SRC)/spatialhashing.cpp
	mkdir -p $(OBJ)
	$(CXX) $(CXXFLAGS) -I$(INCLUDE) -o $@ -c $<

.PHONY: clean
clean:
	rm -rf $(BIN)
